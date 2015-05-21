package mattparks.mods.exoplanets.elipse.blocks;

import mattparks.mods.exoplanets.elipse.ElipseCore;
import mattparks.mods.exoplanets.elipse.blocks.items.ItemBlockBasicElipse;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ElipseBlocks {
	public static Block elipseBasicBlock;

	private static void initBlocks() {
		ElipseBlocks.elipseBasicBlock = new BlockBasicElipse("elipse_basic");
	}

	public static void setHarvestLevels() {
	}

	private static void registerBlocks() {
		ElipseCore.registerBlock(ElipseBlocks.elipseBasicBlock, ItemBlockBasicElipse.class);
	}

	public static void oreDictRegistration() {
		OreDictionary.registerOre("oreFlameite", new ItemStack(ElipseBlocks.elipseBasicBlock, 1, 5));
	}

	public static void init() {
		initBlocks();
		setHarvestLevels();
		registerBlocks();
		oreDictRegistration();
	}
}
