package mattparks.mods.space.mercury.blocks;

import mattparks.mods.space.core.util.ItemBlockUtil;
import mattparks.mods.space.mercury.MercuryCore;
import mattparks.mods.space.mercury.blocks.items.ItemBlockBasicMercury;
import mattparks.mods.space.mercury.blocks.items.ItemBlockGlowstoneMercury;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class MercuryBlocks {
	public static Block mercuryBasicBlock;
	public static Block caravanModule;
	public static Block caravanModuleDummy;
	public static Block mercuryGlowstone;
	public static Block mercuryTreasureChest;

	private static void initBlocks() {
		MercuryBlocks.mercuryBasicBlock = new BlockBasicMercury("mercury_block");
		MercuryBlocks.caravanModule = new BlockCaravanModule("caravan_module");
		MercuryBlocks.caravanModuleDummy = new BlockCaravanModuleDummy("caravan_module_dummy");
		MercuryBlocks.mercuryGlowstone = new BlockMercuryGlowstone("mercury_glowstone");
	}

	public static void setHarvestLevels() {
	}

	private static void registerBlocks() {
		MercuryCore.registerBlock(MercuryBlocks.mercuryBasicBlock, ItemBlockBasicMercury.class);
		MercuryCore.registerBlock(MercuryBlocks.mercuryGlowstone, ItemBlockGlowstoneMercury.class);
		MercuryCore.registerBlock(MercuryBlocks.caravanModule, ItemBlockUtil.class);
		MercuryCore.registerBlock(MercuryBlocks.caravanModuleDummy, ItemBlockUtil.class);
	}

	public static void oreDictRegistration() {
		OreDictionary.registerOre("oreIridium", new ItemStack(MercuryBlocks.mercuryBasicBlock, 1, 4));
		OreDictionary.registerOre("oreMeteor", new ItemStack(MercuryBlocks.mercuryBasicBlock, 1, 5));
		OreDictionary.registerOre("oreTin", new ItemStack(MercuryBlocks.mercuryBasicBlock, 1, 6));
		OreDictionary.registerOre("oreCopper", new ItemStack(MercuryBlocks.mercuryBasicBlock, 1, 7));
		OreDictionary.registerOre("oreGold", new ItemStack(MercuryBlocks.mercuryBasicBlock, 1, 8));
	}

	public static void init() {
		initBlocks();
		setHarvestLevels();
		registerBlocks();
		oreDictRegistration();
	}
}
