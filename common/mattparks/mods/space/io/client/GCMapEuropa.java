package mattparks.mods.space.io.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class GCMapEuropa implements IMapObject
{
	@Override
	public float getDistanceFromCenter()
	{
		return 38.0F;
	}

	@Override
	public IGalaxy getParentGalaxy()
	{
		return GalacticraftCore.galaxyMilkyWay;
	}

	@Override
	public float getPhaseShift()
	{
		return 0.0F;
	}

	@Override
	public float getPlanetSize()
	{
		return 0.31666666666666666666666666666667F;
	}

	@Override
	public ICelestialBodyRenderer getSlotRenderer()
	{
		return new GCIoSlotRender();
	}

	@Override
	public float getStretchValue()
	{
		return 0.01F;
	}
}
