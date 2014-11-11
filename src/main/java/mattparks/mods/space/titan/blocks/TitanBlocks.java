package mattparks.mods.space.titan.blocks;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.titan.fluids.EthaneFluid;
import mattparks.mods.space.titan.fluids.blocks.BlockFluidEthane;
import mattparks.mods.space.titan.itemblocks.ItemBlockTitanSand;
import micdoodle8.mods.galacticraft.core.items.ItemBlockGC;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class TitanBlocks
{
	public static Block titanBasicBlock;
	public static Block titanSand;
	public static Block wetClay;
	public static Block ethaneCloud;
	public static Block ethaneFluidBlock;

	public static Fluid ethaneFluid;

	public static void init()
	{
		initBlocks();
		registerBlocks();
	}

	private static void initBlocks()
	{
		TitanBlocks.titanBasicBlock = new BlockBasicTitan("titan_block");
		TitanBlocks.titanSand = new BlockTitanSand("titan_sand");
		TitanBlocks.wetClay = new BlockWetClay("wet_clay");
		TitanBlocks.ethaneCloud = new BlockEthaneCloud("ethane_cloud");

		TitanBlocks.ethaneFluid = new EthaneFluid("ethane_fluid").setBlock(TitanBlocks.ethaneFluidBlock);
		FluidRegistry.registerFluid(TitanBlocks.ethaneFluid);
		TitanBlocks.ethaneFluidBlock = new BlockFluidEthane("ethane_fluid", TitanBlocks.ethaneFluid, Material.water);
	}

	private static void registerBlocks()
	{
		SpaceCore.registerBlock(TitanBlocks.titanBasicBlock, ItemBlockGC.class);
		SpaceCore.registerBlock(TitanBlocks.titanSand, ItemBlockTitanSand.class);
		SpaceCore.registerBlock(TitanBlocks.wetClay, ItemBlockGC.class);
		SpaceCore.registerBlock(TitanBlocks.ethaneCloud, ItemBlockGC.class);
		SpaceCore.registerBlock(TitanBlocks.ethaneFluidBlock, ItemBlockGC.class);
	}
}