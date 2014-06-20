package mattparks.mods.space.europa.client;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.sound.PlayBackgroundMusicEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.client.FMLClientHandler;

public class GCEuropaSounds
{
	@ForgeSubscribe
	public void onMusicSound(PlayBackgroundMusicEvent event)
	{
		final Minecraft mc = FMLClientHandler.instance().getClient();

		if (mc.thePlayer != null && mc.thePlayer.worldObj != null && mc.thePlayer.worldObj.provider instanceof IGalacticraftWorldProvider)
		{
			final int randInt = FMLClientHandler.instance().getClient().thePlayer.worldObj.rand.nextInt(ClientProxyEuropa.newMusic.size() + 2);

			if (randInt < ClientProxyEuropa.newMusic.size())
			{
				event.result = ClientProxyEuropa.newMusic.get(randInt);
			}
		}
	}
}
