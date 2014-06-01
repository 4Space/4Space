package mattparks.mods.venus.world.gen;

import java.util.Random;

import mattparks.mods.venus.GCVenus;
import mattparks.mods.venus.blocks.VenusBlocks;
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
    protected WorldGenerator meteorGen;
    protected WorldGenerator ironGen;
    protected WorldGenerator coalGen;
    protected WorldGenerator tinGen;
    protected WorldGenerator copperGen;
    protected WorldGenerator crystalGen;
    protected WorldGenerator goldGen;
    protected WorldGenerator fossilizedPlantGen;

	public GCVenusBiomeDecorator()
	{
        this.dirtGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusDirt.blockID, 25, 6, false, VenusBlocks.VenusStone.blockID, 9); 
        this.sulfurGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusSulfurOre.blockID, 12, 7, false, VenusBlocks.VenusStone.blockID, 9);
        this.coalGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusCoalOre.blockID, 10, 7, false, VenusBlocks.VenusStone.blockID, 9);     
        this.ironGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusIronOre.blockID, 7, 3, false, VenusBlocks.VenusStone.blockID, 9);  
        this.tinGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusTinOre.blockID, 4, 1, false, VenusBlocks.VenusStone.blockID, 9);  
        this.copperGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusCopperOre.blockID, 5, 3, false, VenusBlocks.VenusStone.blockID, 9);      
        this.crystalGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusCrystalOre.blockID, 3, 1, false, VenusBlocks.VenusStone.blockID, 9);
        this.meteorGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusMeteorOre.blockID, 4, 3, false, VenusBlocks.VenusStone.blockID, 9);
        this.goldGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusGoldOre.blockID, 7, 4, false, VenusBlocks.VenusStone.blockID, 9);
        this.gemGen = new GCCoreWorldGenMinableMeta(VenusBlocks.VenusRedGemOre.blockID, 8, 5, false, VenusBlocks.VenusStone.blockID, 9);
        this.fossilizedPlantGen = new GCCoreWorldGenMinableMeta(VenusBlocks.FossilizedPlantOre.blockID, 2, 1, false, VenusBlocks.VenusStone.blockID, 9);
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
			this.generateVenus();
			this.currentWorld = null;
			this.rand = null;
		}
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

	protected void generateVenus()
	{
		MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
        this.generateOre(20, this.dirtGen, 0, 150);
        this.generateOre(23, this.sulfurGen, 0, 100);
        this.generateOre(36, this.coalGen, 0, 70);
        this.generateOre(35, this.ironGen, 0, 60);
        this.generateOre(35, this.tinGen, 0, 60);
        this.generateOre(36, this.copperGen, 0, 60);
        this.generateOre(36, this.crystalGen, 0, 60);
        this.generateOre(12, this.meteorGen, 0, 40);
        this.generateOre(36, this.goldGen, 0, 30);
        this.generateOre(26, this.gemGen, 0, 20);
        this.generateOre(36, this.fossilizedPlantGen, 0, 15);
		MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
	}
}
