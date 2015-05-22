package mattparks.mods.space.venus.proxy;

import java.util.ArrayList;

import mattparks.mods.space.venus.dimension.SkyProviderVenus;
import mattparks.mods.space.venus.dimension.WorldProviderVenus;
import mattparks.mods.space.venus.entities.EntityEvolvedBlaze;
import mattparks.mods.space.venus.entities.EntityVenusianTNT;
import mattparks.mods.space.venus.entities.EntityVenusianVillager;
import mattparks.mods.space.venus.entities.render.RenderEvolvedBlaze;
import mattparks.mods.space.venus.entities.render.RenderVenusianTNT;
import mattparks.mods.space.venus.entities.render.RenderVenusianVillager;
import mattparks.mods.space.venus.items.ItemJetpack;
import mattparks.mods.space.venus.items.VenusItems;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.WorldClient;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxyVenus extends CommonProxyVenus {
	private static Minecraft mc = FMLClientHandler.instance().getClient();

	private static int renderIndexRubyArmor;
	private static int renderIndexSulfurArmor;
	private static int renderIndexJetpack;

	public static ArrayList<SoundPoolEntry> newMusic = new ArrayList<SoundPoolEntry>();

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		ClientProxyVenus.renderIndexRubyArmor = RenderingRegistry.addNewArmourRendererPrefix("ruby");
		ClientProxyVenus.renderIndexSulfurArmor = RenderingRegistry.addNewArmourRendererPrefix("sulfur");
		ClientProxyVenus.renderIndexJetpack = RenderingRegistry.addNewArmourRendererPrefix("jetpack");

		super.preInit(event);
	}

	@Override
	public int getRubyArmorRenderIndex() {
		return ClientProxyVenus.renderIndexRubyArmor;
	}

	@Override
	public int getSulfurArmorRenderIndex() {
		return ClientProxyVenus.renderIndexSulfurArmor;
	}

	@Override
	public int getJetpackArmorRenderIndex() {
		return ClientProxyVenus.renderIndexJetpack;
	}

	public static void registerEntityRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedBlaze.class, new RenderEvolvedBlaze());
		RenderingRegistry.registerEntityRenderingHandler(EntityVenusianVillager.class, new RenderVenusianVillager());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(new TickHandlerClient());

		RenderingRegistry.registerEntityRenderingHandler(EntityVenusianTNT.class, new RenderVenusianTNT());

		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		ClientProxyVenus.registerEntityRenderers();
		super.postInit(event);
	}

	public void registerRenderInfo() {
	}

	@Override
	public int getBlockRender(Block block) {
		return -1;
	}

	public static class TickHandlerClient {
		@SideOnly(Side.CLIENT)
		@SubscribeEvent
		public void onClientTick(ClientTickEvent event) {
			final Minecraft minecraft = FMLClientHandler.instance().getClient();
			final WorldClient world = minecraft.theWorld;
			final EntityClientPlayerMP player = minecraft.thePlayer;

			// TODO: Make work!
			if (Side.CLIENT != null) {
				if (player != null && world != null && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == VenusItems.jetpack && FMLClientHandler.instance().getClient().gameSettings.keyBindJump.isPressed() && player.posY < 360) {
					((ItemJetpack) player.inventory.armorItemInSlot(2).getItem()).setActive();
					player.motionY -= 0.05D;
					player.motionY += 0.07 + player.rotationPitch * 2 / 150 * 0.750;
					player.fallDistance = 0.0F;
					world.spawnParticle("largesmoke", player.posX, player.posY - 1D, player.posZ, 0, -0.5, 0);
				}
			}

			if (world != null) {
				if (world.provider instanceof WorldProviderVenus) {
					if (world.provider.getSkyRenderer() == null) {
						world.provider.setSkyRenderer(new SkyProviderVenus((IGalacticraftWorldProvider) world.provider));
					}

					if (world.provider.getCloudRenderer() == null) {
						world.provider.setCloudRenderer(new CloudRenderer());
					}
				}
			}
		}
	}
}
