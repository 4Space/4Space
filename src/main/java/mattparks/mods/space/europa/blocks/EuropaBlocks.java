package mattparks.mods.space.europa.blocks;

import mattparks.mods.space.core.util.ItemBlockUtil;
import mattparks.mods.space.europa.EuropaCore;
import mattparks.mods.space.europa.fluids.EuropaWaterFluid;
import mattparks.mods.space.europa.fluids.blocks.BlockFluidEuropaWater;
import mattparks.mods.space.europa.itemblocks.ItemBlockBasicEuropa;
import mattparks.mods.space.europa.itemblocks.ItemBlockEuropaIce;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class EuropaBlocks {
	public static Block europaBasicBlock;
	public static Block europaIce;
	public static Block packedEuropaIce;
	public static Block europaWaterFluidBlock;

	public static Fluid europaWaterFluid;

	private static void initBlocks() {
		EuropaBlocks.europaBasicBlock = new BlockBasicEuropa("europa_block");
		EuropaBlocks.europaIce = new BlockEuropaIce("europa_ice");
		EuropaBlocks.packedEuropaIce = new BlockPackedEuropaIce("packed_europa_ice");

		EuropaBlocks.europaWaterFluid = new EuropaWaterFluid("europa_water_fluid").setBlock(EuropaBlocks.europaWaterFluidBlock);
		FluidRegistry.registerFluid(EuropaBlocks.europaWaterFluid);
		EuropaBlocks.europaWaterFluidBlock = new BlockFluidEuropaWater("europa_water_fluid", EuropaBlocks.europaWaterFluid, Material.water);
	}

	private static void setHarvestLevels() {
		EuropaBlocks.europaBasicBlock.setHarvestLevel("pickaxe", 1);
	}

	private static void registerBlocks() {
		EuropaCore.registerBlock(EuropaBlocks.europaBasicBlock, ItemBlockBasicEuropa.class);
		EuropaCore.registerBlock(EuropaBlocks.europaIce, ItemBlockEuropaIce.class);
		EuropaCore.registerBlock(EuropaBlocks.packedEuropaIce, ItemBlockUtil.class);
		EuropaCore.registerBlock(EuropaBlocks.europaWaterFluidBlock, ItemBlockUtil.class);
	}

	public static void oreDictRegistration() {
	}

	public static void init() {
		initBlocks();
		setHarvestLevels();
		registerBlocks();
		oreDictRegistration();
	}
}
