package mattparks.mods.mercury.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GCMercuryBlock extends Block
{
    public GCMercuryBlock(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
        this.setHardness(2.0F);
    }
}
