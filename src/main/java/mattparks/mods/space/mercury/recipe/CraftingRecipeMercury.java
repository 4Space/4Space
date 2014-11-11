package mattparks.mods.space.mercury.recipe;

import mattparks.mods.space.mercury.blocks.MercuryBlocks;
import mattparks.mods.space.mercury.items.MercuryItems;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class CraftingRecipeMercury
{
	public static void loadRecipes()
	{
		CraftingRecipeMercury.addCraftingRecipes();
	}

	private static void addCraftingRecipes()
	{
		// ORE DICTIONARY
		OreDictionary.registerOre("iridiumCrystals", new ItemStack(MercuryItems.mercuryBasicItem, 1, 0));
		OreDictionary.registerOre("iridiumPlate", new ItemStack(MercuryItems.mercuryBasicItem, 1, 1));

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

		// ITEM TO BLOCK
		RecipeUtil.addRecipe(new ItemStack(MercuryBlocks.caravanModule), new Object[] { "XYZ", "GJG", "GGG", 'X', Blocks.furnace, 'Y', Blocks.crafting_table, 'Z', Blocks.chest, 'G', GCItems.canvas, 'J', new ItemStack(GCItems.canister, 1, 0) });
	}
}