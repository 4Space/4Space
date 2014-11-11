package mattparks.mods.space.gas.blocks;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.gas.itemblocks.ItemBlockGas;
import net.minecraft.block.Block;

public class GasBlocks
{
	public static Block gasBlock;

	public static void init()
	{
		initBlocks();
		setHarvestLevels();
		registerBlocks();
	}

	private static void initBlocks()
	{
		GasBlocks.gasBlock = new BlockBasicGas("gas_block");
	}

	private static void setHarvestLevels()
	{
		GasBlocks.gasBlock.setHarvestLevel("pickaxe", 1);
	}

	private static void registerBlocks()
	{
		SpaceCore.registerBlock(GasBlocks.gasBlock, ItemBlockGas.class);
	}
}