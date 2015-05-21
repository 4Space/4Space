package mattparks.mods.exoplanets.elipse.util;

import mattparks.mods.exoplanets.core.Constants;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterHelperElipse {
	public static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, Constants.MOD_ID_ELIPSE + "_" + block.getUnlocalizedName().substring(5));
	}

	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, Constants.MOD_ID_ELIPSE + "_" + item.getUnlocalizedName().substring(5));
	}
}
