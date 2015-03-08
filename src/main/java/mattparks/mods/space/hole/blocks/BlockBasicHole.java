package mattparks.mods.space.hole.blocks;

import java.util.List;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.hole.HoleCore;
import micdoodle8.mods.galacticraft.api.block.IPlantableBlock;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockBasicHole extends Block implements IPlantableBlock, ITerraformableBlock {
	private IIcon[] venusBlockIcon;

	public BlockBasicHole(String name) {
		super(Material.rock);
		this.setBlockName(name);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.venusBlockIcon = new IIcon[7];
		this.venusBlockIcon[0] = par1IconRegister.registerIcon(HoleCore.TEXTURE_PREFIX + "holeSurfaceRock");
		this.venusBlockIcon[1] = par1IconRegister.registerIcon(HoleCore.TEXTURE_PREFIX + "holeSubRock");
		this.venusBlockIcon[2] = par1IconRegister.registerIcon(HoleCore.TEXTURE_PREFIX + "holeRock");
		this.venusBlockIcon[3] = par1IconRegister.registerIcon(HoleCore.TEXTURE_PREFIX + "holeCobblestone");
		this.venusBlockIcon[4] = par1IconRegister.registerIcon(HoleCore.TEXTURE_PREFIX + "holeBrick");
		this.venusBlockIcon[5] = par1IconRegister.registerIcon(HoleCore.TEXTURE_PREFIX + "flameiteOre");
		this.venusBlockIcon[6] = par1IconRegister.registerIcon(HoleCore.TEXTURE_PREFIX + "flameiteBlock");
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return SpaceCore.spaceBlocksTab;
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return this.venusBlockIcon[meta];
	}

	@Override
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
		for (int i = 0; i < 7; ++i) {
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public float getBlockHardness(World par1World, int par2, int par3, int par4) // FIX
	{
		final int meta = par1World.getBlockMetadata(par2, par3, par4);

		if (meta == 0) {
			return 1.25F;
		}

		if (meta == 1) {
			return 1.0F;
		}

		if (meta == 2) {
			return 1.5F;
		}

		if (meta == 3) {
			return 2.5F;
		}

		if (meta == 4) {
			return 2.0F;
		}

		if (meta == 5) {
			return 2.5F;
		}

		if (meta == 6) {
			return 2.5F;
		}

		return 1.0F;
	}

	public MapColor getMapColor(int meta) {
		switch (meta) {
		case 0:
			return MapColor.greenColor;
		default:
			return MapColor.greenColor;
		}
	}

	@Override
	public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
		int metadata = world.getBlockMetadata(x, y, z);

		if (metadata == 4) {
			return 40.0F;
		}

		return super.getExplosionResistance(par1Entity, world, x, y, z, explosionX, explosionY, explosionZ);
	}

	@Override
	public int damageDropped(int meta) {
		if (meta == 2) {
			return 3;
		}

		return meta;
	}

	@Override
	public boolean isTerraformable(World world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z) == 0 && world.getBlock(x, y + 1, z) instanceof BlockAir;
	}

	@Override
	public int requiredLiquidBlocksNearby() {
		return 4;
	}

	@Override
	public boolean isPlantable(int metadata) {
		switch (metadata) {
		case 0:
			return true;
		case 1:
			return true;
		default:
			return false;
		}
	}
}
