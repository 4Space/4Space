package mattparks.mods.exoplanets.elipse.util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class ConfigManagerElipse {
	public static boolean loaded;

	static Configuration configuration;

	public ConfigManagerElipse(File file) {
		if (!ConfigManagerElipse.loaded) {
			ConfigManagerElipse.configuration = new Configuration(file);
			this.setDefaultValues();
		}
	}

	public static boolean idElipseEnabled;
	public static int idDimensionElipse;
	public static int idBiomeElipse;

	private void setDefaultValues() {
		try {
			ConfigManagerElipse.configuration.load();

			ConfigManagerElipse.idElipseEnabled = ConfigManagerElipse.configuration.get(Configuration.CATEGORY_GENERAL, "Should Elipse, Items and Blocks be registered in the game (Big planet on / off switch.)", true).getBoolean(true);
			ConfigManagerElipse.idDimensionElipse = ConfigManagerElipse.configuration.get(Configuration.CATEGORY_GENERAL, "Elipse Dimension", -63).getInt(63);
			ConfigManagerElipse.idBiomeElipse = ConfigManagerElipse.configuration.get(Configuration.CATEGORY_GENERAL, "Elipse Biome", 233).getInt(233);
		}

		catch (final Exception e) {
			FMLLog.log(Level.ERROR, e, "4Space Elipse Config has a problem loading it's configuration");
		}

		finally {
			ConfigManagerElipse.configuration.save();
			ConfigManagerElipse.loaded = true;
		}
	}
}
