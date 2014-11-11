package mattparks.mods.space.europa.worldgen;

import mattparks.mods.space.core.util.ConfigManagerSpace;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBaseEuropa extends BiomeGenBase
{
	public static final BiomeGenBase europa = new BiomeGenBaseEuropa(ConfigManagerSpace.idBiomeEuropa).setBiomeName("Europa");

	public BiomeGenBaseEuropa(int var1)
	{
		super(var1);
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 10, 2, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedZombie.class, 10, 2, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 1));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedCreeper.class, 4, 1, 1));
		this.rainfall = 0F;
	}

	@Override
	public BiomeGenBaseEuropa setColor(int var1)
	{
		return (BiomeGenBaseEuropa) super.setColor(var1);
	}

	@Override
	public float getSpawningChance()
	{
		return 0.01F;
	}
}