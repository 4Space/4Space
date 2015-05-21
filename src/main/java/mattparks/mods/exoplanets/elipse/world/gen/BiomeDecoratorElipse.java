package mattparks.mods.exoplanets.elipse.world.gen;

import mattparks.mods.exoplanets.elipse.blocks.ElipseBlocks;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorElipse extends BiomeDecoratorSpace {
	protected WorldGenerator dirtGen;
	protected WorldGenerator flameGen;

	private World currentWorld;

	public BiomeDecoratorElipse() {
		this.dirtGen = new WorldGenMinableMeta(ElipseBlocks.elipseBasicBlock, 32, 1, true, ElipseBlocks.elipseBasicBlock, 2);
		this.flameGen = new WorldGenMinableMeta(ElipseBlocks.elipseBasicBlock, 16, 5, true, ElipseBlocks.elipseBasicBlock, 2);
	}

	@Override
	protected void decorate() {
		this.generateOre(32, this.dirtGen, 0, 256);
		this.generateOre(32, this.flameGen, 0, 256);
	}

	protected void setCurrentWorld(World world) {
		this.currentWorld = world;
	}

	protected World getCurrentWorld() {
		return this.currentWorld;
	}
}
