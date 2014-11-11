package mattparks.mods.space.ganymede.worldgen;

import mattparks.mods.space.core.util.ConfigManagerSpace;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBaseGanymede extends BiomeGenBase
{
	public static final BiomeGenBase eris = new BiomeGenBaseGanymede(ConfigManagerSpace.idBiomeEris).setBiomeName("Eris");

	public BiomeGenBaseGanymede(int var1)
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
	public BiomeGenBaseGanymede setColor(int var1)
	{
		return (BiomeGenBaseGanymede) super.setColor(var1);
	}

	@Override
	public float getSpawningChance()
	{
		return 0.01F;
	}
}