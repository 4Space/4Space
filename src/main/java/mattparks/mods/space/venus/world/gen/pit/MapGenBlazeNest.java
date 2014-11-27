package mattparks.mods.space.venus.world.gen.pit;

import net.minecraft.world.gen.structure.StructureStart;

public class MapGenBlazeNest extends MapGenBlazePitStructure
{
	@Override
	protected boolean canSpawnStructureAtCoords(int par1, int par2)
	{
		if (this.rand.nextInt(100) != 0)
		{
			return false;
		}
		return true;
	}

	@Override
	protected StructureStart getStructureStart(int par1, int par2)
	{
		return new StructureBlazePitStart(this.worldObj, this.rand, par1, par2);
	}
}