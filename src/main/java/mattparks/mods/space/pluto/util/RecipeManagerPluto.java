package mattparks.mods.space.pluto.util;

import mattparks.mods.space.core.util.RecipeUtil;
import mattparks.mods.space.pluto.blocks.PlutoBlocks;
import mattparks.mods.space.pluto.items.PlutoItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeManagerPluto
{
    private static void addUniversalRecipes()
    {
		// ORE DICTIONARY
		OreDictionary.registerOre("blueGem", new ItemStack(PlutoItems.plutoBasicItem, 1, 0));
		OreDictionary.registerOre("ununpetiumRaw", new ItemStack(PlutoItems.plutoBasicItem, 1, 1));
		OreDictionary.registerOre("ingotFrozenIron", new ItemStack(PlutoItems.plutoBasicItem, 1, 2));
		
		OreDictionary.registerOre("blueGemBlock", new ItemStack(PlutoBlocks.plutoBasicBlock, 1, 7));
		OreDictionary.registerOre("ununpetiumRawBlock", new ItemStack(PlutoBlocks.plutoBasicBlock, 1, 8));
		OreDictionary.registerOre("ingotFrozenIronBlock", new ItemStack(PlutoBlocks.plutoBasicBlock, 1, 9));
		
		OreDictionary.registerOre("plutoStone", new ItemStack(PlutoBlocks.plutoBasicBlock, 1, 2));
    	
		// ARMOR AND TOOLS CRAFTING
		RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemBoots), new Object[] {  "X X", "X X", 'X', "blueGemCrystals" });
		RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemHelmet), new Object[] { "XXX", "X X", 'X', "blueGemCrystals" });
		RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "blueGemCrystals" });
		RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemLeggings), new Object[] { "XXX", "X X", "X X", 'X', "blueGemCrystals" });

		RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemSword), new Object[] { "X", "X", "Y", 'X', "blueGemCrystals", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "blueGemCrystals", 'Y',Items.stick });
		RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemSpade), new Object[] { "X", "Y", "Y", 'X', "blueGemCrystals", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemHoe), new Object[] { "XX", " Y", " Y", 'X', "blueGemCrystals", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(PlutoItems.blueGemAxe), new Object[] { "XX", "XY", " Y", 'X', "blueGemCrystals", 'Y', Items.stick });

		
		// ITEM TO BLOCK
		RecipeUtil.addRecipe(new ItemStack(PlutoBlocks.plutoBasicBlock, 1, 7), new Object[] { "XXX", "XXX", "XXX", 'X', "blueGem" });
        RecipeUtil.addRecipe(new ItemStack(PlutoBlocks.plutoBasicBlock, 1, 8), new Object[] { "XXX", "XXX", "XXX", 'X', "ununpetiumRaw" });
        RecipeUtil.addRecipe(new ItemStack(PlutoBlocks.plutoBasicBlock, 1, 9), new Object[] { "XXX", "XXX", "XXX", 'X', "ingotFrozenIron" });
        
		// BLOCK TO ITEM 
		RecipeUtil.addRecipe(new ItemStack(PlutoItems.plutoBasicItem, 9, 0), new Object[] { "XXX", "XXX", "XXX", 'X', "blueGemBlock" });
        RecipeUtil.addRecipe(new ItemStack(PlutoItems.plutoBasicItem, 9, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "ununpetiumRawBlock" });
        RecipeUtil.addRecipe(new ItemStack(PlutoItems.plutoBasicItem, 9, 2), new Object[] { "XXX", "XXX", "XXX", 'X', "ingotFrozenIronBlock" });
    
        // Smelting
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(PlutoBlocks.plutoBasicBlock, 1, 3), OreDictionary.getOres("plutoStone").get(0), 0.2F);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(PlutoBlocks.plutoBasicBlock, 1, 4), OreDictionary.getOres("blueGem").get(0), 0.2F);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(PlutoBlocks.plutoBasicBlock, 1, 5), OreDictionary.getOres("ununpetiumRaw").get(0), 0.2F);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(PlutoBlocks.plutoBasicBlock, 1, 6), OreDictionary.getOres("ingotFrozenIron").get(0), 0.2F);
    }

    public static void loadRecipes()
    {
        RecipeManagerPluto.addUniversalRecipes();
    }
}