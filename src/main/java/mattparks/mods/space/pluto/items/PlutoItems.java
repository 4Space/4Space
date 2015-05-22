package mattparks.mods.space.pluto.items;

import mattparks.mods.space.pluto.PlutoCore;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class PlutoItems {
	public static Item plutoBasicItem;
	public static Item sapphirePickaxe;
	public static Item sapphireAxe;
	public static Item sapphireHoe;
	public static Item sapphireSpade;
	public static Item sapphireSword;
	public static Item sapphireHelmet;
	public static Item sapphireChestplate;
	public static Item sapphireLeggings;
	public static Item sapphireBoots;

	public static ArmorMaterial ARMOR_SAPPHIRE = EnumHelper.addArmorMaterial("sapphire", 30, new int[] { 3, 8, 6, 3 }, 12);
	public static ToolMaterial TOOL_SAPPHIRE = EnumHelper.addToolMaterial("sapphire", 3, 768, 5.0F, 2, 8);

	public static void init() {
		initItems();
		registerItems();
		registerHarvestLevels();
	}

	private static void initItems() {
		PlutoItems.plutoBasicItem = new ItemBasicPluto();

		PlutoItems.sapphirePickaxe = new ItemPickaxePluto("sapphire_pickaxe", PlutoItems.TOOL_SAPPHIRE);
		PlutoItems.sapphireAxe = new ItemAxePluto("sapphire_axe", PlutoItems.TOOL_SAPPHIRE);
		PlutoItems.sapphireHoe = new ItemHoePluto("sapphire_hoe", PlutoItems.TOOL_SAPPHIRE);
		PlutoItems.sapphireSpade = new ItemSpadePluto("sapphire_spade", PlutoItems.TOOL_SAPPHIRE);
		PlutoItems.sapphireSword = new ItemSwordPluto("sapphire_sword", PlutoItems.TOOL_SAPPHIRE);

		PlutoItems.sapphireHelmet = new ItemSapphireArmor("sapphire_helmet", PlutoItems.ARMOR_SAPPHIRE, 7, 0);
		PlutoItems.sapphireChestplate = new ItemSapphireArmor("sapphire_chestplate", PlutoItems.ARMOR_SAPPHIRE, 7, 1);
		PlutoItems.sapphireLeggings = new ItemSapphireArmor("sapphire_leggings", PlutoItems.ARMOR_SAPPHIRE, 7, 2);
		PlutoItems.sapphireBoots = new ItemSapphireArmor("sapphire_boots", PlutoItems.ARMOR_SAPPHIRE, 7, 3);
	}

	private static void registerHarvestLevels() {
		PlutoItems.sapphirePickaxe.setHarvestLevel("pickaxe", 4);
		PlutoItems.sapphireAxe.setHarvestLevel("axe", 4);
		PlutoItems.sapphireSpade.setHarvestLevel("shovel", 4);
	}

	private static void registerItems() {
		PlutoCore.registerItem(plutoBasicItem);

		PlutoCore.registerItem(sapphirePickaxe);
		PlutoCore.registerItem(sapphireAxe);
		PlutoCore.registerItem(sapphireHoe);
		PlutoCore.registerItem(sapphireSpade);
		PlutoCore.registerItem(sapphireSword);

		PlutoCore.registerItem(sapphireHelmet);
		PlutoCore.registerItem(sapphireChestplate);
		PlutoCore.registerItem(sapphireLeggings);
		PlutoCore.registerItem(sapphireBoots);
	}
}
