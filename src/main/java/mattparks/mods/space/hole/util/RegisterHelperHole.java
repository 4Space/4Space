package mattparks.mods.space.hole.util;

import mattparks.mods.space.core.Constants;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterHelperHole 
{
	public static void registerBlock(Block block)
	{
		GameRegistry.registerBlock(block, Constants.MOD_ID_HOLE + "_" + block.getUnlocalizedName().substring(5));
	}

	public static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, Constants.MOD_ID_HOLE + "_" + item.getUnlocalizedName().substring(5));
	}
}
