package mattparks.mods.exoplanets.elipse.world.gen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerElipse extends WorldChunkManagerSpace {
	@Override
	public BiomeGenBase getBiome() {
		return BiomeGenBaseElipse.elipse;
	}
}
