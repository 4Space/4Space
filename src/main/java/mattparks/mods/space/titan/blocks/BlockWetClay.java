package mattparks.mods.space.titan.blocks;

import java.util.Random;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.titan.items.TitanItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockWetClay extends Block
{
	public BlockWetClay(String name)
	{
		super(Material.clay);
		this.setStepSound(Block.soundTypeGravel);
		this.setHardness(0.55F);
		this.setBlockName(name);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("galacticrafttitan:wetClay");
	}

	@Override
	public int quantityDropped(Random par1Random)
	{
		return 4;
	}

	@Override
	public boolean canSilkHarvest()
	{
		return true;
	}

	@Override
	public Item getItemDropped(int meta, Random par2Random, int par3)
	{
		return TitanItems.wetClayBall;
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return SpaceCore.spaceBlocksTab;
	}
}