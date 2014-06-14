package mattparks.mods.space.core.thread;

import mattparks.mods.space.core.client.gui.GuiMissingCore;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ThreadRequirementMissing extends Thread
{
	private static Side threadSide;

	public ThreadRequirementMissing(Side threadSide)
	{
		super("4-Space Requirement Check Thread");
		this.setDaemon(true);
		ThreadRequirementMissing.threadSide = threadSide;
	}

	@Override
	public void run()
	{
		if (!Loader.isModLoaded("MattCore"))
		{
			if (ThreadRequirementMissing.threadSide.isServer())
			{
				FMLCommonHandler.instance().getMinecraftServerInstance().getLogAgent().logSevere("===================================================================");
				FMLCommonHandler.instance().getMinecraftServerInstance().getLogAgent().logSevere("MattparksCore not found in mods folder. 4-Space will not load.");
				FMLCommonHandler.instance().getMinecraftServerInstance().getLogAgent().logSevere("===================================================================");
			}
			else
			{
				ThreadRequirementMissing.openGuiClient();
			}
		}
	}

	@SideOnly(Side.CLIENT)
	private static void openGuiClient()
	{
		FMLClientHandler.instance().getClient().displayGuiScreen(new GuiMissingCore());
	}
}
