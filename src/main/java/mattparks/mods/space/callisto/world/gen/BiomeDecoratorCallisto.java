package mattparks.mods.space.callisto.world.gen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import net.minecraft.world.World;

public class BiomeDecoratorCallisto extends BiomeDecoratorSpace {
	// protected WorldGenerator dirtyIce;
	// protected WorldGenerator denceIce;
	private World currentWorld;

	public BiomeDecoratorCallisto() {
		// this.dirtyIce = new WorldGenMinableMeta(EuropaBlocks.europaIce, 8, 1,
		// true, EuropaBlocks.europaIce, 2);
		// this.denceIce = new WorldGenMinableMeta(EuropaBlocks.europaIce, 8, 2,
		// true, EuropaBlocks.europaIce, 2);
	}

	@Override
	public void decorate() {
		// this.generateOre(32, this.dirtyIce, 0, 256);
		// this.generateOre(32, this.denceIce, 0, 256);
	}

	protected void setCurrentWorld(World world) {
		this.currentWorld = world;
	}

	protected World getCurrentWorld() {
		return this.currentWorld;
	}
}
