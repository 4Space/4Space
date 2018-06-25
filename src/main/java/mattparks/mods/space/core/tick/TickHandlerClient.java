package mattparks.mods.space.core.tick;

import mattparks.mods.space.core.util.ThreadVersionCheck;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

public class TickHandlerClient {
	public static boolean checkedVersion = true;

	@SubscribeEvent
	public void onClientTick(ClientTickEvent event) {
		final Minecraft minecraft = FMLClientHandler.instance().getClient();
		final WorldClient world = minecraft.theWorld;
		final EntityClientPlayerMP player = minecraft.thePlayer;

		if (event.phase == Phase.START) {
			if (world != null && TickHandlerClient.checkedVersion) {
				ThreadVersionCheck.startCheck();
				TickHandlerClient.checkedVersion = false;
			}
		}
	}
}
