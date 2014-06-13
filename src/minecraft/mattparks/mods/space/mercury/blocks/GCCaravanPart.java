package mattparks.mods.space.mercury.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;

public class GCCaravanPart extends Block
{
    public GCCaravanPart(int par1, String name)
    {
        super(par1, Material.cloth);
        this.setUnlocalizedName(name);
        this.setStepSound(new StepSound("cloth", 0.0F, 1.0F));
    }
    
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }
}
