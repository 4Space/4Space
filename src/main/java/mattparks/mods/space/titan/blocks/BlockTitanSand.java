package mattparks.mods.space.titan.blocks;

import java.util.List;
import java.util.Random;

import mattparks.mods.space.core.SpaceCore;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockTitanSand extends BlockSand
{
	private IIcon[] sandIcon = new IIcon[2];
	
	public BlockTitanSand(String name)
	{
		super();
		this.setStepSound(Block.soundTypeSand);
		this.setHardness(0.55F);
		this.setBlockName(name);
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(this);
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return this.sandIcon[meta];
	}

	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int var4 = 0; var4 < 2; ++var4)
		{
			par3List.add(new ItemStack(par1, 1, var4));
		}
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		 this.sandIcon[0] = par1IconRegister.registerIcon("galacticrafttitan:titanSand");
		 this.sandIcon[1] = par1IconRegister.registerIcon("galacticrafttitan:wetSand");
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return SpaceCore.spaceBlocksTab;
	}
}