package mattparks.mods.space.europa.blocks;

import mattparks.mods.space.jupiter.GCJupiter;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCEuropaBlock extends Block
{
    public GCEuropaBlock(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
        this.setStepSound(new StepSound("rock", 0.0F, 1.0F));
    }

	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return GCJupiter.galacticraftJupiterTab;
	}
}
