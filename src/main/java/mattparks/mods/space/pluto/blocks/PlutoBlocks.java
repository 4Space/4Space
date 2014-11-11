package mattparks.mods.space.pluto.blocks;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.pluto.itemblocks.ItemBlockPluto;
import net.minecraft.block.Block;

public class PlutoBlocks
{
	public static Block plutoBasicBlock;

	public static void init()
	{
		initBlocks();
		setHarvestLevels();
		registerBlocks();
	}

	private static void initBlocks()
	{
		PlutoBlocks.plutoBasicBlock = new BlockBasicPluto("pluto_block");
	}

	private static void setHarvestLevels()
	{
		PlutoBlocks.plutoBasicBlock.setHarvestLevel("pickaxe", 1);
	}

	private static void registerBlocks()
	{
		SpaceCore.registerBlock(PlutoBlocks.plutoBasicBlock, ItemBlockPluto.class);
	}
}