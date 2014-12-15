package mattparks.mods.space.mercury.items;

import mattparks.mods.space.mercury.MercuryCore;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MercuryItems
{
	public static Item mercuryBasicItem;
	public static Item iridiumPickaxe;
	public static Item iridiumAxe;
	public static Item iridiumHoe;
	public static Item iridiumSpade;
	public static Item iridiumSword;
	public static Item iridiumHelmet;
	public static Item iridiumChestplate;
	public static Item iridiumLeggings;
	public static Item iridiumBoots;

	public static ArmorMaterial ARMOR_IRIDIUM = EnumHelper.addArmorMaterial("iridium", 30, new int[] { 3, 8, 6, 3 }, 12);
	public static ToolMaterial TOOL_IRIDIUM = EnumHelper.addToolMaterial("iridium", 3, 768, 5.0F, 2, 8);

	public static void init()
	{
		initItems();
		registerItems();
		registerHarvestLevels();
	}

	private static void initItems()
	{
		MercuryItems.mercuryBasicItem = new ItemBasicMercury();
		
		MercuryItems.iridiumPickaxe = new ItemPickaxeMercury("iridium_pickaxe", MercuryItems.TOOL_IRIDIUM);
		MercuryItems.iridiumAxe = new ItemAxeMercury("iridium_axe", MercuryItems.TOOL_IRIDIUM);
		MercuryItems.iridiumHoe = new ItemHoeMercury("iridium_hoe", MercuryItems.TOOL_IRIDIUM);
		MercuryItems.iridiumSpade = new ItemSpadeMercury("iridium_spade", MercuryItems.TOOL_IRIDIUM);
		MercuryItems.iridiumSword = new ItemSwordMercury("iridium_sword", MercuryItems.TOOL_IRIDIUM);
		
		MercuryItems.iridiumHelmet = new ItemIridiumArmor("iridium_helmet", MercuryItems.ARMOR_IRIDIUM, 7, 0);
		MercuryItems.iridiumChestplate = new ItemIridiumArmor("iridium_chestplate", MercuryItems.ARMOR_IRIDIUM, 7, 1);
		MercuryItems.iridiumLeggings = new ItemIridiumArmor("iridium_leggings", MercuryItems.ARMOR_IRIDIUM, 7, 2);
		MercuryItems.iridiumBoots = new ItemIridiumArmor("iridium_boots", MercuryItems.ARMOR_IRIDIUM, 7, 3);
	}

	private static void registerHarvestLevels()
	{
		MercuryItems.iridiumPickaxe.setHarvestLevel("pickaxe", 4);
		MercuryItems.iridiumAxe.setHarvestLevel("axe", 4);
		MercuryItems.iridiumSpade.setHarvestLevel("shovel", 4);
	}

	private static void registerItems()
	{
		MercuryCore.registerItem(mercuryBasicItem);
		
		MercuryCore.registerItem(iridiumPickaxe);
		MercuryCore.registerItem(iridiumAxe);
		MercuryCore.registerItem(iridiumHoe);
		MercuryCore.registerItem(iridiumSpade);
		MercuryCore.registerItem(iridiumSword);
		
		MercuryCore.registerItem(iridiumHelmet);
		MercuryCore.registerItem(iridiumChestplate);
		MercuryCore.registerItem(iridiumLeggings);
		MercuryCore.registerItem(iridiumBoots);
	}
}