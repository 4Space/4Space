package mattparks.mods.space.mercury.util;

import mattparks.mods.space.core.Constants;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegisterHelperMercury {
	public static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, Constants.MOD_ID_MERCURY + "_" + block.getUnlocalizedName().substring(5));
	}

	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, Constants.MOD_ID_MERCURY + "_" + item.getUnlocalizedName().substring(5));
	}
}
