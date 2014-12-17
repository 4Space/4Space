package mattparks.mods.space.hole.util;

import mattparks.mods.space.hole.blocks.HoleBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeManagerHole
{
    private static void addUniversalRecipes()
    {
		// ORE DICTIONARY
		OreDictionary.registerOre("holeStone", new ItemStack(HoleBlocks.holeBasicBlock, 1, 3));

		// Smelting
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(HoleBlocks.holeBasicBlock, 2, 4), OreDictionary.getOres("holeStone").get(0), 0.2F);
    }

    public static void loadRecipes()
    {
        RecipeManagerHole.addUniversalRecipes();
    }
}