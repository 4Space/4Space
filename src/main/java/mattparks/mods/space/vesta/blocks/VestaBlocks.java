package mattparks.mods.space.vesta.blocks;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.vesta.itemblocks.ItemBlockVesta;
import net.minecraft.block.Block;

public class VestaBlocks
{
	public static Block vestaBasicBlock;

	public static void init()
	{
		initBlocks();
		setHarvestLevels();
		registerBlocks();
	}

	private static void initBlocks()
	{
		VestaBlocks.vestaBasicBlock = new BlockBasicVesta("vesta_block");
	}

	private static void setHarvestLevels()
	{
		VestaBlocks.vestaBasicBlock.setHarvestLevel("pickaxe", 1);
	}

	private static void registerBlocks()
	{
		SpaceCore.registerBlock(VestaBlocks.vestaBasicBlock, ItemBlockVesta.class);
	}
}