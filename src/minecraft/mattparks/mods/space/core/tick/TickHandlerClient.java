package mattparks.mods.space.core.tick;

import java.util.EnumSet;

import mattparks.mods.space.core.thread.ThreadRequirementMissing;
import mattparks.mods.space.core.util.CoreUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.multiplayer.WorldClient;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.Side;

public class TickHandlerClient implements ITickHandler
{
	public static boolean checkedVersion = true;
	private static long tickCount;

	private static ThreadRequirementMissing missingRequirementThread;

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		final Minecraft minecraft = FMLClientHandler.instance().getClient();

		final WorldClient world = minecraft.theWorld;

		final EntityClientPlayerMP player = minecraft.thePlayer;

			if (minecraft.currentScreen != null && minecraft.currentScreen instanceof GuiMainMenu)
			{
				if (TickHandlerClient.missingRequirementThread == null)
				{
					TickHandlerClient.missingRequirementThread = new ThreadRequirementMissing(FMLCommonHandler.instance().getEffectiveSide());
					TickHandlerClient.missingRequirementThread.start();
				}
			}

			if (world != null && TickHandlerClient.checkedVersion)
			{
				CoreUtil.checkVersion(Side.CLIENT);
				TickHandlerClient.checkedVersion = false;
			}
		}
	
		
	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		final Minecraft minecraft = FMLClientHandler.instance().getClient();
	}

	@Override
	public String getLabel()
	{
		return "SpaceCore Client";
	}

	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.RENDER, TickType.CLIENT);
	}
}
