package mattparks.mods.space.ganymede.worldgen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerGanymede extends WorldChunkManagerSpace
{
	@Override
	public BiomeGenBase getBiome()
	{
		return BiomeGenBaseGanymede.eris;
	}
}