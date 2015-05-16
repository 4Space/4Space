package mattparks.mods.space.callisto.blocks;

import mattparks.mods.space.callisto.CallistoCore;
import mattparks.mods.space.callisto.blocks.items.ItemBlockBasicCallisto;
import net.minecraft.block.Block;

public class CallistoBlocks {
	public static Block callistoBasicBlock;

	private static void initBlocks() {
		CallistoBlocks.callistoBasicBlock = new BlockBasicCallisto("callisto_block");	
	}

	private static void setHarvestLevels() {
		CallistoBlocks.callistoBasicBlock.setHarvestLevel("pickaxe", 1);
	}

	private static void registerBlocks() {
		CallistoCore.registerBlock(CallistoBlocks.callistoBasicBlock, ItemBlockBasicCallisto.class);
	}

	public static void oreDictRegistration() {
	}

	public static void init() {
		initBlocks();
		setHarvestLevels();
		registerBlocks();
		oreDictRegistration();
	}
}
