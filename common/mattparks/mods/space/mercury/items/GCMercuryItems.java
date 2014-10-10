package mattparks.mods.space.mercury.items;

import mattparks.mods.space.core.util.ConfigManager;
import mattparks.mods.space.mercury.GCMercury;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class GCMercuryItems
{
    public static void initItems()
    {    	
        GCMercuryItems.mercuryItemBasic = new GCMercuryItem(ConfigManager.idItemMercuryBasic);

        GCMercuryItems.iridiumPickaxe = new GCMercuryItemPickaxe(ConfigManager.idToolMercuryIridiumPickaxe, GCMercuryItems.TOOLIRIDIUM).setUnlocalizedName("iridiumPick");
        GCMercuryItems.iridiumAxe = new GCMercuryItemAxe(ConfigManager.idToolMercuryIridiumAxe, GCMercuryItems.TOOLIRIDIUM).setUnlocalizedName("iridiumAxe");
        GCMercuryItems.iridiumHoe = new GCMercuryItemHoe(ConfigManager.idToolMercuryIridiumHoe, GCMercuryItems.TOOLIRIDIUM).setUnlocalizedName("iridiumHoe");
        GCMercuryItems.iridiumSpade = new GCMercuryItemSpade(ConfigManager.idToolMercuryIridiumSpade, GCMercuryItems.TOOLIRIDIUM).setUnlocalizedName("iridiumSpade");
        GCMercuryItems.iridiumSword = new GCMercuryItemSword(ConfigManager.idToolMercuryIridiumSword, GCMercuryItems.TOOLIRIDIUM).setUnlocalizedName("iridiumSword");

        GCMercuryItems.iridiumHelmet = new GCMercuryItemIridiumArmor(ConfigManager.idArmorMercuryIridiumHelmet, GCMercuryItems.ARMORIRIDIUM, 7, 0, false).setUnlocalizedName("iridiumHelmet");
        GCMercuryItems.iridiumChestplate = new GCMercuryItemIridiumArmor(ConfigManager.idArmorMercuryIridiumChestplate, GCMercuryItems.ARMORIRIDIUM, 7, 1, false).setUnlocalizedName("iridiumChestplate");
        GCMercuryItems.iridiumLeggings = new GCMercuryItemIridiumArmor(ConfigManager.idArmorMercuryIridiumLeggings, GCMercuryItems.ARMORIRIDIUM, 7, 2, false).setUnlocalizedName("iridiumLeggings");
        GCMercuryItems.iridiumBoots = new GCMercuryItemIridiumArmor(ConfigManager.idArmorMercuryIridiumBoots, GCMercuryItems.ARMORIRIDIUM, 7, 3, false).setUnlocalizedName("iridiumBoots");

    	registerItems();
    }

    public static void registerHarvestLevels()
    {
    	MinecraftForge.setToolClass(GCMercuryItems.iridiumPickaxe, "pickaxe", 4);
		MinecraftForge.setToolClass(GCMercuryItems.iridiumPickaxe, "brickPickaxe", 4);
		MinecraftForge.setToolClass(GCMercuryItems.iridiumAxe, "axe", 4);
		MinecraftForge.setToolClass(GCMercuryItems.iridiumSpade, "shovel", 4);
    }
    private static void registerItem(Item item)
 	{
 		GameRegistry.registerItem(item, item.getUnlocalizedName(), GCMercury.MODID);
 	}
    private static void registerItems()
 	{
 		registerItem(mercuryItemBasic);

	 	registerItem(iridiumPickaxe);
 		registerItem(iridiumAxe);
 		registerItem(iridiumHoe);
 		registerItem(iridiumSpade);
 		registerItem(iridiumSword);
 		
 		registerItem(iridiumHelmet);
 		registerItem(iridiumChestplate);
 		registerItem(iridiumLeggings);
 		registerItem(iridiumBoots);

 	}
    public static Item mercuryItemBasic;
    public static Item iridiumPickaxe;
    public static Item iridiumAxe;
    public static Item iridiumHoe;
    public static Item iridiumSpade;
    public static Item iridiumSword;


    public static Item iridiumHelmet;
    public static Item iridiumChestplate;

    public static Item iridiumLeggings;
    
    public static Item iridiumBoots;
    
 	public static EnumArmorMaterial ARMORIRIDIUM = EnumHelper.addArmorMaterial("IRIDIUM", 30, new int[] { 3, 8, 6, 3 }, 12);
 	
 	public static EnumToolMaterial TOOLIRIDIUM = EnumHelper.addToolMaterial("IRIDIUM", 3, 768, 5.0F, 2, 8);
}
