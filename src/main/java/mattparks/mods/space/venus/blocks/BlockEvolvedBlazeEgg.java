package mattparks.mods.space.venus.blocks;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.venus.VenusCore;
import mattparks.mods.space.venus.entities.EntityEvolvedBlaze;
//import mattparks.mods.space.venus.entities.EntityEvolvedBlaze;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEvolvedBlazeEgg extends BlockDragonEgg
{
	public BlockEvolvedBlazeEgg(String name)
	{
		super();
		this.setBlockName(name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(VenusCore.TEXTURE_PREFIX + "evolvedBlazeEgg");
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return SpaceCore.spaceBlocksTab;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return 27;
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		return false;
	}

	@Override
	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
	{
	}

	@Override
	public boolean canHarvestBlock(EntityPlayer player, int metadata)
	{
		ItemStack stack = player.inventory.getCurrentItem();
		
		if (stack == null)
		{
			return player.canHarvestBlock(this);
		}
		
		return stack.getItem() == MarsItems.deshPickSlime;
	}

	@Override
	public float getPlayerRelativeBlockHardness(EntityPlayer player, World p_149737_2_, int p_149737_3_, int p_149737_4_, int p_149737_5_)
	{
		ItemStack stack = player.inventory.getCurrentItem();
		
		if (stack != null && stack.getItem() == MarsItems.deshPickSlime)
		{
			return 0.2F;
		}
		
		return ForgeHooks.blockStrength(this, player, p_149737_2_, p_149737_3_, p_149737_4_, p_149737_5_);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World par1World, int par2, int par3, int par4)
	{
		return Item.getItemFromBlock(this);
	}

	@Override
	public void onBlockExploded(World world, int x, int y, int z, Explosion explosion)
	{
		if (!world.isRemote)
		{
			final EntityEvolvedBlaze blaze = new EntityEvolvedBlaze(world);
			blaze.setPosition(x + 0.5, y + 1, z + 0.5);
			world.spawnEntityInWorld(blaze);
		}
		
		world.setBlockToAir(x, y, z);
		this.onBlockDestroyedByExplosion(world, x, y, z, explosion);
	}
}