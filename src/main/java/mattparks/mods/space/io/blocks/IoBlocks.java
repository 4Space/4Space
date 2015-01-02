package mattparks.mods.space.io.blocks;

import mattparks.mods.space.core.util.ItemBlockUtil;
import mattparks.mods.space.io.IoCore;
import mattparks.mods.space.io.itemblocks.ItemBlockBasicIo;
import mattparks.mods.space.io.itemblocks.ItemBlockMagmaRock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

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

	private static void initBlocks()
	{
		IoBlocks.ioBasicBlock = new BlockBasicIo("io_basic");
		IoBlocks.ioMagmaRock = new BlockMagmaRock("magma_rock");

		// Fluid Blocks
		// DANGER : DON'T CHANGE LIQUID SULFUR NAME! IT MAKE FLUID BUG AND DO
		// NOT CHANGE ANYTHING ON THIS STUFF!
		IoBlocks.liquidRedSulfurFlowing = new BlockIoLavaFlowing("liquid_red_sulfur_flowing", "liquid_red_sulfur_still", "liquid_red_sulfur_flowing");
		IoBlocks.liquidRedSulfurStill = new BlockIoLavaStill("liquid_red_sulfur_still", "liquid_red_sulfur_still", "liquid_red_sulfur_flowing");
		IoBlocks.liquidYellowSulfurFlowing = new BlockIoLavaFlowing("liquid_yellow_sulfur_flowing", "liquid_yellow_sulfur_still", "liquid_yellow_sulfur_flowing");
		IoBlocks.liquidYellowSulfurStill = new BlockIoLavaStill("liquid_yellow_sulfur_still", "liquid_yellow_sulfur_still", "liquid_yellow_sulfur_flowing");
		IoBlocks.liquidOrangeSulfurStill = new BlockIoLavaStill("liquid_orange_sulfur_still", "liquid_orange_sulfur_still", "liquid_orange_sulfur_flowing");
		IoBlocks.liquidOrangeSulfurFlowing = new BlockIoLavaFlowing("liquid_orange_sulfur_flowing", "liquid_orange_sulfur_still", "liquid_orange_sulfur_flowing");
		IoBlocks.ioLavaFlowing = new BlockIoLavaFlowing("io_lava_flowing", "lava_still", "lava_flow", true);
		IoBlocks.ioLavaStill = new BlockIoLavaStill("io_lava_still", "lava_still", "lava_flow", true);
	}

	public static void setHarvestLevels()
	{
	}

	private static void registerBlocks()
	{
		IoCore.registerBlock(IoBlocks.ioBasicBlock, ItemBlockBasicIo.class);
		IoCore.registerBlock(IoBlocks.ioMagmaRock, ItemBlockMagmaRock.class);
		IoCore.registerBlock(IoBlocks.liquidRedSulfurFlowing, ItemBlockUtil.class);
		IoCore.registerBlock(IoBlocks.liquidRedSulfurStill, ItemBlockUtil.class);
		IoCore.registerBlock(IoBlocks.liquidYellowSulfurFlowing, ItemBlockUtil.class);
		IoCore.registerBlock(IoBlocks.liquidYellowSulfurStill, ItemBlockUtil.class);
		IoCore.registerBlock(IoBlocks.liquidOrangeSulfurFlowing, ItemBlockUtil.class);
		IoCore.registerBlock(IoBlocks.liquidOrangeSulfurStill, ItemBlockUtil.class);
		IoCore.registerBlock(IoBlocks.ioLavaFlowing, ItemBlockUtil.class);
		IoCore.registerBlock(IoBlocks.ioLavaStill, ItemBlockUtil.class);
	}

	public static void oreDictRegistration()
	{
		OreDictionary.registerOre("oreSulfur", new ItemStack(IoBlocks.ioBasicBlock, 1, 4));
	}

	public static void init()
	{
		initBlocks();
		setHarvestLevels();
		registerBlocks();
		oreDictRegistration();
	}
}
