package mattparks.mods.venus;

import java.io.File;
import java.util.logging.Level;

import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
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
    public static int idItemVenusBattery;
    public static int idItemVenusRod;
    public static int idVurnBerry;

    // BLOCKS
    
    
    // ARMOR
    public static int idArmorSulferHelmet;
    public static int idArmorSulferChestplate;
    public static int idArmorSulferLeggings;
    public static int idArmorSulferBoots;
    
    public static int idArmorGemHelmet;
    public static int idArmorGemChestplate;
    public static int idArmorGemLeggings;
    public static int idArmorGemBoots;
    
    public static int idJetpack;
    
    // TOOLS
    public static int idToolSulferSword;
    public static int idToolSulferPickaxe;
    public static int idToolSulferAxe;
    public static int idToolSulferSpade;
    public static int idToolSulferHoe;
    
    public static int idToolGemSword;
    public static int idToolGemPickaxe;
    public static int idToolGemAxe;
    public static int idToolGemSpade;
    public static int idToolGemHoe;
    
    // ENTITIES
    public static int idEntityEvolvedBlaze;
    public static int idEntityVenusianVillager;

    // GUI

    // SCHEMATIC

    // ACHIEVEMENTS
    
    // GENERAL
    public static boolean generateOtherMods;
    public static boolean disableVenusVillageGen;
    
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

            GCVenusConfigManager.idItemVenusBasic = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVenusItemBasic", 7870).getInt(7870);
            GCVenusConfigManager.idVurnBerry = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idVurnBerry", 7871).getInt(7871);

            GCVenusConfigManager.idItemVenusBattery = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVenusBattery", 7872).getInt(7872);
            
            GCVenusConfigManager.idItemVenusRod = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVenusRod", 8880).getInt(8880);
            
            
            GCVenusConfigManager.idArmorGemHelmet = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemHelmet", 7852).getInt(7852);
            GCVenusConfigManager.idArmorGemChestplate = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemChestplate", 7853).getInt(7853);
            GCVenusConfigManager.idArmorGemLeggings = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemLeggings", 7854).getInt(7854);
            GCVenusConfigManager.idArmorGemBoots = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemBoots", 7855).getInt(7855);
            GCVenusConfigManager.idToolGemSword = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSword", 7856).getInt(7856);
            GCVenusConfigManager.idToolGemPickaxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemPickaxe", 7857).getInt(7857);
            GCVenusConfigManager.idToolGemSpade = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSpade", 7858).getInt(7858);
            GCVenusConfigManager.idToolGemHoe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemHoe", 7859).getInt(7859);
            GCVenusConfigManager.idToolGemAxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemAxe", 7860).getInt(7860);
            
            GCVenusConfigManager.idArmorSulferHelmet = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulferHelmet", 7861).getInt(7861);
            GCVenusConfigManager.idArmorSulferChestplate = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulferChestplate", 7862).getInt(7862);
            GCVenusConfigManager.idArmorSulferLeggings = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulferLeggings", 7863).getInt(7863);
            GCVenusConfigManager.idArmorSulferBoots = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulferBoots", 7864).getInt(7864);
            GCVenusConfigManager.idToolSulferSword = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferSword", 7865).getInt(7865);
            GCVenusConfigManager.idToolSulferPickaxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferPickaxe", 7866).getInt(7866);
            GCVenusConfigManager.idToolSulferSpade = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferSpade", 7867).getInt(7867);
            GCVenusConfigManager.idToolSulferHoe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferHoe", 7868).getInt(7868);
            GCVenusConfigManager.idToolSulferAxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulferAxe", 7869).getInt(7869);
            GCVenusConfigManager.idJetpack = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idJetpack", 8879).getInt(8879);
            
            GCVenusConfigManager.idEntityEvolvedBlaze = GCVenusConfigManager.configuration.get("Entities", "idEntityEvolvedBlaze", 193).getInt(193);
            GCVenusConfigManager.idEntityVenusianVillager = GCVenusConfigManager.configuration.get("Entities", "idEntityVenusianVillager", 194).getInt(194);

            GCVenusConfigManager.generateOtherMods = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on Venus", false).getBoolean(false);        
            GCVenusConfigManager.disableVenusVillageGen = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Venus Village Gen", false).getBoolean(false);  
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