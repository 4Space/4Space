package mattparks.mods.space.pluto.util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class ConfigManagerPluto {
	public static boolean loaded;

	static Configuration configuration;

	public ConfigManagerPluto(File file) {
		if (!ConfigManagerPluto.loaded) {
			ConfigManagerPluto.configuration = new Configuration(file);
			this.setDefaultValues();
		}
	}

	public static boolean idPlutoEnabled;
	public static int idDimensionPluto;
	public static boolean idDayLength;
	public static int idBiomePluto;

	private void setDefaultValues() {
		try {
			ConfigManagerPluto.configuration.load();

			ConfigManagerPluto.idPlutoEnabled = ConfigManagerPluto.configuration.get(Configuration.CATEGORY_GENERAL, "Should Pluto, Items and Blocks be registered in the game (Big planet on / off switch.)", true).getBoolean(true);
			ConfigManagerPluto.idDimensionPluto = ConfigManagerPluto.configuration.get(Configuration.CATEGORY_GENERAL, "Pluto Dimension", -59).getInt(-55);
			ConfigManagerPluto.idDayLength = ConfigManagerPluto.configuration.get(Configuration.CATEGORY_GENERAL, "Pluto Day Length Realistic", true).getBoolean(true);
			ConfigManagerPluto.idBiomePluto = ConfigManagerPluto.configuration.get(Configuration.CATEGORY_GENERAL, "Pluto Biome", 225).getInt(225);
		}

		catch (final Exception e) {
			FMLLog.log(Level.ERROR, e, "4Space Pluto Config has a problem loading it's configuration");
		}

		finally {
			ConfigManagerPluto.configuration.save();
			ConfigManagerPluto.loaded = true;
		}
	}
}
