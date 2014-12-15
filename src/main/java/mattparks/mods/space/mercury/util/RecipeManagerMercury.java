package mattparks.mods.space.mercury.util;

import mattparks.mods.space.core.util.RecipeUtil;
import mattparks.mods.space.mercury.blocks.MercuryBlocks;
import mattparks.mods.space.mercury.items.MercuryItems;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeManagerMercury
{
    private static void addUniversalRecipes()
    {
		// ORE DICTIONARY
		OreDictionary.registerOre("iridiumCrystals", new ItemStack(MercuryItems.mercuryBasicItem, 1, 0));
		OreDictionary.registerOre("iridiumPlate", new ItemStack(MercuryItems.mercuryBasicItem, 1, 1));
		OreDictionary.registerOre("mercuryStone", new ItemStack(MercuryBlocks.mercuryBasicBlock, 1, 2));
      	OreDictionary.registerOre("meteorBlock", new ItemStack(MercuryBlocks.mercuryBasicBlock, 10));
    	OreDictionary.registerOre("meteoricIronIngot", new ItemStack(GCItems.meteoricIronIngot, 1, 0));
    	
		// ARMOR AND TOOLS CRAFTING
		RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumBoots), new Object[] {  "X X", "X X", 'X', "iridiumCrystals" });
		RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumHelmet), new Object[] { "XXX", "X X", 'X', "iridiumCrystals" });
		RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "iridiumCrystals" });
		RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumLeggings), new Object[] { "XXX", "X X", "X X", 'X', "iridiumCrystals" });

		RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumSword), new Object[] { "X", "X", "Y", 'X', "iridiumCrystals", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "iridiumCrystals", 'Y',Items.stick });
		RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumSpade), new Object[] { "X", "Y", "Y", 'X', "iridiumCrystals", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumHoe), new Object[] { "XX", " Y", " Y", 'X', "iridiumCrystals", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(MercuryItems.iridiumAxe), new Object[] { "XX", "XY", " Y", 'X', "iridiumCrystals", 'Y', Items.stick });

		for (int var2 = 0; var2 < 16; ++var2)
		{
			CraftingManager.getInstance().addShapelessRecipe(new ItemStack(MercuryBlocks.mercuryGlowstone, 1, 15 - var2), new Object[] { new ItemStack(Items.dye, 1, var2), Blocks.glowstone});
		}
		
		// ITEM TO BLOCK
		RecipeUtil.addRecipe(new ItemStack(MercuryBlocks.caravanModule), new Object[] { "XYZ", "GJG", "GGG", 'X', Blocks.furnace, 'Y', Blocks.crafting_table, 'Z', Blocks.chest, 'G', GCItems.canvas, 'J', new ItemStack(GCItems.canister, 1, 0) });
		RecipeUtil.addRecipe(new ItemStack(MercuryBlocks.mercuryBasicBlock, 1, 9), new Object[] { "XXX", "XXX", "XXX", 'X', "iridiumCrystals" });
        RecipeUtil.addRecipe(new ItemStack(MercuryBlocks.mercuryBasicBlock, 1, 10), new Object[] { "XXX", "XXX", "XXX", 'X', "meteoricIronIngot" });
    
        // Smelting
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(MercuryBlocks.mercuryBasicBlock, 4, 3), OreDictionary.getOres("mercuryStone").get(0), 0.2F);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(MercuryBlocks.mercuryBasicBlock, 1, 7), OreDictionary.getOres("ingotCopper").get(0), 0.2F);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(MercuryBlocks.mercuryBasicBlock, 1, 6), OreDictionary.getOres("ingotTin").get(0), 0.2F);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(MercuryBlocks.mercuryBasicBlock, 1, 4), OreDictionary.getOres("iridiumCrystals").get(0), 0.2F);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(MercuryBlocks.mercuryBasicBlock, 1, 5), new ItemStack(GCItems.meteoricIronRaw), 0.2F);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(MercuryBlocks.mercuryBasicBlock, 1, 8), new ItemStack(Items.gold_ingot), 0.2F);
    }

    public static void loadRecipes()
    {
        RecipeManagerMercury.addUniversalRecipes();
    }
}