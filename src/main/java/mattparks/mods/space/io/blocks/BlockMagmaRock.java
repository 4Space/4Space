package mattparks.mods.space.io.blocks;

import java.util.List;
import java.util.Random;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.io.IoCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockMagmaRock extends Block {
	private IIcon[] rockIcon = new IIcon[2];

	public BlockMagmaRock(String name) {
		super(Material.rock);
		this.setBlockName(name);
		this.setHardness(3.0F);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.rockIcon[0] = par1IconRegister.registerIcon(IoCore.TEXTURE_PREFIX + "magmaRock");
		this.rockIcon[1] = par1IconRegister.registerIcon(IoCore.TEXTURE_PREFIX + "sulfurRock");
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return SpaceCore.spaceBlocksTab;
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return this.rockIcon[meta];
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int par2, int par3, int par4) {
		if (world.getBlockMetadata(par2, par3, par4) == 0) {
			final float f = 0.1F;
			return AxisAlignedBB.getBoundingBox(par2, par3, par4, par2 + 1, par3 + 1 - f, par4 + 1);
		}
		return super.getCollisionBoundingBoxFromPool(world, par2, par3, par4);
	}

	@Override
	public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side) {
		if (world.getBlockMetadata(x, y, z) == 0) {
			if (side == ForgeDirection.UP) {
				return true;
			}
		}
		return super.isFireSource(world, x, y, z, side);
	}

	@Override
	public Item getItemDropped(int meta, Random par2Random, int par3) {
		return Item.getItemFromBlock(this);
	}

	@Override
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
		for (int i = 0; i < 2; ++i) {
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (world.getBlockMetadata(x, y, z) == 0) {
			entity.setFire(10);
			entity.motionX *= 0.5D;
			entity.motionZ *= 0.5D;
		}
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		if (random.nextInt(1) == 0) {
			world.spawnParticle("smoke", x + random.nextFloat(), y + 1.1F, z + random.nextFloat(), 0.0D, 0.0D, 0.0D);
		}
	}
}
