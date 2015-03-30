package mattparks.mods.space.callisto.util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class ConfigManagerCallisto {
	public static boolean loaded;

	static Configuration configuration;

	public ConfigManagerCallisto(File file) {
		if (!ConfigManagerCallisto.loaded) {
			ConfigManagerCallisto.configuration = new Configuration(file);
			this.setDefaultValues();
		}
	}

	public static int idDimensionCallisto;
	public static boolean idDayLength;
	public static int idBiomeCallisto;

	private void setDefaultValues() {
		try {
			ConfigManagerCallisto.configuration.load();

			ConfigManagerCallisto.idDimensionCallisto = ConfigManagerCallisto.configuration.get(Configuration.CATEGORY_GENERAL, "Callisto Dimension", -49).getInt(-49);
			ConfigManagerCallisto.idDayLength = ConfigManagerCallisto.configuration.get(Configuration.CATEGORY_GENERAL, "Callisto Day Length Realistic", true).getBoolean(true);
			ConfigManagerCallisto.idBiomeCallisto = ConfigManagerCallisto.configuration.get(Configuration.CATEGORY_GENERAL, "Callisto Biome", 219).getInt(219);
		}

		catch (final Exception e) {
			FMLLog.log(Level.ERROR, e, "4Space Callisto Config has a problem loading it's configuration");
		}

		finally {
			ConfigManagerCallisto.configuration.save();
			ConfigManagerCallisto.loaded = true;
		}
	}
}
