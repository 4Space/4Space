package mattparks.mods.space.mercury.blocks;

import mattparks.mods.space.core.SpaceCore;
import micdoodle8.mods.galacticraft.api.block.IPartialSealableBlock;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCaravanModule extends Block implements IPartialSealableBlock
{
	public BlockCaravanModule(String name)
	{
		super(Material.cloth);
		this.setBlockName(name);
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setStepSound(soundTypeCloth);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("galacticraftmercury:caravanModule");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return SpaceCore.spaceBlocksTab;
	}

	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
	{
		this.breakBlocks(par1World, par2, par3 + 2, par4 - 1, false);

		this.breakBlocks(par1World, par2, par3, par4 - 1, false);
		this.breakBlocks(par1World, par2 + 1, par3, par4 - 1, false);
		this.breakBlocks(par1World, par2 + 1, par3, par4, false);
		this.breakBlocks(par1World, par2 + 1, par3, par4 + 1, false);
		this.breakBlocks(par1World, par2, par3, par4 + 1, false);
		this.breakBlocks(par1World, par2 - 1, par3, par4 + 1, false);
		this.breakBlocks(par1World, par2 - 1, par3, par4, false);
		this.breakBlocks(par1World, par2 - 1, par3, par4 - 1, false);

		this.breakBlocks(par1World, par2 - 1, par3, par4 + 2, false);
		this.breakBlocks(par1World, par2, par3, par4 + 2, false);
		this.breakBlocks(par1World, par2 + 1, par3, par4 + 2, false);

		this.breakBlocks(par1World, par2 - 1, par3, par4 + 3, false);
		this.breakBlocks(par1World, par2, par3, par4 + 3, false);
		this.breakBlocks(par1World, par2 + 1, par3, par4 + 3, false);

		this.breakBlocks(par1World, par2 - 1, par3, par4 + 4, false);
		this.breakBlocks(par1World, par2, par3, par4 + 4, false);
		this.breakBlocks(par1World, par2 + 1, par3, par4 + 4, false);

		this.breakBlocks(par1World, par2 + 2, par3, par4 + 4, false);
		this.breakBlocks(par1World, par2 + 2, par3, par4 + 3, false);
		this.breakBlocks(par1World, par2 + 2, par3, par4 + 2, false);
		this.breakBlocks(par1World, par2 + 2, par3, par4 + 1, false);
		this.breakBlocks(par1World, par2 + 2, par3, par4, false);
		this.breakBlocks(par1World, par2 + 2, par3, par4 - 1, false);
		this.breakBlocks(par1World, par2 + 2, par3, par4 - 2, false);

		this.breakBlocks(par1World, par2 + 1, par3, par4 - 2, false);
		this.breakBlocks(par1World, par2, par3, par4 - 2, false);
		this.breakBlocks(par1World, par2 - 1, par3, par4 - 2, false);
		this.breakBlocks(par1World, par2 - 2, par3, par4 - 2, false);

		this.breakBlocks(par1World, par2 - 2, par3, par4 - 1, false);
		this.breakBlocks(par1World, par2 - 2, par3, par4, false);
		this.breakBlocks(par1World, par2 - 2, par3, par4 + 1, false);
		this.breakBlocks(par1World, par2 - 2, par3, par4 + 2, false);
		this.breakBlocks(par1World, par2 - 2, par3, par4 + 3, false);
		this.breakBlocks(par1World, par2 - 2, par3, par4 + 4, false);

		this.breakBlocks(par1World, par2 - 1, par3 + 1, par4 + 4, false);
		this.breakBlocks(par1World, par2 + 1, par3 + 1, par4 + 4, false);

		this.breakBlocks(par1World, par2 + 2, par3 + 1, par4 + 4, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 1, par4 + 3, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 1, par4 + 2, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 1, par4 + 1, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 1, par4, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 1, par4 - 1, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 1, par4 - 2, false);

		this.breakBlocks(par1World, par2 + 1, par3 + 1, par4 - 2, false);
		this.breakBlocks(par1World, par2, par3 + 1, par4 - 2, false);
		this.breakBlocks(par1World, par2 - 1, par3 + 1, par4 - 2, false);
		this.breakBlocks(par1World, par2 - 2, par3 + 1, par4 - 2, false);

		this.breakBlocks(par1World, par2 - 2, par3 + 1, par4 - 1, false);
		this.breakBlocks(par1World, par2 - 2, par3 + 1, par4, false);
		this.breakBlocks(par1World, par2 - 2, par3 + 1, par4 + 1, false);
		this.breakBlocks(par1World, par2 - 2, par3 + 1, par4 + 2, false);
		this.breakBlocks(par1World, par2 - 2, par3 + 1, par4 + 3, false);
		this.breakBlocks(par1World, par2 - 2, par3 + 1, par4 + 4, false);

		this.breakBlocks(par1World, par2 - 1, par3 + 1, par4 - 1, false);
		this.breakBlocks(par1World, par2 + 1, par3 + 1, par4 - 1, false);
		this.breakBlocks(par1World, par2, par3 + 1, par4 - 1, false);

		this.breakBlocks(par1World, par2 - 1, par3 + 2, par4 + 4, false);
		this.breakBlocks(par1World, par2 + 1, par3 + 2, par4 + 4, false);

		this.breakBlocks(par1World, par2, par3, par4 + 5, false);

		this.breakBlocks(par1World, par2 + 2, par3 + 2, par4 + 4, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 2, par4 + 3, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 2, par4 + 2, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 2, par4 + 1, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 2, par4, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 2, par4 - 1, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 2, par4 - 2, false);

		this.breakBlocks(par1World, par2 + 1, par3 + 2, par4 - 2, false);
		this.breakBlocks(par1World, par2, par3 + 2, par4 - 2, false);
		this.breakBlocks(par1World, par2 - 1, par3 + 2, par4 - 2, false);
		this.breakBlocks(par1World, par2 - 2, par3 + 2, par4 - 2, false);

		this.breakBlocks(par1World, par2 - 2, par3 + 2, par4 - 1, false);
		this.breakBlocks(par1World, par2 - 2, par3 + 2, par4, false);
		this.breakBlocks(par1World, par2 - 2, par3 + 2, par4 + 1, false);
		this.breakBlocks(par1World, par2 - 2, par3 + 2, par4 + 2, false);
		this.breakBlocks(par1World, par2 - 2, par3 + 2, par4 + 3, false);

		this.breakBlocks(par1World, par2 - 2, par3 + 2, par4 + 4, false);

		this.breakBlocks(par1World, par2 - 1, par3 + 3, par4 + 4, false);
		this.breakBlocks(par1World, par2, par3 + 3, par4 + 4, false);
		this.breakBlocks(par1World, par2 + 1, par3 + 3, par4 + 4, false);

		this.breakBlocks(par1World, par2 + 2, par3 + 3, par4 + 4, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 3, par4 + 3, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 3, par4 + 2, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 3, par4 + 1, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 3, par4, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 3, par4 - 1, false);
		this.breakBlocks(par1World, par2 + 2, par3 + 3, par4 - 2, false);

		this.breakBlocks(par1World, par2 + 1, par3 + 3, par4 - 2, false);
		this.breakBlocks(par1World, par2, par3 + 3, par4 - 2, false);
		this.breakBlocks(par1World, par2 - 1, par3 + 3, par4 - 2, false);
		this.breakBlocks(par1World, par2 - 2, par3 + 3, par4 - 2, false);

		this.breakBlocks(par1World, par2 - 2, par3 + 3, par4 - 1, false);
		this.breakBlocks(par1World, par2 - 2, par3 + 3, par4, false);
		this.breakBlocks(par1World, par2 - 2, par3 + 3, par4 + 1, false);
		this.breakBlocks(par1World, par2 - 2, par3 + 3, par4 + 2, false);
		this.breakBlocks(par1World, par2 - 2, par3 + 3, par4 + 3, false);
		this.breakBlocks(par1World, par2 - 2, par3 + 3, par4 + 4, false);

		this.breakBlocks(par1World, par2, par3 + 4, par4 + 4, false);
		this.breakBlocks(par1World, par2, par3 + 4, par4 + 3, false);
		this.breakBlocks(par1World, par2, par3 + 4, par4 + 2, false);
		this.breakBlocks(par1World, par2, par3 + 4, par4 + 1, false);
		this.breakBlocks(par1World, par2, par3 + 4, par4, false);
		this.breakBlocks(par1World, par2, par3 + 4, par4 - 1, false);
		this.breakBlocks(par1World, par2, par3 + 4, par4 - 2, false);

		this.breakBlocks(par1World, par2, par3 + 5, par4 + 4, false);
		this.breakBlocks(par1World, par2, par3 + 5, par4 + 3, false);
		this.breakBlocks(par1World, par2, par3 + 5, par4 + 2, false);
		this.breakBlocks(par1World, par2, par3 + 5, par4 + 1, false);
		this.breakBlocks(par1World, par2, par3 + 5, par4, false);
		this.breakBlocks(par1World, par2, par3 + 5, par4 - 1, false);
		this.breakBlocks(par1World, par2, par3 + 5, par4 - 2, false);

		this.breakBlocks(par1World, par2 - 1, par3 + 4, par4 + 4, false);
		this.breakBlocks(par1World, par2 - 1, par3 + 4, par4 + 3, false);
		this.breakBlocks(par1World, par2 - 1, par3 + 4, par4 + 2, false);
		this.breakBlocks(par1World, par2 - 1, par3 + 4, par4 + 1, false);
		this.breakBlocks(par1World, par2 - 1, par3 + 4, par4, false);
		this.breakBlocks(par1World, par2 - 1, par3 + 4, par4 - 1, false);
		this.breakBlocks(par1World, par2 - 1, par3 + 4, par4 - 2, false);

		this.breakBlocks(par1World, par2 + 1, par3 + 4, par4 + 4, false);
		this.breakBlocks(par1World, par2 + 1, par3 + 4, par4 + 3, false);
		this.breakBlocks(par1World, par2 + 1, par3 + 4, par4 + 2, false);
		this.breakBlocks(par1World, par2 + 1, par3 + 4, par4 + 1, false);
		this.breakBlocks(par1World, par2 + 1, par3 + 4, par4, false);
		this.breakBlocks(par1World, par2 + 1, par3 + 4, par4 - 1, false);
		this.breakBlocks(par1World, par2 + 1, par3 + 4, par4 - 2, false);

		this.breakBlocks(par1World, par2 - 1, par3 + 1, par4 - 1, false);
	}

	private void breakBlocks(World par1World, int x, int y, int z, boolean item)
	{
		final Block block = par1World.getBlock(x, y, z);

		if (par1World.blockExists(x, y, z))
		{
			if (block == MercuryBlocks.caravanModuleDummy || block == GCBlocks.glowstoneTorch || block == Blocks.lit_furnace || block == Blocks.furnace || block == Blocks.chest || block == Blocks.crafting_table || block == Blocks.wooden_door || block == GCBlocks.tinStairs2)
			{
				par1World.func_147480_a(x, y, z, item);
			}
		}
	}

	private void breakBlocksOther(World par1World, int x, int y, int z, boolean item)
	{
		if (par1World.blockExists(x, y, z))
		{
			par1World.func_147480_a(x, y, z, item);
		}
	}

	@Override
	public int getMobilityFlag()
	{
		return 2;
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		this.breakBlocksOther(par1World, par2 - 1, par3 + 1, par4 + 3, false);
		this.breakBlocksOther(par1World, par2, par3 + 1, par4 + 3, false);
		this.breakBlocksOther(par1World, par2 + 1, par3 + 1, par4 + 3, false);

		this.breakBlocksOther(par1World, par2 - 1, par3 + 1, par4 + 2, false);
		this.breakBlocksOther(par1World, par2, par3 + 1, par4 + 2, false);
		this.breakBlocksOther(par1World, par2 + 1, par3 + 1, par4 + 2, false);

		this.breakBlocksOther(par1World, par2 - 1, par3 + 1, par4 + 1, false);
		this.breakBlocksOther(par1World, par2, par3 + 1, par4 + 1, false);
		this.breakBlocksOther(par1World, par2 + 1, par3 + 1, par4 + 1, false);

		this.breakBlocksOther(par1World, par2 - 1, par3 + 1, par4, false);
		this.breakBlocksOther(par1World, par2, par3 + 1, par4, false);
		this.breakBlocksOther(par1World, par2 + 1, par3 + 1, par4, false);

		this.breakBlocksOther(par1World, par2 - 1, par3 + 2, par4 + 3, false);
		this.breakBlocksOther(par1World, par2, par3 + 2, par4 + 3, false);
		this.breakBlocksOther(par1World, par2 + 1, par3 + 2, par4 + 3, false);

		this.breakBlocksOther(par1World, par2 - 1, par3 + 2, par4 + 2, false);
		this.breakBlocksOther(par1World, par2, par3 + 2, par4 + 2, false);
		this.breakBlocksOther(par1World, par2 + 1, par3 + 2, par4 + 2, false);

		this.breakBlocksOther(par1World, par2 - 1, par3 + 2, par4 + 1, false);
		this.breakBlocksOther(par1World, par2, par3 + 2, par4 + 1, false);
		this.breakBlocksOther(par1World, par2 + 1, par3 + 2, par4 + 1, false);

		this.breakBlocksOther(par1World, par2, par3 + 2, par4 + 4, false);
		this.breakBlocksOther(par1World, par2, par3 + 1, par4 + 4, false);

		this.breakBlocksOther(par1World, par2, par3 + 1, par4 + 5, false);
		this.breakBlocksOther(par1World, par2, par3 + 2, par4 + 5, false);

		this.breakBlocksOther(par1World, par2 - 1, par3 + 2, par4, false);
		this.breakBlocksOther(par1World, par2, par3 + 2, par4, false);
		this.breakBlocksOther(par1World, par2 + 1, par3 + 2, par4, false);

		this.breakBlocksOther(par1World, par2 - 1, par3 + 2, par4 - 1, false);
		this.breakBlocksOther(par1World, par2 + 1, par3 + 2, par4 + 1, false);

		this.breakBlocksOther(par1World, par2 - 1, par3 + 3, par4 + 3, false);
		this.breakBlocksOther(par1World, par2, par3 + 3, par4 + 3, false);
		this.breakBlocksOther(par1World, par2 + 1, par3 + 3, par4 + 3, false);

		this.breakBlocksOther(par1World, par2 - 1, par3 + 3, par4 + 2, false);
		this.breakBlocksOther(par1World, par2, par3 + 3, par4 + 2, false);
		this.breakBlocksOther(par1World, par2 + 1, par3 + 3, par4 + 2, false);

		this.breakBlocksOther(par1World, par2 - 1, par3 + 3, par4 + 1, false);
		this.breakBlocksOther(par1World, par2, par3 + 3, par4 + 1, false);
		this.breakBlocksOther(par1World, par2 + 1, par3 + 3, par4 + 1, false);

		this.breakBlocksOther(par1World, par2 - 1, par3 + 3, par4, false);
		this.breakBlocksOther(par1World, par2, par3 + 3, par4, false);
		this.breakBlocksOther(par1World, par2 + 1, par3 + 3, par4, false);

		this.breakBlocksOther(par1World, par2 - 1, par3 + 3, par4 - 1, false);
		this.breakBlocksOther(par1World, par2 + 1, par3 + 3, par4 + 1, false);
		this.breakBlocksOther(par1World, par2 + 1, par3 + 3, par4, false);

		this.breakBlocksOther(par1World, par2 + 1, par3 + 2, par4 - 1, false);
		this.breakBlocksOther(par1World, par2 + 1, par3 + 3, par4 - 1, false);

		this.breakBlocksOther(par1World, par2, par3 + 4, par4 + 3, false);
		this.breakBlocksOther(par1World, par2, par3 + 4, par4 + 2, false);
		this.breakBlocksOther(par1World, par2, par3 + 4, par4 + 1, false);
		this.breakBlocksOther(par1World, par2, par3 + 4, par4, false);
		this.breakBlocksOther(par1World, par2, par3 + 4, par4 - 1, false);

		this.breakBlocksOther(par1World, par2, par3 + 3, par4 - 1, false);

		this.setBlocks(par1World, par2, par3, par4 - 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 1, par3, par4 - 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 +1, par3, par4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 1, par3, par4 + 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2, par3, par4 + 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 1, par3, par4 + 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 1, par3, par4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 1, par3, par4 - 1, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 - 1, par3, par4 + 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2, par3, par4 + 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 1, par3, par4 + 2, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 - 1, par3, par4 + 3, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2, par3, par4 + 3, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 1, par3, par4 + 3, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 - 1, par3, par4 + 4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2, par3, par4 + 4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 1, par3, par4 + 4, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 + 2, par3, par4 + 4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3, par4 + 3, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3, par4 + 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3, par4 + 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3, par4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3, par4 - 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3, par4 - 2, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 + 1, par3, par4 - 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2, par3, par4 - 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 1, par3, par4 - 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3, par4 - 2, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 - 2, par3, par4 - 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3, par4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3, par4 + 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3, par4 + 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3, par4 + 3, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3, par4 + 4, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 - 1, par3 + 1, par4 + 4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 1, par3 + 1, par4 + 4, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 + 2, par3 + 1, par4 + 4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 1, par4 + 3, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 1, par4 + 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 1, par4 + 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 1, par4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 1, par4 - 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 1, par4 - 2, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 + 1, par3 + 1, par4 - 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2, par3 + 1, par4 - 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 1, par3 + 1, par4 - 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3 + 1, par4 - 2, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 - 2, par3 + 1, par4 - 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3 + 1, par4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3 + 1, par4 + 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3 + 1, par4 + 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3 + 1, par4 + 3, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3 + 1, par4 + 4, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 - 1, par3 + 1, par4 - 1, false, Blocks.crafting_table);
		this.setBlocks(par1World, par2 + 1, par3 + 1, par4 - 1, false, Blocks.chest, 3);
		this.setBlocks(par1World, par2, par3 + 1, par4 - 1, false, Blocks.furnace, 3);

		this.setBlocks(par1World, par2 - 1, par3 + 2, par4 + 4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 1, par3 + 2, par4 + 4, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2, par3, par4 + 5, true, GCBlocks.tinStairs2, 3);

		this.setBlocks(par1World, par2 + 2, par3 + 2, par4 + 4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 2, par4 + 3, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 2, par4 + 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 2, par4 + 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 2, par4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 2, par4 - 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 2, par4 - 2, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 - 2, par3 + 2, par4 + 2, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 + 1, par3 + 2, par4 - 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2, par3 + 2, par4 - 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 1, par3 + 2, par4 - 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3 + 2, par4 - 2, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 - 2, par3 + 2, par4 - 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3 + 2, par4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3 + 2, par4 + 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3 + 2, par4 + 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3 + 2, par4 + 3, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2, par3 + 2, par4 - 1, false, GCBlocks.glowstoneTorch, 3);

		this.setBlocks(par1World, par2 - 2, par3 + 2, par4 + 4, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 - 1, par3 + 3, par4 + 4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2, par3 + 3, par4 + 4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 1, par3 + 3, par4 + 4, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 + 2, par3 + 3, par4 + 4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 3, par4 + 3, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 3, par4 + 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 3, par4 + 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 3, par4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 3, par4 - 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 2, par3 + 3, par4 - 2, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 + 1, par3 + 3, par4 - 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2, par3 + 3, par4 - 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 1, par3 + 3, par4 - 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3 + 3, par4 - 2, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 - 2, par3 + 3, par4 - 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3 + 3, par4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3 + 3, par4 + 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3 + 3, par4 + 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3 + 3, par4 + 3, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 2, par3 + 3, par4 + 4, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2, par3 + 4, par4 + 4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2, par3 + 4, par4 - 2, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2, par3 + 5, par4 + 4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2, par3 + 5, par4 + 3, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2, par3 + 5, par4 + 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2, par3 + 5, par4 + 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2, par3 + 5, par4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2, par3 + 5, par4 - 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2, par3 + 5, par4 - 2, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 - 1, par3 + 4, par4 + 4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 1, par3 + 4, par4 + 3, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 1, par3 + 4, par4 + 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 1, par3 + 4, par4 + 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 1, par3 + 4, par4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 1, par3 + 4, par4 - 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 - 1, par3 + 4, par4 - 2, true, MercuryBlocks.caravanModuleDummy);

		this.setBlocks(par1World, par2 + 1, par3 + 4, par4 + 4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 1, par3 + 4, par4 + 3, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 1, par3 + 4, par4 + 2, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 1, par3 + 4, par4 + 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 1, par3 + 4, par4, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 1, par3 + 4, par4 - 1, true, MercuryBlocks.caravanModuleDummy);
		this.setBlocks(par1World, par2 + 1, par3 + 4, par4 - 2, true, MercuryBlocks.caravanModuleDummy);
		return true;
	}

	private void setBlocks(World par1World, int x, int y, int z, boolean item, Block blockid)
	{
		if (par1World.blockExists(x, y, z))
		{
			if (par1World.getBlock(x, y, z) != blockid)
			{
				par1World.func_147480_a(x, y, z, item);
			}
			par1World.setBlock(x, y, z, blockid);
		}
	}

	private void setBlocks(World par1World, int x, int y, int z, boolean item, Block blockid, int meta)
	{
		if (par1World.blockExists(x, y, z))
		{
			if (par1World.getBlock(x, y, z) != blockid)
			{
				par1World.func_147480_a(x, y, z, item);
			}
			par1World.setBlock(x, y, z, blockid, meta, 3);
		}
	}

	@Override
	public boolean isSealed(World world, int x, int y, int z, ForgeDirection direction)
	{
		return true;
	}
}