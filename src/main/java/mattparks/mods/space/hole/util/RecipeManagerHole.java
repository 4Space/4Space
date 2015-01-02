package mattparks.mods.space.hole.util;

import mattparks.mods.space.core.util.RecipeUtil;
import mattparks.mods.space.hole.blocks.HoleBlocks;
import mattparks.mods.space.hole.items.HoleItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeManagerHole
{
	private static void addUniversalRecipes()
	{
		// ORE DICTIONARY
		OreDictionary.registerOre("holeStone", new ItemStack(HoleBlocks.holeBasicBlock, 1, 3));
		OreDictionary.registerOre("flameiteBlock", new ItemStack(HoleBlocks.holeBasicBlock, 1, 6));
		OreDictionary.registerOre("dustFlameite", new ItemStack(HoleItems.holeBasicItem, 1, 0));
		OreDictionary.registerOre("ingotFlameite", new ItemStack(HoleItems.holeBasicItem, 1, 1));
		OreDictionary.registerOre("flameitePlate", new ItemStack(HoleItems.holeBasicItem, 1, 2));

		// ARMOR AND TOOLS CRAFTING
		RecipeUtil.addRecipe(new ItemStack(HoleItems.flameiteHelmet), new Object[] { "XXX", "X X", 'X', "ingotFlameite" });
		RecipeUtil.addRecipe(new ItemStack(HoleItems.flameiteChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "ingotFlameite" });
		RecipeUtil.addRecipe(new ItemStack(HoleItems.flameiteLeggings), new Object[] { "XXX", "X X", "X X", 'X', "ingotFlameite" });
		RecipeUtil.addRecipe(new ItemStack(HoleItems.flameiteBoots), new Object[] { "X X", "X X", 'X', "ingotFlameite" });
		RecipeUtil.addRecipe(new ItemStack(HoleItems.flameiteSword), new Object[] { "X", "X", "Y", 'X', "ingotFlameite", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(HoleItems.flameitePickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "ingotFlameite", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(HoleItems.flameiteSpade), new Object[] { "X", "Y", "Y", 'X', "ingotFlameite", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(HoleItems.flameiteHoe), new Object[] { "XX", " Y", " Y", 'X', "ingotFlameite", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(HoleItems.flameiteAxe), new Object[] { "XX", "XY", " Y", 'X', "ingotFlameite", 'Y', Items.stick });

		// ITEM TO BLOCK
		RecipeUtil.addRecipe(new ItemStack(HoleBlocks.holeBasicBlock, 1, 6), new Object[] { "XXX", "XXX", "XXX", 'X', "ingotFlameite" });

		// BLOCK TO ITEM
		RecipeUtil.addRecipe(new ItemStack(HoleItems.holeBasicItem, 9, 1), new Object[] { "X", 'X', "flameiteBlock" });

		// Smelting
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(HoleBlocks.holeBasicBlock, 2, 4), OreDictionary.getOres("holeStone").get(0), 0.2F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(HoleBlocks.holeBasicBlock, 1, 6), OreDictionary.getOres("dustFlameite").get(0), 0.2F);
	}

	public static void loadRecipes()
	{
		RecipeManagerHole.addUniversalRecipes();
	}
}
