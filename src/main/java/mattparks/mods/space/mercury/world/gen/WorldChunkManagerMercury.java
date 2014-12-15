package mattparks.mods.space.mercury.world.gen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerMercury extends WorldChunkManagerSpace
{
	@Override
	public BiomeGenBase getBiome()
	{
		return BiomeGenBaseMercury.mercury;
	}
}