package mattparks.mods.space.io.blocks;

import java.util.Random;

import mattparks.mods.space.io.IoCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockIoLavaStill extends BlockIoLiquid
{
	private IIcon[] ioLavaIcon;
	private String stillTexture;
	private String flowingTexture;
	private boolean usingMinecraftDirectory;

	public BlockIoLavaStill(String name, String stillTexture, String flowingTexture)
	{
		super(Material.lava);
		this.setLightLevel(1.0F);
		this.setHardness(100.0F);
		this.setResistance(100.0F);
		this.setBlockName(name);
		this.setTickRandomly(true);
		this.stillTexture = stillTexture;
		this.flowingTexture = flowingTexture;
	}

	public BlockIoLavaStill(String name, String stillTexture, String flowingTexture, boolean usingMcTexture)
	{
		super(Material.lava);
		this.usingMinecraftDirectory = usingMcTexture;
		this.setLightLevel(1.0F);
		this.setHardness(100.0F);
		this.setResistance(100.0F);
		this.setBlockName(name);
		this.stillTexture = stillTexture;
		this.flowingTexture = flowingTexture;
		this.setTickRandomly(true);
	}

	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		if (!this.usingMinecraftDirectory)
		{
			this.ioLavaIcon = new IIcon[] { icon.registerIcon(IoCore.TEXTURE_PREFIX + this.stillTexture), icon.registerIcon(IoCore.TEXTURE_PREFIX + this.flowingTexture) };
		}
		else
		{
			this.ioLavaIcon = new IIcon[] { icon.registerIcon(this.stillTexture), icon.registerIcon(this.flowingTexture) };
		}
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return side != 0 && side != 1 ? this.ioLavaIcon[1] : this.ioLavaIcon[0];
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		super.onNeighborBlockChange(world, x, y, z, block);

		if (world.getBlock(x, y, z) == this)
		{
			this.setNotStationary(world, x, y, z);
		}
	}

	private void setNotStationary(World world, int x, int y, int z)
	{
		final int i = world.getBlockMetadata(x, y, z);
		world.setBlock(x, y, z, Block.getBlockById(Block.getIdFromBlock(this) - 1), i, 2);
		world.scheduleBlockUpdate(x, y, z, Block.getBlockById(Block.getIdFromBlock(this) - 1), this.tickRate(world));
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		final int i = rand.nextInt(3);

		for (int j = 0; j < i; j++)
		{
			x += rand.nextInt(3) - 1;
			y++;
			z += rand.nextInt(3) - 1;
			final Block localBlock = world.getBlock(x, y, z);

			if (localBlock.getMaterial() == Material.air)
			{
				if (this.isFlammable(world, x - 1, y, z) || this.isFlammable(world, x + 1, y, z) || this.isFlammable(world, x, y, z - 1) || this.isFlammable(world, x, y, z + 1) || this.isFlammable(world, x, y - 1, z) || this.isFlammable(world, x, y + 1, z))
				{
					world.setBlock(x, y, z, Blocks.fire);
				}
			}
			else if (localBlock.getMaterial().blocksMovement())
			{
				return;
			}
		}
		if (i == 0)
		{
			final int j = x;
			final int k = z;

			for (int m = 0; m < 3; m++)
			{
				x = j + rand.nextInt(3) - 1;
				z = k + rand.nextInt(3) - 1;

				if (world.isAirBlock(x, y + 1, z) && this.isFlammable(world, x, y, z))
				{
					world.setBlock(x, y + 1, z, Blocks.fire);
				}
			}
		}
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		entity.setFire(10);
	}

	private boolean isFlammable(World world, int x, int y, int z)
	{
		return world.getBlock(x, y, z).getMaterial().getCanBurn();
	}
}
