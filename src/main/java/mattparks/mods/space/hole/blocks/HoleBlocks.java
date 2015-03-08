package mattparks.mods.space.hole.blocks;

import mattparks.mods.space.hole.HoleCore;
import mattparks.mods.space.hole.itemblocks.ItemBlockBasicHole;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class HoleBlocks {
	public static Block holeBasicBlock;

	private static void initBlocks() {
		HoleBlocks.holeBasicBlock = new BlockBasicHole("hole_basic");
	}

	public static void setHarvestLevels() {
	}

	private static void registerBlocks() {
		HoleCore.registerBlock(HoleBlocks.holeBasicBlock, ItemBlockBasicHole.class);
	}

	public static void oreDictRegistration() {
		OreDictionary.registerOre("oreFlameite", new ItemStack(HoleBlocks.holeBasicBlock, 1, 5));
	}

	public static void init() {
		initBlocks();
		setHarvestLevels();
		registerBlocks();
		oreDictRegistration();
	}
}
