package mattparks.mods.space.venus.recipe;

import mattparks.mods.space.venus.blocks.VenusBlocks;
import mattparks.mods.space.venus.items.GCVenusItems;
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
		OreDictionary.registerOre("dustSulfur", new ItemStack(GCVenusItems.venusItemBasic, 1, 0));
		OreDictionary.registerOre("itemSulfurDust", new ItemStack(GCVenusItems.venusItemBasic, 1, 0)); // FOR ICBM SPIKES
    	OreDictionary.registerOre("ingotSulfur", new ItemStack(GCVenusItems.venusItemBasic, 1, 1));
    	OreDictionary.registerOre("redGem", new ItemStack(GCVenusItems.venusItemBasic, 1, 2));
    	OreDictionary.registerOre("ingotUranium", new ItemStack(GCVenusItems.venusItemBasic, 1, 3));
    	OreDictionary.registerOre("VenusCrystal", new ItemStack(GCVenusItems.venusItemBasic, 1, 4));
    	
    	OreDictionary.registerOre("sulfurPlate", new ItemStack(GCVenusItems.venusItemBasic, 1, 5));
    	OreDictionary.registerOre("redGemPlate", new ItemStack(GCVenusItems.venusItemBasic, 1, 6));
    	OreDictionary.registerOre("uraniumPlate", new ItemStack(GCVenusItems.venusItemBasic, 1, 7));

    	OreDictionary.registerOre("venusRodDust", new ItemStack(GCVenusItems.venusItemBasic, 1, 9));
    	OreDictionary.registerOre("VenusPowerCrystal", new ItemStack(GCVenusItems.venusItemBasic, 1, 10));
//    	OreDictionary.registerOre("FossilizedPlant", new ItemStack(GCVenusItems.venusItemBasic, 1, 13));
    	
    	OreDictionary.registerOre("jetpackThruster", new ItemStack(GCVenusItems.venusItemBasic, 1, 10));
    	OreDictionary.registerOre("jetpackBody", new ItemStack(GCVenusItems.venusItemBasic, 1, 11));
    	
//    	OreDictionary.registerOre("vurnBerry", new ItemStack(GCVenusItems.vurnBerry, 1, 1));

    	// ARMOR AND TOOLS CRAFTING
    	RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 11), new Object[] {  "III", "IRI", 'I', Item.ingotIron, 'R', Item.redstone });
    	RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 10), new Object[] {  "IRI", "C C", 'I', Item.ingotIron, 'R', Item.redstone , 'C', Item.coal });

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
    	
    	RecipeUtil.addRecipe(new ItemStack(GCVenusItems.jetpack), new Object[] {  "TBT", 'B', "jetpackBody", 'T', "jetpackThruster" });
    	RecipeUtil.addRecipe(new ItemStack(GCVenusItems.gemJetpack), new Object[] {  "TBT", " C ", 'T', "jetpackThruster", 'B', "jetpackBody", 'C', GCVenusItems.gemChestplate });
    	
        // OTHERS CRAFTING
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 10), new Object[] { "D D", " C ", "D D", 'D', "venusRodDust", 'C', "VenusCrystal" });

        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 1), new Object[] { "XX", 'X', "dustSulfur" });
		RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 2, 0), new Object[] { "X", 'X', "ingotSulfur" });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 4, 9), new Object[] { "X", 'X', GCVenusItems.venusRod });
//        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.vurnBerry), new Object[] { "Y Y", " X ", "Y Y", 'X', "FossilizedPlant", 'Y', Item.bone });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusUraniumBattery, 1, 100), new Object[] { "TTT", "SIS", "TTT", 'T', "redGemPlate", 'I', VenusBlocks.VenusUraniumBlock, 'S', GCVenusItems.venusSulfurBattery });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusSulfurBattery, 1, 100), new Object[] { "TRT", "RVR", "TRT", 'T', "sulfurPlate", 'V', "VenusPowerCrystal", 'R', Item.redstone });
        
        // ITEM TO BLOCK
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusCrystalBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "VenusCrystal" });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusUraniumBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "ingotUranium" });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusRedGemBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "redGem" });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusSulfurBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "ingotSulfur" });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusCompositeBlock, 16, 1), new Object[] { "XXX", "TST", "XXX", 'X', "ingotSulfur", 'T', "ingotTin", 'S', VenusBlocks.VenusStone });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.SulfurTorch, 4, 1), new Object[] { "X", "Y", 'X', "dustSulfur", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.SulfurTorch, 4, 1), new Object[] { "X", "Y", 'X', "itemSulfurDust", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusSpaceStone, 6, 1), new Object[] { "X", "Y", 'X', "dustSulfur", 'Y', VenusBlocks.VenusGrass });
        RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusSpaceStone, 6, 1), new Object[] { "X", "Y", 'X', "itemSulfurDust", 'Y', VenusBlocks.VenusGrass });
        
        // BLOCK TO ITEM
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 9, 1), new Object[] { "X", 'X', VenusBlocks.VenusSulfurBlock });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 9, 2), new Object[] { "X", 'X', VenusBlocks.VenusRedGemBlock });
        RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 9, 3), new Object[] { "X", 'X', VenusBlocks.VenusUraniumBlock });
        
        // Smelting
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusSulfurOre.blockID, 0, OreDictionary.getOres("dustSulfur").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusCoalOre.blockID, 0, new ItemStack(Item.coal), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusIronOre.blockID, 0, new ItemStack(Item.ingotIron), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusCopperOre.blockID, 0, OreDictionary.getOres("ingotCopper").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusTinOre.blockID, 0, OreDictionary.getOres("ingotTin").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusRedGemOre.blockID, 0, OreDictionary.getOres("redGem").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusCrystalOre.blockID, 0, OreDictionary.getOres("VenusCrystal").get(0), 0.2F);
//        FurnaceRecipes.smelting().addSmelting(VenusBlocks.FossilizedPlantOre.blockID, 0, OreDictionary.getOres("FossilizedPlant").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(VenusBlocks.VenusUraniumOre.blockID, 0, OreDictionary.getOres("ingotUranium").get(0), 0.2F);
    }

    public static void loadRecipes()
    {
        GCVenusRecipeManager.addUniversalRecipes();
    }
}
