package mattparks.mods.space.saturn.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class GCMapSaturn implements IMapObject
{
	@Override
	public float getDistanceFromCenter() 
	{
		return 9.54F;
	}

	@Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

	@Override
	public float getPhaseShift() 
	{
		return 555.5F;
	}

	@Override
	public float getPlanetSize() 
	{
		return 14F;
	}

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new GCSaturnSlotRender();
    }

    @Override
	public float getStretchValue() 
	{
		return 11.86F;
	}
}