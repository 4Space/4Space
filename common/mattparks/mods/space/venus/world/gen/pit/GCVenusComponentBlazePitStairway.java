package mattparks.mods.space.venus.world.gen.pit;

import java.util.List;
import java.util.Random;

import mattparks.mods.space.venus.blocks.VenusBlocks;
import micdoodle8.mods.galacticraft.core.world.gen.GCCoreStructureComponent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class GCVenusComponentBlazePitStairway extends GCCoreStructureComponent
{
    private int[] orig = new int[3];
    private final GCVenusComponentBlazePitRoom originalRoom;
    
	protected GCVenusComponentBlazePitStairway(GCVenusComponentBlazePitRoom origRoom, int type, Random rand, int x, int y, int z) 
	{
		super(type);
        this.orig = new int[] {x, y, z};
        this.originalRoom = origRoom;
        this.boundingBox = new StructureBoundingBox(Math.min(x - 5, x - 2), Math.min(y - 20, y - 20), Math.min(z - 5, z - 2), Math.max(x - 5, x - 2), Math.max(y, y), Math.max(z - 5, z - 2));
	}

	@Override
	public boolean addComponentParts(World par1World, Random var2, StructureBoundingBox var3) 
	{
		final int x1 = this.getBoundingBox().minX;
		final int y1 = this.getBoundingBox().minY;
		final int z1 = this.getBoundingBox().minZ;
		final int x2 = this.getBoundingBox().maxX;
		final int y2 = this.getBoundingBox().maxY;
		final int z2 = this.getBoundingBox().maxZ;

		this.fillWithBlocks(par1World, var3, x1, y1, z1, x2, y2, z2, VenusBlocks.VenusBrick.blockID, 0, false);
		this.fillWithBlocks(par1World, var3, x1 + 1, y1, z1 + 1, x2 - 1, y2, z2 - 1, 0, 0, false);

		return true;
	}

	@Override
	public void buildComponent(StructureComponent par1StructureComponent, List par2List, Random par3Random)
    {
		;
    }

	@Override
	protected void func_143011_b(NBTTagCompound nbttagcompound) 
	{
		;
	}

	@Override
	protected void func_143012_a(NBTTagCompound nbttagcompound) 
	{
		;
	}
}