package mattparks.mods.space.hole.world.gen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerHole extends WorldChunkManagerSpace
{
	@Override
	public BiomeGenBase getBiome()
	{
		return BiomeGenBaseHole.hole;
	}
}
