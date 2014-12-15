package mattparks.mods.space.hole.world.gen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import net.minecraft.world.World;

public class BiomeDecoratorHole extends BiomeDecoratorSpace
{
    private World currentWorld;

	public BiomeDecoratorHole()
	{
	}

	@Override
	public void decorate()
	{       
	}
    
    protected void setCurrentWorld(World world)
    {
    	this.currentWorld = world;
    }

	protected World getCurrentWorld()
	{
		return this.currentWorld;
	}
}