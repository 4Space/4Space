package mattparks.mods.space.titan.blocks;

import java.util.Random;

import mattparks.mods.space.core.SpaceCore;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEthaneCloud extends BlockBreakable
{
	public BlockEthaneCloud(String name)
	{
		super(name, Material.cloth, false);
		this.setStepSound(Block.soundTypeCloth);
		this.blockHardness = 0.55F;
		this.setBlockName(name);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("galacticrafttitan:ethaneCloud");
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return this.blockIcon;
	}

	@Override
	public Item getItemDropped(int meta, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(this);
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return SpaceCore.spaceBlocksTab;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		final float f = 0.999F;
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1 - f, z + 1);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if (entity instanceof EntityPlayer)
		{
			if (entity.motionY < 0)
			{
				entity.motionY *= 0.0005D;
				entity.fallDistance = 0.0F;
				return;
			}
		}
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
	{
		return super.shouldSideBeRendered(world, x, y, z, 1 - side);
	}
}