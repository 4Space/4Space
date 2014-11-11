package mattparks.mods.space.eris.blocks;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.eris.itemblocks.ItemBlockEris;
import net.minecraft.block.Block;

public class ErisBlocks
{
	public static Block erisBasicBlock;

	public static void init()
	{
		initBlocks();
		setHarvestLevels();
		registerBlocks();
	}

	private static void initBlocks()
	{
		ErisBlocks.erisBasicBlock = new BlockBasicEris("eris_block");
	}

	private static void setHarvestLevels()
	{
		ErisBlocks.erisBasicBlock.setHarvestLevel("pickaxe", 1);
	}

	private static void registerBlocks()
	{
		SpaceCore.registerBlock(ErisBlocks.erisBasicBlock, ItemBlockEris.class);
	}
}