package mattparks.mods.space.io.util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class ConfigManagerIo
{
	public static boolean loaded;

	static Configuration configuration;

	public ConfigManagerIo(File file)
	{
		if (!ConfigManagerIo.loaded)
		{
			ConfigManagerIo.configuration = new Configuration(file);
			this.setDefaultValues();
		}
	}

	public static int idDimensionIo;
	public static boolean idDayLength;
	public static int idBiomeIo;

	private void setDefaultValues()
	{
		try
		{
			ConfigManagerIo.configuration.load();

			ConfigManagerIo.idDimensionIo = ConfigManagerIo.configuration.get(Configuration.CATEGORY_GENERAL, "Io Dimension", -42).getInt(-42);
			ConfigManagerIo.idDayLength = ConfigManagerIo.configuration.get(Configuration.CATEGORY_GENERAL, "Io Day Length Realistic", true).getBoolean(true);
			ConfigManagerIo.idBiomeIo = ConfigManagerIo.configuration.get(Configuration.CATEGORY_GENERAL, "Io Biome", 213).getInt(213);
		}

		catch (final Exception e)
		{
			FMLLog.log(Level.ERROR, e, "4Space Io Config has a problem loading it's configuration");
		}

		finally
		{
			ConfigManagerIo.configuration.save();
			ConfigManagerIo.loaded = true;
		}
	}
}
