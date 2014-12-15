package mattparks.mods.space.mercury.world.gen;

import mattparks.mods.space.mercury.blocks.MercuryBlocks;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorMercury extends BiomeDecoratorSpace
{
	protected WorldGenerator dirtGen;
	protected WorldGenerator copperGen;
	protected WorldGenerator tinGen;
	protected WorldGenerator meteorGen;
	protected WorldGenerator goldGen;
	protected WorldGenerator iridiumGen;
	private World currentWorld;

	public BiomeDecoratorMercury()
	{
		this.dirtGen = new WorldGenMinableMeta(MercuryBlocks.mercuryBasicBlock, 32, 1, true, MercuryBlocks.mercuryBasicBlock, 2);
		this.copperGen = new WorldGenMinableMeta(MercuryBlocks.mercuryBasicBlock, 6, 7, true, MercuryBlocks.mercuryBasicBlock, 2);
		this.tinGen = new WorldGenMinableMeta(MercuryBlocks.mercuryBasicBlock, 6, 6, true, MercuryBlocks.mercuryBasicBlock, 2);
		this.meteorGen = new WorldGenMinableMeta(MercuryBlocks.mercuryBasicBlock, 4, 5, true, MercuryBlocks.mercuryBasicBlock, 2);
		this.goldGen = new WorldGenMinableMeta(MercuryBlocks.mercuryBasicBlock, 4, 8, true, MercuryBlocks.mercuryBasicBlock, 2);
		this.iridiumGen = new WorldGenMinableMeta(MercuryBlocks.mercuryBasicBlock, 8, 4, true, MercuryBlocks.mercuryBasicBlock, 2);
	}

    @Override
    protected void decorate()
    {
		this.generateOre(32, this.dirtGen, 0, 256);
		this.generateOre(16, this.copperGen, 0, 60);
		this.generateOre(16, this.tinGen, 0, 60);
		this.generateOre(4, this.meteorGen, 0, 128);
		this.generateOre(8, this.goldGen, 0, 32);
		this.generateOre(12, this.iridiumGen, 0, 16);
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