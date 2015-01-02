package mattparks.mods.space.hole.items;

import mattparks.mods.space.hole.HoleCore;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class HoleItems
{
	public static Item holeBasicItem;

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

	public static void init()
	{
		initItems();
		registerItems();
		registerHarvestLevels();
	}

	private static void initItems()
	{
		HoleItems.holeBasicItem = new ItemBasicHole();

		HoleItems.flameiteSword = new ItemSwordHole("flameite_sword", HoleItems.TOOL_FLAMEITE);
		HoleItems.flameitePickaxe = new ItemPickaxeHole("flameite_pickaxe", HoleItems.TOOL_FLAMEITE);
		HoleItems.flameiteSpade = new ItemSpadeHole("flameite_spade", HoleItems.TOOL_FLAMEITE);
		HoleItems.flameiteAxe = new ItemAxeHole("flameite_axe", HoleItems.TOOL_FLAMEITE);
		HoleItems.flameiteHoe = new ItemHoeHole("flameite_hoe", HoleItems.TOOL_FLAMEITE);

		HoleItems.flameiteHelmet = new ItemFlameiteArmor("flameite_helmet", HoleItems.ARMOR_FLAMEITE, 7, 0);
		HoleItems.flameiteChestplate = new ItemFlameiteArmor("flameite_chestplate", HoleItems.ARMOR_FLAMEITE, 7, 1);
		HoleItems.flameiteLeggings = new ItemFlameiteArmor("flameite_leggings", HoleItems.ARMOR_FLAMEITE, 7, 2);
		HoleItems.flameiteBoots = new ItemFlameiteArmor("flameite_boots", HoleItems.ARMOR_FLAMEITE, 7, 3);

		HoleItems.flameiteBattery = new ItemFlameiteBattery("flameite_battery");
	}

	private static void registerHarvestLevels()
	{
		HoleItems.flameitePickaxe.setHarvestLevel("pickaxe", 4);
		HoleItems.flameiteAxe.setHarvestLevel("axe", 4);
		HoleItems.flameiteSpade.setHarvestLevel("shovel", 4);
	}

	private static void registerItems()
	{
		HoleCore.registerItem(holeBasicItem);

		HoleCore.registerItem(flameitePickaxe);
		HoleCore.registerItem(flameiteAxe);
		HoleCore.registerItem(flameiteHoe);
		HoleCore.registerItem(flameiteSpade);
		HoleCore.registerItem(flameiteSword);

		HoleCore.registerItem(flameiteHelmet);
		HoleCore.registerItem(flameiteChestplate);
		HoleCore.registerItem(flameiteLeggings);
		HoleCore.registerItem(flameiteBoots);

		HoleCore.registerItem(flameiteBattery);
	}
}
