package mattparks.mods.space.pluto.blocks;

import java.util.List;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.pluto.PlutoCore;
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

public class BlockBasicPluto extends Block implements IDetectableResource, IPartialSealableBlock, IPlantableBlock, ITerraformableBlock
{
	private IIcon[] plutoBlockIcon;

	public BlockBasicPluto(String name)
	{
		super(Material.rock);
		this.setBlockName(name);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.plutoBlockIcon = new IIcon[11];
		this.plutoBlockIcon[0] = par1IconRegister.registerIcon(PlutoCore.TEXTURE_PREFIX + "plutoSurfaceRock");
		this.plutoBlockIcon[1] = par1IconRegister.registerIcon(PlutoCore.TEXTURE_PREFIX + "plutoSubRock");
		this.plutoBlockIcon[2] = par1IconRegister.registerIcon(PlutoCore.TEXTURE_PREFIX + "plutoRock");
		this.plutoBlockIcon[3] = par1IconRegister.registerIcon(PlutoCore.TEXTURE_PREFIX + "plutoCobblestone");
		this.plutoBlockIcon[4] = par1IconRegister.registerIcon(PlutoCore.TEXTURE_PREFIX + "blueGemOre");
		this.plutoBlockIcon[5] = par1IconRegister.registerIcon(PlutoCore.TEXTURE_PREFIX + "frozenIronOre");
		this.plutoBlockIcon[6] = par1IconRegister.registerIcon(PlutoCore.TEXTURE_PREFIX + "ununpentiumOre");
		this.plutoBlockIcon[7] = par1IconRegister.registerIcon(PlutoCore.TEXTURE_PREFIX + "blueGemBlock");
		this.plutoBlockIcon[8] = par1IconRegister.registerIcon(PlutoCore.TEXTURE_PREFIX + "frozenIronBlock");
		this.plutoBlockIcon[9] = par1IconRegister.registerIcon(PlutoCore.TEXTURE_PREFIX + "ununpetiumBlock");
		this.plutoBlockIcon[10] = par1IconRegister.registerIcon(PlutoCore.TEXTURE_PREFIX + "plutoDungeonBrick");
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return SpaceCore.spaceBlocksTab;
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return this.plutoBlockIcon[meta];
	}

	@Override
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list)
	{
		for (int i = 0; i < 11; ++i)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public float getBlockHardness(World par1World, int par2, int par3, int par4) // FIX
	{
		final int meta = par1World.getBlockMetadata(par2, par3, par4);

		if (meta == 0)
		{
			return 1.25F;
		}

		if (meta == 1)
		{
			return 1.0F;
		}

		if (meta == 2)
		{
			return 1.5F;
		}

		if (meta == 3)
		{
			return 2.5F;
		}

		if (meta == 4)
		{
			return 2.5F;
		}

		if (meta == 5)
		{
			return 2.5F;
		}

		if (meta == 6)
		{
			return 2.5F;
		}

		if (meta == 7)
		{
			return 2.5F;
		}

		if (meta == 8)
		{
			return 2.5F;
		}

		if (meta == 9)
		{
			return 2.5F;
		}

		if (meta == 12)
		{
			return 25.0F;
		}

		return 1.0F;
	}

	@Override
	public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
	{
		int metadata = world.getBlockMetadata(x, y, z);

		if (metadata == 10)
		{
			return 40.0F;
		}

		return super.getExplosionResistance(par1Entity, world, x, y, z, explosionX, explosionY, explosionZ);
	}

	public MapColor getMapColor(int meta)
	{
		switch (meta)
		{
			case 0:
				return MapColor.blueColor;
			default:
				return MapColor.blueColor;
		}
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
	public boolean isTerraformable(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z) == 0 && world.getBlock(x, y + 1, z) instanceof BlockAir;
	}

	@Override
	public int requiredLiquidBlocksNearby()
	{
		return 4;
	}

	@Override
	public boolean isPlantable(int metadata)
	{
		switch (metadata)
		{
			case 0:
				return true;
			case 1:
				return true;
			default:
				return false;
		}
	}

	@Override
	public boolean isSealed(World world, int x, int y, int z, ForgeDirection direction)
	{
		return false;
	}

	@Override
	public boolean isValueable(int metadata)
	{
		switch (metadata)
		{
			case 4:
				return true;
			case 5:
				return true;
			case 6:
				return true;
			default:
				return false;
		}
	}
}
