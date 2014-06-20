package mattparks.mods.space.uranus.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class GCMapUranus implements IMapObject
{
	@Override
	public float getDistanceFromCenter() 
	{
		return 19.2F;
	}

	@Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

	@Override
	public float getPhaseShift() 
	{
		return 40000.5F;
	}

	@Override
	public float getPlanetSize() 
	{
		return 15F;
	}

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new GCUranusSlotRender();
    }

    @Override
	public float getStretchValue() 
	{
		return 11.86F;
	}
}