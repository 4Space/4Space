package mattparks.mods.venus.items;

import mattparks.mods.MattparksCore.ConfigManager;
import mattparks.mods.venus.GCVenus;
import mattparks.mods.venus.blocks.VenusBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class GCVenusItems
{
    public static Item venusItemBasic;
//    public static Item vurnBerry;

    public static Item sulfurPickaxe;
    public static Item sulfurAxe;
    public static Item sulfurHoe;
    public static Item sulfurSpade;
    public static Item sulfurSword;
    public static Item sulfurHelmet;
    public static Item sulfurChestplate;
    public static Item sulfurLeggings;
    public static Item sulfurBoots;
    
    public static Item pJetpack;
    public static Item jetpack;
    public static Item gemPickaxe;
    public static Item gemAxe;
    public static Item gemHoe;
    public static Item gemSpade;
    public static Item gemSword;
    public static Item gemHelmet;
    public static Item gemChestplate;
    public static Item gemLeggings;
    public static Item gemBoots;
    
    public static Item venusRod;
    
    public static Item venusBattery;
    
    public static EnumArmorMaterial ARMORSULFUR = EnumHelper.addArmorMaterial("SULFUR", 15, new int[] { 1, 4, 2, 1 }, 7);
    public static EnumToolMaterial TOOLSULFUR = EnumHelper.addToolMaterial("SULFUR", 3, 216, 2.5F, 0, 2);
    
    public static EnumArmorMaterial ARMORGEM = EnumHelper.addArmorMaterial("GEM", 30, new int[] { 3, 8, 6, 3 }, 12);
    public static EnumToolMaterial TOOLGEM = EnumHelper.addToolMaterial("GEM", 3, 768, 5.0F, 2, 8);
    
    public static EnumArmorMaterial ARMORJETPACK = EnumHelper.addArmorMaterial("JETPACK", 200, new int[] { 0, 0, 0, 0 }, 0);
    public static EnumArmorMaterial ARMORPJETPACK = EnumHelper.addArmorMaterial("PJETPACK", 30, new int[] { 0, 8, 0, 0 }, 8);
    
    public static void initItems()
    {    	
        GCVenusItems.venusItemBasic = new GCVenusItem(ConfigManager.idItemVenusBasic);
        
//        GCVenusItems.vurnBerry = (new GCVenusVurnBerry(ConfigManager.idVurnBerry, 4, 0.6F, (VenusBlocks.VurnBerryBush.blockID), Block.tilledField.blockID)).setUnlocalizedName("vurnBerry").setTextureName("starcraftvenus:vurnBerry");
 
        GCVenusItems.sulfurPickaxe = new GCVenusItemPickaxe(ConfigManager.idToolSulfurPickaxe, GCVenusItems.TOOLSULFUR).setUnlocalizedName("sulfurPick");
        GCVenusItems.sulfurAxe = new GCVenusItemAxe(ConfigManager.idToolSulfurAxe, GCVenusItems.TOOLSULFUR).setUnlocalizedName("sulfurAxe");
        GCVenusItems.sulfurHoe = new GCVenusItemHoe(ConfigManager.idToolSulfurHoe, GCVenusItems.TOOLSULFUR).setUnlocalizedName("sulfurHoe");
        GCVenusItems.sulfurSpade = new GCVenusItemSpade(ConfigManager.idToolSulfurSpade, GCVenusItems.TOOLSULFUR).setUnlocalizedName("sulfurSpade");
        GCVenusItems.sulfurSword = new GCVenusItemSword(ConfigManager.idToolSulfurSword, GCVenusItems.TOOLSULFUR).setUnlocalizedName("sulfurSword");
        
        GCVenusItems.sulfurHelmet = new GCVenusItemSulfurArmor(ConfigManager.idArmorSulfurHelmet, GCVenusItems.ARMORSULFUR, 7, 0, false).setUnlocalizedName("sulfurHelmet");
        GCVenusItems.sulfurChestplate = new GCVenusItemSulfurArmor(ConfigManager.idArmorSulfurChestplate, GCVenusItems.ARMORSULFUR, 7, 1, false).setUnlocalizedName("sulfurChestplate");
        GCVenusItems.sulfurLeggings = new GCVenusItemSulfurArmor(ConfigManager.idArmorSulfurLeggings, GCVenusItems.ARMORSULFUR, 7, 2, false).setUnlocalizedName("sulfurLeggings");
        GCVenusItems.sulfurBoots = new GCVenusItemSulfurArmor(ConfigManager.idArmorSulfurBoots, GCVenusItems.ARMORSULFUR, 7, 3, false).setUnlocalizedName("sulfurBoots");
    
        GCVenusItems.gemPickaxe = new GCVenusItemPickaxe(ConfigManager.idToolGemPickaxe, GCVenusItems.TOOLGEM).setUnlocalizedName("gemPick");
        GCVenusItems.gemAxe = new GCVenusItemAxe(ConfigManager.idToolGemAxe, GCVenusItems.TOOLGEM).setUnlocalizedName("gemAxe");
        GCVenusItems.gemHoe = new GCVenusItemHoe(ConfigManager.idToolGemHoe, GCVenusItems.TOOLGEM).setUnlocalizedName("gemHoe");
        GCVenusItems.gemSpade = new GCVenusItemSpade(ConfigManager.idToolGemSpade, GCVenusItems.TOOLGEM).setUnlocalizedName("gemSpade");
        GCVenusItems.gemSword = new GCVenusItemSword(ConfigManager.idToolGemSword, GCVenusItems.TOOLGEM).setUnlocalizedName("gemSword");

        GCVenusItems.gemHelmet = new GCVenusItemGemArmor(ConfigManager.idArmorGemHelmet, GCVenusItems.ARMORGEM, 7, 0, false).setUnlocalizedName("gemHelmet");
        GCVenusItems.gemChestplate = new GCVenusItemGemArmor(ConfigManager.idArmorGemChestplate, GCVenusItems.ARMORGEM, 7, 1, false).setUnlocalizedName("gemChestplate");
        GCVenusItems.gemLeggings = new GCVenusItemGemArmor(ConfigManager.idArmorGemLeggings, GCVenusItems.ARMORGEM, 7, 2, false).setUnlocalizedName("gemLeggings");
        GCVenusItems.gemBoots = new GCVenusItemGemArmor(ConfigManager.idArmorGemBoots, GCVenusItems.ARMORGEM, 7, 3, false).setUnlocalizedName("gemBoots");

        GCVenusItems.venusRod = new GCVenusRod(ConfigManager.idItemVenusRod, null).setUnlocalizedName("venusRod").setTextureName("galacticraftvenus:venusRod");
        
        GCVenusItems.pJetpack = new GCVenusItemPJetpack(ConfigManager.idPJetpack, GCVenusItems.ARMORPJETPACK, 7, 1, false).setUnlocalizedName("pJetpack");
        GCVenusItems.jetpack = new GCVenusItemJetpack(ConfigManager.idJetpack, GCVenusItems.ARMORJETPACK, 7, 1, false).setUnlocalizedName("jetpack");
        GCVenusItems.venusBattery = new GCVenusItemBattery(ConfigManager.idItemVenusBattery, "venusBattery");
    
    	registerItems();
    }
    
    public static void registerHarvestLevels()
    {
		MinecraftForge.setToolClass(GCVenusItems.gemPickaxe, "pickaxe", 4);
		MinecraftForge.setToolClass(GCVenusItems.gemAxe, "axe", 4);
		MinecraftForge.setToolClass(GCVenusItems.gemSpade, "shovel", 4);
		MinecraftForge.setToolClass(GCVenusItems.sulfurPickaxe, "pickaxe", 4);
		MinecraftForge.setToolClass(GCVenusItems.sulfurAxe, "axe", 4);
		MinecraftForge.setToolClass(GCVenusItems.sulfurSpade, "shovel", 4);
    }
    
 	private static void registerItems()
 	{
		registerItem(venusItemBasic);
//		registerItem(vurnBerry);
		
 		registerItem(sulfurPickaxe);
 		registerItem(sulfurAxe);
 		registerItem(sulfurHoe);
 		registerItem(sulfurSpade);
 		registerItem(sulfurSword);
 		
 		registerItem(sulfurHelmet);
 		registerItem(sulfurChestplate);
 		registerItem(sulfurLeggings);
 		registerItem(sulfurBoots);
		
	 	registerItem(gemPickaxe);
 		registerItem(gemAxe);
 		registerItem(gemHoe);
 		registerItem(gemSpade);
 		registerItem(gemSword);
 		
 		registerItem(gemHelmet);
 		registerItem(gemChestplate);
 		registerItem(gemLeggings);
 		registerItem(gemBoots);
		
 		registerItem(pJetpack);
 		registerItem(jetpack);
 		registerItem(venusBattery);
 		registerItem(venusRod);
 	}
 	
 	private static void registerItem(Item item)
 	{
 		GameRegistry.registerItem(item, item.getUnlocalizedName(), GCVenus.MODID);
 	}
}
