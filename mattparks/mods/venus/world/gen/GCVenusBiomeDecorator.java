package mattparks.mods.venus.world.gen;

import java.util.Random;

import mattparks.mods.venus.GCVenus;
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
    protected WorldGenerator sulferGen;
    protected WorldGenerator meteorGen;
    protected WorldGenerator ironGen;
    protected WorldGenerator coalGen;
    protected WorldGenerator tinGen;
    protected WorldGenerator copperGen;
    protected WorldGenerator crystalGen;
    protected WorldGenerator fossilizedPlantGen;

	public GCVenusBiomeDecorator()
	{
        this.gemGen = new GCCoreWorldGenMinableMeta(GCVenus.VenusRedGemOre.blockID, 3, 0, false, GCVenus.VenusStone.blockID, 9);
        this.sulferGen = new GCCoreWorldGenMinableMeta(GCVenus.VenusSulferOre.blockID, 16, 2, false, GCVenus.VenusStone.blockID, 9);
        this.meteorGen = new GCCoreWorldGenMinableMeta(GCVenus.VenusMeteorOre.blockID, 2, 2, false, GCVenus.VenusStone.blockID, 9);
        this.dirtGen = new GCCoreWorldGenMinableMeta(GCVenus.VenusDirt.blockID, 25, 6, false, GCVenus.VenusStone.blockID, 9); 
        this.ironGen = new GCCoreWorldGenMinableMeta(GCVenus.VenusIronOre.blockID, 8, 3, false, GCVenus.VenusStone.blockID, 9);  
        this.coalGen = new GCCoreWorldGenMinableMeta(GCVenus.VenusCoalOre.blockID, 12, 5, false, GCVenus.VenusStone.blockID, 9);     
        this.tinGen = new GCCoreWorldGenMinableMeta(GCVenus.VenusTinOre.blockID, 4, 1, false, GCVenus.VenusStone.blockID, 9);  
        this.copperGen = new GCCoreWorldGenMinableMeta(GCVenus.VenusCopperOre.blockID, 5, 7, false, GCVenus.VenusStone.blockID, 9);      
        this.crystalGen = new GCCoreWorldGenMinableMeta(GCVenus.VenusCrystalOre.blockID, 1, 3, false, GCVenus.VenusStone.blockID, 9);
        this.fossilizedPlantGen = new GCCoreWorldGenMinableMeta(GCVenus.FossilizedPlantOre.blockID, 1, 2, false, GCVenus.VenusCoalOre.blockID, 9);
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

	protected void generateMars()
	{
		MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
        this.generateOre(20, this.dirtGen, 0, 225);
        this.generateOre(26, this.gemGen, 0, 8);
        this.generateOre(23, this.sulferGen, 0, 120);
        this.generateOre(12, this.meteorGen, 0, 20);
        this.generateOre(35, this.ironGen, 0, 64);
        this.generateOre(36, this.coalGen, 0, 75);
        this.generateOre(35, this.tinGen, 0, 60);
        this.generateOre(36, this.copperGen, 0, 60);
        this.generateOre(36, this.crystalGen, 0, 12);
        this.generateOre(36, this.fossilizedPlantGen, 0, 1000);
		MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
	}
}
