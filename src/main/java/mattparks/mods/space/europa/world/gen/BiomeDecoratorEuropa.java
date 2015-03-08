package mattparks.mods.space.europa.world.gen;

import mattparks.mods.space.europa.blocks.EuropaBlocks;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorEuropa extends BiomeDecoratorSpace {
	public int europaWaterLakesPerChunk;

	protected WorldGenerator dirtyIce;
	protected WorldGenerator denceIce;
	private World currentWorld;

	public BiomeDecoratorEuropa() {
		this.dirtyIce = new WorldGenMinableMeta(EuropaBlocks.europaIce, 8, 1, true, EuropaBlocks.europaIce, 2);
		this.denceIce = new WorldGenMinableMeta(EuropaBlocks.europaIce, 8, 2, true, EuropaBlocks.europaIce, 2);

		this.europaWaterLakesPerChunk = 6;
	}

	@Override
	public void decorate() {
		this.generateOre(32, this.dirtyIce, 0, 256);
		this.generateOre(32, this.denceIce, 0, 256);

		int var2;
		int var3;
		int var4;
		int var5;

		for (var2 = 0; var2 < this.europaWaterLakesPerChunk; ++var2) {
			var3 = this.chunkX + this.rand.nextInt(16) + 8;
			var4 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(112) + 8) + 8);
			var5 = this.chunkZ + this.rand.nextInt(16) + 8;
			new WorldGenEuropaWater(EuropaBlocks.europaWaterFluidBlock, EuropaBlocks.europaIce, 1).generate(this.currentWorld, this.rand, var3, var4, var5);
		}
	}

	protected void setCurrentWorld(World world) {
		this.currentWorld = world;
	}

	protected World getCurrentWorld() {
		return this.currentWorld;
	}
}
