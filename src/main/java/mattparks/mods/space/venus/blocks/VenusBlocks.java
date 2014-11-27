package mattparks.mods.space.venus.blocks;

import mattparks.mods.space.core.util.ItemBlockUtil;
import mattparks.mods.space.venus.VenusCore;
import mattparks.mods.space.venus.itemblocks.ItemBlockBasicVenus;
import mattparks.mods.space.venus.itemblocks.ItemBlockDecorVenus;
import net.minecraft.block.Block;

public class VenusBlocks
{
	public static Block venusBasicBlock;
	public static Block venusDecorBlock;
	public static Block evolvedBlazeEgg;
	public static Block sulfurTorch;
	public static Block venusianTNT;
	public static Block vurnStone;

	private static void initBlocks()
	{
		VenusBlocks.venusBasicBlock = new BlockBasicVenus("venus_basic");
		VenusBlocks.venusDecorBlock = new BlockDecorVenus("venus_decor");
		VenusBlocks.evolvedBlazeEgg = new BlockEvolvedBlazeEgg("evolved_blaze_egg");
		VenusBlocks.sulfurTorch = new BlockSulfurTorch("sulfur_torch");
		VenusBlocks.venusianTNT = new BlockVenusianTNT("venusian_tnt");
		VenusBlocks.vurnStone = new BlockVurnStone("vurn_stone");
	}
	
	public static void setHarvestLevels()
	{
	}

	private static void registerBlocks()
	{
		VenusCore.registerBlock(VenusBlocks.venusBasicBlock, ItemBlockBasicVenus.class);
		VenusCore.registerBlock(VenusBlocks.venusDecorBlock, ItemBlockDecorVenus.class);
		VenusCore.registerBlock(VenusBlocks.venusianTNT, ItemBlockUtil.class);
		VenusCore.registerBlock(VenusBlocks.vurnStone, ItemBlockUtil.class);
		VenusCore.registerBlock(VenusBlocks.evolvedBlazeEgg, ItemBlockUtil.class);
		VenusCore.registerBlock(VenusBlocks.sulfurTorch, ItemBlockUtil.class);
	}
	
	public static void init()
	{
		initBlocks();
		registerBlocks();
	}
}