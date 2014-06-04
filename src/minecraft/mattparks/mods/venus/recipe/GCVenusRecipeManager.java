package mattparks.mods.venus.recipe;

import mattparks.mods.venus.blocks.VenusBlocks;
import mattparks.mods.venus.items.GCVenusItems;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class GCVenusRecipeManager
{
    private static void addUniversalRecipes()
    {
    	// ORE DICTIONARY
    	OreDictionary.registerOre("ingotSulfur", new ItemStack(GCVenusItems.venusItemBasic, 1, 0));
    	OreDictionary.registerOre("SulfurDust", new ItemStack(GCVenusItems.venusItemBasic, 1, 1));
    	OreDictionary.registerOre("redGem", new ItemStack(GCVenusItems.venusItemBasic, 1, 2));
    	OreDictionary.registerOre("ingotUranium", new ItemStack(GCVenusItems.venusItemBasic, 1, 12));
    	OreDictionary.registerOre("venusRodDust", new ItemStack(GCVenusItems.venusItemBasic, 1, 9));
    	OreDictionary.registerOre("SulfurPlate", new ItemStack(GCVenusItems.venusItemBasic, 1, 7));
    	OreDictionary.registerOre("redGemPlate", new ItemStack(GCVenusItems.venusItemBasic, 1, 6));

    	OreDictionary.registerOre("VenusPowerCrystal", new ItemStack(GCVenusItems.venusItemBasic, 1, 4));
    	OreDictionary.registerOre("VenusCrystal", new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
    	OreDictionary.registerOre("FossilizedPlant", new ItemStack(GCVenusItems.venusItemBasic, 1, 5));
    	OreDictionary.registerOre("jetpackThruster", new ItemStack(GCVenusItems.venusItemBasic, 1, 10));
    	OreDictionary.registerOre("jetpackBody", new ItemStack(GCVenusItems.venusItemBasic, 1, 11));
    	
//    	OreDictionary.registerOre("vurnBerry", new ItemStack(GCVenusItems.vurnBerry, 1, 1));
    	OreDictionary.registerOre("meteoricIronIngot", new ItemStack(GCCoreItems.meteoricIronIngot, 1, 0));

    	// ARMOR AND TOOLS CRAFTING
    	RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 11), new Object[] {  "III", "IRI", 'I', Item.ingotIron, 'R', Item.redstone });
    	
    	RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 10), new Object[] {  "IRI", "C C", 'I', Item.ingotIron, 'R', Item.redstone , 'C', Item.coal });
    	
    	RecipeUtil.addRecipe(new ItemStack(GCVenusItems.jetpack), new Object[] {  "TBT", 'B', "jetpackBody", 'T', "jetpackThruster" });
    	
    	RecipeUtil.addRecipe(new ItemStack(GCVenusItems.pJetpack), new Object[] {  "TCT", 'T', "jetpackThruster", 'C', GCVenusItems.gemChestplate, });
    	
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemBoots), new Object[] {  "X X", "X X", 'X', "redGem" });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemHelmet), new Object[] { "XXX", "X X", 'X', "redGem" });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "redGem" });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemLeggings), new Object[] { "XXX", "X X", "X X", 'X', "redGem" });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemSword), new Object[] { "X", "X", "Y", 'X', "redGem", 'Y', Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "redGem", 'Y',Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemSpade), new Object[] { "X", "Y", "Y", 'X', "redGem", 'Y', Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemHoe), new Object[] { "XX", " Y", " Y", 'X', "redGem", 'Y', Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemAxe), new Object[] { "XX", "XY", " Y", 'X', "redGem", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulfurHelmet), new Object[] { "XXX", "X X", 'X', "ingotSulfur" });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulfurChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "ingotSulfur" });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulfurLeggings), new Object[] { "XXX", "X X", "X X", 'X', "ingotSulfur" });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulfurBoots), new Object[] {  "X X", "X X", 'X', "ingotSulfur" });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulfurSword), new Object[] { "X", "X", "Y", 'X', "ingotSulfur", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulfurPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "ingotSulfur", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulfurSpade), new Object[] { "X", "Y", "Y", 'X', "ingotSulfur", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulfurHoe), new Object[] { "XX", " Y", " Y", 'X', "ingotSulfur", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.sulfurAxe), new Object[] { "XX", "XY", " Y", 'X', "ingotSulfur", 'Y', Item.stick });
       
        // PLATE CRAFTING
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 13), new Object[] { "XX", "XY", 'X', "ingotUranium", 'Y', "venusRodDust" });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 7), new Object[] { "XX", "XY", 'X', "ingotSulfur", 'Y', "venusRodDust" });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 6), new Object[] { "XX", "XY", 'X', "redGem", 'Y', "venusRodDust" });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 8), new Object[] { "XYX", 'X', "SulfurPlate", 'Y', "redGemPlate" });
        
        // OTHERS CRAFTING
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 4), new Object[] { "D D", " C ", "D D", 'D', "venusRodDust", 'C', "VenusCrystal" });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 0), new Object[] { "XX", 'X', "SulfurDust" });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 4, 9), new Object[] { "X", 'X', GCVenusItems.venusRod });
//        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.vurnBerry), new Object[] { "Y Y", " X ", "Y Y", 'X', "FossilizedPlant", 'Y', Item.bone });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusBattery, 1, 100), new Object[] { "TRT", "CVC", "TRT", 'T', "SulfurPlate", 'R', Item.redstone, 'C', Item.coal, 'V', "VenusPowerCrystal" });
        
        // ITEM TO BLOCK
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusUraniumPowerBlock, 1, 1), new Object[] { "XXX", "XCX", "XXX", 'P', "redGemPlate", 'C', VenusBlocks.VenusUraniumBlock });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusUraniumBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "ingotUranium" });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusRedGemBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "redGem" });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusSulfurBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "ingotSulfur" });

        // BLOCK TO ITEM
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 9, 12), new Object[] { "X", 'X', VenusBlocks.VenusUraniumBlock });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 9, 0), new Object[] { "X", 'X', VenusBlocks.VenusSulfurBlock });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 9, 2), new Object[] { "X", 'X', VenusBlocks.VenusRedGemBlock });

        // Smelting
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusSulfurOre.blockID, 0, new ItemStack(GCVenusItems.venusItemBasic, 1, 1), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusCoalOre.blockID, 0, new ItemStack(Item.coal), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusIronOre.blockID, 0, new ItemStack(Item.ingotIron), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusCopperOre.blockID, 0, OreDictionary.getOres("ingotCopper").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusTinOre.blockID, 0, OreDictionary.getOres("ingotTin").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusRedGemOre.blockID, 0, new ItemStack(GCVenusItems.venusItemBasic, 1, 2), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusCrystalOre.blockID, 0, new ItemStack(GCVenusItems.venusItemBasic, 1, 3), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.FossilizedPlantOre.blockID, 0, new ItemStack(GCVenusItems.venusItemBasic, 1, 5), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusUraniumOre.blockID, 0, new ItemStack(GCVenusItems.venusItemBasic, 4, 12), 0.2F);
    }

    public static void loadRecipes()
    {
        GCVenusRecipeManager.addUniversalRecipes();
    }
}
