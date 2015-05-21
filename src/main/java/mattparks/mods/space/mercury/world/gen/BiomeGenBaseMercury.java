package mattparks.mods.space.mercury.world.gen;

import mattparks.mods.space.core.util.ConfigManagerCore;
import mattparks.mods.space.mercury.util.ConfigManagerMercury;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBaseMercury extends BiomeGenBase {
	public static final BiomeGenBase mercury = new BiomeGenBaseMercury(ConfigManagerMercury.idBiomeMercury).setBiomeName("Mercury");

	public BiomeGenBaseMercury(int var1) {
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
	public BiomeGenBaseMercury setColor(int var1) {
		return (BiomeGenBaseMercury) super.setColor(var1);
	}

	@Override
	public float getSpawningChance() {
		return 0.01F;
	}
}
