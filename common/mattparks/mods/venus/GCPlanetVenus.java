package mattparks.mods.venus;

import mattparks.mods.venus.client.GCMapVenus;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class GCPlanetVenus implements IPlanet{

	@Override
	public String getName() 
	{
		return "Venus";
	}

	@Override
	public boolean isReachable() 
	{
		return false;
	}

	@Override
	public IMapObject getMapObject() 
	{
		return new GCMapVenus();
	}

	@Override
	public boolean addToList() 
	{
		return false;
	}

	@Override
	public boolean autoRegister() 
	{
		return true;
	}

	@Override
	public Class<? extends WorldProvider> getWorldProvider() 
	{
		return null;
	}

	@Override
	public int getDimensionID() 
	{
		return -40;
	}

	@Override
	public IGalaxy getParentGalaxy() 
	{
		return GalacticraftCore.galaxyMilkyWay;
	}

	@Override
	public boolean forceStaticLoad() 
	{
		return true;
	}

}
