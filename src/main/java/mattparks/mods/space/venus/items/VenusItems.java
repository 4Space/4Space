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

	public static Item rubySword;
	public static Item rubyPickaxe;
	public static Item rubySpade;
	public static Item rubyAxe;
	public static Item rubyHoe;

	public static Item rubyHelmet;
	public static Item rubyChestplate;
	public static Item rubyLeggings;
	public static Item rubyBoots;

	public static Item jetpack;

	public static Item sulfurBattery;
	public static Item uraniumBattery;

	public static ArmorMaterial JETPACK = EnumHelper.addArmorMaterial("jetpack", 30, new int[] { 3, 8, 6, 3 }, 12);

	public static ArmorMaterial ARMOR_SULFUR = EnumHelper.addArmorMaterial("sulfur", 15, new int[] { 1, 4, 2, 1 }, 7);
	public static ToolMaterial TOOL_SULFUR = EnumHelper.addToolMaterial("sulfur", 3, 416, 6.0F, 1, 2);

	public static ArmorMaterial ARMOR_RUBY = EnumHelper.addArmorMaterial("ruby", 30, new int[] { 3, 8, 6, 3 }, 12);
	public static ToolMaterial TOOL_RUBY = EnumHelper.addToolMaterial("ruby", 3, 768, 5.0F, 2, 8);

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

		VenusItems.rubySword = new ItemSwordVenus("ruby_sword", VenusItems.TOOL_RUBY);
		VenusItems.rubyPickaxe = new ItemPickaxeVenus("ruby_pickaxe", VenusItems.TOOL_RUBY);
		VenusItems.rubySpade = new ItemSpadeVenus("ruby_spade", VenusItems.TOOL_RUBY);
		VenusItems.rubyAxe = new ItemAxeVenus("ruby_axe", VenusItems.TOOL_RUBY);
		VenusItems.rubyHoe = new ItemHoeVenus("ruby_hoe", VenusItems.TOOL_RUBY);

		VenusItems.rubyHelmet = new ItemRubyArmor("ruby_helmet", VenusItems.ARMOR_RUBY, 7, 0);
		VenusItems.rubyChestplate = new ItemRubyArmor("ruby_chestplate", VenusItems.ARMOR_RUBY, 7, 1);
		VenusItems.rubyLeggings = new ItemRubyArmor("ruby_leggings", VenusItems.ARMOR_RUBY, 7, 2);
		VenusItems.rubyBoots = new ItemRubyArmor("ruby_boots", VenusItems.ARMOR_RUBY, 7, 3);

		VenusItems.jetpack = new ItemJetpack("jetpack", VenusItems.JETPACK, 7, 1);

		VenusItems.sulfurBattery = new ItemSulfurBattery("sulfur_battery");
		VenusItems.uraniumBattery = new ItemUraniumBattery("uranium_battery");
	}

	private static void registerHarvestLevels() {
		VenusItems.rubyPickaxe.setHarvestLevel("pickaxe", 4);
		VenusItems.rubyAxe.setHarvestLevel("axe", 4);
		VenusItems.rubySpade.setHarvestLevel("shovel", 4);

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

		VenusCore.registerItem(rubyPickaxe);
		VenusCore.registerItem(rubyAxe);
		VenusCore.registerItem(rubyHoe);
		VenusCore.registerItem(rubySpade);
		VenusCore.registerItem(rubySword);

		VenusCore.registerItem(rubyHelmet);
		VenusCore.registerItem(rubyChestplate);
		VenusCore.registerItem(rubyLeggings);
		VenusCore.registerItem(rubyBoots);

		VenusCore.registerItem(jetpack);

		VenusCore.registerItem(sulfurBattery);
		VenusCore.registerItem(uraniumBattery);
	}
}
