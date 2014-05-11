package mattparks.mods.venus.blocks;

import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GCVenusOre extends Block implements IDetectableResource
{
    public GCVenusOre(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
        this.setHardness(2.0F);
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
