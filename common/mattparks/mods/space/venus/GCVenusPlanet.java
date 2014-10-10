package mattparks.mods.space.venus;

import mattparks.mods.space.core.util.ConfigManager;
import mattparks.mods.space.venus.client.GCMapVenus;
import mattparks.mods.space.venus.dimension.GCVenusWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class GCVenusPlanet implements IPlanet
{
	private final IMapObject venus = new GCMapVenus();

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
	public boolean forceStaticLoad()
	{
		return true;
	}

	@Override
	public int getDimensionID()
	{
		return ConfigManager.dimensionIDVenus;
	}

	@Override
	public IMapObject getMapObject()
	{
		return this.venus;
	}

	@Override
	public String getName()
	{
		return "Venus";
	}

	@Override
	public IGalaxy getParentGalaxy()
	{
		return GalacticraftCore.galaxyMilkyWay;
	}

	@Override
	public Class<? extends WorldProvider> getWorldProvider()
	{
		return GCVenusWorldProvider.class;
	}

	@Override
	public boolean isReachable()
	{
		return true;
	}
}
