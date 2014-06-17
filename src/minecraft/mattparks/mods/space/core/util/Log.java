package mattparks.mods.space.core.util;

import java.util.logging.Level;

import cpw.mods.fml.relauncher.FMLRelaunchLog;

public class Log
{
	public static void info(String message)
	{
		FMLRelaunchLog.log("4-Space", Level.INFO, message);
	}

	public static void severe(String message)
	{
		FMLRelaunchLog.log("4-Space", Level.SEVERE, message);
	}
}
