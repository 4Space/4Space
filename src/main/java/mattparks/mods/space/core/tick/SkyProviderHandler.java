package mattparks.mods.space.core.tick;

import mattparks.mods.space.europa.dimension.WorldProviderEuropa;
import mattparks.mods.space.europa.dimension.sky.SkyProviderEuropa;
import mattparks.mods.space.io.dimension.WorldProviderIo;
import mattparks.mods.space.io.dimension.sky.SkyProviderIo;
import mattparks.mods.space.mercury.dimension.WorldProviderMercury;
import mattparks.mods.space.mercury.dimension.sky.SkyProviderMercury;
import mattparks.mods.space.venus.dimension.WorldProviderVenus;
import mattparks.mods.space.venus.dimension.sky.SkyProviderVenus;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SkyProviderHandler
{
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onSkyRendererTick(ClientTickEvent event)
	{
		final Minecraft minecraft = FMLClientHandler.instance().getClient();
		final WorldClient world = minecraft.theWorld;

		if (world != null)
		{
			if (world.provider instanceof WorldProviderEuropa)
			{
				if (world.provider.getSkyRenderer() == null)
				{
					world.provider.setSkyRenderer(new SkyProviderEuropa());
				}
				if (world.provider.getCloudRenderer() == null)
				{
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			else if (world.provider instanceof WorldProviderIo)
			{
				if (world.provider.getSkyRenderer() == null)
				{
					world.provider.setSkyRenderer(new SkyProviderIo());
				}
				if (world.provider.getCloudRenderer() == null)
				{
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			else if (world.provider instanceof WorldProviderMercury)
			{
				if (world.provider.getSkyRenderer() == null)
				{
					world.provider.setSkyRenderer(new SkyProviderMercury());
				}
				if (world.provider.getCloudRenderer() == null)
				{
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			else if (world.provider instanceof WorldProviderVenus)
			{
				if (world.provider.getSkyRenderer() == null)
				{
					world.provider.setSkyRenderer(new SkyProviderVenus());
				}
				if (world.provider.getCloudRenderer() == null)
				{
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
		}
	}
}