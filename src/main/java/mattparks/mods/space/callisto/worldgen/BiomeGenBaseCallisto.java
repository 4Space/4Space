package mattparks.mods.space.callisto.worldgen;

import mattparks.mods.space.core.util.ConfigManagerSpace;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBaseCallisto extends BiomeGenBase
{
	public static final BiomeGenBase callisto = new BiomeGenBaseCallisto(ConfigManagerSpace.idBiomeCallisto).setBiomeName("Callisto");

	public BiomeGenBaseCallisto(int var1)
	{
		super(var1);
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedZombie.class, 10, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSpider.class, 10, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 10, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedCreeper.class, 10, 4, 4));
		this.rainfall = 0F;
	}

	@Override
	public BiomeGenBaseCallisto setColor(int var1)
	{
		return (BiomeGenBaseCallisto) super.setColor(var1);
	}

	@Override
	public float getSpawningChance()
	{
		return 0.01F;
	}
}