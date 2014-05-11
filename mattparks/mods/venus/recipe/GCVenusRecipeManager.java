package mattparks.mods.venus.recipe;

import java.util.HashMap;

import mattparks.mods.venus.GCVenus;
import mattparks.mods.venus.items.VenusItems;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class GCVenusRecipeManager
{
    private static void addUniversalRecipes()
    {
    	// ORE DICTIONARY
    	OreDictionary.registerOre("ingotSulfer", new ItemStack(VenusItems.venusItemBasic, 1, 0));
    	OreDictionary.registerOre("sulferDust", new ItemStack(VenusItems.venusItemBasic, 1, 1));
    	OreDictionary.registerOre("redGem", new ItemStack(VenusItems.venusItemBasic, 1, 2));
    	OreDictionary.registerOre("venusRodDust", new ItemStack(VenusItems.venusItemBasic, 1, 10));
    	OreDictionary.registerOre("sulferPlate", new ItemStack(VenusItems.venusItemBasic, 1, 7));
    	OreDictionary.registerOre("redGemPlate", new ItemStack(VenusItems.venusItemBasic, 1, 6));
    	OreDictionary.registerOre("venusRod", new ItemStack(VenusItems.venusItemBasic, 1, 9));
    	OreDictionary.registerOre("VenusCrystal", new ItemStack(VenusItems.venusItemBasic, 1, 3));
    	OreDictionary.registerOre("FossilizedPlant", new ItemStack(VenusItems.venusItemBasic, 1, 5));
    	
    	OreDictionary.registerOre("vurnBerry", new ItemStack(VenusItems.vurnBerry, 1, 1));
    	OreDictionary.registerOre("meteoricIronIngot", new ItemStack(GCCoreItems.meteoricIronIngot, 1, 0));
    	OreDictionary.registerOre("meteorBlock", new ItemStack(GCVenus.VenusMeteorBlock));

    	// ARMOR AND TOOLS CRAFTING
    	RecipeUtil.addRecipe(new ItemStack(VenusItems.jetpack), new Object[] {  "GRG", "C C", 'R', Item.redstone, 'G', "redGem", 'C', Item.coal });
    	
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemBoots), new Object[] {  "X X", "X X", 'X', "redGem" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemHelmet), new Object[] { "XXX", "X X", 'X', "redGem" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "redGem" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemLeggings), new Object[] { "XXX", "X X", "X X", 'X', "redGem" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemSword), new Object[] { "X", "X", "Y", 'X', "redGem", 'Y', Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "redGem", 'Y',Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemSpade), new Object[] { "X", "Y", "Y", 'X', "redGem", 'Y', Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemHoe), new Object[] { "XX", " Y", " Y", 'X', "redGem", 'Y', Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.gemAxe), new Object[] { "XX", "XY", " Y", 'X', "redGem", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferHelmet), new Object[] { "XXX", "X X", 'X', "ingotSulfer" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "ingotSulfer" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferLeggings), new Object[] { "XXX", "X X", "X X", 'X', "ingotSulfer" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferBoots), new Object[] {  "X X", "X X", 'X', "ingotSulfer" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferSword), new Object[] { "X", "X", "Y", 'X', "ingotSulfer", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "ingotSulfer", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferSpade), new Object[] { "X", "Y", "Y", 'X', "ingotSulfer", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferHoe), new Object[] { "XX", " Y", " Y", 'X', "ingotSulfer", 'Y', Item.stick });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.sulferAxe), new Object[] { "XX", "XY", " Y", 'X', "ingotSulfer", 'Y', Item.stick });
       
        // PLATE CRAFTING
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 1, 2), new Object[] { "XX", "XY", 'X', "ingotSulfer", 'Y', "venusRodDust" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 1, 4), new Object[] { "XX", "XY", 'X', "redGem", 'Y', "venusRodDust" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 1, 5), new Object[] { "XYX", 'X', "sulferPlate", 'Y', "redGemPlate" });
        
        // OTHERS CRAFTING
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 1, 0), new Object[] { "XX", 'X', "sulferDust" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 4, 10), new Object[] { "X", 'X', "venusRod" });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.vurnBerry), new Object[] { "Y Y", " X ", "Y Y", 'X', "FossilizedPlant", 'Y', Item.bone });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBattery, 1, 100), new Object[] { "TRT", "CVC", "TRT", 'T', "sulferPlate", 'R', Item.redstone, 'C', Item.coal, 'V', "VenusCrystal" });
        
        // ITEM TO BLOCK
        RecipeUtil.addRecipe(new ItemStack(GCVenus.VenusRedGemBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "redGem" });
        RecipeUtil.addRecipe(new ItemStack(GCVenus.VenusMeteorBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "meteoricIronIngot" });
        RecipeUtil.addRecipe(new ItemStack(GCVenus.VenusSulferBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "ingotSulfer" });

        // BLOCK TO ITEM
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 9, 0), new Object[] { "X", 'X', GCVenus.VenusSulferBlock });
        RecipeUtil.addRecipe(new ItemStack(VenusItems.venusItemBasic, 9, 2), new Object[] { "X", 'X', GCVenus.VenusRedGemBlock });
        RecipeUtil.addRecipe(new ItemStack(GCCoreItems.meteoricIronIngot, 9, 0), new Object[] { "X", 'X', GCVenus.VenusMeteorBlock });

        // Smelting
        FurnaceRecipes.smelting().addSmelting(GCVenus.VenusSulferOre.blockID, 0, new ItemStack(VenusItems.venusItemBasic, 1, 1), 0.2F);
        FurnaceRecipes.smelting().addSmelting(GCVenus.VenusCoalOre.blockID, 0, new ItemStack(Item.coal), 0.2F);
        FurnaceRecipes.smelting().addSmelting(GCVenus.VenusIronOre.blockID, 0, new ItemStack(Item.ingotIron), 0.2F);
        FurnaceRecipes.smelting().addSmelting(GCVenus.VenusCopperOre.blockID, 0, OreDictionary.getOres("ingotCopper").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(GCVenus.VenusTinOre.blockID, 0, OreDictionary.getOres("ingotTin").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(GCVenus.VenusRedGemOre.blockID, 0, new ItemStack(VenusItems.venusItemBasic, 1, 2), 0.2F);
        FurnaceRecipes.smelting().addSmelting(GCVenus.VenusCrystalOre.blockID, 0, new ItemStack(VenusItems.venusItemBasic, 1, 3), 0.2F);
        FurnaceRecipes.smelting().addSmelting(GCVenus.VenusMeteorOre.blockID, 0, new ItemStack(GCCoreItems.meteoricIronRaw), 0.2F);
        FurnaceRecipes.smelting().addSmelting(GCVenus.FossilizedPlantOre.blockID, 0, new ItemStack(VenusItems.venusItemBasic, 1, 5), 0.2F);
    }

    public static void loadRecipes()
    {
        GCVenusRecipeManager.addUniversalRecipes();
    }
}
