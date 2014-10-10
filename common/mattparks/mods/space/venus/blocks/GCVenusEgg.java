package mattparks.mods.space.venus.blocks;

import mattparks.mods.space.venus.GCVenus;
import mattparks.mods.space.venus.entities.GCVenusEntityEvolvedBlaze;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusEgg extends BlockDragonEgg
{
	public GCVenusEgg(int par1)
	{
		super(par1);
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return GCVenus.galacticraftVenusTab;
	}

	@Override
	public int getRenderType()
	{
		return 27;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int idPicked(World par1World, int par2, int par3, int par4)
	{
		return 0;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
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
	public void onBlockExploded(World world, int x, int y, int z, Explosion explosion)
	{
		if (!world.isRemote)
		{
			GCVenusEntityEvolvedBlaze blaze = new GCVenusEntityEvolvedBlaze(world);
			blaze.setPosition(x + 0.5, y + 1, z + 0.5);
			world.spawnEntityInWorld(blaze);
		}

		world.setBlockToAir(x, y, z);
		this.onBlockDestroyedByExplosion(world, x, y, z, explosion);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(GCVenus.TEXTURE_PREFIX + "evolvedBlazeEgg");
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
}
