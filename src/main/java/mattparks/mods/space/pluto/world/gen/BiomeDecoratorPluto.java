package mattparks.mods.space.pluto.world.gen;

import mattparks.mods.space.pluto.blocks.PlutoBlocks;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorPluto extends BiomeDecoratorSpace
{
	protected WorldGenerator dirtGen;
	protected WorldGenerator blueGemGen;
	protected WorldGenerator frozenIronGen;
	protected WorldGenerator ununpentiumGen;
	private World currentWorld;

	public BiomeDecoratorPluto()
	{
		this.dirtGen = new WorldGenMinableMeta(PlutoBlocks.plutoBasicBlock, 32, 1, true, PlutoBlocks.plutoBasicBlock, 2);
		this.blueGemGen = new WorldGenMinableMeta(PlutoBlocks.plutoBasicBlock, 6, 4, true, PlutoBlocks.plutoBasicBlock, 2);
		this.frozenIronGen = new WorldGenMinableMeta(PlutoBlocks.plutoBasicBlock, 6, 5, true, PlutoBlocks.plutoBasicBlock, 2);
		this.ununpentiumGen = new WorldGenMinableMeta(PlutoBlocks.plutoBasicBlock, 4, 6, true, PlutoBlocks.plutoBasicBlock, 2);
	}

    @Override
    protected void decorate()
    {
		this.generateOre(32, this.dirtGen, 0, 256);
		this.generateOre(16, this.blueGemGen, 0, 60);
		this.generateOre(16, this.frozenIronGen, 0, 60);
		this.generateOre(4, this.ununpentiumGen, 0, 128);
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