package mattparks.mods.venus.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;


public class GCMapVenus implements IMapObject
{

	@Override
	public float getPlanetSize() 
	{
		return 0.72f;
	}

	@Override
	public float getDistanceFromCenter() 
	{
		return 12f;
	}

	@Override
	public float getPhaseShift() 
	{
		return 20f;
	}

	@Override
	public float getStretchValue() 
	{
		return 15f;
	}

	@Override
	public ICelestialBodyRenderer getSlotRenderer() 
	{
		return new GCVenusSlotRender();
	}

	@Override
	public IGalaxy getParentGalaxy() 
	{
		return GalacticraftCore.galaxyMilkyWay;
	}
}
