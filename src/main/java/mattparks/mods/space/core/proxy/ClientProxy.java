package mattparks.mods.space.core.proxy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.tick.TickHandlerClient;
import mattparks.mods.space.core.util.SpaceMusicTicker;
import mattparks.mods.space.mercury.MercuryCore;
import micdoodle8.mods.galacticraft.api.event.client.CelestialBodyRenderEvent;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.client.gui.screen.GuiCelestialSelection;
import micdoodle8.mods.galacticraft.core.client.render.ThreadDownloadImageDataGC;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.VersionUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.util.EnumHelper;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.Maps;

import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {
	public static EnumRarity spaceItem = EnumHelper.addRarity("SpaceRarity", TextFormatting.RED, "Space");

	public static MusicTicker.MusicType MUSIC_TYPE_SPACE;

	private static Minecraft mc = FMLClientHandler.instance().getClient();
	private static Map<String, ResourceLocation> capesMap = Maps.newHashMap();

	private static final ResourceLocation saturnRingTexture = new ResourceLocation("galacticraftcore", "textures/gui/celestialbodies/saturnRings.png");
	private static final ResourceLocation uranusRingTexture = new ResourceLocation("galacticraftcore", "textures/gui/celestialbodies/uranusRings.png");

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Class[][] commonTypes = { { MusicTicker.MusicType.class, ResourceLocation.class, int.class, int.class }, };
		MUSIC_TYPE_SPACE = EnumHelper.addEnum(commonTypes, MusicTicker.MusicType.class, "SNOWSTORM", new ResourceLocation(MercuryCore.ASSET_PREFIX, "4space.musicSpace"), 12000, 24000);

		ClientProxyCore.setupCapes();
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		try {
			Field ftc = Minecraft.getMinecraft().getClass().getDeclaredField(VersionUtil.getNameDynamic(VersionUtil.KEY_FIELD_MUSICTICKER));
			ftc.setAccessible(true);
			ftc.set(Minecraft.getMinecraft(), new SpaceMusicTicker(Minecraft.getMinecraft()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		super.postInit(event);
	}

	public static void registerHandlers() {
		TickHandlerClient tickHandlerClient = new TickHandlerClient();
	}

	public static void setupCapes() {
		try {
			ClientProxy.updateCapeList();
		} catch (Exception e) {
			FMLLog.severe("Error while setting up 4Space capes");
			e.printStackTrace();
		}

		/*
		 * if (Loader.isModLoaded("CoFHCore")) { for (Entry<String, String> e :
		 * ClientProxy.capeMap.entrySet()) { try { Object capeRegistry =
		 * Class.forName
		 * ("cofh.api.core.RegistryAccess").getField("capeRegistry").get(null);
		 * Class.forName("cofh.api.core.ISimpleRegistry").getMethod("register",
		 * String.class, String.class).invoke(capeRegistry, e.getKey(),
		 * e.getValue()); } catch (Exception e1) { e1.printStackTrace(); break;
		 * } } }
		 */
	}

	private static void updateCapeList() {
		int timeout = 10000;
		URL capeListUrl = null;

		try {
			capeListUrl = new URL("https://raw.github.com/4Space/4Space-1.7/master/capes.txt");
		} catch (MalformedURLException e) {
			FMLLog.severe("Error getting capes list URL");
			e.printStackTrace();
			return;
		}

		URLConnection connection = null;

		try {
			connection = capeListUrl.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		connection.setConnectTimeout(timeout);
		connection.setReadTimeout(timeout);
		InputStream stream = null;

		try {
			stream = connection.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		InputStreamReader streamReader = new InputStreamReader(stream);
		BufferedReader reader = new BufferedReader(streamReader);

		String line;

		try {
			while ((line = reader.readLine()) != null) {
				if (line.contains(":")) {
					int splitLocation = line.indexOf(":");
					String username = line.substring(0, splitLocation);
					String capeUrl = "https://raw.github.com/4Space/4Space-1.7/master/capes/" + line.substring(splitLocation + 1) + ".png";
					ClientProxyCore.capeMap.put(username, capeUrl);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			streamReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SubscribeEvent
	public void onPostRender(RenderPlayerEvent.Specials.Post event) {
		AbstractClientPlayer player = (AbstractClientPlayer) event.entityPlayer;
		boolean flag = ClientProxyCore.capeMap.containsKey(event.entityPlayer.getCommandSenderName());
		float f4;

		if (flag && !player.isInvisible() && !player.getHideCape()) {
			String url = ClientProxyCore.capeMap.get(player.getCommandSenderName());
			ResourceLocation capeLoc = capesMap.get(url);
			if (!capesMap.containsKey(url)) {
				try {
					String dirName = Minecraft.getMinecraft().mcDataDir.getAbsolutePath();
					File directory = new File(dirName, "assets");
					boolean success = true;

					if (!directory.exists()) {
						success = directory.mkdir();
					}

					if (success) {
						directory = new File(directory, "4SpaceCapes");
						if (!directory.exists()) {
							success = directory.mkdir();
						}

						if (success) {
							String hash = String.valueOf(player.getCommandSenderName().hashCode());
							File file1 = new File(directory, hash.substring(0, 2));
							File file2 = new File(file1, hash);
							final ResourceLocation resourcelocation = new ResourceLocation("4SpaceCapes/" + hash);
							ThreadDownloadImageDataGC threaddownloadimagedata = new ThreadDownloadImageDataGC(file2, url, null, new IImageBuffer() {
								public BufferedImage parseUserSkin(BufferedImage p_78432_1_) {
									if (p_78432_1_ == null) {
										return null;
									} else {
										BufferedImage bufferedimage1 = new BufferedImage(512, 256, 2);
										Graphics graphics = bufferedimage1.getGraphics();
										graphics.drawImage(p_78432_1_, 0, 0, null);
										graphics.dispose();
										p_78432_1_ = bufferedimage1;
									}
									return p_78432_1_;
								}

								public void func_152634_a() {
								}
							});

							if (ClientProxy.mc.getTextureManager().loadTexture(resourcelocation, threaddownloadimagedata)) {
								capeLoc = resourcelocation;
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				capesMap.put(url, capeLoc);
			}

			if (capeLoc != null) {
				ClientProxy.mc.getTextureManager().bindTexture(capeLoc);
				GL11.glPushMatrix();
				GL11.glTranslatef(0.0F, 0.0F, 0.125F);
				double d3 = player.field_71091_bM + (player.field_71094_bP - player.field_71091_bM) * event.partialRenderTick - (player.prevPosX + (player.posX - player.prevPosX) * event.partialRenderTick);
				double d4 = player.field_71096_bN + (player.field_71095_bQ - player.field_71096_bN) * event.partialRenderTick - (player.prevPosY + (player.posY - player.prevPosY) * event.partialRenderTick);
				double d0 = player.field_71097_bO + (player.field_71085_bR - player.field_71097_bO) * event.partialRenderTick - (player.prevPosZ + (player.posZ - player.prevPosZ) * event.partialRenderTick);
				f4 = (player.prevRenderYawOffset + (player.renderYawOffset - player.prevRenderYawOffset) * event.partialRenderTick) / 57.29578F;
				double d1 = MathHelper.sin(f4);
				double d2 = -MathHelper.cos(f4);
				float f5 = (float) d4 * 10.0F;

				if (f5 < -6.0F) {
					f5 = -6.0F;
				}

				if (f5 > 32.0F) {
					f5 = 32.0F;
				}

				float f6 = (float) (d3 * d1 + d0 * d2) * 100.0F;
				float f7 = (float) (d3 * d2 - d0 * d1) * 100.0F;

				if (f6 < 0.0F) {
					f6 = 0.0F;
				}

				float f8 = player.prevCameraYaw + (player.cameraYaw - player.prevCameraYaw) * event.partialRenderTick;
				f5 += MathHelper.sin((player.prevDistanceWalkedModified + (player.distanceWalkedModified - player.prevDistanceWalkedModified) * event.partialRenderTick) * 6.0F) * 32.0F * f8;

				if (player.isSneaking()) {
					f5 += 25.0F;
				}

				GL11.glRotatef(6.0F + f6 / 2.0F + f5, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(f7 / 2.0F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-f7 / 2.0F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
				event.renderer.modelBipedMain.renderCloak(0.0625F);
				GL11.glPopMatrix();
			}
		}
	}

	@SubscribeEvent
	public void onRenderPlanetPost(CelestialBodyRenderEvent.Post event) { // TODO?
		if (this.mc.currentScreen instanceof GuiCelestialSelection) {
			if (event.celestialBody == SpaceCore.planetSaturn) {
				this.mc.renderEngine.bindTexture(saturnRingTexture);
				float size = GuiCelestialSelection.getWidthForCelestialBodyStatic(event.celestialBody) / 6.0F;
				((GuiCelestialSelection) this.mc.currentScreen).drawTexturedModalRect(-7.5F * size, -1.75F * size, 15.0F * size, 3.5F * size, 0, 0, 30, 7, false, false, 30, 7);
			} else if (event.celestialBody == SpaceCore.planetUranus) {
				this.mc.renderEngine.bindTexture(uranusRingTexture);
				float size = GuiCelestialSelection.getWidthForCelestialBodyStatic(event.celestialBody) / 6.0F;
				((GuiCelestialSelection) this.mc.currentScreen).drawTexturedModalRect(-1.75F * size, -7.0F * size, 3.5F * size, 14.0F * size, 0, 0, 28, 7, false, false, 28, 7);
			}
		}
	}
}
