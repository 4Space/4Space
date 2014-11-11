package mattparks.mods.space.ganymede.worldgen;

import mattparks.mods.space.eris.blocks.ErisBlocks;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorGanymede extends BiomeDecoratorSpace
{
	protected WorldGenerator dirtGen;
	protected WorldGenerator gemGen;
	protected WorldGenerator tinGen;
	protected WorldGenerator meteorGen;
	protected WorldGenerator coalGen;
	protected WorldGenerator ironGen;

	public BiomeDecoratorGanymede()
	{
		super();
		this.dirtGen = new WorldGenMinableMeta(ErisBlocks.erisBasicBlock, 32, 1, true, ErisBlocks.erisBasicBlock, 2);
		this.gemGen = new WorldGenMinableMeta(ErisBlocks.erisBasicBlock, 6, 4, true, ErisBlocks.erisBasicBlock, 2);
		this.tinGen = new WorldGenMinableMeta(ErisBlocks.erisBasicBlock, 6, 6, true, ErisBlocks.erisBasicBlock, 2);
		this.meteorGen = new WorldGenMinableMeta(ErisBlocks.erisBasicBlock, 4, 5, true, ErisBlocks.erisBasicBlock, 2);
		this.coalGen = new WorldGenMinableMeta(ErisBlocks.erisBasicBlock, 4, 7, true, ErisBlocks.erisBasicBlock, 2);
		this.ironGen = new WorldGenMinableMeta(ErisBlocks.erisBasicBlock, 8, 8, true, ErisBlocks.erisBasicBlock, 2);
	}

	@Override
	public void decorate()
	{
		this.generateOre(32, this.dirtGen, 0, 256);
		this.generateOre(12, this.gemGen, 0, 32);
		this.generateOre(12, this.tinGen, 0, 60);
		this.generateOre(8, this.meteorGen, 0, 128);
		this.generateOre(16, this.coalGen, 0, 128);
		this.generateOre(16, this.ironGen, 0, 64);
	}
}