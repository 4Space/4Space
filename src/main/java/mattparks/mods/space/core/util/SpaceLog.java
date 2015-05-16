package mattparks.mods.space.core.util;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.relauncher.FMLRelaunchLog;

public class SpaceLog {
	public static void info(String message) {
		FMLRelaunchLog.log("4Space", Level.INFO, message);
	}

	public static void severe(String message) {
		FMLRelaunchLog.log("4Space", Level.ERROR, message);
	}
}
