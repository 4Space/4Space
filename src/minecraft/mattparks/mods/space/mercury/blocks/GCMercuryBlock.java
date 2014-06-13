package mattparks.mods.space.mercury.blocks;

import mattparks.mods.space.mercury.GCMercury;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCMercuryBlock extends Block
{
    public GCMercuryBlock(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
        this.setStepSound(new StepSound("stone", 0.0F, 1.0F));
    }

	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return GCMercury.galacticraftMercuryTab;
	}
}
