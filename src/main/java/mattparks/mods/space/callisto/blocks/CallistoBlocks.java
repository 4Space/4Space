package mattparks.mods.space.callisto.blocks;

import mattparks.mods.space.callisto.itemblocks.ItemBlockCallisto;
import mattparks.mods.space.core.SpaceCore;
import net.minecraft.block.Block;

public class CallistoBlocks
{
	public static Block callistoBasicBlock;

	public static void init()
	{
		initBlocks();
		setHarvestLevels();
		registerBlocks();
	}

	private static void initBlocks()
	{
		CallistoBlocks.callistoBasicBlock = new BlockBasicCallisto("callisto_block");
	}

	private static void setHarvestLevels()
	{
		CallistoBlocks.callistoBasicBlock.setHarvestLevel("pickaxe", 1);
	}

	private static void registerBlocks()
	{
		SpaceCore.registerBlock(CallistoBlocks.callistoBasicBlock, ItemBlockCallisto.class);
	}
}