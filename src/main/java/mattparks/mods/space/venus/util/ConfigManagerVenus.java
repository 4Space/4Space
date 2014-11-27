package mattparks.mods.space.venus.util;

import java.io.File;

import mattparks.mods.space.core.util.ConfigAddon;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class ConfigManagerVenus
{
	public static boolean loaded;

	static Configuration configuration;

	public ConfigManagerVenus(File file)
	{
		if (!ConfigManagerVenus.loaded)
		{
			ConfigManagerVenus.configuration = new Configuration(file);
			this.setDefaultValues();
		}
	}

	public static int idDimensionVenus;
	public static boolean idDayLength;
	public static boolean idFlamelingCreeper;
	public static int idBiomeVenus;

	public static int idEntityEvolvedBlaze;
	public static int idEntityFlameling;
	public static int idEntityVenusianVillager;
	public static int idEntityVenusianTNT;

	private void setDefaultValues()
	{
		try
		{
			ConfigManagerVenus.configuration.load();

			ConfigManagerVenus.idDimensionVenus = ConfigManagerVenus.configuration.get(Configuration.CATEGORY_GENERAL, "Venus Dimension", -41).getInt(-41);
			ConfigManagerVenus.idDayLength = ConfigManagerVenus.configuration.get(Configuration.CATEGORY_GENERAL, "Venus Day Length Realistic", true).getBoolean(true);
			ConfigManagerVenus.idFlamelingCreeper = ConfigManagerVenus.configuration.get(Configuration.CATEGORY_GENERAL, "Enable this if you want creepers to have a enemy...", false).getBoolean(false);
			ConfigManagerVenus.idBiomeVenus = ConfigManagerVenus.configuration.get(Configuration.CATEGORY_GENERAL, "Venus Biome", 207).getInt(207);

			ConfigManagerVenus.idEntityEvolvedBlaze = ConfigManagerVenus.configuration.get(ConfigAddon.CATEGORY_ENTITIES, "Evolved Blaze", 193).getInt(193);
			ConfigManagerVenus.idEntityVenusianVillager = ConfigManagerVenus.configuration.get(ConfigAddon.CATEGORY_ENTITIES, "Venusian Villager", 194).getInt(194);
			ConfigManagerVenus.idEntityFlameling = ConfigManagerVenus.configuration.get(ConfigAddon.CATEGORY_ENTITIES, "Flameling", 195).getInt(195);
			ConfigManagerVenus.idEntityVenusianTNT = ConfigManagerVenus.configuration.get(ConfigAddon.CATEGORY_ENTITIES, "Venusian TNT", 438).getInt(438);
		}

		catch (final Exception e)
		{
			FMLLog.log(Level.ERROR, e, "4Space Venus Config has a problem loading it's configuration");
		}

		finally
		{
			ConfigManagerVenus.configuration.save();
			ConfigManagerVenus.loaded = true;
		}
	}
}