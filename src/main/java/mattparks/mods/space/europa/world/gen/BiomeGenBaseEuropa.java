package mattparks.mods.space.europa.world.gen;

import mattparks.mods.space.europa.util.ConfigManagerEuropa;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBaseEuropa extends BiomeGenBase {
	public static final BiomeGenBase europa = new BiomeGenBaseEuropa(ConfigManagerEuropa.idBiomeEuropa).setBiomeName("Europa");

	public BiomeGenBaseEuropa(int var1) {
		super(var1);
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedZombie.class, 5, 1, 1));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSpider.class, 3, 1, 1));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedCreeper.class, 2, 1, 1));
		this.rainfall = 0F;
	}

	@Override
	public BiomeGenBaseEuropa setColor(int var1) {
		return (BiomeGenBaseEuropa) super.setColor(var1);
	}

	@Override
	public float getSpawningChance() {
		return 0.01F;
	}
}
