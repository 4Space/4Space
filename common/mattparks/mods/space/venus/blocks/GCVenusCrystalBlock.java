package mattparks.mods.space.venus.blocks;

import mattparks.mods.space.venus.GCVenus;
import micdoodle8.mods.galacticraft.api.block.IPartialSealableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusCrystalBlock extends Block implements IPartialSealableBlock
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

    @Override
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }
    
    @Override
	public boolean isSealed(World world, int x, int y, int z, ForgeDirection direction) 
	{
		return true;
	}
    
	@Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }
}
