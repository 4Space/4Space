package mattparks.mods.space.hole.world.gen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import net.minecraft.world.World;

public class BiomeDecoratorHole extends BiomeDecoratorSpace
{
/*	private WorldGenerator coalGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator diamondGen;
    private WorldGenerator lapisGen;*/
    private World currentWorld;

	public BiomeDecoratorHole()
	{
/*        this.coalGen = new WorldGenMinableMeta(Blocks.coal_ore, 16, 0, true, Blocks.stone, 0);
        this.ironGen = new WorldGenMinableMeta(Blocks.iron_ore, 8, 0, true, Blocks.stone, 0);
        this.goldGen = new WorldGenMinableMeta(Blocks.gold_ore, 8, 0, true, Blocks.stone, 0);
        this.redstoneGen = new WorldGenMinableMeta(Blocks.redstone_ore, 7, 0, true, Blocks.stone, 0);
        this.diamondGen = new WorldGenMinableMeta(Blocks.diamond_ore, 7, 0, true, Blocks.stone, 0);
        this.lapisGen = new WorldGenMinableMeta(Blocks.lapis_ore, 6, 0, true, Blocks.stone, 0);*/
	}

	@Override
	public void decorate()
	{       
/*		this.generateOre(20, this.coalGen, 0, 128);
        this.generateOre(20, this.ironGen, 0, 64);
        this.generateOre(2, this.goldGen, 0, 32);
        this.generateOre(8, this.redstoneGen, 0, 16);
        this.generateOre(1, this.diamondGen, 0, 16);
        this.generateOre(1, this.lapisGen, 16, 16);*/
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