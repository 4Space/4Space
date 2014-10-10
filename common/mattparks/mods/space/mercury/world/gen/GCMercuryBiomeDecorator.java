package mattparks.mods.space.mercury.world.gen;

import java.util.Random;

import mattparks.mods.space.mercury.blocks.MercuryBlocks;
import micdoodle8.mods.galacticraft.api.event.wgen.GCCoreEventPopulate;
import micdoodle8.mods.galacticraft.core.world.gen.GCCoreWorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;

public class GCMercuryBiomeDecorator
{
	protected World worldObj;
	protected Random randomGenerator;

	protected int chunkX;
	protected int chunkZ;

	protected WorldGenerator dirtGen;
	protected WorldGenerator copperGen;
	protected WorldGenerator tinGen;
	protected WorldGenerator meteorGen;
	protected WorldGenerator goldGen;
	protected WorldGenerator iridiumGen;

	public GCMercuryBiomeDecorator(BiomeGenBase par1BiomeGenBase)
	{
		this.dirtGen = new GCCoreWorldGenMinableMeta(MercuryBlocks.MercuryDirt.blockID, 32, 9, true, MercuryBlocks.MercuryStone.blockID, 0);
		this.copperGen = new GCCoreWorldGenMinableMeta(MercuryBlocks.MercuryCopperOre.blockID, 4, 3, true, MercuryBlocks.MercuryStone.blockID, 0);
		this.tinGen = new GCCoreWorldGenMinableMeta(MercuryBlocks.MercuryTinOre.blockID, 4, 3, true, MercuryBlocks.MercuryStone.blockID, 0);
        this.meteorGen = new GCCoreWorldGenMinableMeta(MercuryBlocks.MercuryMeteorOre.blockID, 1, 1, false, MercuryBlocks.MercuryStone.blockID, 0);
		this.goldGen = new GCCoreWorldGenMinableMeta(MercuryBlocks.MercuryGoldOre.blockID, 4, 2, true, MercuryBlocks.MercuryStone.blockID, 0);
		this.iridiumGen = new GCCoreWorldGenMinableMeta(MercuryBlocks.MercuryIridiumOre.blockID, 7, 3, true, MercuryBlocks.MercuryStone.blockID, 0);
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
			this.generateMercury();
			this.worldObj = null;
			this.randomGenerator = null;
		}
	}

	protected void generateMercury()
	{
		MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Pre(this.worldObj, this.randomGenerator, this.chunkX, this.chunkZ));
		this.genStandardOre1(20, this.dirtGen, 0, 200);
		this.genStandardOre1(26, this.copperGen, 0, 60);
		this.genStandardOre1(23, this.tinGen, 0, 60);
		this.genStandardOre1(15, this.meteorGen, 0, 128);
		this.genStandardOre1(20, this.goldGen, 0, 29);
		this.genStandardOre1(20, this.iridiumGen, 0, 12);
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
