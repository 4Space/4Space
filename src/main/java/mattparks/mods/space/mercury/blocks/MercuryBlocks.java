package mattparks.mods.space.mercury.blocks;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.mercury.itemblocks.ItemBlockMercury;
import mattparks.mods.space.mercury.itemblocks.ItemBlockMercuryGlowstone;
import micdoodle8.mods.galacticraft.core.items.ItemBlockGC;
import net.minecraft.block.Block;

public class MercuryBlocks
{
	public static Block mercuryBasicBlock;
	public static Block caravanModule;
	public static Block caravanModuleDummy;
	public static Block mercuryGlowstone;
	public static Block mercuryTreasureChest;

	public static void init()
	{
		initBlocks();
		registerBlocks();
	}

	private static void initBlocks()
	{
		MercuryBlocks.mercuryBasicBlock = new BlockBasicMercury("mercury_block");
		MercuryBlocks.caravanModule = new BlockCaravanModule("caravan_module");
		MercuryBlocks.caravanModuleDummy = new BlockCaravanModuleDummy("caravan_module_dummy");
		MercuryBlocks.mercuryGlowstone = new BlockMercuryGlowstone("mercury_glowstone");
		MercuryBlocks.mercuryTreasureChest = new BlockT4MercuryTreasureChest("mercury_treasure_chest");
	}

	private static void registerBlocks()
	{
		SpaceCore.registerBlock(MercuryBlocks.mercuryBasicBlock, ItemBlockMercury.class);
		SpaceCore.registerBlock(MercuryBlocks.mercuryGlowstone, ItemBlockMercuryGlowstone.class);
		SpaceCore.registerBlock(MercuryBlocks.caravanModule, ItemBlockGC.class);
		SpaceCore.registerBlock(MercuryBlocks.caravanModuleDummy, ItemBlockGC.class);
		SpaceCore.registerBlock(MercuryBlocks.mercuryTreasureChest, ItemBlockGC.class);
	}
}