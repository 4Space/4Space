package mattparks.mods.mercury.recipe;

import mattparks.mods.mercury.GCMercury;
import mattparks.mods.mercury.items.GCMercuryItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class GCMercuryRecipeManager  //TODO CREATE CRAFTING
{
    private static void addUniversalRecipes()
    {
    	// ORE DICTIONARY
    	OreDictionary.registerOre("iridiumCrystals", new ItemStack(GCMercuryItems.mercuryItemBasic, 1, 0));
      	OreDictionary.registerOre("iridiumPlate", new ItemStack(GCMercuryItems.mercuryItemBasic, 1, 2));

    	// ARMOR AND TOOLS CRAFTING
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumBoots), new Object[] {  "X X", "X X", 'X', "iridiumCrystals" });
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumHelmet), new Object[] { "XXX", "X X", 'X', "iridiumCrystals" });
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "iridiumCrystals" });
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumLeggings), new Object[] { "XXX", "X X", "X X", 'X', "iridiumCrystals" });
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumSword), new Object[] { "X", "X", "Y", 'X', "iridiumCrystals", 'Y', Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "iridiumCrystals", 'Y',Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumSpade), new Object[] { "X", "Y", "Y", 'X', "iridiumCrystals", 'Y', Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumHoe), new Object[] { "XX", " Y", " Y", 'X', "iridiumCrystals", 'Y', Item.stick  });
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.iridiumAxe), new Object[] { "XX", "XY", " Y", 'X', "iridiumCrystals", 'Y', Item.stick });

        // PLATE CRAFTING
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.mercuryItemBasic, 1, 2), new Object[] { "XX", "XX", 'X', "iridiumCrystals" });
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.mercuryItemBasic, 1, 1), new Object[] { "XX", "XX", 'X', "iridiumPlate" });

        // OTHERS CRAFTING

        // ITEM TO BLOCK
        RecipeUtil.addRecipe(new ItemStack(GCMercury.MercuryIridiumBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "iridiumCrystals" });
        GameRegistry.addShapelessRecipe(new ItemStack(GCMercury.BlackGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 0), new ItemStack(Block.glowStone, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(GCMercury.BlueGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Block.glowStone, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(GCMercury.BrownGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 3), new ItemStack(Block.glowStone, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(GCMercury.CyanGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 6), new ItemStack(Block.glowStone, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(GCMercury.GreenGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 2), new ItemStack(Block.glowStone, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(GCMercury.GreyGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 8), new ItemStack(Block.glowStone, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(GCMercury.LightBlueGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 12), new ItemStack(Block.glowStone, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(GCMercury.SilverGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 7), new ItemStack(Block.glowStone, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(GCMercury.LimeGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 10), new ItemStack(Block.glowStone, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(GCMercury.MagentaGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 13), new ItemStack(Block.glowStone, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(GCMercury.OrangeGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 14), new ItemStack(Block.glowStone, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(GCMercury.PinkGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 9), new ItemStack(Block.glowStone, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(GCMercury.PurpleGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 5), new ItemStack(Block.glowStone, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(GCMercury.RedGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Block.glowStone, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(GCMercury.WhiteGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 15), new ItemStack(Block.glowStone, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(GCMercury.YellowGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 11), new ItemStack(Block.glowStone, 1, 0));        
      
        // BLOCK TO ITEM
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.mercuryItemBasic, 9, 0), new Object[] { "X", 'X', GCMercury.MercuryIridiumBlock });

        // Smelting
        FurnaceRecipes.smelting().addSmelting(GCMercury.MercuryCopperOre.blockID, 0, OreDictionary.getOres("ingotCopper").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(GCMercury.MercuryTinOre.blockID, 0, OreDictionary.getOres("ingotTin").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(GCMercury.MercuryIridiumOre.blockID, 0, OreDictionary.getOres("iridiumCrystals").get(0), 0.2F);

    }

    public static void loadRecipes()
    {
        GCMercuryRecipeManager.addUniversalRecipes();
    }
}
