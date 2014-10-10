package mattparks.mods.space.core.util;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class ConfigManager
{
	public static boolean loaded;

	static Configuration configuration;

	public static boolean GenerateOtherMods;
	
    public static boolean NormalDays;
    // MERCURY    
    public static int idItemMercuryBasic;
    
    public static int idArmorMercuryIridiumHelmet;
    
    public static int idArmorMercuryIridiumChestplate;
    public static int idArmorMercuryIridiumLeggings;
    public static int idArmorMercuryIridiumBoots;
    public static int idToolMercuryIridiumSword;
    
    public static int idToolMercuryIridiumPickaxe;
    public static int idToolMercuryIridiumAxe;
    public static int idToolMercuryIridiumSpade;
    public static int idToolMercuryIridiumHoe;
    public static int idBlockMercuryGrass;
    
    public static int idBlockMercuryDirt;
    public static int idBlockMercuryStone;
    public static int idBlockMercuryBrick;
    public static int idBlockMercuryIridiumBlock;
    public static int idBlockMercuryMeteorBlock;
    public static int idBlockMercuryIridiumOre;
    public static int idBlockMercuryTinOre;
    public static int idBlockMercuryGoldOre;
    public static int idBlockMercuryCopperOre;
    public static int idBlockMercuryMeteorOre;
    public static int idBlockMercuryCaravanModule;
    public static int idBlockMercuryCaravanModulePart;
    public static int dimensionIDMercury;

    // VENUS
    public static int idItemVenusBasic;
    
    public static int idItemVenusSulfurBattery;
    public static int idItemVenusUraniumBattery;
    public static int idItemVenusRod;
    public static int idItemVurnBerry;
    public static int idVenusJetpack;
    public static int idVenusGemJetpack;
    public static int idArmorVenusSulfurHelmet;

    public static int idArmorVenusSulfurChestplate;
    public static int idArmorVenusSulfurLeggings;
    public static int idArmorVenusSulfurBoots;
    public static int idArmorVenusGemHelmet;
    public static int idArmorVenusGemChestplate;
    public static int idArmorVenusGemLeggings;
    public static int idArmorVenusGemBoots;
    public static int idToolVenusSulfurSword;

    public static int idToolVenusSulfurPickaxe;
    public static int idToolVenusSulfurAxe;
    public static int idToolVenusSulfurSpade;
    public static int idToolVenusSulfurHoe;
    public static int idToolVenusGemSword;
    public static int idToolVenusGemPickaxe;
    public static int idToolVenusGemAxe;
    public static int idToolVenusGemSpade;
    public static int idToolVenusGemHoe;
    public static int idBlockVenusBlazeEgg;

    public static int idBlockVenusGrass;
    public static int idBlockVenusDirt;
    public static int idBlockVenusStone;
    public static int idBlockVenusBrick;
    public static int idBlockVenusRedGemBlock;
    public static int idBlockVenusSulfurBlock;
    public static int idBlockVenusUraniumBlock;
    public static int idBlockVenusCrystalBlock;
    public static int idBlockVenusCompositeBlock;
    public static int idBlockVenusSulfurOre;
    public static int idBlockVenusRedGemOre;
    public static int idBlockVenusIronOre;
    public static int idBlockVenusCoalOre;
    public static int idBlockVenusTinOre;
    public static int idBlockVenusCopperOre;
    public static int idBlockVenusCrystalOre;
    public static int idBlockVenusUraniumOre;
    public static int idBlockVenusFossilizedPlantOre;
    public static int idBlockVurnBerryBush;
    public static int idBlockVenusSulfurTorch;
    public static int idEntityVenusEvolvedBlaze;
    
    public static int idEntityVenusianVillager;
    public static int dimensionIDVenus;

    public static boolean disableVenusVillageGen;
    // GAS PLANETS
    public static int dimensionIDEuropa;
    
    public static int idBlockEuropaSurface;
    public static int idBlockEuropaIce;
    public static int dimensionIDIo;
    
    public static int idBlockIoSlab;
    public static int idBlockIoFull;
    public static int idBlockIoStone;
    public ConfigManager(File file)
	{
		if (!ConfigManager.loaded)
		{
			ConfigManager.configuration = new Configuration(file);
			this.setDefaultValues();
		}
	}
    
    
	private void setDefaultValues()
	{
		try
		{
            ConfigManager.configuration.load();
            ConfigManager.GenerateOtherMods = ConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Generate other mod's features on any 4-Space world", false).getBoolean(false);        
            
            ConfigManager.NormalDays = ConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "If set to false, days will become the length of a normal overworld day.", true).getBoolean(true);        
            
            //MERCURY
            ConfigManager.idItemMercuryBasic = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemMercuryBasic", 7855).getInt(7855);

            ConfigManager.idArmorMercuryIridiumHelmet = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorMercuryIridiumHelmet", 7841).getInt(7841);
            ConfigManager.idArmorMercuryIridiumChestplate = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorMercuryIridiumChestplate", 7842).getInt(7842);
            ConfigManager.idArmorMercuryIridiumLeggings = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorMercuryIridiumLeggings", 7843).getInt(7843);
            ConfigManager.idArmorMercuryIridiumBoots = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorMercuryIridiumBoots", 7844).getInt(7844);
            
            ConfigManager.idToolMercuryIridiumSword = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolMercuryIridiumSword", 7845).getInt(7845);
            ConfigManager.idToolMercuryIridiumPickaxe = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolMercuryIridiumPickaxe", 7846).getInt(7846);
            ConfigManager.idToolMercuryIridiumSpade = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolMercuryIridiumSpade", 7847).getInt(7847);
            ConfigManager.idToolMercuryIridiumHoe = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolMercuryIridiumHoe", 7848).getInt(7848);
            ConfigManager.idToolMercuryIridiumAxe = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolMercuryIridiumAxe", 7849).getInt(7849);
            
            ConfigManager.idBlockMercuryGrass = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockMercuryGrass", 629).getInt(629);
            ConfigManager.idBlockMercuryDirt = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockMercuryDirt", 630).getInt(630);
            ConfigManager.idBlockMercuryStone = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockMercuryStone", 631).getInt(631);
            ConfigManager.idBlockMercuryBrick = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockMercuryBrick", 632).getInt(632);
            ConfigManager.idBlockMercuryIridiumBlock = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockMercuryIridiumBlock", 633).getInt(633);
            ConfigManager.idBlockMercuryMeteorBlock = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockMercuryMeteorBlock", 634).getInt(634);
            ConfigManager.idBlockMercuryIridiumOre = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockMercuryIridiumOre", 635).getInt(635);
            ConfigManager.idBlockMercuryMeteorOre = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockMercuryMeteorOre", 636).getInt(636);
            ConfigManager.idBlockMercuryTinOre = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockMercuryTinOre", 637).getInt(637);
            ConfigManager.idBlockMercuryGoldOre = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockMercuryGoldOre", 638).getInt(638);
            ConfigManager.idBlockMercuryCopperOre = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockMercuryCopperOre", 639).getInt(639);
            ConfigManager.idBlockMercuryCaravanModule = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockMercuryCaravanModule", 640).getInt(640);
            ConfigManager.idBlockMercuryCaravanModulePart = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockMercuryCaravanModulePart", 641).getInt(641);

            ConfigManager.dimensionIDMercury = ConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Mercury Dimension ID", -40).getInt(-40);

            
            //VENUS
            ConfigManager.idItemVenusBasic = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVenusItemBasic", 7898).getInt(7898);
            ConfigManager.idItemVenusSulfurBattery = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVenusSulfurBattery", 7871).getInt(7871);
            ConfigManager.idItemVenusUraniumBattery = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVenusUraniumBattery", 7872).getInt(7872);
            ConfigManager.idItemVenusRod = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVenusRod", 7873).getInt(7873);
            ConfigManager.idItemVurnBerry = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idItemVurnBerry", 7870).getInt(7870);
            ConfigManager.idVenusJetpack = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorVenusJetpack", 7882).getInt(7882);       
            ConfigManager.idVenusGemJetpack = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorVenusGemJetpack", 7883).getInt(7883);
            
            ConfigManager.idArmorVenusGemHelmet = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorVenusGemHelmet", 7874).getInt(7874);
            ConfigManager.idArmorVenusGemChestplate = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorVenusGemChestplate", 7875).getInt(7875);
            ConfigManager.idArmorVenusGemLeggings = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorVenusGemLeggings", 7876).getInt(7876);
            ConfigManager.idArmorVenusGemBoots = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorVenusGemBoots", 7877).getInt(7877);
            ConfigManager.idArmorVenusSulfurHelmet = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorVenusSulfurHelmet", 7878).getInt(7878);
            ConfigManager.idArmorVenusSulfurChestplate = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorVenusSulfurChestplate", 7879).getInt(7879);
            ConfigManager.idArmorVenusSulfurLeggings = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorVenusSulfurLeggings", 7880).getInt(7880);
            ConfigManager.idArmorVenusSulfurBoots = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idArmorVenusSulfurBoots", 7881).getInt(7881);

            ConfigManager.idToolVenusGemSword = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolVenusGemSword", 7884).getInt(7884);
            ConfigManager.idToolVenusGemPickaxe = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolVenusGemPickaxe", 7885).getInt(7885);
            ConfigManager.idToolVenusGemSpade = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolVenusGemSpade", 7886).getInt(7886);
            ConfigManager.idToolVenusGemHoe = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolVenusGemHoe", 7887).getInt(7887);
            ConfigManager.idToolVenusGemAxe = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolVenusGemAxe", 7888).getInt(7888);
            ConfigManager.idToolVenusSulfurSword = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolVenusSulfurSword", 7889).getInt(7889);
            ConfigManager.idToolVenusSulfurPickaxe = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolVenusSulfurPickaxe", 7890).getInt(7890);
            ConfigManager.idToolVenusSulfurSpade = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolVenusSulfurSpade", 7891).getInt(7891);
            ConfigManager.idToolVenusSulfurHoe = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolVenusSulfurHoe", 7892).getInt(7892);
            ConfigManager.idToolVenusSulfurAxe = ConfigManager.configuration.get(Configuration.CATEGORY_ITEM, "idToolVenusSulfurAxe", 7893).getInt(7893);

            ConfigManager.idBlockVenusGrass = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusGrass", 760).getInt(760);
            ConfigManager.idBlockVenusDirt = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusDirt", 761).getInt(761);
            ConfigManager.idBlockVenusStone = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusStone", 762).getInt(762);
            ConfigManager.idBlockVenusBrick = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusBrick", 763).getInt(763);
            ConfigManager.idBlockVenusBlazeEgg = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusBlazeEgg", 764).getInt(764);
            ConfigManager.idBlockVenusRedGemBlock = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusRedGemBlock", 765).getInt(765);
            ConfigManager.idBlockVenusSulfurBlock = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusSulfurBlock", 766).getInt(766);
            ConfigManager.idBlockVenusUraniumBlock = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusUraniumBlock", 767).getInt(767);
            ConfigManager.idBlockVenusCrystalBlock = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusCrystalBlock", 768).getInt(768);
            ConfigManager.idBlockVenusCompositeBlock = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusCompositeBlock", 769).getInt(769);
                       
            ConfigManager.idBlockVenusSulfurOre = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusSulfurOre", 779).getInt(779);
            ConfigManager.idBlockVenusRedGemOre = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusRedGemOre", 780).getInt(780);
            ConfigManager.idBlockVenusUraniumOre = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusUraniumOre", 781).getInt(781);
            ConfigManager.idBlockVenusIronOre = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusIronOre", 782).getInt(782);
            ConfigManager.idBlockVenusCoalOre = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusCoalOre", 783).getInt(783);
            ConfigManager.idBlockVenusTinOre = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusTinOre", 784).getInt(784);
            ConfigManager.idBlockVenusCopperOre = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusCopperOre", 785).getInt(785);
            ConfigManager.idBlockVenusCrystalOre = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusCrystalOre", 786).getInt(786);
            ConfigManager.idBlockVenusFossilizedPlantOre = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusFossilizedPlantOre", 787).getInt(787);
            ConfigManager.idBlockVurnBerryBush = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVurnBerryBush", 788).getInt(788);
            ConfigManager.idBlockVenusSulfurTorch = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockVenusSulfurTorch", 789).getInt(789);
            
            ConfigManager.idEntityVenusEvolvedBlaze = ConfigManager.configuration.get("Entities", "idEntityEvolvedBlaze", 193).getInt(193);
            ConfigManager.idEntityVenusianVillager = ConfigManager.configuration.get("Entities", "idEntityVenusianVillager", 194).getInt(194);
            
            ConfigManager.disableVenusVillageGen = ConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Disable Venus Village Gen", false).getBoolean(false);  
            
            ConfigManager.dimensionIDVenus = ConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Venus Dimension ID", -41).getInt(-41);

            
            // GAS PLANETS
            ConfigManager.dimensionIDEuropa = ConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Europa Dimension ID", -50).getInt(-50);
            ConfigManager.idBlockEuropaSurface = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockEuropaSurface", 809).getInt(809);
            ConfigManager.idBlockEuropaIce = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockEuropaIce", 810).getInt(810);
            
            ConfigManager.dimensionIDIo = ConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Io Dimension ID", -51).getInt(-51);
            ConfigManager.idBlockIoSlab = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockIoSlab", 820).getInt(820);
            ConfigManager.idBlockIoFull = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockIoFull", 821).getInt(821);
            ConfigManager.idBlockIoStone = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idBlockIoStone", 822).getInt(822); 
		}
		
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "4-Space Core Config has a problem loading it's configuration");
        }
		
        finally
        {
            ConfigManager.configuration.save();
            ConfigManager.loaded = true;
        }
    }
}