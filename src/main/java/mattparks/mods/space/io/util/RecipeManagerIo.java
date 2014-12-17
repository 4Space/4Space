package mattparks.mods.space.io.util;

import mattparks.mods.space.core.util.RecipeUtil;
import mattparks.mods.space.io.items.IoItems;
import net.minecraft.item.ItemStack;

public class RecipeManagerIo
{
    private static void addUniversalRecipes()
    {
    	OreDictionary.registerOre("ioStone", new ItemStack(IoBlocks.ioBasicBlock, 1, 2));
		OreDictionary.registerOre("ashStone", new ItemStack(IoBlocks.ioBasicBlock, 1, 5));
    	
    	RecipeUtil.addRecipe(new ItemStack(IoItems.ioBucket, 1, 0), new Object[] { "X X", "X X", "XXX", 'X', "dustSulfur" });
    	
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(IoBlocks.ioBasicBlock, 2, 4), OreDictionary.getOres("dustSulfur").get(0), 0.2F);
    	FurnaceRecipes.smelting().func_151394_a(new ItemStack(IoBlocks.ioBasicBlock, 4, 4), OreDictionary.getOres("dustSulfur").get(0), 0.2F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(IoBlocks.ioBasicBlock, 2, 3), OreDictionary.getOres("ioStone").get(0), 0.2F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(IoBlocks.ioBasicBlock, 2, 6), OreDictionary.getOres("ashStone").get(0), 0.2F);
    }

    public static void loadRecipes()
    {
        RecipeManagerIo.addUniversalRecipes();
    }
}