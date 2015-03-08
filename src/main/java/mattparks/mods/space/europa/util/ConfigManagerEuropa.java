package mattparks.mods.space.europa.util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class ConfigManagerEuropa {
	public static boolean loaded;

	static Configuration configuration;

	public ConfigManagerEuropa(File file) {
		if (!ConfigManagerEuropa.loaded) {
			ConfigManagerEuropa.configuration = new Configuration(file);
			this.setDefaultValues();
		}
	}

	public static int idDimensionEuropa;
	public static boolean idDayLength;
	public static int idBiomeEuropa;

	private void setDefaultValues() {
		try {
			ConfigManagerEuropa.configuration.load();

			ConfigManagerEuropa.idDimensionEuropa = ConfigManagerEuropa.configuration.get(Configuration.CATEGORY_GENERAL, "Europa Dimension", -45).getInt(-43);
			ConfigManagerEuropa.idDayLength = ConfigManagerEuropa.configuration.get(Configuration.CATEGORY_GENERAL, "Europa Day Length Realistic", true).getBoolean(true);
			ConfigManagerEuropa.idBiomeEuropa = ConfigManagerEuropa.configuration.get(Configuration.CATEGORY_GENERAL, "Europa Biome", 212).getInt(212);
		}

		catch (final Exception e) {
			FMLLog.log(Level.ERROR, e, "4Space Europa Config has a problem loading it's configuration");
		}

		finally {
			ConfigManagerEuropa.configuration.save();
			ConfigManagerEuropa.loaded = true;
		}
	}
}
