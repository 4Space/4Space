package mattparks.mods.space.venus.blocks;

import mattparks.mods.space.venus.GCVenus;
import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusOre extends Block implements IDetectableResource
{
    public GCVenusOre(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
        this.setStepSound(new StepSound("stone", 0.0F, 1.0F));
    }

	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return GCVenus.galacticraftVenusTab;
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
    
//    @Override
//    public int idDropped(int par1, Random par2Random, int par3)
//    {
//    	if(VenusBlocks.VenusUraniumOre.blockID == this.blockID)
//   	{
//    		if(Compatibility.isIndustrialCraft2Loaded())
//    		{
//    			return Items.getItem("UranFuel").itemID;
//    		}
//    		
//    		return this.blockID;
//    	}
//		return par3;
//    }
}
