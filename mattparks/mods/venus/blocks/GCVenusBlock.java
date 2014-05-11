package mattparks.mods.venus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GCVenusBlock extends Block
{
    public GCVenusBlock(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
        this.setHardness(2.0F);
    }
}
