package mattparks.mods.space.venus.recipe;

import mattparks.mods.space.venus.blocks.VenusBlocks;
import mattparks.mods.space.venus.items.VenusItems;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class CraftingRecipeVenus
{
	public static void loadRecipes()
	{
		CraftingRecipeVenus.addUniversalRecipes();
	}

	private static void addUniversalRecipes()
	{
		// ORE DICTIONARY
		OreDictionary.registerOre("dustSulfur", new ItemStack(VenusItems.venusBasicItem, 1, 0));
		OreDictionary.registerOre("itemSulfurDust", new ItemStack(VenusItems.venusBasicItem, 1, 0)); // FOR ICBM SPIKES
		OreDictionary.registerOre("ingotSulfur", new ItemStack(VenusItems.venusBasicItem, 1, 1));
		OreDictionary.registerOre("redGem", new ItemStack(VenusItems.venusBasicItem, 1, 2));
		OreDictionary.registerOre("ingotUranium", new ItemStack(VenusItems.venusBasicItem, 1, 3));
		OreDictionary.registerOre("VenusCrystal", new ItemStack(VenusItems.venusBasicItem, 1, 4));

		OreDictionary.registerOre("sulfurPlate", new ItemStack(VenusItems.venusBasicItem, 1, 5));
		OreDictionary.registerOre("redGemPlate", new ItemStack(VenusItems.venusBasicItem, 1, 6));
		OreDictionary.registerOre("uraniumPlate", new ItemStack(VenusItems.venusBasicItem, 1, 7));

		OreDictionary.registerOre("venusRodDust", new ItemStack(VenusItems.venusBasicItem, 1, 9));
		OreDictionary.registerOre("VenusPowerCrystal", new ItemStack(VenusItems.venusBasicItem, 1, 12));

		// ARMOR AND TOOLS CRAFTING
		RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBasicItem, 1, 11), new Object[] { "III", "IRI", 'I', Items.iron_ingot, 'R', Items.redstone });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBasicItem, 1, 10), new Object[] { "IRI", "C C", 'I', Items.iron_ingot, 'R', Items.redstone , 'C', Items.coal });

		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemBoots), new Object[] { "X X", "X X", 'X', "redGem" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemHelmet), new Object[] { "XXX", "X X", 'X', "redGem" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "redGem" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemLeggings), new Object[] { "XXX", "X X", "X X", 'X', "redGem" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemSword), new Object[] { "X", "X", "Y", 'X', "redGem", 'Y', Items.stick  });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "redGem", 'Y',Items.stick  });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemSpade), new Object[] { "X", "Y", "Y", 'X', "redGem", 'Y', Items.stick  });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemHoe), new Object[] { "XX", " Y", " Y", 'X', "redGem", 'Y', Items.stick  });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.gemAxe), new Object[] { "XX", "XY", " Y", 'X', "redGem", 'Y', Items.stick });

		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurHelmet), new Object[] { "XXX", "X X", 'X', "ingotSulfur" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurChestplate), new Object[] { "X X", "XXX", "XXX", 'X', "ingotSulfur" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurLeggings), new Object[] { "XXX", "X X", "X X", 'X', "ingotSulfur" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurBoots), new Object[] { "X X", "X X", 'X', "ingotSulfur" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurSword), new Object[] { "X", "X", "Y", 'X', "ingotSulfur", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurPickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "ingotSulfur", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurSpade), new Object[] { "X", "Y", "Y", 'X', "ingotSulfur", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurHoe), new Object[] { "XX", " Y", " Y", 'X', "ingotSulfur", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurAxe), new Object[] { "XX", "XY", " Y", 'X', "ingotSulfur", 'Y', Items.stick });

		// OTHERS CRAFTING
		RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBasicItem, 1, 12), new Object[] { "D D", " C ", "D D", 'D', "venusRodDust", 'C', "VenusCrystal" });

		RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBasicItem, 1, 1), new Object[] { "XX", 'X', "dustSulfur" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBasicItem, 2, 0), new Object[] { "X", 'X', "ingotSulfur" });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.venusBasicItem, 4, 9), new Object[] { "X", 'X', new ItemStack(VenusItems.venusBasicItem, 1, 9) });
		//RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusUraniumBattery, 1, 100), new Object[] { "TTT", "SIS", "TTT", 'T', "redGemPlate", 'I', VenusBlocks.VenusUraniumBlock, 'S', GCVenusItems.venusSulfurBattery });
		RecipeUtil.addRecipe(new ItemStack(VenusItems.sulfurBattery, 1, 100), new Object[] { "TRT", "RVR", "TRT", 'T', "sulfurPlate", 'V', "VenusPowerCrystal", 'R', Items.redstone });

		// ITEM TO BLOCK
		//RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusCrystalBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "VenusCrystal" });
		//RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusUraniumBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "ingotUranium" });
		//RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusRedGemBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "redGem" });
		//RecipeUtil.addRecipe(new ItemStack(VenusBlocks.VenusSulfurBlock, 1, 1), new Object[] { "XXX", "XXX", "XXX", 'X', "ingotSulfur" });
		RecipeUtil.addRecipe(new ItemStack(VenusBlocks.sulfurTorch, 4, 1), new Object[] { "X", "Y", 'X', "dustSulfur", 'Y', Items.stick });
		RecipeUtil.addRecipe(new ItemStack(VenusBlocks.sulfurTorch, 4, 1), new Object[] { "X", "Y", 'X', "itemSulfurDust", 'Y', Items.stick });

		// BLOCK TO ITEM
		//RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 9, 1), new Object[] { "X", 'X', VenusBlocks.VenusSulfurBlock });
		//RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 9, 2), new Object[] { "X", 'X', VenusBlocks.VenusRedGemBlock });
		//RecipeUtil.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 9, 3), new Object[] { "X", 'X', VenusBlocks.VenusUraniumBlock });

		// Smelting
		//		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.VenusSulfurOre, 1, 0), OreDictionary.getOres("dustSulfur").get(0), 0.2F);
		//		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.VenusCoalOre, 1, 0), new ItemStack(Items.coal), 0.2F);
		//		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.VenusIronOre, 1, 0), new ItemStack(Items.iron_ingot), 0.2F);
		//		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.VenusCopperOre, 1, 0), OreDictionary.getOres("ingotCopper").get(0), 0.2F);
		//		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.VenusTinOre, 1, 0), OreDictionary.getOres("ingotTin").get(0), 0.2F);
		//		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.VenusRedGemOre, 1, 0), OreDictionary.getOres("redGem").get(0), 0.2F);
		//		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.VenusCrystalOre, 1, 0), OreDictionary.getOres("VenusCrystal").get(0), 0.2F);
		//		FurnaceRecipes.smelting().func_151394_a(new ItemStack(VenusBlocks.VenusUraniumOre, 1, 0), OreDictionary.getOres("ingotUranium").get(0), 0.2F);
	}
}