package mattparks.mods.space.pluto.blocks;

import mattparks.mods.space.pluto.PlutoCore;
import mattparks.mods.space.pluto.itemblocks.ItemBlockBasicPluto;
import net.minecraft.block.Block;

public class PlutoBlocks
{
	public static Block plutoBasicBlock;

	private static void initBlocks()
	{
		PlutoBlocks.plutoBasicBlock = new BlockBasicPluto("pluto_block");
	}
	
	public static void setHarvestLevels()
	{
	}

	private static void registerBlocks()
	{
		PlutoCore.registerBlock(PlutoBlocks.plutoBasicBlock, ItemBlockBasicPluto.class);
	}
	
	public static void init()
	{
		initBlocks();
		registerBlocks();
	}
}