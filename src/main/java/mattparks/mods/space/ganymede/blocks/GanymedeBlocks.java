package mattparks.mods.space.ganymede.blocks;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.ganymede.itemblocks.ItemBlockGanymede;
import net.minecraft.block.Block;

public class GanymedeBlocks
{
	public static Block ganymedeBasicBlock;

	public static void init()
	{
		initBlocks();
		setHarvestLevels();
		registerBlocks();
	}

	private static void initBlocks()
	{
		GanymedeBlocks.ganymedeBasicBlock = new BlockBasicGanymede("ganymede_block");
	}

	private static void setHarvestLevels()
	{
		GanymedeBlocks.ganymedeBasicBlock.setHarvestLevel("pickaxe", 1);
	}

	private static void registerBlocks()
	{
		SpaceCore.registerBlock(GanymedeBlocks.ganymedeBasicBlock, ItemBlockGanymede.class);
	}
}