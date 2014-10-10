package mattparks.mods.space.europa.world.gen;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.event.wgen.GCCoreEventPopulate;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;

public class GCEuropaBiomeDecorator
{
	protected World worldObj;
	protected Random randomGenerator;

	protected int chunkX;
	protected int chunkZ;

//	protected WorldGenerator dirtGen;

	public GCEuropaBiomeDecorator(BiomeGenBase par1BiomeGenBase)
	{
//		this.dirtGen = new GCCoreWorldGenMinableMeta(GCCoreBlocks.blockMoon.blockID, 32, 3, true, GCCoreBlocks.blockMoon.blockID, 4);
	}

	public void decorate(World worldObj, Random rand, int chunkX, int chunkZ)
	{
		if (this.worldObj != null)
		{
			throw new RuntimeException("Already decorating!!");
		}
		else
		{
			this.worldObj = worldObj;
			this.randomGenerator = rand;
			this.chunkX = chunkX;
			this.chunkZ = chunkZ;
			this.generateEuropa();
			this.worldObj = null;
			this.randomGenerator = null;
		}
	}

	protected void generateEuropa()
	{
		MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Pre(this.worldObj, this.randomGenerator, this.chunkX, this.chunkZ));
//		this.genStandardOre1(20, this.dirtGen, 0, 200);
		MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Post(this.worldObj, this.randomGenerator, this.chunkX, this.chunkZ));
	}

	protected void genStandardOre1(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY)
	{
		for (int var5 = 0; var5 < amountPerChunk; ++var5)
		{
			final int var6 = this.chunkX + this.randomGenerator.nextInt(16);
			final int var7 = this.randomGenerator.nextInt(maxY - minY) + minY;
			final int var8 = this.chunkZ + this.randomGenerator.nextInt(16);
			worldGenerator.generate(this.worldObj, this.randomGenerator, var6, var7, var8);
		}
	}
}
