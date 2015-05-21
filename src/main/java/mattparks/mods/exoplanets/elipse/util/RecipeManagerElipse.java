package mattparks.mods.exoplanets.elipse.util;

import mattparks.mods.exoplanets.elipse.blocks.ElipseBlocks;
import mattparks.mods.exoplanets.elipse.items.ElipseItems;
import mattparks.mods.space.core.util.RecipeUtil;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeManagerElipse {
	private static void addUniversalRecipes() {
		// ORE DICTIONARY
		OreDictionary.registerOre("elipseStone", new ItemStack(ElipseBlocks.elipseBasicBlock, 1, 3));
		OreDictionary.registerOre("flameiteBlock", new ItemStack(ElipseBlocks.elipseBasicBlock, 1, 6));
		OreDictionary.registerOre("dustFlameite", new ItemStack(ElipseItems.elipseBasicItem, 1, 0));
		OreDictionary.registerOre("ingotFlameite", new ItemStack(ElipseItems.elipseBasicItem, 1, 1));
		OreDictionary.registerOre("flameitePlate", new ItemStack(ElipseItems.elipseBasicItem, 1, 2));

		// ARMOR AND TOOLS CRAFTING
		RecipeUtil.addRecipe(new ItemStack(ElipseItems.flameiteHelmet), new Object[] { "XXX", "X X", 'X', "ingotFlameite" });
		RecipeUtil.addRecipe(new ItemStack(ElipseItems.flameiteChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "ingotFlameite" });
		RecipeUtil.addRecipe(new ItemStack(ElipseItems.flameiteLeggings), new Object[] { "XXX", "X X", "X X", 'X', "ingotFlameite" });
		RecipeUtil.addRecipe(new ItemStack(ElipseItems.flameiteBoots), new Object[] { "X X", "X X", 'X', "ingotFlameite" });
		RecipeUtil.addRecipe(new ItemStack(ElipseItems.flameiteSword), new Object[] { "X", "X", "Y", 'X', "ingotFlameite", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(ElipseItems.flameitePickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "ingotFlameite", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(ElipseItems.flameiteSpade), new Object[] { "X", "Y", "Y", 'X', "ingotFlameite", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(ElipseItems.flameiteHoe), new Object[] { "XX", " Y", " Y", 'X', "ingotFlameite", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(ElipseItems.flameiteAxe), new Object[] { "XX", "XY", " Y", 'X', "ingotFlameite", 'Y', Items.stick });

		// ITEM TO BLOCK
		RecipeUtil.addRecipe(new ItemStack(ElipseBlocks.elipseBasicBlock, 1, 6), new Object[] { "XXX", "XXX", "XXX", 'X', "ingotFlameite" });

		// BLOCK TO ITEM
		RecipeUtil.addRecipe(new ItemStack(ElipseItems.elipseBasicItem, 9, 1), new Object[] { "X", 'X', "flameiteBlock" });

		// Smelting
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(ElipseBlocks.elipseBasicBlock, 2, 4), OreDictionary.getOres("elipseStone").get(0), 0.2F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(ElipseBlocks.elipseBasicBlock, 1, 6), OreDictionary.getOres("dustFlameite").get(0), 0.2F);
	}

	public static void loadRecipes() {
		RecipeManagerElipse.addUniversalRecipes();
	}
}
