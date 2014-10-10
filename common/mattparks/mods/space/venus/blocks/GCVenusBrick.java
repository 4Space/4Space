package mattparks.mods.space.venus.blocks;

import mattparks.mods.space.venus.GCVenus;
import micdoodle8.mods.galacticraft.api.block.IPartialSealableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusBrick extends Block implements IPartialSealableBlock
{
    public GCVenusBrick(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
        this.setStepSound(new StepSound("stone", 0.0F, 1.0F));
    }

	@Override
	public boolean canHarvestBlock(EntityPlayer player, int meta)
	{
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return GCVenus.galacticraftVenusTab;
	}
	
	@Override
	public boolean isSealed(World world, int x, int y, int z, ForgeDirection direction) 
	{
		return true;
	}
}
