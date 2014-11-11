package mattparks.mods.space.gas.blocks;

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

public class BlockBasicGas extends Block implements IDetectableResource, ITerraformableBlock
{
	private IIcon[] gasBlockIcon;

	public BlockBasicGas(String name)
	{
		super(Material.rock);
		this.setBlockName(name);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		if (world.getBlockMetadata(x, y, z) == 16)
		{
			return null;
		}
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
	{
		if (world.getBlockMetadata(x, y, z) == 16)
		{
			return AxisAlignedBB.getBoundingBox(x + 0.0D, y + 0.0D, z + 0.0D, x + 0.0D, y + 0.0D, z + 0.0D);
		}
		return super.getSelectedBoundingBoxFromPool(world, x, y, z);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		if (world.getBlockMetadata(x, y, z) == 16)
		{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		}
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		super.setBlockBoundsBasedOnState(world, x, y, z);
	}

	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisalignedbb, List list, Entity entity)
	{
		if (world.getBlockMetadata(x, y, z) == 16)
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
		if (world.getBlockMetadata(x, y, z) == 16)
		{
			return false;
		}
		return super.isNormalCube(world, x, y, z);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		//Nitrogen
		//Helium
		//Hydrogen
		this.gasBlockIcon = new IIcon[17];
		this.gasBlockIcon[0] = par1IconRegister.registerIcon("galacticraftjupiter:jupiterNitrogen");
		this.gasBlockIcon[1] = par1IconRegister.registerIcon("galacticraftjupiter:jupiterHelium");
		this.gasBlockIcon[2] = par1IconRegister.registerIcon("galacticraftjupiter:jupiterHydrogen");
		this.gasBlockIcon[3] = par1IconRegister.registerIcon("galacticraftsaturn:saturnNitrogen");
		this.gasBlockIcon[4] = par1IconRegister.registerIcon("galacticraftsaturn:saturnHelium");
		this.gasBlockIcon[5] = par1IconRegister.registerIcon("galacticraftsaturn:saturnHydrogen");
		this.gasBlockIcon[6] = par1IconRegister.registerIcon("galacticrafturanus:uranusNitrogen");
		this.gasBlockIcon[7] = par1IconRegister.registerIcon("galacticrafturanus:uranusHelium");
		this.gasBlockIcon[8] = par1IconRegister.registerIcon("galacticrafturanus:uranusHydrogen");
		this.gasBlockIcon[9] = par1IconRegister.registerIcon("galacticraftneptune:neptuneNitrogen");
		this.gasBlockIcon[10] = par1IconRegister.registerIcon("galacticraftneptune:neptuneHelium");
		this.gasBlockIcon[11] = par1IconRegister.registerIcon("galacticraftneptune:neptuneHydrogen");
		this.gasBlockIcon[12] = par1IconRegister.registerIcon("galacticraftjupiter:jupiterBrick");
		this.gasBlockIcon[13] = par1IconRegister.registerIcon("galacticraftsaturn:saturnBrick");
		this.gasBlockIcon[14] = par1IconRegister.registerIcon("galacticrafturanus:uranusBrick");
		this.gasBlockIcon[15] = par1IconRegister.registerIcon("galacticraftneptune:neptuneBrick");
		this.gasBlockIcon[16] = par1IconRegister.registerIcon("galacticraftcore:blank");
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return SpaceCore.spaceBlocksTab;
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return this.gasBlockIcon[meta];
	}

	@Override
	public int getDamageValue(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}

	@Override
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list)
	{
		for (int i = 0; i < 16; ++i)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public float getBlockHardness(World par1World, int par2, int par3, int par4)
	{
		final int meta = par1World.getBlockMetadata(par2, par3, par4);

		if (meta == 0 || meta == 3 || meta == 6 || meta == 9)
		{
			return 1.5F;
		}
		if (meta == 1 || meta == 4 || meta == 7 || meta == 10)
		{
			return 1.25F;
		}
		if (meta == 2 || meta == 5 || meta == 8 || meta == 11)
		{
			return 2.5F;
		}
		if (meta >= 12 && meta <= 15)
		{
			return 4.0F;
		}
		return 1.0F;
	}

	@Override
	public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
	{
		final int meta = world.getBlockMetadata(x, y, z);

		if (meta == 16)
		{
			return 10000000.0F;
		}
		return super.getExplosionResistance(par1Entity, world, x, y, z, explosionX, explosionY, explosionZ);
	}

	@Override
	public boolean canHarvestBlock(EntityPlayer player, int meta)
	{
		if (meta == 16)
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
		return meta;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		if (meta == 16)
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

		if (meta >= 12 && meta <= 15)
		{
			return false;
		}
		return true;
	}
}