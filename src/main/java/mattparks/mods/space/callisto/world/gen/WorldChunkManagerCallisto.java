package mattparks.mods.space.callisto.world.gen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerCallisto extends WorldChunkManagerSpace {
	@Override
	public BiomeGenBase getBiome() {
		return BiomeGenBaseCallisto.callisto;
	}
}
