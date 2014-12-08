package mattparks.mods.space.hole.world.gen;

import java.util.ArrayList;
import java.util.List;

import mattparks.mods.space.hole.blocks.HoleBlocks;
import micdoodle8.mods.galacticraft.api.prefab.core.BlockMetaPair;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.ChunkProviderSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

import com.google.common.collect.Lists;

public class ChunkProviderHole extends ChunkProviderSpace
{
    public ChunkProviderHole(World par1World, long seed, boolean mapFeaturesEnabled) 
    {
		super(par1World, seed, mapFeaturesEnabled);
		// TODO Auto-generated constructor stub
	}

	private final BiomeDecoratorHole holeBiomeDecorator = new BiomeDecoratorHole();
    private final MapGenHoleCave cavernGenerator = new MapGenHoleCave();

    @Override
    protected BiomeDecoratorSpace getBiomeGenerator()
    {
        return this.holeBiomeDecorator;
    }

    @Override
    protected BiomeGenBase[] getBiomesForGeneration()
    {
        return new BiomeGenBase[] { BiomeGenBaseHole.holeFlat };
    }

    @Override
    protected int getSeaLevel()
    {
        return 93;
    }

    @Override
    protected List<MapGenBaseMeta> getWorldGenerators()
    {
        List<MapGenBaseMeta> generators = Lists.newArrayList();
        generators.add(this.cavernGenerator);
        return generators;
    }

    @Override
    protected BiomeGenBase.SpawnListEntry[] getMonsters()
    {
        List<BiomeGenBase.SpawnListEntry> monsters = new ArrayList<BiomeGenBase.SpawnListEntry>();
        monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
        monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
        monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
        monsters.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));
        return monsters.toArray(new BiomeGenBase.SpawnListEntry[monsters.size()]);
    }

    @Override
    protected BiomeGenBase.SpawnListEntry[] getCreatures()
    {
        return new BiomeGenBase.SpawnListEntry[0];
    }

    @Override
    protected BlockMetaPair getGrassBlock()
    {
        return new BlockMetaPair(HoleBlocks.holeBasicBlock, (byte) 0);
    }

    @Override
    protected BlockMetaPair getDirtBlock()
    {
        return new BlockMetaPair(HoleBlocks.holeBasicBlock, (byte) 1);
    }

    @Override
    protected BlockMetaPair getStoneBlock()
    {
        return new BlockMetaPair(HoleBlocks.holeBasicBlock, (byte) 2);
    }

    @Override
    public double getHeightModifier()
    {
        return 12;
    }

    @Override
    public double getSmallFeatureHeightModifier()
    {
        return 26;
    }

    @Override
    public double getMountainHeightModifier()
    {
        return 95;
    }

    @Override
    public double getValleyHeightModifier()
    {
        return 50;
    }

    @Override
    public int getCraterProbability()
    {
        return 2000;
    }

    @Override
    public void onChunkProvide(int cX, int cZ, Block[] blocks, byte[] metadata)
    {
    }

    @Override
    public void onPopulate(IChunkProvider provider, int cX, int cZ)
    {
    }
}
