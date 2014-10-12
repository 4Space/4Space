package mattparks.mods.space.venus.blocks;

import mattparks.mods.space.venus.GCVenus;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusSpaceStone extends Block
{
    public GCVenusSpaceStone(int par1, String name)
    {
        super(par1, Material.glass);
        this.setUnlocalizedName(name);
        this.setStepSound(new StepSound("glass", 0.0F, 1.0F));
    }

	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return GCVenus.galacticraftVenusTab;
	}
}
