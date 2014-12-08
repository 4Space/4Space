package mattparks.mods.space.hole.blocks;

import mattparks.mods.space.hole.HoleCore;
import mattparks.mods.space.hole.itemblocks.ItemBlockBasicHole;
import net.minecraft.block.Block;

public class HoleBlocks
{
	public static Block holeBasicBlock;

	private static void initBlocks()
	{
		HoleBlocks.holeBasicBlock = new BlockBasicHole("hole_basic");
	}
	
	public static void setHarvestLevels()
	{
	}

	private static void registerBlocks()
	{
		HoleCore.registerBlock(HoleBlocks.holeBasicBlock, ItemBlockBasicHole.class);
	}
	
	public static void init()
	{
		initBlocks();
		registerBlocks();
	}
}