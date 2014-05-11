package mattparks.mods.venus.blocks;

import java.util.Random;

import mattparks.mods.venus.GCVenus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GCVenusStone extends Block
{
    public GCVenusStone(int par1, String name)
    {
        super(par1, Material.rock);
        this.setUnlocalizedName(name);
        this.setHardness(2.0F);
    }

    @Override
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return GCVenus.VenusCobblestone.blockID;
    }
}
