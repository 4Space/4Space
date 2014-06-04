package mattparks.mods.venus.blocks;

import mattparks.mods.venus.GCVenus;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusUraniumPower extends Block
{
    public GCVenusUraniumPower(int par1, String name)
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
		return GCVenus.galacticraftVenusTab;
	}
	

	public float getMaxElectricityStored(ItemStack itemStack)
	{
		return 5000;
	}

	public float getVoltage(ItemStack itemStack)
	{
		return 120;
	}
}
