package mattparks.mods.space.core.event;

import mattparks.mods.space.core.proxy.ClientProxySpace;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.sound.PlayBackgroundMusicEvent;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlanetSoundsEvents
{
	@SubscribeEvent
	public void onMusicSound(PlayBackgroundMusicEvent event)
	{
		final Minecraft mc = FMLClientHandler.instance().getClient();

		if (mc.thePlayer != null && mc.thePlayer.worldObj != null && mc.thePlayer.worldObj.provider instanceof IGalacticraftWorldProvider)
		{
			final int randInt = FMLClientHandler.instance().getClient().thePlayer.worldObj.rand.nextInt(ClientProxySpace.newMusic.size() + 2);

			if (randInt < ClientProxySpace.newMusic.size())
			{
				event.result = ClientProxySpace.newMusic.get(randInt);
			}
		}
	}
}