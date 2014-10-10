package mattparks.mods.space.io.world.gen;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.event.wgen.GCCoreEventPopulate;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;

public class GCIoBiomeDecorator
{
	protected World currentWorld;
	protected Random rand;

	protected int chunkX;
	protected int chunkZ;

//   protected WorldGenerator waterGen;

	public GCIoBiomeDecorator()
	{
//        this.waterGen = new GCCoreWorldGenMinableMeta(Block.waterMoving.blockID, 250, 6, false, EuropaBlocks.EuropaIce.blockID, 9); 
	}

	public void decorate(World world, Random random, int chunkX, int chunkZ)
	{
		if (this.currentWorld != null)
		{
			throw new RuntimeException("Already decorating!!");
		}
		else
		{
			this.currentWorld = world;
			this.rand = random;
			this.chunkX = chunkX;
			this.chunkZ = chunkZ;
			this.generateIo();
			this.currentWorld = null;
			this.rand = null;
		}
	}

	protected void generateIo()
	{
		MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
 //       this.generateOre(20, this.waterGen, 0, 100);
		MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
	}

	protected void generateOre(int amountPerChunk, WorldGenerator worldGenerator, int minY, int maxY)
	{
		for (int var5 = 0; var5 < amountPerChunk; ++var5)
		{
			final int var6 = this.chunkX + this.rand.nextInt(16);
			final int var7 = this.rand.nextInt(maxY - minY) + minY;
			final int var8 = this.chunkZ + this.rand.nextInt(16);
			worldGenerator.generate(this.currentWorld, this.rand, var6, var7, var8);
		}
	}
}
