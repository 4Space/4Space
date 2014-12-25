package mattparks.mods.space.pluto.world.gen;

import mattparks.mods.space.pluto.util.ConfigManagerPluto;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBasePluto extends BiomeGenBase
{
	public static final BiomeGenBase pluto = new BiomeGenBasePluto(ConfigManagerPluto.idBiomePluto).setBiomeName("Pluto");

	public BiomeGenBasePluto(int var1)
	{
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
	public BiomeGenBasePluto setColor(int var1)
	{
		return (BiomeGenBasePluto) super.setColor(var1);
	}

	@Override
	public float getSpawningChance()
	{
		return 0.01F;
	}
}