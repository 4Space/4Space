package mattparks.mods.space.hole.world.gen;

import mattparks.mods.space.hole.blocks.HoleBlocks;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorHole extends BiomeDecoratorSpace
{
	protected WorldGenerator dirtGen;
	protected WorldGenerator flameGen;

	private World currentWorld;

	public BiomeDecoratorHole()
	{
		this.dirtGen = new WorldGenMinableMeta(HoleBlocks.holeBasicBlock, 32, 1, true, HoleBlocks.holeBasicBlock, 2);
		this.flameGen = new WorldGenMinableMeta(HoleBlocks.holeBasicBlock, 16, 5, true, HoleBlocks.holeBasicBlock, 2);
	}

	@Override
	protected void decorate()
	{
		this.generateOre(32, this.dirtGen, 0, 256);
		this.generateOre(32, this.flameGen, 0, 256);
	}

	protected void setCurrentWorld(World world)
	{
		this.currentWorld = world;
	}

	protected World getCurrentWorld()
	{
		return this.currentWorld;
	}
}
