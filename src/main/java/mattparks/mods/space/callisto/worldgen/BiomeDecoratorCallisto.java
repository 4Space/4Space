package mattparks.mods.space.callisto.worldgen;

import mattparks.mods.space.callisto.worldgen.feature.WorldGenRockSpike;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

public class BiomeDecoratorCallisto extends BiomeDecoratorSpace
{
	/*protected WorldGenerator dirtGen;
	protected WorldGenerator gemGen;
	protected WorldGenerator tinGen;
	protected WorldGenerator meteorGen;
	protected WorldGenerator coalGen;
	protected WorldGenerator ironGen;*/

	protected WorldGenerator rockSpikeGen;

	public int rockSpikePerChunk;

	public BiomeDecoratorCallisto()
	{
		/*this.dirtGen = new WorldGenMinableMeta(ErisBlocks.erisBasicBlock, 32, 1, true, ErisBlocks.erisBasicBlock, 2);
		this.gemGen = new WorldGenMinableMeta(ErisBlocks.erisBasicBlock, 6, 4, true, ErisBlocks.erisBasicBlock, 2);
		this.tinGen = new WorldGenMinableMeta(ErisBlocks.erisBasicBlock, 6, 6, true, ErisBlocks.erisBasicBlock, 2);
		this.meteorGen = new WorldGenMinableMeta(ErisBlocks.erisBasicBlock, 4, 5, true, ErisBlocks.erisBasicBlock, 2);
		this.coalGen = new WorldGenMinableMeta(ErisBlocks.erisBasicBlock, 4, 7, true, ErisBlocks.erisBasicBlock, 2);
		this.ironGen = new WorldGenMinableMeta(ErisBlocks.erisBasicBlock, 8, 8, true, ErisBlocks.erisBasicBlock, 2);*/

		this.rockSpikeGen = new WorldGenRockSpike();

		this.rockSpikePerChunk = 4;
	}

	@Override
	public void decorate()
	{
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));

		int var2;
		int var3;
		int var4;
		int var5;
		
		for (var2 = 0; var2 < this.rockSpikePerChunk; ++var2)
		{
			var3 = this.chunkX + this.rand.nextInt(16) + 8;
			var4 = this.rand.nextInt(256);
			var5 = this.chunkZ + this.rand.nextInt(16) + 8;
			this.rockSpikeGen.generate(this.currentWorld, this.rand, var3, var4, var5);
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
		/*this.generateOre(32, this.dirtGen, 0, 256);
		this.generateOre(12, this.gemGen, 0, 32);
		this.generateOre(12, this.tinGen, 0, 60);
		this.generateOre(8, this.meteorGen, 0, 128);
		this.generateOre(16, this.coalGen, 0, 128);
		this.generateOre(16, this.ironGen, 0, 64);*/
	}
}