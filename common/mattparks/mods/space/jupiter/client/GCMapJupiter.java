package mattparks.mods.space.jupiter.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class GCMapJupiter implements IMapObject
{
	@Override
	public float getDistanceFromCenter() 
	{
		return 5.2F;
	}

	@Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

	@Override
	public float getPhaseShift() 
	{
		return 5.5F;
	}

	@Override
	public float getPlanetSize() 
	{
		return 17F;
	}

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new GCJupiterSlotRender();
    }

    @Override
	public float getStretchValue() 
	{
		return 11.86F;
	}
}