package mattparks.mods.venus.items;

import mattparks.mods.venus.GCVenus;
import mattparks.mods.venus.GCVenusConfigManager;
import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class GCVenusItems
{
    public static Item venusItemBasic;
    public static Item vurnBerry;

    public static Item sulferPickaxe;
    public static Item sulferAxe;
    public static Item sulferHoe;
    public static Item sulferSpade;
    public static Item sulferSword;
    public static Item sulferHelmet;
    public static Item sulferChestplate;
    public static Item sulferLeggings;
    public static Item sulferBoots;
    
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
    
    public static EnumArmorMaterial ARMORSULFER = EnumHelper.addArmorMaterial("SULFER", 42, new int[] { 4, 9, 7, 4 }, 12);
    public static EnumToolMaterial TOOLSULFER = EnumHelper.addToolMaterial("SULFER", 3, 1024, 5.0F, 2.5F, 8);
    
    public static EnumArmorMaterial ARMORGEM = EnumHelper.addArmorMaterial("GEM", 42, new int[] { 3, 3, 3, 3 }, 12);
    public static EnumToolMaterial TOOLGEM = EnumHelper.addToolMaterial("GEM", 3, 1024, 5.0F, 2.5F, 8);
    
    public static EnumArmorMaterial ARMORJETPACK = EnumHelper.addArmorMaterial("JETPACK", 42, new int[] { 4, 9, 7, 4 }, 12);
    
    public static void initItems()
    {    	
        GCVenusItems.venusItemBasic = new GCVenusItem(GCVenusConfigManager.idItemVenusBasic);
        GCVenusItems.vurnBerry = (new GCVenusVurnBerry(GCVenusConfigManager.idVurnBerry, 4, 0.6F, GCVenus.VurnBerryBush.blockID, Block.tilledField.blockID)).setUnlocalizedName("vurnBerry").setTextureName("galacticraftvenus:vurnBerry");
 
        GCVenusItems.sulferPickaxe = new GCVenusItemPickaxe(GCVenusConfigManager.idToolSulferPickaxe, GCVenusItems.TOOLSULFER).setUnlocalizedName("sulferPick");
        GCVenusItems.sulferAxe = new GCVenusItemAxe(GCVenusConfigManager.idToolSulferAxe, GCVenusItems.TOOLSULFER).setUnlocalizedName("sulferAxe");
        GCVenusItems.sulferHoe = new GCVenusItemHoe(GCVenusConfigManager.idToolSulferHoe, GCVenusItems.TOOLSULFER).setUnlocalizedName("sulferHoe");
        GCVenusItems.sulferSpade = new GCVenusItemSpade(GCVenusConfigManager.idToolSulferSpade, GCVenusItems.TOOLSULFER).setUnlocalizedName("sulferSpade");
        GCVenusItems.sulferSword = new GCVenusItemSword(GCVenusConfigManager.idToolSulferSword, GCVenusItems.TOOLSULFER).setUnlocalizedName("sulferSword");
        
        GCVenusItems.sulferHelmet = new GCVenusItemSulferArmor(GCVenusConfigManager.idArmorSulferHelmet, GCVenusItems.ARMORSULFER, 7, 0, false).setUnlocalizedName("sulferHelmet");
        GCVenusItems.sulferChestplate = new GCVenusItemSulferArmor(GCVenusConfigManager.idArmorSulferChestplate, GCVenusItems.ARMORSULFER, 7, 1, false).setUnlocalizedName("sulferChestplate");
        GCVenusItems.sulferLeggings = new GCVenusItemSulferArmor(GCVenusConfigManager.idArmorSulferLeggings, GCVenusItems.ARMORSULFER, 7, 2, false).setUnlocalizedName("sulferLeggings");
        GCVenusItems.sulferBoots = new GCVenusItemSulferArmor(GCVenusConfigManager.idArmorSulferBoots, GCVenusItems.ARMORSULFER, 7, 3, false).setUnlocalizedName("sulferBoots");
    
        GCVenusItems.gemPickaxe = new GCVenusItemPickaxe(GCVenusConfigManager.idToolGemPickaxe, GCVenusItems.TOOLGEM).setUnlocalizedName("gemPick");
        GCVenusItems.gemAxe = new GCVenusItemAxe(GCVenusConfigManager.idToolGemAxe, GCVenusItems.TOOLGEM).setUnlocalizedName("gemAxe");
        GCVenusItems.gemHoe = new GCVenusItemHoe(GCVenusConfigManager.idToolGemHoe, GCVenusItems.TOOLGEM).setUnlocalizedName("gemHoe");
        GCVenusItems.gemSpade = new GCVenusItemSpade(GCVenusConfigManager.idToolGemSpade, GCVenusItems.TOOLGEM).setUnlocalizedName("gemSpade");
        GCVenusItems.gemSword = new GCVenusItemSword(GCVenusConfigManager.idToolGemSword, GCVenusItems.TOOLGEM).setUnlocalizedName("gemSword");

        GCVenusItems.gemHelmet = new GCVenusItemGemArmor(GCVenusConfigManager.idArmorGemHelmet, GCVenusItems.ARMORGEM, 7, 0, false).setUnlocalizedName("gemHelmet");
        GCVenusItems.gemChestplate = new GCVenusItemGemArmor(GCVenusConfigManager.idArmorGemChestplate, GCVenusItems.ARMORGEM, 7, 1, false).setUnlocalizedName("gemChestplate");
        GCVenusItems.gemLeggings = new GCVenusItemGemArmor(GCVenusConfigManager.idArmorGemLeggings, GCVenusItems.ARMORGEM, 7, 2, false).setUnlocalizedName("gemLeggings");
        GCVenusItems.gemBoots = new GCVenusItemGemArmor(GCVenusConfigManager.idArmorGemBoots, GCVenusItems.ARMORGEM, 7, 3, false).setUnlocalizedName("gemBoots");

        GCVenusItems.venusRod = new GCVenusRod(GCVenusConfigManager.idItemVenusRod, null).setUnlocalizedName("venusRod").setTextureName("galacticraftvenus:venusRod");
        
        GCVenusItems.jetpack = new GCVenusItemJetpack(GCVenusConfigManager.idJetpack, GCVenusItems.ARMORJETPACK, 7, 1, false).setUnlocalizedName("jetpack");
        GCVenusItems.venusBattery = new GCVenusItemBattery(GCVenusConfigManager.idItemVenusBattery, "venusBattery");
    
    	registerItems();
    }
    
    public static void registerHarvestLevels()
    {
		MinecraftForge.setToolClass(GCVenusItems.gemPickaxe, "pickaxe", 4);
		MinecraftForge.setToolClass(GCVenusItems.gemAxe, "axe", 4);
		MinecraftForge.setToolClass(GCVenusItems.gemSpade, "shovel", 4);
		MinecraftForge.setToolClass(GCVenusItems.sulferPickaxe, "pickaxe", 4);
		MinecraftForge.setToolClass(GCVenusItems.sulferAxe, "axe", 4);
		MinecraftForge.setToolClass(GCVenusItems.sulferSpade, "shovel", 4);
    }
    
 	private static void registerItems()
 	{
 		registerItem(venusItemBasic);
		registerItem(vurnBerry);
		
 		registerItem(sulferPickaxe);
 		registerItem(sulferAxe);
 		registerItem(sulferHoe);
 		registerItem(sulferSpade);
 		registerItem(sulferSword);
 		
 		registerItem(sulferHelmet);
 		registerItem(sulferChestplate);
 		registerItem(sulferLeggings);
 		registerItem(sulferBoots);
		
	 	registerItem(gemPickaxe);
 		registerItem(gemAxe);
 		registerItem(gemHoe);
 		registerItem(gemSpade);
 		registerItem(gemSword);
 		
 		registerItem(gemHelmet);
 		registerItem(gemChestplate);
 		registerItem(gemLeggings);
 		registerItem(gemBoots);
		
 		registerItem(jetpack);
 		registerItem(venusBattery);
 	}
 	
 	private static void registerItem(Item item)
 	{
 		GameRegistry.registerItem(item, item.getUnlocalizedName(), GCVenus.MODID);
 	}
}
