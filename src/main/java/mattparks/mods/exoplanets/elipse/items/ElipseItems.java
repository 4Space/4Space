package mattparks.mods.exoplanets.elipse.items;

import mattparks.mods.exoplanets.elipse.ElipseCore;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ElipseItems {
	public static Item elipseBasicItem;

	public static Item flameiteSword;
	public static Item flameitePickaxe;
	public static Item flameiteSpade;
	public static Item flameiteAxe;
	public static Item flameiteHoe;

	public static Item flameiteHelmet;
	public static Item flameiteChestplate;
	public static Item flameiteLeggings;
	public static Item flameiteBoots;

	public static Item flameiteBattery;

	public static ArmorMaterial ARMOR_FLAMEITE = EnumHelper.addArmorMaterial("flameite", 15, new int[] { 1, 4, 2, 1 }, 7);
	public static ToolMaterial TOOL_FLAMEITE = EnumHelper.addToolMaterial("flameite", 3, 416, 6.0F, 1, 2);

	public static void init() {
		initItems();
		registerItems();
		registerHarvestLevels();
	}

	private static void initItems() {
		ElipseItems.elipseBasicItem = new ItemBasicElipse();

		ElipseItems.flameiteSword = new ItemSwordElipse("flameite_sword", ElipseItems.TOOL_FLAMEITE);
		ElipseItems.flameitePickaxe = new ItemPickaxeElipse("flameite_pickaxe", ElipseItems.TOOL_FLAMEITE);
		ElipseItems.flameiteSpade = new ItemSpadeElipse("flameite_spade", ElipseItems.TOOL_FLAMEITE);
		ElipseItems.flameiteAxe = new ItemAxeElipse("flameite_axe", ElipseItems.TOOL_FLAMEITE);
		ElipseItems.flameiteHoe = new ItemHoeElipse("flameite_hoe", ElipseItems.TOOL_FLAMEITE);

		ElipseItems.flameiteHelmet = new ItemFlameiteArmor("flameite_helmet", ElipseItems.ARMOR_FLAMEITE, 7, 0);
		ElipseItems.flameiteChestplate = new ItemFlameiteArmor("flameite_chestplate", ElipseItems.ARMOR_FLAMEITE, 7, 1);
		ElipseItems.flameiteLeggings = new ItemFlameiteArmor("flameite_leggings", ElipseItems.ARMOR_FLAMEITE, 7, 2);
		ElipseItems.flameiteBoots = new ItemFlameiteArmor("flameite_boots", ElipseItems.ARMOR_FLAMEITE, 7, 3);

		ElipseItems.flameiteBattery = new ItemFlameiteBattery("flameite_battery");
	}

	private static void registerHarvestLevels() {
		ElipseItems.flameitePickaxe.setHarvestLevel("pickaxe", 4);
		ElipseItems.flameiteAxe.setHarvestLevel("axe", 4);
		ElipseItems.flameiteSpade.setHarvestLevel("shovel", 4);
	}

	private static void registerItems() {
		ElipseCore.registerItem(elipseBasicItem);

		ElipseCore.registerItem(flameitePickaxe);
		ElipseCore.registerItem(flameiteAxe);
		ElipseCore.registerItem(flameiteHoe);
		ElipseCore.registerItem(flameiteSpade);
		ElipseCore.registerItem(flameiteSword);

		ElipseCore.registerItem(flameiteHelmet);
		ElipseCore.registerItem(flameiteChestplate);
		ElipseCore.registerItem(flameiteLeggings);
		ElipseCore.registerItem(flameiteBoots);

		ElipseCore.registerItem(flameiteBattery);
	}
}
