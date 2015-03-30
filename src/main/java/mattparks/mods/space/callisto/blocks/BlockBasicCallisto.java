package mattparks.mods.space.callisto.blocks;

import java.util.List;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.callisto.CallistoCore;
import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import micdoodle8.mods.galacticraft.api.block.IPartialSealableBlock;
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
import net.minecraftforge.common.util.ForgeDirection;

public class BlockBasicCallisto extends Block implements IDetectableResource, IPartialSealableBlock, IPlantableBlock, ITerraformableBlock {
	private IIcon[] callistoBlockIcon;

	public BlockBasicCallisto(String name) {
		super(Material.rock);
		this.setBlockName(name);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.callistoBlockIcon = new IIcon[5];
		this.callistoBlockIcon[0] = par1IconRegister.registerIcon(CallistoCore.TEXTURE_PREFIX + "callistoSurfaceRock");
		this.callistoBlockIcon[1] = par1IconRegister.registerIcon(CallistoCore.TEXTURE_PREFIX + "callistoSubRock");
		this.callistoBlockIcon[2] = par1IconRegister.registerIcon(CallistoCore.TEXTURE_PREFIX + "callistoRock");
		this.callistoBlockIcon[3] = par1IconRegister.registerIcon(CallistoCore.TEXTURE_PREFIX + "callistoCobblestone");
		this.callistoBlockIcon[4] = par1IconRegister.registerIcon(CallistoCore.TEXTURE_PREFIX + "callistoDungeonBrick");
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return SpaceCore.spaceBlocksTab;
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return this.callistoBlockIcon[meta];
	}

	@Override
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
		for (int i = 0; i < 5; ++i) {
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
			return 25.0F;
		}

		return 1.0F;
	}

	@Override
	public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
		int metadata = world.getBlockMetadata(x, y, z);

		if (metadata == 4) {
			return 40.0F;
		}

		return super.getExplosionResistance(par1Entity, world, x, y, z, explosionX, explosionY, explosionZ);
	}

	public MapColor getMapColor(int meta) {
		switch (meta) {
		case 0:
			return MapColor.redColor;
		default:
			return MapColor.redColor;
		}
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

	@Override
	public boolean isSealed(World world, int x, int y, int z, ForgeDirection direction) {
		return false;
	}

	@Override
	public boolean isValueable(int metadata) {
		switch (metadata) {
		default:
			return false;
		}
	}
}
