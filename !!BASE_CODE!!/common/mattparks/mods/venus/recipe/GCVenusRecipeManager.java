package mattparks.mods.venus.recipe;

import mattparks.mods.venus.GCVenus;
import mattparks.mods.venus.items.VenusItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class GCVenusRecipeManager
{
    private static void addUniversalRecipes()
    {
    	// ORE DICTIONARY
    	OreDictionary.registerOre("venusStone", new ItemStack(GCVenus.VenusStone));

        // CRAFTING
//        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 1, 0), new Object[] { "   ", 'X', "   ", "venusStone" });

        // Smelting
        FurnaceRecipes.smelting().addSmelting(GCVenus.VenusCobblestone.blockID, 0, new ItemStack(GCVenus.VenusStone), 0.2F);
    }

    public static void loadRecipes()
    {
        GCVenusRecipeManager.addUniversalRecipes();
    }
}
