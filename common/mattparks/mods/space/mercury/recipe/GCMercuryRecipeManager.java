package mattparks.mods.space.mercury.recipe;

import mattparks.mods.space.mercury.blocks.MercuryBlocks;
import mattparks.mods.space.mercury.items.GCMercuryItems;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class GCMercuryRecipeManager  //TODO CREATE CRAFTING
{
    private static void addUniversalRecipes()
    {
    	// ORE DICTIONARY
    	OreDictionary.registerOre("iridiumCrystals", new ItemStack(GCMercuryItems.mercuryItemBasic, 1, 0));
      	OreDictionary.registerOre("iridiumPlate", new ItemStack(GCMercuryItems.mercuryItemBasic, 1, 2));
      	OreDictionary.registerOre("meteorBlock", new ItemStack(MercuryBlocks.MercuryMeteorBlock));
    	OreDictionary.registerOre("meteoricIronIngot", new ItemStack(GCCoreItems.meteoricIronIngot, 1, 0));

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

        // ITEM TO BLOCK
        RecipeUtil.addRecipe(new ItemStack(Block.pistonStickyBase, 1, 1), new Object[] {"S", "P", 'S', "redSlimeball", 'P', Block.pistonBase});
        
        RecipeUtil.addRecipe(new ItemStack(MercuryBlocks.CaravanModule), new Object[] { "XYZ", "GJG", "GGG", 'X', Block.furnaceIdle, 'Y', Block.workbench , 'Z', Block.chest, 'G' , GCCoreItems.canvas, 'J' , new ItemStack(GCCoreItems.canister, 1, 0) });

        RecipeUtil.addRecipe(new ItemStack(MercuryBlocks.MercuryIridiumBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "iridiumCrystals" });
        RecipeUtil.addRecipe(new ItemStack(MercuryBlocks.MercuryMeteorBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "meteoricIronIngot" });
//        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.BlackGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 0), new ItemStack(Block.glowStone, 1, 0));
//        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.BlueGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 4), new ItemStack(Block.glowStone, 1, 0));
//        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.BrownGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 3), new ItemStack(Block.glowStone, 1, 0));
//        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.CyanGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 6), new ItemStack(Block.glowStone, 1, 0));
//        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.GreenGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 2), new ItemStack(Block.glowStone, 1, 0));
//        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.GreyGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 8), new ItemStack(Block.glowStone, 1, 0));
//        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.LightBlueGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 12), new ItemStack(Block.glowStone, 1, 0));
//        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.SilverGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 7), new ItemStack(Block.glowStone, 1, 0));
//        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.LimeGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 10), new ItemStack(Block.glowStone, 1, 0));
//        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.MagentaGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 13), new ItemStack(Block.glowStone, 1, 0));
//        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.OrangeGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 14), new ItemStack(Block.glowStone, 1, 0));
//        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.PinkGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 9), new ItemStack(Block.glowStone, 1, 0));
//        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.PurpleGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 5), new ItemStack(Block.glowStone, 1, 0));
//        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.RedGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Block.glowStone, 1, 0));
//        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.WhiteGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 15), new ItemStack(Block.glowStone, 1, 0));
//        GameRegistry.addShapelessRecipe(new ItemStack(MercuryBlocks.YellowGlowstone, 1, 0), new ItemStack(Item.dyePowder, 1, 11), new ItemStack(Block.glowStone, 1, 0));        
      
        // BLOCK TO ITEM
        RecipeUtil.addRecipe(new ItemStack(GCMercuryItems.mercuryItemBasic, 9, 0), new Object[] { "X", 'X', MercuryBlocks.MercuryIridiumBlock });
        RecipeUtil.addRecipe(new ItemStack(GCCoreItems.meteoricIronIngot, 9, 0), new Object[] { "X", 'X', MercuryBlocks.MercuryMeteorBlock });

        // Smelting
        FurnaceRecipes.smelting().addSmelting(MercuryBlocks.MercuryCopperOre.blockID, 0, OreDictionary.getOres("ingotCopper").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(MercuryBlocks.MercuryTinOre.blockID, 0, OreDictionary.getOres("ingotTin").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(MercuryBlocks.MercuryIridiumOre.blockID, 0, OreDictionary.getOres("iridiumCrystals").get(0), 0.2F);
        FurnaceRecipes.smelting().addSmelting(MercuryBlocks.MercuryMeteorOre.blockID, 0, new ItemStack(GCCoreItems.meteoricIronRaw), 0.2F);
        FurnaceRecipes.smelting().addSmelting(MercuryBlocks.MercuryGoldOre.blockID, 0, new ItemStack(Item.ingotGold), 0.2F);

    }

    public static void loadRecipes()
    {
        GCMercuryRecipeManager.addUniversalRecipes();
    }
}
