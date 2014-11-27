package mattparks.mods.space.europa.world.gen;

import mattparks.mods.space.europa.blocks.EuropaBlocks;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import net.minecraft.world.World;

public class BiomeDecoratorEuropa extends BiomeDecoratorSpace
{
/*	public int europaWaterLakesPerChunk;*/
	private World currentWorld;

	public BiomeDecoratorEuropa()
	{
/*		this.europaWaterLakesPerChunk = 6;*/
	}

	@Override
	public void decorate()
	{
/*		int var2;
		int var3;
		int var4;
		int var5;
		
		for (var2 = 0; var2 < this.europaWaterLakesPerChunk; ++var2)
		{
			var3 = this.chunkX + this.rand.nextInt(16) + 8;
			var4 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(112) + 8) + 8);
			var5 = this.chunkZ + this.rand.nextInt(16) + 8;
			new WorldGenEuropaWater(EuropaBlocks.europaWaterFluidBlock, EuropaBlocks.europaBasicBlock, 1).generate(this.currentWorld, this.rand, var3, var4, var5);
		}*/
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