package mattparks.mods.space.venus.blocks;

import java.util.List;
import java.util.Random;

import mattparks.mods.space.core.SpaceCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockOreVenus extends Block
{
	private IIcon[] venusBlockIcon;

	public BlockOreVenus(String name)
	{
		super(Material.rock);
		this.setStepSound(soundTypeMetal);
		this.setBlockName(name);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.venusBlockIcon = new IIcon[4];
		this.venusBlockIcon[0] = par1IconRegister.registerIcon("galacticraftvenus:sulfurBlock");
		this.venusBlockIcon[1] = par1IconRegister.registerIcon("galacticraftvenus:uraniumBlock");
		this.venusBlockIcon[2] = par1IconRegister.registerIcon("galacticraftvenus:gemBlock");
		this.venusBlockIcon[3] = par1IconRegister.registerIcon("galacticraftvenus:crystalBlock");
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return SpaceCore.spaceBlocksTab;
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return this.venusBlockIcon[meta];
	}

	@Override
	public int getDamageValue(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}

	@Override
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list)
	{
		for (int i = 0; i < 4; ++i)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public float getBlockHardness(World par1World, int par2, int par3, int par4)
	{
		return 3.25F;
	}

	@Override
	public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
	{
		return super.getExplosionResistance(par1Entity, world, x, y, z, explosionX, explosionY, explosionZ);
	}

	@Override
	public Item getItemDropped(int meta, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(this);
	}

	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
}