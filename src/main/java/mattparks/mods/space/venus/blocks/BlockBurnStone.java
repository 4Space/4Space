package mattparks.mods.space.venus.blocks;

import java.util.Random;

import mattparks.mods.space.core.SpaceCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockBurnStone extends Block
{
	public BlockBurnStone(String name)
	{
		super(Material.rock);
		this.setBlockName(name);
		this.setHardness(3.0F);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("galacticraftvenus:burnStone");
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return SpaceCore.spaceBlocksTab;
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return this.blockIcon;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int par2, int par3, int par4)
	{
		final float f = 0.1F;
		return AxisAlignedBB.getBoundingBox(par2, par3, par4, par2 + 1, par3 + 1 - f, par4 + 1);
	}

	@Override
	public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side)
	{
		if (side == ForgeDirection.UP)
		{
			return true;
		}
		return super.isFireSource(world, x, y, z, side);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		entity.setFire(10);
		entity.motionX *= 0.5D;
		entity.motionZ *= 0.5D;
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		if (random.nextInt(1) == 0)
		{
			world.spawnParticle("smoke", x + random.nextFloat(), y + 1.1F, z + random.nextFloat(), 0.0D, 0.0D, 0.0D);
		}
	}
}