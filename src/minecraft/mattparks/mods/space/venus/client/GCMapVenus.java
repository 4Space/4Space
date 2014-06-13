package mattparks.mods.space.venus.client;

import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;

public class GCMapVenus implements IMapObject
{
    @Override
    public float getDistanceFromCenter()
    {
        return 0.72F;
    }

    @Override
    public IGalaxy getParentGalaxy()
    {
        return GalacticraftCore.galaxyMilkyWay;
    }

    @Override
    public float getPhaseShift()
    {
        return 950F;
    }
    
    @Override
    public float getPlanetSize()
    {
        return 0.53191489361702127659574468085106F;
    }

    @Override
    public ICelestialBodyRenderer getSlotRenderer()
    {
        return new GCVenusSlotRender();
    }

    @Override
    public float getStretchValue()
    {
        return 1.5F;
    }
}