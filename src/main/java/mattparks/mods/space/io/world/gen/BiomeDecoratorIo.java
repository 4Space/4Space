package mattparks.mods.space.io.world.gen;

import mattparks.mods.space.io.blocks.IoBlocks;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorIo extends BiomeDecoratorSpace {
	protected WorldGenerator sulfurGen;

	/*
	 * public int redLiquidSulfurLakesPerChunk; public int yellowLiquidSulfurLakesPerChunk; public int orangeLiquidSulfurLakesPerChunk; public int ioLavaLakesPerChunk;
	 */

	private World currentWorld;

	public BiomeDecoratorIo() {
		this.sulfurGen = new WorldGenMinableMeta(IoBlocks.ioBasicBlock, 16, 8, true, IoBlocks.ioBasicBlock, 2);

		/*
		 * this.redLiquidSulfurLakesPerChunk = 1; this.yellowLiquidSulfurLakesPerChunk = 1; this.orangeLiquidSulfurLakesPerChunk = 1; this.ioLavaLakesPerChunk = 3;
		 */
	}

	@Override
	public void decorate() {
		this.generateOre(32, this.sulfurGen, 0, 256);

		/*
		 * int var2; int var3; int var4; int var5;
		 * 
		 * for (var2 = 0; var2 < this.redLiquidSulfurLakesPerChunk; ++var2) { var3 = this.chunkX + this.rand.nextInt(16) + 8; var4 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(112) + 8) + 8); var5 = this.chunkZ + this.rand.nextInt(16) + 8; new WorldGenIoLava(IoBlocks.liquidRedSulfurFlowing, IoBlocks.ioBasicBlock, 3).generate(this.currentWorld, this.rand, var3, var4, var5); }
		 * 
		 * for (var2 = 0; var2 < this.yellowLiquidSulfurLakesPerChunk; ++var2) { var3 = this.chunkX + this.rand.nextInt(16) + 8; var4 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(112) + 8) + 8); var5 = this.chunkZ + this.rand.nextInt(16) + 8; new WorldGenIoLava(IoBlocks.liquidYellowSulfurStill, IoBlocks.ioBasicBlock, 3).generate(this.currentWorld, this.rand, var3, var4, var5); }
		 * 
		 * for (var2 = 0; var2 < this.orangeLiquidSulfurLakesPerChunk; ++var2) { var3 = this.chunkX + this.rand.nextInt(16) + 8; var4 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(112) + 8) + 8); var5 = this.chunkZ + this.rand.nextInt(16) + 8; new WorldGenIoLava(IoBlocks.liquidOrangeSulfurFlowing, IoBlocks.ioBasicBlock, 3).generate(this.currentWorld, this.rand, var3, var4, var5); }
		 * 
		 * for (var2 = 0; var2 < this.ioLavaLakesPerChunk; ++var2) { var3 = this.chunkX + this.rand.nextInt(16) + 8; var4 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(112) + 8) + 8); var5 = this.chunkZ + this.rand.nextInt(16) + 8; new WorldGenIoLava(IoBlocks.ioLavaFlowing, IoBlocks.ioBasicBlock, 3).generate(this.currentWorld, this.rand, var3, var4, var5); }
		 */
	}

	protected void setCurrentWorld(World world) {
		this.currentWorld = world;
	}

	protected World getCurrentWorld() {
		return this.currentWorld;
	}
}
