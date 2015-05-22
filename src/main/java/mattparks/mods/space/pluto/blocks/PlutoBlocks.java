package mattparks.mods.space.pluto.blocks;

import mattparks.mods.space.pluto.PlutoCore;
import mattparks.mods.space.pluto.blocks.items.ItemBlockBasicPluto;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class PlutoBlocks {
	public static Block plutoBasicBlock;

	private static void initBlocks() {
		PlutoBlocks.plutoBasicBlock = new BlockBasicPluto("pluto_block");
	}

	public static void setHarvestLevels() {
	}

	private static void registerBlocks() {
		PlutoCore.registerBlock(PlutoBlocks.plutoBasicBlock, ItemBlockBasicPluto.class);
	}

	public static void oreDictRegistration() {
		OreDictionary.registerOre("oreSapphire", new ItemStack(PlutoBlocks.plutoBasicBlock, 1, 4));
		OreDictionary.registerOre("oreIron", new ItemStack(PlutoBlocks.plutoBasicBlock, 1, 5));
		OreDictionary.registerOre("oreUnunpentium", new ItemStack(PlutoBlocks.plutoBasicBlock, 1, 6));
	}

	public static void init() {
		initBlocks();
		setHarvestLevels();
		registerBlocks();
		oreDictRegistration();
	}
}
