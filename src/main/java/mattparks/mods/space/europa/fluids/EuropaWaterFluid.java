package mattparks.mods.space.europa.fluids;

import mattparks.mods.space.europa.fluids.blocks.BlockFluidEuropaWater;
import net.minecraftforge.fluids.Fluid;

public class EuropaWaterFluid extends Fluid
{
	public EuropaWaterFluid(String fluidName)
	{
		super(fluidName);
		this.setIcons(BlockFluidEuropaWater.europaWaterStillIcon, BlockFluidEuropaWater.europaWaterFlowingIcon);
	}
}