package mattparks.mods.space.io.util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class ConfigManagerIo {
	public static boolean loaded;

	static Configuration configuration;

	public ConfigManagerIo(File file) {
		if (!ConfigManagerIo.loaded) {
			ConfigManagerIo.configuration = new Configuration(file);
			this.setDefaultValues();
		}
	}

	public static boolean idIoEnabled;
	public static int idDimensionIo;
	public static boolean idDayLength;
	public static int idBiomeIo;

	private void setDefaultValues() {
		try {
			ConfigManagerIo.configuration.load();

			ConfigManagerIo.idIoEnabled = ConfigManagerIo.configuration.get(Configuration.CATEGORY_GENERAL, "Should Io, Items and Blocks be registered in the game (Big planet on / off switch.)", true).getBoolean(true);
			ConfigManagerIo.idDimensionIo = ConfigManagerIo.configuration.get(Configuration.CATEGORY_GENERAL, "Io Dimension", -47).getInt(-47);
			ConfigManagerIo.idDayLength = ConfigManagerIo.configuration.get(Configuration.CATEGORY_GENERAL, "Io Day Length Realistic", true).getBoolean(true);
			ConfigManagerIo.idBiomeIo = ConfigManagerIo.configuration.get(Configuration.CATEGORY_GENERAL, "Io Biome", 217).getInt(217);
		}

		catch (final Exception e) {
			FMLLog.log(Level.ERROR, e, "4Space Io Config has a problem loading it's configuration");
		}

		finally {
			ConfigManagerIo.configuration.save();
			ConfigManagerIo.loaded = true;
		}
	}
}
