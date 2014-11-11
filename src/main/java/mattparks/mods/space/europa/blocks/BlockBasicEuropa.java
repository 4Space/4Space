package mattparks.mods.space.europa.blocks;

import java.util.List;
import java.util.Random;

import mattparks.mods.space.core.SpaceCore;
import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBasicEuropa extends Block implements IDetectableResource, ITerraformableBlock
{
	private IIcon[] ioBlockIcon;

	public BlockBasicEuropa(String name)
	{
		super(Material.rock);
		this.setBlockName(name);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		if (world.getBlockMetadata(x, y, z) == 12)
		{
			return null;
		}
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
	{
		if (world.getBlockMetadata(x, y, z) == 12)
		{
			return AxisAlignedBB.getBoundingBox(x + 0.0D, y + 0.0D, z + 0.0D, x + 0.0D, y + 0.0D, z + 0.0D);
		}
		return super.getSelectedBoundingBoxFromPool(world, x, y, z);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		if (world.getBlockMetadata(x, y, z) == 12)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		}
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		super.setBlockBoundsBasedOnState(world, x, y, z);
	}

	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisalignedbb, List list, Entity entity)
	{
		if (world.getBlockMetadata(x, y, z) == 12)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			super.addCollisionBoxesToList(world, x, y, z, axisalignedbb, list, entity);
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		super.addCollisionBoxesToList(world, x, y, z, axisalignedbb, list, entity);
	}

	@Override
	public boolean isNormalCube(IBlockAccess world, int x, int y, int z)
	{
		if (world.getBlockMetadata(x, y, z) == 12)
		{
			return false;
		}
		return super.isNormalCube(world, x, y, z);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.ioBlockIcon = new IIcon[13];
		this.ioBlockIcon[0] = par1IconRegister.registerIcon("galacticrafteuropa:europaSurfaceIce");
		this.ioBlockIcon[1] = par1IconRegister.registerIcon("galacticrafteuropa:europaHardIce");
		this.ioBlockIcon[12] = par1IconRegister.registerIcon("galacticraftcore:blank");
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return SpaceCore.spaceBlocksTab;
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return this.ioBlockIcon[meta];
	}

	@Override
	public int getDamageValue(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}

	@Override
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list)
	{
		for (int i = 0; i < 2; ++i)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public float getBlockHardness(World par1World, int par2, int par3, int par4)
	{
		final int meta = par1World.getBlockMetadata(par2, par3, par4);

		if (meta == 2)
		{
			return 2.75F;
		}
		if (meta == 3)
		{
			return 2.5F;
		}
		if (meta == 0 || meta == 1 || meta >= 4 && meta <= 8)
		{
			return 3.0F;
		}
		if (meta == 9 || meta == 10)
		{
			return 3.25F;
		}
		if (meta == 11)
		{
			return 4.0F;
		}
		if (meta == 12)
		{
			return -1.0F;
		}
		return 1.0F;
	}

	@Override
	public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
	{
		final int meta = world.getBlockMetadata(x, y, z);

		if (meta == 12)
		{
			return 10000000.0F;
		}
		return super.getExplosionResistance(par1Entity, world, x, y, z, explosionX, explosionY, explosionZ);
	}

	@Override
	public boolean canHarvestBlock(EntityPlayer player, int meta)
	{
		if (meta == 12)
		{
			return false;
		}
		return super.canHarvestBlock(player, meta);
	}

	/*@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		if (metadata == 15)
		{
			return new TileEntityDionaDungeonSpawner();
		}//TODO
		return null;
	}*/

	@Override
	public Item getItemDropped(int meta, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(this);
	}

	@Override
	public int damageDropped(int meta)
	{
		if (meta == 2)
		{
			return 3;
		}
		return meta;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		if (meta == 12)
		{
			return 0;
		}
		if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(meta, random, fortune))
		{
			int j = random.nextInt(fortune + 2) - 1;

			if (j < 0)
			{
				j = 0;
			}
			return this.quantityDropped(random) * (j + 1);
		}
		return this.quantityDropped(random);
	}

	@Override
	public boolean isValueable(int meta)
	{
		if (meta >= 4 && meta <= 8)
		{
			return true;
		}
		return false;
	}

	@Override
	public void dropBlockAsItemWithChance(World world, int par2, int par3, int par4, int par5, float par6, int par7)
	{
		super.dropBlockAsItemWithChance(world, par2, par3, par4, par5, par6, par7);

		if (this.getItemDropped(par5, world.rand, par7) != Item.getItemFromBlock(this))
		{
			final int var8 = MathHelper.getRandomIntegerInRange(world.rand, 3, 5);
			this.dropXpOnBlockBreak(world, par2, par3, par4, var8);
		}
	}

	@Override
	public boolean isTerraformable(World world, int x, int y, int z)
	{
		final int meta = world.getBlockMetadata(x, y, z);

		if (meta == 0 || meta == 1)
		{
			return true;
		}
		return false;
	}
}