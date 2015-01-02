package mattparks.mods.space.pluto.items;

import mattparks.mods.space.pluto.PlutoCore;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class PlutoItems
{
	public static Item plutoBasicItem;
	public static Item blueGemPickaxe;
	public static Item blueGemAxe;
	public static Item blueGemHoe;
	public static Item blueGemSpade;
	public static Item blueGemSword;
	public static Item blueGemHelmet;
	public static Item blueGemChestplate;
	public static Item blueGemLeggings;
	public static Item blueGemBoots;

	public static ArmorMaterial ARMOR_BLUEGEM = EnumHelper.addArmorMaterial("blueGem", 30, new int[] { 3, 8, 6, 3 }, 12);
	public static ToolMaterial TOOL_BLUEGEM = EnumHelper.addToolMaterial("blueGem", 3, 768, 5.0F, 2, 8);

	public static void init()
	{
		initItems();
		registerItems();
		registerHarvestLevels();
	}

	private static void initItems()
	{
		PlutoItems.plutoBasicItem = new ItemBasicPluto();

		PlutoItems.blueGemPickaxe = new ItemPickaxePluto("blueGem_pickaxe", PlutoItems.TOOL_BLUEGEM);
		PlutoItems.blueGemAxe = new ItemAxePluto("blueGem_axe", PlutoItems.TOOL_BLUEGEM);
		PlutoItems.blueGemHoe = new ItemHoePluto("blueGem_hoe", PlutoItems.TOOL_BLUEGEM);
		PlutoItems.blueGemSpade = new ItemSpadePluto("blueGem_spade", PlutoItems.TOOL_BLUEGEM);
		PlutoItems.blueGemSword = new ItemSwordPluto("blueGem_sword", PlutoItems.TOOL_BLUEGEM);

		PlutoItems.blueGemHelmet = new ItemBlueGemArmor("blueGem_helmet", PlutoItems.ARMOR_BLUEGEM, 7, 0);
		PlutoItems.blueGemChestplate = new ItemBlueGemArmor("blueGem_chestplate", PlutoItems.ARMOR_BLUEGEM, 7, 1);
		PlutoItems.blueGemLeggings = new ItemBlueGemArmor("blueGem_leggings", PlutoItems.ARMOR_BLUEGEM, 7, 2);
		PlutoItems.blueGemBoots = new ItemBlueGemArmor("blueGem_boots", PlutoItems.ARMOR_BLUEGEM, 7, 3);
	}

	private static void registerHarvestLevels()
	{
		PlutoItems.blueGemPickaxe.setHarvestLevel("pickaxe", 4);
		PlutoItems.blueGemAxe.setHarvestLevel("axe", 4);
		PlutoItems.blueGemSpade.setHarvestLevel("shovel", 4);
	}

	private static void registerItems()
	{
		PlutoCore.registerItem(plutoBasicItem);

		PlutoCore.registerItem(blueGemPickaxe);
		PlutoCore.registerItem(blueGemAxe);
		PlutoCore.registerItem(blueGemHoe);
		PlutoCore.registerItem(blueGemSpade);
		PlutoCore.registerItem(blueGemSword);

		PlutoCore.registerItem(blueGemHelmet);
		PlutoCore.registerItem(blueGemChestplate);
		PlutoCore.registerItem(blueGemLeggings);
		PlutoCore.registerItem(blueGemBoots);
	}
}
