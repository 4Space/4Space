package mattparks.mods.space.mercury.blocks;

import java.util.List;
import java.util.Random;

import mattparks.mods.space.core.SpaceCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMercuryGlowstone extends Block
{
	private IIcon[] iconArray;

	public BlockMercuryGlowstone(String name)
	{
		super(Material.glass);
		this.setBlockName(name);
		this.setStepSound(Block.soundTypeGlass);
		this.setHardness(0.5F);
		this.setLightLevel(1.0F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.iconArray = new IIcon[16];

		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = par1IconRegister.registerIcon("galacticraftmercury:glowstone_" + ItemDye.field_150921_b[BlockMercuryGlowstone.getDyeFromBlock(i)]);
		}
	}

	@Override
	public boolean canSilkHarvest()
	{
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return this.iconArray[par2 % this.iconArray.length];
	}

	@Override
	public int damageDropped(int par1)
	{
		return par1;
	}

	public static int getDyeFromBlock(int par0)
	{
		return ~par0 & 15;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int j = 0; j < 16; ++j)
		{
			par3List.add(new ItemStack(par1, 1, j));
		}
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return SpaceCore.spaceBlocksTab;
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(Blocks.air);
	}
}