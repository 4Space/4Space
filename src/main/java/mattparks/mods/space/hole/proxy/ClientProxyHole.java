package mattparks.mods.space.hole.proxy;

import java.util.ArrayList;

import mattparks.mods.space.hole.dimension.SkyProviderHole;
import mattparks.mods.space.hole.dimension.WorldProviderHole;
import mattparks.mods.space.hole.entites.EntityMakianVillager;
import mattparks.mods.space.hole.entites.render.RenderMakianVillager;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundPoolEntry;
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

public class ClientProxyHole extends CommonProxyHole {
	public static ArrayList<SoundPoolEntry> newMusic = new ArrayList<SoundPoolEntry>();

	private static int renderIndexFlameiteArmor;

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		ClientProxyHole.renderIndexFlameiteArmor = RenderingRegistry.addNewArmourRendererPrefix("flameite");

		super.preInit(event);
	}

	@Override
	public int getFlameiteArmorRenderIndex() {
		return ClientProxyHole.renderIndexFlameiteArmor;
	}

	public static void registerEntityRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityMakianVillager.class, new RenderMakianVillager());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(new TickHandlerClient());

		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		ClientProxyHole.registerEntityRenderers();
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

			if (world != null) {
				if (world.provider instanceof WorldProviderHole) {
					if (world.provider.getSkyRenderer() == null) {
						world.provider.setSkyRenderer(new SkyProviderHole((IGalacticraftWorldProvider) world.provider));
					}

					if (world.provider.getCloudRenderer() == null) {
						world.provider.setCloudRenderer(new CloudRenderer());
					}
				}
			}
		}
	}
}
