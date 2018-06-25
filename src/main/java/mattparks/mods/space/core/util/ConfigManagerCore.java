package mattparks.mods.space.core.util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

import net.minecraftforge.fml.common.FMLLog;

public class ConfigManagerCore {
	public static boolean loaded;

	static Configuration configuration;

	public ConfigManagerCore(File file) {
		if (!ConfigManagerCore.loaded) {
			ConfigManagerCore.configuration = new Configuration(file);
			this.setDefaultValues();
		}
	}

	public static boolean idJupiterEnabled;
	public static boolean idSaturnEnabled;
	public static boolean idUranusEnabled;
	public static boolean idNeptuneEnabled;
	public static boolean idRealisticEnabled;
	public static boolean updateCheck;

	private void setDefaultValues() {
		try {
			ConfigManagerCore.configuration.load();

			ConfigManagerCore.idJupiterEnabled = ConfigManagerCore.configuration.get(Configuration.CATEGORY_GENERAL, "Enable Jupiter and all of its Moons?", true).getBoolean(true);
			ConfigManagerCore.idSaturnEnabled = ConfigManagerCore.configuration.get(Configuration.CATEGORY_GENERAL, "Enable Saturn and all of its Moons?", true).getBoolean(true);
			ConfigManagerCore.idUranusEnabled = ConfigManagerCore.configuration.get(Configuration.CATEGORY_GENERAL, "Enable Neptune and all of its Moons?", true).getBoolean(true);
			ConfigManagerCore.idNeptuneEnabled = ConfigManagerCore.configuration.get(Configuration.CATEGORY_GENERAL, "Enable Pluto and all of its Moons?", true).getBoolean(true);
			ConfigManagerCore.idRealisticEnabled = ConfigManagerCore.configuration.get(Configuration.CATEGORY_GENERAL, "Enable super realistic mode, disables mobs, structures, creates alturnitive craftings.", false).getBoolean(false);

			ConfigManagerCore.updateCheck = ConfigManagerCore.configuration.get(Configuration.CATEGORY_GENERAL, "Enable Update Checking?", true).getBoolean(true);
		}

		catch (final Exception e) {
			FMLLog.log(Level.ERROR, e, "4Space Core Config has a problem loading it's configuration");
		}

		finally {
			ConfigManagerCore.configuration.save();
			ConfigManagerCore.loaded = true;
		}
	}
}
