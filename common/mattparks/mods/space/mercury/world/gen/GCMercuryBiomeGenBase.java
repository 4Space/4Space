package mattparks.mods.space.mercury.world.gen;

import micdoodle8.mods.galacticraft.core.entities.GCCoreEntitySpider;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntityZombie;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class GCMercuryBiomeGenBase extends BiomeGenBase
{
	public static final BiomeGenBase mercuryFlat = new GCMercuryBiomeGenFlat(103).setBiomeName("mercuryFlat");

	@SuppressWarnings("unchecked")
	public GCMercuryBiomeGenBase(int var1)
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
	public GCMercuryBiomeGenBase setColor(int var1)
	{
		return (GCMercuryBiomeGenBase) super.setColor(var1);
	}

	@Override
	public float getSpawningChance()
	{
		return 0.01F;
	}
}
