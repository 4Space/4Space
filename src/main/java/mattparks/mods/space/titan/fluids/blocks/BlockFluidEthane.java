package mattparks.mods.space.titan.fluids.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFluidEthane extends BlockFluidClassic
{
	public static IIcon ethaneStillIcon;
	public static IIcon ethaneFlowingIcon;

	public BlockFluidEthane(String name, Fluid fluid, Material par2Material)
	{
		super(fluid, par2Material);
		this.setQuantaPerBlock(4);
		this.setRenderPass(1);
		this.needsRandomTick = true;
		this.stack = new FluidStack(fluid, FluidContainerRegistry.BUCKET_VOLUME);
		this.setBlockName(name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2)
	{
		return par1 != 0 && par1 != 1 ? BlockFluidEthane.ethaneStillIcon : BlockFluidEthane.ethaneFlowingIcon;
	}

	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z)
	{
		if (world.getBlock(x, y, z).getMaterial().isLiquid())
		{
			return false;
		}
		return super.canDisplace(world, x, y, z);
	}

	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z)
	{
		if (world.getBlock(x, y, z).getMaterial().isLiquid())
		{
			return false;
		}
		return super.displaceIfPossible(world, x, y, z);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		BlockFluidEthane.ethaneStillIcon = par1IconRegister.registerIcon("galacticrafttitan:ethane_flowing");
		BlockFluidEthane.ethaneFlowingIcon = par1IconRegister.registerIcon("galacticrafttitan:ethane_still");
	}

	/*@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random rand)
	{
		super.randomDisplayTick(par1World, par2, par3, par4, rand);

		if (rand.nextInt(64) == 0)
		{
			final int l = par1World.getBlockMetadata(par2, par3, par4);

			if (l > 0 && l < 8)
			{
				par1World.playSound(par2 + 0.5F, par3 + 0.5F, par4 + 0.5F, "liquid.water", rand.nextFloat() * 0.25F + 0.75F, rand.nextFloat() * 1.0F + 0.5F, false);
			}
		}
	}*/
}