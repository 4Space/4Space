package mattparks.mods.exoplanets.util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class ConfigManagerCore {
	public static boolean loaded;

	static Configuration configuration;

	public ConfigManagerCore(File file) {
		if (!ConfigManagerCore.loaded) {
			ConfigManagerCore.configuration = new Configuration(file);
			this.setDefaultValues();
		}
	}

	//public static boolean updateCheck;

	private void setDefaultValues() {
		try {
			ConfigManagerCore.configuration.load();
			
			//ConfigManagerCore.updateCheck = ConfigManagerCore.configuration.get(Configuration.CATEGORY_GENERAL, "Enable Update Checking?", true).getBoolean(true);
		}

		catch (final Exception e) {
			FMLLog.log(Level.ERROR, e, "4Space ExoPlanets Config has a problem loading it's configuration");
		}

		finally {
			ConfigManagerCore.configuration.save();
			ConfigManagerCore.loaded = true;
		}
	}
}
