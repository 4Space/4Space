package mattparks.mods.mercury.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mattparks.mods.mercury.GCMercury;
import mattparks.mods.venus.GCVenus;
import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class GCMercuryOre extends Block implements IDetectableResource
{
    public GCMercuryOre(int par1, String name)
    {
        super(par1, Material.rock);
        this.setResistance(0.0F);
        this.setHardness(2.0F);
        this.setUnlocalizedName(name);
        this.setStepSound(new StepSound("stone", 0.0F, 1.0F));
    }

	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return GCMercury.galacticraftMercuryTab;
	}

    @Override
    public boolean isValueable(int metadata)
    {
        switch (metadata)
        {
        default:
            return true;
        }
    }
}
