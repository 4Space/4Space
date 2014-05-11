package mattparks.mods.venus;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class GCVenusConfigManager
{
    public static boolean loaded;

    static Configuration configuration;

    // DIMENSIONS
    public static int dimensionIDVenus;

    // ITEMS
    public static int idItemVenusBasic;

    // BLOCKS

    
    // ARMOR

    // TOOLS


    // GUI

    // SCHEMATIC

    // ACHIEVEMENTS
    
    // GENERAL
    public static boolean generateOtherMods;
    
    public GCVenusConfigManager(File file)
    {
        if (!GCVenusConfigManager.loaded)
        {
            GCVenusConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            GCVenusConfigManager.configuration.load();

            GCVenusConfigManager.dimensionIDVenus = GCVenusConfigManager.configuration.get("Dimensions", "Venus Dimension ID", -41).getInt(-41);

            GCVenusConfigManager.idItemVenusBasic = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemvenusItemBasic", 7870).getInt(7870);

            GCVenusConfigManager.generateOtherMods = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Venus", false).getBoolean(false);        
        }
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Galacticraft Venus has a problem loading it's configuration");
        }
        finally
        {
            GCVenusConfigManager.configuration.save();
            GCVenusConfigManager.loaded = true;
        }
    }
}