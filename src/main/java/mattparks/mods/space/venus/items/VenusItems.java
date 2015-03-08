package mattparks.mods.space.venus.items;

import mattparks.mods.space.venus.VenusCore;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class VenusItems {
	public static Item venusBasicItem;

	public static Item sulfurSword;
	public static Item sulfurPickaxe;
	public static Item sulfurSpade;
	public static Item sulfurAxe;
	public static Item sulfurHoe;

	public static Item sulfurHelmet;
	public static Item sulfurChestplate;
	public static Item sulfurLeggings;
	public static Item sulfurBoots;

	public static Item gemSword;
	public static Item gemPickaxe;
	public static Item gemSpade;
	public static Item gemAxe;
	public static Item gemHoe;

	public static Item gemHelmet;
	public static Item gemChestplate;
	public static Item gemLeggings;
	public static Item gemBoots;

	public static Item jetpack;

	public static Item sulfurBattery;
	public static Item uraniumBattery;

	public static ArmorMaterial JETPACK = EnumHelper.addArmorMaterial("jetpack", 30, new int[] { 3, 8, 6, 3 }, 12);

	public static ArmorMaterial ARMOR_SULFUR = EnumHelper.addArmorMaterial("sulfur", 15, new int[] { 1, 4, 2, 1 }, 7);
	public static ToolMaterial TOOL_SULFUR = EnumHelper.addToolMaterial("sulfur", 3, 416, 6.0F, 1, 2);

	public static ArmorMaterial ARMOR_GEM = EnumHelper.addArmorMaterial("gem", 30, new int[] { 3, 8, 6, 3 }, 12);
	public static ToolMaterial TOOL_GEM = EnumHelper.addToolMaterial("gem", 3, 768, 5.0F, 2, 8);

	public static void init() {
		initItems();
		registerItems();
		registerHarvestLevels();
	}

	private static void initItems() {
		VenusItems.venusBasicItem = new ItemBasicVenus();

		VenusItems.sulfurSword = new ItemSwordVenus("sulfur_sword", VenusItems.TOOL_SULFUR);
		VenusItems.sulfurPickaxe = new ItemPickaxeVenus("sulfur_pickaxe", VenusItems.TOOL_SULFUR);
		VenusItems.sulfurSpade = new ItemSpadeVenus("sulfur_spade", VenusItems.TOOL_SULFUR);
		VenusItems.sulfurAxe = new ItemAxeVenus("sulfur_axe", VenusItems.TOOL_SULFUR);
		VenusItems.sulfurHoe = new ItemHoeVenus("sulfur_hoe", VenusItems.TOOL_SULFUR);

		VenusItems.sulfurHelmet = new ItemSulfurArmor("sulfur_helmet", VenusItems.ARMOR_SULFUR, 7, 0);
		VenusItems.sulfurChestplate = new ItemSulfurArmor("sulfur_chestplate", VenusItems.ARMOR_SULFUR, 7, 1);
		VenusItems.sulfurLeggings = new ItemSulfurArmor("sulfur_leggings", VenusItems.ARMOR_SULFUR, 7, 2);
		VenusItems.sulfurBoots = new ItemSulfurArmor("sulfur_boots", VenusItems.ARMOR_SULFUR, 7, 3);

		VenusItems.gemSword = new ItemSwordVenus("gem_sword", VenusItems.TOOL_GEM);
		VenusItems.gemPickaxe = new ItemPickaxeVenus("gem_pickaxe", VenusItems.TOOL_GEM);
		VenusItems.gemSpade = new ItemSpadeVenus("gem_spade", VenusItems.TOOL_GEM);
		VenusItems.gemAxe = new ItemAxeVenus("gem_axe", VenusItems.TOOL_GEM);
		VenusItems.gemHoe = new ItemHoeVenus("gem_hoe", VenusItems.TOOL_GEM);

		VenusItems.gemHelmet = new ItemGemArmor("gem_helmet", VenusItems.ARMOR_GEM, 7, 0);
		VenusItems.gemChestplate = new ItemGemArmor("gem_chestplate", VenusItems.ARMOR_GEM, 7, 1);
		VenusItems.gemLeggings = new ItemGemArmor("gem_leggings", VenusItems.ARMOR_GEM, 7, 2);
		VenusItems.gemBoots = new ItemGemArmor("gem_boots", VenusItems.ARMOR_GEM, 7, 3);

		VenusItems.jetpack = new ItemSulfurArmor("jetpack", VenusItems.JETPACK, 7, 1);

		VenusItems.sulfurBattery = new ItemSulfurBattery("sulfur_battery");
		VenusItems.uraniumBattery = new ItemUraniumBattery("uranium_battery");
	}

	private static void registerHarvestLevels() {
		VenusItems.gemPickaxe.setHarvestLevel("pickaxe", 4);
		VenusItems.gemAxe.setHarvestLevel("axe", 4);
		VenusItems.gemSpade.setHarvestLevel("shovel", 4);

		VenusItems.sulfurPickaxe.setHarvestLevel("pickaxe", 4);
		VenusItems.sulfurAxe.setHarvestLevel("axe", 4);
		VenusItems.sulfurSpade.setHarvestLevel("shovel", 4);
	}

	private static void registerItems() {
		VenusCore.registerItem(venusBasicItem);

		VenusCore.registerItem(sulfurPickaxe);
		VenusCore.registerItem(sulfurAxe);
		VenusCore.registerItem(sulfurHoe);
		VenusCore.registerItem(sulfurSpade);
		VenusCore.registerItem(sulfurSword);

		VenusCore.registerItem(sulfurHelmet);
		VenusCore.registerItem(sulfurChestplate);
		VenusCore.registerItem(sulfurLeggings);
		VenusCore.registerItem(sulfurBoots);

		VenusCore.registerItem(gemPickaxe);
		VenusCore.registerItem(gemAxe);
		VenusCore.registerItem(gemHoe);
		VenusCore.registerItem(gemSpade);
		VenusCore.registerItem(gemSword);

		VenusCore.registerItem(gemHelmet);
		VenusCore.registerItem(gemChestplate);
		VenusCore.registerItem(gemLeggings);
		VenusCore.registerItem(gemBoots);

		VenusCore.registerItem(jetpack);

		VenusCore.registerItem(sulfurBattery);
		VenusCore.registerItem(uraniumBattery);
	}
}
