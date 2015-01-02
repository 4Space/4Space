package mattparks.mods.space.core.util;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipeUtil
{
	@SuppressWarnings("unchecked")
	public static void addRecipe(ItemStack result, Object[] obj)
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(result, obj));
	}

	public static void addBlockRecipe(ItemStack result, String oreDictIngot, ItemStack spaceIngot)
	{
		RecipeUtil.addRecipe(result, new Object[] { "XXX", "XXX", "XXI", 'X', oreDictIngot, 'I', spaceIngot });
		RecipeUtil.addRecipe(result, new Object[] { "XXX", "XXX", "XIX", 'X', oreDictIngot, 'I', spaceIngot });
		RecipeUtil.addRecipe(result, new Object[] { "XXX", "XXX", "IXX", 'X', oreDictIngot, 'I', spaceIngot });
		RecipeUtil.addRecipe(result, new Object[] { "XXX", "XXI", "XXX", 'X', oreDictIngot, 'I', spaceIngot });
		RecipeUtil.addRecipe(result, new Object[] { "XXX", "XIX", "XXX", 'X', oreDictIngot, 'I', spaceIngot });
		RecipeUtil.addRecipe(result, new Object[] { "XXX", "IXX", "XXX", 'X', oreDictIngot, 'I', spaceIngot });
		RecipeUtil.addRecipe(result, new Object[] { "XXI", "XXX", "XXX", 'X', oreDictIngot, 'I', spaceIngot });
		RecipeUtil.addRecipe(result, new Object[] { "XIX", "XXX", "XXX", 'X', oreDictIngot, 'I', spaceIngot });
		RecipeUtil.addRecipe(result, new Object[] { "IXX", "XXX", "XXX", 'X', oreDictIngot, 'I', spaceIngot });
	}
}
