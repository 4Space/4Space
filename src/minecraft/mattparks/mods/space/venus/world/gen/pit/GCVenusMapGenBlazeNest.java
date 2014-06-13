package mattparks.mods.space.venus.world.gen.pit;

import micdoodle8.mods.galacticraft.core.world.gen.GCCoreMapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;

public class GCVenusMapGenBlazeNest extends GCCoreMapGenStructure
{
    private int terrainType;

	@Override
	protected boolean canSpawnStructureAtCoords(int par1, int par2)
    {
    	if (this.rand.nextInt(75) != 0)
    	{
    		return false;
    	}
    	
    	return true;
    }

    @Override
    protected StructureStart getStructureStart(int par1, int par2)
    {
        return new GCVenusStructureBlazePitStart(this.worldObj, this.rand, par1, par2);
    }
}