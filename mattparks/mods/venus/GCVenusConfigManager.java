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
    public static int idArmorSulfurHelmet;
    public static int idArmorSulfurChestplate;
    public static int idArmorSulfurLeggings;
    public static int idArmorSulfurBoots;
    
    public static int idArmorGemHelmet;
    public static int idArmorGemChestplate;
    public static int idArmorGemLeggings;
    public static int idArmorGemBoots;
    
    public static int idJetpack;
    public static int idPJetpack;
    
    // TOOLS
    public static int idToolSulfurSword;
    public static int idToolSulfurPickaxe;
    public static int idToolSulfurAxe;
    public static int idToolSulfurSpade;
    public static int idToolSulfurHoe;
    
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

            GCVenusConfigManager.idItemVenusBasic = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVenusItemBasic", 7868).getInt(7868);
            
            GCVenusConfigManager.idJetpack = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idJetpack", 7869).getInt(7869);
            
            GCVenusConfigManager.idPJetpack = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idPJetpack", 7870).getInt(7870);
            
            GCVenusConfigManager.idVurnBerry = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idVurnBerry", 7871).getInt(7871);

            GCVenusConfigManager.idItemVenusBattery = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVenusBattery", 7872).getInt(7872);
            
            GCVenusConfigManager.idItemVenusRod = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVenusRod", 7873).getInt(7873);
            
            
            GCVenusConfigManager.idArmorGemHelmet = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemHelmet", 7874).getInt(7874);
            GCVenusConfigManager.idArmorGemChestplate = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemChestplate", 7875).getInt(7875);
            GCVenusConfigManager.idArmorGemLeggings = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemLeggings", 7876).getInt(7876);
            GCVenusConfigManager.idArmorGemBoots = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorGemBoots", 7877).getInt(7877);
            GCVenusConfigManager.idToolGemSword = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSword", 7878).getInt(7878);
            GCVenusConfigManager.idToolGemPickaxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemPickaxe", 7879).getInt(7879);
            GCVenusConfigManager.idToolGemSpade = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemSpade", 7880).getInt(7880);
            GCVenusConfigManager.idToolGemHoe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemHoe", 7881).getInt(7881);
            GCVenusConfigManager.idToolGemAxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolGemAxe", 7882).getInt(7882);
            
            GCVenusConfigManager.idArmorSulfurHelmet = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulfurHelmet", 7883).getInt(7883);
            GCVenusConfigManager.idArmorSulfurChestplate = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulfurChestplate", 7884).getInt(7884);
            GCVenusConfigManager.idArmorSulfurLeggings = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulfurLeggings", 7885).getInt(7885);
            GCVenusConfigManager.idArmorSulfurBoots = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorSulfurBoots", 7886).getInt(7886);
            GCVenusConfigManager.idToolSulfurSword = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulfurSword", 7887).getInt(7887);
            GCVenusConfigManager.idToolSulfurPickaxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulfurPickaxe", 7888).getInt(7888);
            GCVenusConfigManager.idToolSulfurSpade = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulfurSpade", 7889).getInt(7889);
            GCVenusConfigManager.idToolSulfurHoe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulfurHoe", 7890).getInt(7890);
            GCVenusConfigManager.idToolSulfurAxe = GCVenusConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolSulfurAxe", 7891).getInt(7891);
            
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