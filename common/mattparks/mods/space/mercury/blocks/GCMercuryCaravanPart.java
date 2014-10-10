package mattparks.mods.space.mercury.blocks;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.block.IPartialSealableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class GCMercuryCaravanPart extends Block implements IPartialSealableBlock
{
    public GCMercuryCaravanPart(int par1, String name)
    {
        super(par1, Material.cloth);
        this.setUnlocalizedName(name);
        this.setStepSound(new StepSound("cloth", 0.0F, 1.0F));
    }
    
    @Override
	public boolean isSealed(World world, int x, int y, int z, ForgeDirection direction) 
	{
		return true;
	}
    
	@Override
	public int quantityDropped(Random par1Random)
    {
        return 0;
    }
}
