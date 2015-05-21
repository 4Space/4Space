package mattparks.mods.space.callisto.world.gen;

import mattparks.mods.space.callisto.util.ConfigManagerCallisto;
import mattparks.mods.space.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBaseCallisto extends BiomeGenBase {
	public static final BiomeGenBase callisto = new BiomeGenBaseCallisto(ConfigManagerCallisto.idBiomeCallisto).setBiomeName("Callisto");

	public BiomeGenBaseCallisto(int var1) {
		super(var1);
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();

		if (!ConfigManagerCore.idRealisticEnabled) {
			this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedZombie.class, 5, 1, 1));
			this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSpider.class, 3, 1, 1));
			this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedCreeper.class, 2, 1, 1));
		}

		this.rainfall = 0F;
	}

	@Override
	public BiomeGenBaseCallisto setColor(int var1) {
		return (BiomeGenBaseCallisto) super.setColor(var1);
	}

	@Override
	public float getSpawningChance() {
		return 0.01F;
	}
}
