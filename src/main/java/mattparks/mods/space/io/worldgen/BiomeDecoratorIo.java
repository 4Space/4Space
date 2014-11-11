package mattparks.mods.space.io.worldgen;

import mattparks.mods.space.io.blocks.IoBlocks;
import mattparks.mods.space.io.worldgen.feature.WorldGenIoLava;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

public class BiomeDecoratorIo extends BiomeDecoratorSpace
{
	public int redLiquidSulfurLakesPerChunk;
	public int yellowLiquidSulfurLakesPerChunk;
	public int orangeLiquidSulfurLakesPerChunk;
	public int ioLavaLakesPerChunk;
	protected WorldGenerator sulfurGen;

	public BiomeDecoratorIo()
	{
		this.sulfurGen = new WorldGenMinableMeta(IoBlocks.ioBasicBlock, 8, 4, true, IoBlocks.ioBasicBlock, 2);

		this.redLiquidSulfurLakesPerChunk = 6;
		this.yellowLiquidSulfurLakesPerChunk = 6;
		this.orangeLiquidSulfurLakesPerChunk = 6;
		this.ioLavaLakesPerChunk = 12;
	}

	@Override
	public void decorate()
	{
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.rand, this.chunkX, this.chunkZ));

		this.generateOre(32, this.sulfurGen, 0, 256);

		int var2;
		int var3;
		int var4;
		int var5;

		for (var2 = 0; var2 < this.redLiquidSulfurLakesPerChunk; ++var2)
		{
			var3 = this.chunkX + this.rand.nextInt(16) + 8;
			var4 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(112) + 8) + 8);
			var5 = this.chunkZ + this.rand.nextInt(16) + 8;
			new WorldGenIoLava(IoBlocks.liquidRedSulfurFlowing, IoBlocks.ioBasicBlock, 3).generate(this.currentWorld, this.rand, var3, var4, var5);
		}
		for (var2 = 0; var2 < this.yellowLiquidSulfurLakesPerChunk; ++var2)
		{
			var3 = this.chunkX + this.rand.nextInt(16) + 8;
			var4 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(112) + 8) + 8);
			var5 = this.chunkZ + this.rand.nextInt(16) + 8;
			new WorldGenIoLava(IoBlocks.liquidYellowSulfurStill, IoBlocks.ioBasicBlock, 3).generate(this.currentWorld, this.rand, var3, var4, var5);
		}
		for (var2 = 0; var2 < this.orangeLiquidSulfurLakesPerChunk; ++var2)
		{
			var3 = this.chunkX + this.rand.nextInt(16) + 8;
			var4 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(112) + 8) + 8);
			var5 = this.chunkZ + this.rand.nextInt(16) + 8;
			new WorldGenIoLava(IoBlocks.liquidOrangeSulfurFlowing, IoBlocks.ioBasicBlock, 3).generate(this.currentWorld, this.rand, var3, var4, var5);
		}
		for (var2 = 0; var2 < this.ioLavaLakesPerChunk; ++var2)
		{
			var3 = this.chunkX + this.rand.nextInt(16) + 8;
			var4 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(112) + 8) + 8);
			var5 = this.chunkZ + this.rand.nextInt(16) + 8;
			new WorldGenIoLava(IoBlocks.ioLavaFlowing, IoBlocks.ioBasicBlock, 3).generate(this.currentWorld, this.rand, var3, var4, var5);
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.rand, this.chunkX, this.chunkZ));
	}
}