package mattparks.mods.space.venus.util;

import mattparks.mods.space.core.util.RecipeUtil;
import mattparks.mods.space.venus.blocks.VenusBlocks;
import mattparks.mods.space.venus.items.VenusItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeManagerVenus {
	private static void addUniversalRecipes() {
		// ORE DICTIONARY
		OreDictionary.registerOre("dustSulfur", new ItemStack(VenusItems.venusBasicItem, 1, 0));
		OreDictionary.registerOre("itemSulfurDust", new ItemStack(VenusItems.venusBasicItem, 1, 0)); // FOR
																										// ICBM
																										// SPIKES
		OreDictionary.registerOre("ingotSulfur", new ItemStack(VenusItems.venusBasicItem, 1, 1));
		OreDictionary.registerOre("redGem", new ItemStack(VenusItems.venusBasicItem, 1, 2));
		OreDictionary.registerOre("ingotUranium", new ItemStack(VenusItems.venusBasicItem, 1, 3));
		OreDictionary.registerOre("VenusCrystal", new ItemStack(VenusItems.venusBasicItem, 1, 4));

		OreDictionary.registerOre("sulfurPlate", new ItemStack(VenusItems.venusBasicItem, 1, 5));
		OreDictionary.registerOre("redGemPlate", new ItemStack(VenusItems.venusBasicItem, 1, 6));
		OreDictionary.registerOre("uraniumPlate", new ItemStack(VenusItems.venusBasicItem, 1, 7));

		OreDictionary.registerOre("vurnStone", new ItemStack(VenusBlocks.vurnStone, 1, 0));
		OreDictionary.registerOre("venusStone", new ItemStack(VenusBlocks.venusBasicBlock, 1, 2));
		OreDictionary.registerOre("sulfurDecor", new ItemStack(VenusBlocks.venusDecorBlock, 1, 0));
		OreDictionary.registerOre("uraniumDecor", new ItemStack(VenusBlocks.venusDecorBlock, 1, 1));
		OreDictionary.registerOre("gemDecor", new ItemStack(VenusBlocks.venusDecorBlock, 1, 2));
		OreDictionary.registerOre("crystalDecor", new ItemStack(VenusBlocks.venusDecorBlock, 1, 3));

		OreDictionary.registerOre("venusRodDust", new ItemStack(VenusItems.venusBasicItem, 1, 10));
		OreDictionary.registerOre("VenusPowerCrystal", new ItemStack(VenusItems.venusBasicItem, 1, 11));

		OreDictionary.registerOre("jetpackThruster", new ItemStack(VenusItems.venusBasicItem, 1, 12));
		OreDictionary.registerOre("jetpackBody", new ItemStack(VenusItems.venusBasicItem, 1, 13));

		// ARMOR AND TOOLS CRAFTING
		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemBoots), new Object[] { "X X", "X X", 'X', "redGem" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemHelmet), new Object[] { "XXX", "X X", 'X', "redGem" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "redGem" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemLeggings), new Object[] { "XXX", "X X", "X X", 'X', "redGem" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemSword), new Object[] { "X", "X", "Y", 'X', "redGem", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "redGem", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemSpade), new Object[] { "X", "Y", "Y", 'X', "redGem", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemHoe), new Object[] { "XX", " Y", " Y", 'X', "redGem", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemAxe), new Object[] { "XX", "XY", " Y", 'X', "redGem", 'Y', Items.stick });

		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurHelmet), new Object[] { "XXX", "X X", 'X', "ingotSulfur" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "ingotSulfur" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurLeggings), new Object[] { "XXX", "X X", "X X", 'X', "ingotSulfur" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurBoots), new Object[] { "X X", "X X", 'X', "ingotSulfur" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurSword), new Object[] { "X", "X", "Y", 'X', "ingotSulfur", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "ingotSulfur", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurSpade), new Object[] { "X", "Y", "Y", 'X', "ingotSulfur", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurHoe), new Object[] { "XX", " Y", " Y", 'X', "ingotSulfur", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurAxe), new Object[] { "XX", "XY", " Y", 'X', "ingotSulfur", 'Y', Items.stick });

		RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBasicItem, 1, 13), new Object[] { "III", "IRI", 'I', Items.iron_ingot, 'R', Items.redstone });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBasicItem, 1, 12), new Object[] { "IRI", "C C", 'I', Items.iron_ingot, 'R', Items.redstone, 'C', Items.coal });

		RecipeUtil.addRecipe(new ItemStack(VenusItems.jetpack), new Object[] { "TBT", 'B', "jetpackBody", 'T', "jetpackThruster" });

		// OTHERS CRAFTING
		RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBasicItem, 1, 11), new Object[] { "D D", " C ", "D D", 'D', "venusRodDust", 'C', "VenusCrystal" });

		RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBasicItem, 1, 1), new Object[] { "XX", 'X', "dustSulfur" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBasicItem, 2, 0), new Object[] { "X", 'X', "ingotSulfur" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBasicItem, 4, 10), new Object[] { "X", 'X', new ItemStack(VenusItems.venusBasicItem, 1, 9) });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.uraniumBattery, 1, 100), new Object[] { "TTT", "SIS", "TTT", 'T', "redGemPlate", 'I', "uraniumDecor", 'S', VenusItems.sulfurBattery });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurBattery, 1, 100), new Object[] { "TRT", "RVR", "TRT", 'T', "sulfurPlate", 'V', "VenusPowerCrystal", 'R', Items.redstone });

		// ITEM TO BLOCK
		RecipeUtil.addRecipe(new ItemStack(VenusBlocks.venusianTNT, 1, 0), new Object[] { "DXD", "XDX", "DXD", 'X', "dustSulfur", 'D', "venusRodDust" });
		RecipeUtil.addRecipe(new ItemStack(VenusBlocks.venusDecorBlock, 1, 3), new Object[] { "XXX", "XXX", "XXX", 'X', "VenusCrystal" });
		RecipeUtil.addRecipe(new ItemStack(VenusBlocks.venusDecorBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "ingotUranium" });
		RecipeUtil.addRecipe(new ItemStack(VenusBlocks.venusDecorBlock, 1, 2), new Object[] { "XXX", "XXX", "XXX", 'X', "redGem" });
		RecipeUtil.addRecipe(new ItemStack(VenusBlocks.venusDecorBlock, 1, 0), new Object[] { "XXX", "XXX", "XXX", 'X', "ingotSulfur" });

		RecipeUtil.addRecipe(new ItemStack(VenusBlocks.sulfurTorch, 4, 0), new Object[] { "X", "Y", 'X', "dustSulfur", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(VenusBlocks.sulfurTorch, 4, 0), new Object[] { "X", "Y", 'X', "itemSulfurDust", 'Y', Items.stick });

		// BLOCK TO ITEM
		RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBasicItem, 9, 1), new Object[] { "X", 'X', "sulfurDecor" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBasicItem, 9, 2), new Object[] { "X", 'X', "gemDecor" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBasicItem, 9, 3), new Object[] { "X", 'X', "uraniumDecor" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBasicItem, 9, 4), new Object[] { "X", 'X', "crystalDecor" });

		// Smelting
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.venusBasicBlock, 1, 2), OreDictionary.getOres("vurnStone").get(0), 0.2F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.venusBasicBlock, 1, 3), OreDictionary.getOres("venusStone").get(0), 0.2F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.venusBasicBlock, 2, 4), OreDictionary.getOres("dustSulfur").get(0), 0.2F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.venusBasicBlock, 1, 11), new ItemStack(Items.coal), 0.2F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.venusBasicBlock, 1, 10), new ItemStack(Items.iron_ingot), 0.2F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.venusBasicBlock, 1, 9), OreDictionary.getOres("ingotCopper").get(0), 0.2F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.venusBasicBlock, 1, 8), OreDictionary.getOres("ingotTin").get(0), 0.2F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.venusBasicBlock, 1, 6), OreDictionary.getOres("redGem").get(0), 0.2F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.venusBasicBlock, 1, 7), OreDictionary.getOres("VenusCrystal").get(0), 0.2F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.venusBasicBlock, 1, 5), OreDictionary.getOres("ingotUranium").get(0), 0.2F);
	}

	public static void loadRecipes() {
		RecipeManagerVenus.addUniversalRecipes();
	}
}
