package mattparks.mods.venus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;

public class GCVenusBrick extends Block
{
    public GCVenusBrick(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
        this.setHardness(2.0F);
    }
    
	@Override
	public boolean canHarvestBlock(EntityPlayer player, int meta)
	{
		return false;
	}
}
