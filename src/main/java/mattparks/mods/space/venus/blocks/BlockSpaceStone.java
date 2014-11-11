package mattparks.mods.space.venus.blocks;

import mattparks.mods.space.core.SpaceCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSpaceStone extends Block
{
	public BlockSpaceStone(String name)
	{
		super(Material.rock);
		this.setBlockName(name);
		this.setHardness(0.1F);
		this.setStepSound(soundTypeGlass);
		this.setLightLevel(1.0F);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("galacticraftvenus:spaceStone");
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return SpaceCore.spaceBlocksTab;
	}
}