package mattparks.mods.venus.blocks;

import mattparks.mods.venus.GCVenus;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusCrystalBlock extends Block
{
    public GCVenusCrystalBlock(int par1, String name)
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

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
}
