package mattparks.mods.space.titan.fluids;

import mattparks.mods.space.titan.fluids.blocks.BlockFluidEthane;
import net.minecraftforge.fluids.Fluid;

public class EthaneFluid extends Fluid
{
	public EthaneFluid(String fluidName)
	{
		super(fluidName);
		this.setViscosity(5000);
		this.setIcons(BlockFluidEthane.ethaneStillIcon, BlockFluidEthane.ethaneFlowingIcon);
	}
}