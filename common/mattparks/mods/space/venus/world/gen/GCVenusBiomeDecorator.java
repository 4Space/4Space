package mattparks.mods.space.venus.world.gen;

import java.util.Random;

import mattparks.mods.space.venus.blocks.VenusBlocks;
import micdoodle8.mods.galacticraft.api.event.wgen.GCCoreEventPopulate;
import micdoodle8.mods.galacticraft.core.world.gen.GCCoreWorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;

public class GCVenusBiomeDecorator
{
	protected World currentWorld;
	protected Random rand;

	protected int chunkX;
	protected int chunkZ;

    protected WorldGenerator dirtGen;
    protected WorldGenerator gemGen;
    protected WorldGenerator sulfurGen;
    protected WorldGenerator ironGen;
    protected WorldGenerator coalGen;
    protected WorldGenerator tinGen;
    protected WorldGenerator copperGen;
    protected WorldGenerator crystalGen; 
    protected WorldGenerator uraniumGen;
    protected WorldGenerator fossilizedPlantGen;

	public GCVenusBiomeDecorator()
	{
        this.dirtGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusDirt.blockID, 32, 7, false, VenusBlocks.VenusStone.blockID, 0); 
        this.sulfurGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusSulfurOre.blockID, 7, 5, false, VenusBlocks.VenusStone.blockID, 0);
        this.coalGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusCoalOre.blockID, 6, 4, false, VenusBlocks.VenusStone.blockID, 0);     
        this.ironGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusIronOre.blockID, 5, 4, false, VenusBlocks.VenusStone.blockID, 0);
        this.tinGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusTinOre.blockID, 4, 3, false, VenusBlocks.VenusStone.blockID, 0);  
        this.copperGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusCopperOre.blockID, 4, 3, false, VenusBlocks.VenusStone.blockID, 0);
        this.crystalGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusCrystalOre.blockID, 1, 1, false, VenusBlocks.VenusStone.blockID, 0);
        this.gemGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusRedGemOre.blockID, 7, 1, false, VenusBlocks.VenusStone.blockID, 0);
        this.uraniumGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusUraniumOre.blockID, 3, 2, false, VenusBlocks.VenusStone.blockID, 0);       
        this.fossilizedPlantGen = new GCCoreWorldGenMinableMeta(VenusBlocks.FossilizedPlantOre.blockID, 1, 1, false, VenusBlocks.VenusStone.blockID, 0);
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
			this.generateMars();
			this.currentWorld = null;
			this.rand = null;
		}
	}

	protected void generateMars()
	{
		MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));		
        this.generateOre(35, this.ironGen, 0, 200);
        this.generateOre(35, this.tinGen, 0, 200);
        this.generateOre(36, this.copperGen, 0, 200);       
        this.generateOre(36, this.uraniumGen, 0, 175);
		this.generateOre(20, this.dirtGen, 0, 150);
        this.generateOre(23, this.sulfurGen, 0, 100);       
        this.generateOre(36, this.coalGen, 0, 70);       
        this.generateOre(36, this.crystalGen, 0, 45);       
        this.generateOre(26, this.gemGen, 0, 24);       
        this.generateOre(36, this.fossilizedPlantGen, 0, 16);       
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
