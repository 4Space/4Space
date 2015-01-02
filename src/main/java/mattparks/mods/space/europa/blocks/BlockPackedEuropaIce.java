package mattparks.mods.space.europa.blocks;

import java.util.Random;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.europa.EuropaCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPackedEuropaIce extends Block
{
	public BlockPackedEuropaIce(String name)
	{
		super(Material.packedIce);
		this.slipperiness = 0.99F;
		this.setHardness(0.5F);
		this.setBlockName(name);
		this.setStepSound(soundTypeGlass);
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return SpaceCore.spaceBlocksTab;
	}

	@Override
	public boolean canSilkHarvest()
	{
		return true;
	}

	@Override
	public int quantityDropped(Random rand)
	{
		return 0;
	}

	@Override
	public int getMobilityFlag()
	{
		return 0;
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
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(EuropaCore.TEXTURE_PREFIX + "packedEuropaIce");
	}
}
