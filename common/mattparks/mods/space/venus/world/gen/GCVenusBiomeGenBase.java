package mattparks.mods.space.venus.world.gen;

import micdoodle8.mods.galacticraft.core.entities.GCCoreEntitySpider;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntityZombie;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class GCVenusBiomeGenBase extends BiomeGenBase
{
	public static final BiomeGenBase venusFlat = new GCVenusBiomeGenFlat(103).setBiomeName("venusFlat");

	@SuppressWarnings("unchecked")
	public GCVenusBiomeGenBase(int var1)
	{
		super(var1);
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(GCCoreEntityZombie.class, 10, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(GCCoreEntitySpider.class, 10, 4, 4));
		this.rainfall = 0F;
	}

	@Override
	public float getSpawningChance()
	{
		return 0.01F;
	}

	@Override
	public GCVenusBiomeGenBase setColor(int var1)
	{
		return (GCVenusBiomeGenBase) super.setColor(var1);
	}
}
