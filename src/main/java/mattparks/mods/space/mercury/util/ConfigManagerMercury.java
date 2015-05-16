package mattparks.mods.space.mercury.util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class ConfigManagerMercury {
	public static boolean loaded;

	static Configuration configuration;

	public ConfigManagerMercury(File file) {
		if (!ConfigManagerMercury.loaded) {
			ConfigManagerMercury.configuration = new Configuration(file);
			this.setDefaultValues();
		}
	}

	public static boolean idMercuryEnabled;
	public static int idDimensionMercury;
	public static boolean idDayLength;
	public static int idBiomeMercury;

	private void setDefaultValues() {
		try {
			ConfigManagerMercury.configuration.load();

			ConfigManagerMercury.idMercuryEnabled = ConfigManagerMercury.configuration.get(Configuration.CATEGORY_GENERAL, "Should Mercury, Items and Blocks be registered in the game (Big planet on / off switch.)", true).getBoolean(true);
			ConfigManagerMercury.idDimensionMercury = ConfigManagerMercury.configuration.get(Configuration.CATEGORY_GENERAL, "Mercury Dimension", -40).getInt(-40);
			ConfigManagerMercury.idDayLength = ConfigManagerMercury.configuration.get(Configuration.CATEGORY_GENERAL, "Mercury Day Length Realistic", true).getBoolean(true);
			ConfigManagerMercury.idBiomeMercury = ConfigManagerMercury.configuration.get(Configuration.CATEGORY_GENERAL, "Mercury Biome", 210).getInt(210);
		}

		catch (final Exception e) {
			FMLLog.log(Level.ERROR, e, "4Space Mercury Config has a problem loading it's configuration");
		}

		finally {
			ConfigManagerMercury.configuration.save();
			ConfigManagerMercury.loaded = true;
		}
	}
}
