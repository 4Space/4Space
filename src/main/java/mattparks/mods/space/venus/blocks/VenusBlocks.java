package mattparks.mods.space.venus.blocks;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.venus.itemblocks.ItemBlockOreVenus;
import mattparks.mods.space.venus.itemblocks.ItemBlockVenus;
import micdoodle8.mods.galacticraft.core.items.ItemBlockGC;
import net.minecraft.block.Block;

public class VenusBlocks
{
	public static Block venusBasicBlock;
	public static Block venusOreBlock;
	public static Block evolvedBlazeEgg;
	public static Block sulfurTorch;
	public static Block venusianTnt;
	public static Block burnStone;
	public static Block venusTreasureChest;
	public static Block spaceStone;

	public static void init()
	{
		initBlocks();
		registerBlocks();
	}

	private static void initBlocks()
	{
		VenusBlocks.venusBasicBlock = new BlockBasicVenus("venus_block");
		VenusBlocks.venusOreBlock = new BlockOreVenus("venus_ore_block");
		VenusBlocks.evolvedBlazeEgg = new BlockEvolvedBlazeEgg("evolved_blaze_egg");
		VenusBlocks.sulfurTorch = new BlockSulfurTorch("sulfur_torch");
		VenusBlocks.venusianTnt = new BlockVenusianTNT("venusian_tnt");
		VenusBlocks.burnStone = new BlockBurnStone("burn_stone");
		VenusBlocks.venusTreasureChest = new BlockT4VenusTreasureChest("venus_treasure_chest");
		VenusBlocks.spaceStone = new BlockSpaceStone("space_stone");
	}

	private static void registerBlocks()
	{
		SpaceCore.registerBlock(VenusBlocks.venusBasicBlock, ItemBlockVenus.class);
		SpaceCore.registerBlock(VenusBlocks.venusOreBlock, ItemBlockOreVenus.class);
		SpaceCore.registerBlock(VenusBlocks.venusianTnt, ItemBlockGC.class);
		SpaceCore.registerBlock(VenusBlocks.burnStone, ItemBlockGC.class);
		SpaceCore.registerBlock(VenusBlocks.spaceStone, ItemBlockGC.class);
		SpaceCore.registerBlock(VenusBlocks.venusTreasureChest, ItemBlockGC.class);
		SpaceCore.registerBlock(VenusBlocks.evolvedBlazeEgg, ItemBlockGC.class);
		SpaceCore.registerBlock(VenusBlocks.sulfurTorch, ItemBlockGC.class);
	}
}