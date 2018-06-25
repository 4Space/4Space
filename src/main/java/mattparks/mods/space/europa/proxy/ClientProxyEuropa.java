package mattparks.mods.space.europa.proxy;

import java.util.ArrayList;

import mattparks.mods.space.europa.dimension.SkyProviderEuropa;
import mattparks.mods.space.europa.dimension.WorldProviderEuropa;
import mattparks.mods.space.europa.particles.EntityEuropaWaterDripFX;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EntityFX;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxyEuropa extends CommonProxyEuropa {
	public static ArrayList<SoundPoolEntry> newMusic = new ArrayList<SoundPoolEntry>();
	private static Minecraft mc = FMLClientHandler.instance().getClient();

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}

	public static void registerEntityRenderers() {
	}

	@Override
	public void init(FMLInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(new TickHandlerClient());

		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		ClientProxyEuropa.registerEntityRenderers();
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
				if (world.provider instanceof WorldProviderEuropa) {
					if (world.provider.getSkyRenderer() == null) {
						world.provider.setSkyRenderer(new SkyProviderEuropa((IGalacticraftWorldProvider) world.provider));
					}
					if (world.provider.getCloudRenderer() == null) {
						world.provider.setCloudRenderer(new CloudRenderer());
					}
				}
			}
		}
	}

	@Override
	public void spawnParticle(String string, double x, double y, double z) {
		EntityFX entityfx = null;

		if (string == "europaWaterDrip") {
			entityfx = new EntityEuropaWaterDripFX(mc.theWorld, x, y, z, Material.water);
		}
		mc.effectRenderer.addEffect(entityfx);
	}
}
