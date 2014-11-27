package mattparks.mods.space.europa.blocks;

import java.util.List;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.europa.EuropaCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockBasicEuropa extends Block
{
	private IIcon[] ioBlockIcon;

	public BlockBasicEuropa(String name)
	{
		super(Material.rock);
		this.setBlockName(name);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.ioBlockIcon = new IIcon[2];
		this.ioBlockIcon[0] = par1IconRegister.registerIcon(EuropaCore.TEXTURE_PREFIX + "europaSurfaceIce");
		this.ioBlockIcon[1] = par1IconRegister.registerIcon(EuropaCore.TEXTURE_PREFIX + "europaHardIce");
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
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list)
	{
		for (int i = 0; i < 2; ++i)
		{
			list.add(new ItemStack(this, 1, i));
		}
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
	public float getBlockHardness(World par1World, int par2, int par3, int par4) //FIX
	{
		final int meta = par1World.getBlockMetadata(par2, par3, par4);

		if (meta == 0)
		{
			return 1.25F;
		}
		
		if (meta == 1)
		{
			return 2.0F;
		}

		return 1.0F;
	}
}