package mattparks.mods.space.europa;

import mattparks.mods.space.core.ConfigManager;
import mattparks.mods.space.europa.client.GCMapEuropa;
import mattparks.mods.space.europa.dimension.GCEuropaWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class GCEuropaPlanet implements IPlanet
//IMoon
{
	private final IMapObject europa = new GCMapEuropa();

	@Override
	public String getName()
	{
		return "Europa";
	}

	@Override
	public boolean isReachable()
	{
		return true;
	}

	@Override
	public IMapObject getMapObject()
	{
		return this.europa;
	}

	@Override
	public boolean autoRegister()
	{
		return true;
	}

	@Override
	public boolean addToList()
	{
		return false;
	}

	@Override
	public Class<? extends WorldProvider> getWorldProvider()
	{
		return GCEuropaWorldProvider.class;
	}

	@Override
	public int getDimensionID()
	{
		return ConfigManager.dimensionIDEuropa;
	}

	@Override
	public boolean forceStaticLoad()
	{
		return true;
	}

	@Override
	public IGalaxy getParentGalaxy() 
	{
		return GalacticraftCore.galaxyMilkyWay;
	}

//	@Override
//	public IPlanet getParentPlanet() 
//	{
//		return GCJupiter.jupiter;
//	}
}
