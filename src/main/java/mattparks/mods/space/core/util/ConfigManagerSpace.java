package mattparks.mods.space.core.util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;

public class ConfigManagerSpace
{
	public static boolean loaded;

	static Configuration configuration;

	public ConfigManagerSpace(File file)
	{
		if (!ConfigManagerSpace.loaded)
		{
			ConfigManagerSpace.configuration = new Configuration(file);
			this.setDefaultValues();
		}
	}

	// MERCURY
	public static int idEntityEvolvedSlime;
	public static int idDimensionMercury;

	// VENUS
	public static int idEntityEvolvedBlaze;
	public static int idEntityFlameling;
	public static int idEntityVenusianVillager;
	public static int idDimensionVenus;
	public static int idEntityVenusianTNT;
	public static boolean disableVenusVillageGen;

	// PLANETS/MOON
	public static int idDimensionEuropa;
	public static int idDimensionIo;
	public static int idDimensionEris;
	public static int idDimensionCallisto;

	// BIOMES
	public static int idBiomeMercury;
	public static int idBiomeVenus;
	public static int idBiomeEuropa;
	public static int idBiomeIo;
	public static int idBiomeEris;
	public static int idBiomeCallisto;

	private void setDefaultValues()
	{
		try
		{
			ConfigManagerSpace.configuration.load();

			//MERCURY
			ConfigManagerSpace.idEntityEvolvedSlime = ConfigManagerSpace.configuration.get("Entities", "Evolved Slime", 196).getInt(196);
			ConfigManagerSpace.idDimensionMercury = ConfigManagerSpace.configuration.get(Configuration.CATEGORY_GENERAL, "Mercury Dimension", -40).getInt(-40);

			//VENUS
			ConfigManagerSpace.idEntityEvolvedBlaze = ConfigManagerSpace.configuration.get("Entities", "Evolved Blaze", 193).getInt(193);
			ConfigManagerSpace.idEntityVenusianVillager = ConfigManagerSpace.configuration.get("Entities", "Venusian Villager", 194).getInt(194);
			ConfigManagerSpace.idEntityFlameling = ConfigManagerSpace.configuration.get("Entities", "Flameling", 195).getInt(195);
			ConfigManagerSpace.disableVenusVillageGen = ConfigManagerSpace.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Venus Village Gen", false).getBoolean(false);
			ConfigManagerSpace.idDimensionVenus = ConfigManagerSpace.configuration.get(Configuration.CATEGORY_GENERAL, "Venus Dimension", -41).getInt(-41);
			ConfigManagerSpace.idEntityVenusianTNT = ConfigManagerSpace.configuration.get("Entities", "Venusian TNT", 438).getInt(438);

			// PLANETS/MOON
			ConfigManagerSpace.idDimensionEuropa = ConfigManagerSpace.configuration.get(Configuration.CATEGORY_GENERAL, "Europa Dimension", -50).getInt(-50);
			ConfigManagerSpace.idDimensionIo = ConfigManagerSpace.configuration.get(Configuration.CATEGORY_GENERAL, "Io Dimension", -51).getInt(-51);
			ConfigManagerSpace.idDimensionEris = ConfigManagerSpace.configuration.get(Configuration.CATEGORY_GENERAL, "Eris Dimension", -52).getInt(-52);
			ConfigManagerSpace.idDimensionCallisto = ConfigManagerSpace.configuration.get(Configuration.CATEGORY_GENERAL, "Callisto Dimension", -53).getInt(-52);

			// BIOME
			ConfigManagerSpace.idBiomeMercury = ConfigManagerSpace.configuration.get(Configuration.CATEGORY_GENERAL, "Mercury Biome", 206).getInt(206);
			ConfigManagerSpace.idBiomeVenus = ConfigManagerSpace.configuration.get(Configuration.CATEGORY_GENERAL, "Venus Biome", 207).getInt(207);
			ConfigManagerSpace.idBiomeEuropa = ConfigManagerSpace.configuration.get(Configuration.CATEGORY_GENERAL, "Europa Biome", 208).getInt(208);
			ConfigManagerSpace.idBiomeIo = ConfigManagerSpace.configuration.get(Configuration.CATEGORY_GENERAL, "Io Biome", 209).getInt(209);
			ConfigManagerSpace.idBiomeEris = ConfigManagerSpace.configuration.get(Configuration.CATEGORY_GENERAL, "Eris Biome", 210).getInt(210);
			ConfigManagerSpace.idBiomeCallisto = ConfigManagerSpace.configuration.get(Configuration.CATEGORY_GENERAL, "Callisto Biome", 211).getInt(211);
		}

		catch (final Exception e)
		{
			FMLLog.log(Level.ERROR, e, "4-Space Core Config has a problem loading it's configuration");
		}

		finally
		{
			ConfigManagerSpace.configuration.save();
			ConfigManagerSpace.loaded = true;
		}
	}
}