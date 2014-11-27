package mattparks.mods.space.venus.world.gen;

import mattparks.mods.space.venus.blocks.VenusBlocks;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorVenus extends BiomeDecoratorSpace
{
	protected WorldGenerator dirtGen;
	protected WorldGenerator gemGen;
	protected WorldGenerator sulfurGen;
	protected WorldGenerator ironGen;
	protected WorldGenerator coalGen;
	protected WorldGenerator tinGen;
	protected WorldGenerator copperGen;
	protected WorldGenerator crystalGen;
	protected WorldGenerator uraniumGen;
	protected WorldGenerator fossilizedPlantGen;
	private World currentWorld;

	public BiomeDecoratorVenus()
	{
		this.dirtGen = new WorldGenMinableMeta(VenusBlocks.venusBasicBlock, 32, 1, true, VenusBlocks.venusBasicBlock, 2);
		this.sulfurGen = new WorldGenMinableMeta(VenusBlocks.venusBasicBlock, 12, 4, true, VenusBlocks.venusBasicBlock, 2);
		this.coalGen = new WorldGenMinableMeta(VenusBlocks.venusBasicBlock, 10, 11, true, VenusBlocks.venusBasicBlock, 2);
		this.ironGen = new WorldGenMinableMeta(VenusBlocks.venusBasicBlock, 7, 10, true, VenusBlocks.venusBasicBlock, 2);
		this.tinGen = new WorldGenMinableMeta(VenusBlocks.venusBasicBlock, 4, 8, true, VenusBlocks.venusBasicBlock, 2);
		this.copperGen = new WorldGenMinableMeta(VenusBlocks.venusBasicBlock, 5, 9, true, VenusBlocks.venusBasicBlock, 2);
		this.crystalGen = new WorldGenMinableMeta(VenusBlocks.venusBasicBlock, 3, 7, true, VenusBlocks.venusBasicBlock, 2);
		this.gemGen = new WorldGenMinableMeta(VenusBlocks.venusBasicBlock, 8, 6, true, VenusBlocks.venusBasicBlock, 2);
		this.uraniumGen = new WorldGenMinableMeta(VenusBlocks.venusBasicBlock, 2, 5, true, VenusBlocks.venusBasicBlock, 2);
	}

    @Override
    protected void decorate()
    {
		this.generateOre(32, this.dirtGen, 0, 256);
		this.generateOre(12, this.sulfurGen, 0, 64);
		this.generateOre(16, this.coalGen, 0, 128);
		this.generateOre(16, this.ironGen, 0, 64);
		this.generateOre(16, this.tinGen, 0, 48);
		this.generateOre(16, this.copperGen, 0, 48);
		this.generateOre(8, this.crystalGen, 0, 16);
		this.generateOre(8, this.gemGen, 0, 16);
		this.generateOre(8, this.uraniumGen, 0, 16);
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