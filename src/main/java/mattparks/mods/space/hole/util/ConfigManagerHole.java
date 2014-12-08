package mattparks.mods.space.hole.util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class ConfigManagerHole
{
	public static boolean loaded;

	static Configuration configuration;

	public ConfigManagerHole(File file)
	{
		if (!ConfigManagerHole.loaded)
		{
			ConfigManagerHole.configuration = new Configuration(file);
			this.setDefaultValues();
		}
	}

	public static int idDimensionHole;
	public static int idBiomeHole;

	private void setDefaultValues()
	{
		try
		{
			ConfigManagerHole.configuration.load();

			ConfigManagerHole.idDimensionHole = ConfigManagerHole.configuration.get(Configuration.CATEGORY_GENERAL, "Hole Dimension", -50).getInt(-50);
			ConfigManagerHole.idBiomeHole = ConfigManagerHole.configuration.get(Configuration.CATEGORY_GENERAL, "Hole Biome", 225).getInt(225);
		}

		catch (final Exception e)
		{
			FMLLog.log(Level.ERROR, e, "4Space Worm Hole Config has a problem loading it's configuration");
		}

		finally
		{
			ConfigManagerHole.configuration.save();
			ConfigManagerHole.loaded = true;
		}
	}
}