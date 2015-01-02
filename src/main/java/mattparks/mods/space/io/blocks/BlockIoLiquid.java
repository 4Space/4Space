package mattparks.mods.space.io.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public abstract class BlockIoLiquid extends BlockLiquid
{
	public BlockIoLiquid(Material material)
	{
		super(material);
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random rand)
	{
		if (this.blockMaterial == Material.lava && world.getBlock(x, y + 1, z).getMaterial() == Material.air && !world.getBlock(x, y + 1, z).isOpaqueCube())
		{
			if (rand.nextInt(100) == 0)
			{
				final double d5 = x + rand.nextFloat();
				final double d6 = y + this.maxY;
				final double d7 = z + rand.nextFloat();
				world.spawnParticle("lava", d5, d6, d7, 0.0D, 0.0D, 0.0D);
				world.playSound(d5, d6, d7, "liquid.lavapop", 0.2F + rand.nextFloat() * 0.2F, 0.9F + rand.nextFloat() * 0.15F, false);
			}
			if (rand.nextInt(200) == 0)
			{
				world.playSound(x, y, z, "liquid.lava", 0.2F + rand.nextFloat() * 0.2F, 0.9F + rand.nextFloat() * 0.15F, false);
			}
		}
		if (rand.nextInt(10) == 0 && World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && !world.getBlock(x, y - 2, z).getMaterial().blocksMovement())
		{
			final double d5 = x + rand.nextFloat();
			final double d6 = y - 1.05D;
			final double d7 = z + rand.nextFloat();
			world.spawnParticle("dripLava", d5, d6, d7, 0.0D, 0.0D, 0.0D);
		}
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		this.func_149805_n(world, x, y, z);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		this.func_149805_n(world, x, y, z);
	}

	private void func_149805_n(World world, int x, int y, int z)
	{
		if (world.getBlock(x, y, z) == this)
		{
			boolean flag = false;

			if (flag || world.getBlock(x, y, z - 1).getMaterial() == Material.water)
			{
				flag = true;
			}
			if (flag || world.getBlock(x, y, z + 1).getMaterial() == Material.water)
			{
				flag = true;
			}
			if (flag || world.getBlock(x - 1, y, z).getMaterial() == Material.water)
			{
				flag = true;
			}
			if (flag || world.getBlock(x + 1, y, z).getMaterial() == Material.water)
			{
				flag = true;
			}
			if (flag || world.getBlock(x, y + 1, z).getMaterial() == Material.water)
			{
				flag = true;
			}
			if (flag)
			{
				final int l = world.getBlockMetadata(x, y, z);

				if (l == 0)
				{
					world.setBlock(x, y, z, Blocks.obsidian);
				}
				else if (l <= 7)
				{
					world.setBlock(x, y, z, IoBlocks.ioBasicBlock, 3, 3);
				}
				this.func_149799_m(world, x, y, z);
			}
		}
	}

	@Override
	protected void func_149799_m(World world, int x, int y, int z)
	{
		world.playSoundEffect(x + 0.5F, y + 0.5F, z + 0.5F, "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

		for (int l = 0; l < 8; l++)
		{
			world.spawnParticle("largesmoke", x + Math.random(), y + 1.2D, z + Math.random(), 0.0D, 0.0D, 0.0D);
		}
	}
}
