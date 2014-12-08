package mattparks.mods.space.hole.world.gen;

import mattparks.mods.space.hole.util.ConfigManagerHole;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBaseHole extends BiomeGenBase
{
	public static final BiomeGenBase holeFlat = new BiomeGenBaseHole(ConfigManagerHole.idBiomeHole).setBiomeName("Worm Hole");

	public BiomeGenBaseHole(int var1)
	{
		super(var1);
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.rainfall = 0F;
	}

	@Override
	public BiomeGenBaseHole setColor(int var1)
	{
		return (BiomeGenBaseHole) super.setColor(var1);
	}

	@Override
	public float getSpawningChance()
	{
		return 0.01F;
	}
}