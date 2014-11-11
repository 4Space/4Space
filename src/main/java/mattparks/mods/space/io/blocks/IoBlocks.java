package mattparks.mods.space.io.blocks;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.io.itemblocks.ItemBlockIo;
import mattparks.mods.space.io.itemblocks.ItemBlockMagmaRock;
import micdoodle8.mods.galacticraft.core.items.ItemBlockGC;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;

public class IoBlocks
{
	public static Block liquidRedSulfurStill;
	public static Block liquidYellowSulfurStill;
	public static Block liquidOrangeSulfurFlowing;
	public static Block ioLavaFlowing;
	public static Block ioBasicBlock;
	public static Block ioMagmaRock;
	public static BlockLiquid liquidRedSulfurFlowing;
	public static BlockLiquid liquidYellowSulfurFlowing;
	public static BlockLiquid liquidOrangeSulfurStill;
	public static BlockLiquid ioLavaStill;

	public static void init()
	{
		initBlocks();
		setHarvestLevels();
		registerBlocks();
	}

	private static void initBlocks()
	{
		IoBlocks.ioBasicBlock = new BlockBasicIo("io_block");
		IoBlocks.ioMagmaRock = new BlockMagmaRock("magma_rock");

		// Fluid Blocks
		// DANGER : DON'T CHANGE LIQUID SULFUR NAME! IT MAKE FLUID BUG AND DO NOT CHANGE ANYTHING ON THIS STUFF!
		IoBlocks.liquidRedSulfurFlowing = new BlockIoLavaFlowing("liquid_red_sulfur_flowing", "liquid_red_sulfur_still", "liquid_red_sulfur_flowing");
		IoBlocks.liquidRedSulfurStill = new BlockIoLavaStill("liquid_red_sulfur_still", "liquid_red_sulfur_still", "liquid_red_sulfur_flowing");
		IoBlocks.liquidYellowSulfurFlowing = new BlockIoLavaFlowing("liquid_yellow_sulfur_flowing", "liquid_yellow_sulfur_still", "liquid_yellow_sulfur_flowing");
		IoBlocks.liquidYellowSulfurStill = new BlockIoLavaStill("liquid_yellow_sulfur_still", "liquid_yellow_sulfur_still", "liquid_yellow_sulfur_flowing");
		IoBlocks.liquidOrangeSulfurStill = new BlockIoLavaStill("liquid_orange_sulfur_still", "liquid_orange_sulfur_still", "liquid_orange_sulfur_flowing");
		IoBlocks.liquidOrangeSulfurFlowing = new BlockIoLavaFlowing("liquid_orange_sulfur_flowing", "liquid_orange_sulfur_still", "liquid_orange_sulfur_flowing");
		IoBlocks.ioLavaFlowing = new BlockIoLavaFlowing("io_lava_flowing", "lava_still", "lava_flow", true);
		IoBlocks.ioLavaStill = new BlockIoLavaStill("io_lava_still", "lava_still", "lava_flow", true);
	}

	private static void setHarvestLevels()
	{
		IoBlocks.ioBasicBlock.setHarvestLevel("pickaxe", 2);
	}

	private static void registerBlocks()
	{
		SpaceCore.registerBlock(IoBlocks.ioBasicBlock, ItemBlockIo.class);
		SpaceCore.registerBlock(IoBlocks.ioMagmaRock, ItemBlockMagmaRock.class);
		SpaceCore.registerBlock(IoBlocks.liquidRedSulfurFlowing, ItemBlockGC.class);
		SpaceCore.registerBlock(IoBlocks.liquidRedSulfurStill, ItemBlockGC.class);
		SpaceCore.registerBlock(IoBlocks.liquidYellowSulfurFlowing, ItemBlockGC.class);
		SpaceCore.registerBlock(IoBlocks.liquidYellowSulfurStill, ItemBlockGC.class);
		SpaceCore.registerBlock(IoBlocks.liquidOrangeSulfurFlowing, ItemBlockGC.class);
		SpaceCore.registerBlock(IoBlocks.liquidOrangeSulfurStill, ItemBlockGC.class);
		SpaceCore.registerBlock(IoBlocks.ioLavaFlowing, ItemBlockGC.class);
		SpaceCore.registerBlock(IoBlocks.ioLavaStill, ItemBlockGC.class);
	}
}