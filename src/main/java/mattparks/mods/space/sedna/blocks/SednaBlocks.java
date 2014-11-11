package mattparks.mods.space.sedna.blocks;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.sedna.itemblocks.ItemBlockSedna;
import net.minecraft.block.Block;

public class SednaBlocks
{
	public static Block sednaBasicBlock;

	public static void init()
	{
		initBlocks();
		setHarvestLevels();
		registerBlocks();
	}

	private static void initBlocks()
	{
		SednaBlocks.sednaBasicBlock = new BlockBasicSedna("sedna_block");
	}

	private static void setHarvestLevels()
	{
		SednaBlocks.sednaBasicBlock.setHarvestLevel("pickaxe", 1);
	}

	private static void registerBlocks()
	{
		SpaceCore.registerBlock(SednaBlocks.sednaBasicBlock, ItemBlockSedna.class);
	}
}