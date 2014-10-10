package mattparks.mods.space.mercury;

import mattparks.mods.space.core.util.ConfigManager;
import mattparks.mods.space.mercury.client.GCMapMercury;
import mattparks.mods.space.mercury.dimension.GCMercuryWorldProvider;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class GCMercuryPlanet implements IPlanet
{
	private final IMapObject mercury = new GCMapMercury();

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
		return ConfigManager.dimensionIDMercury;
	}

	@Override
	public IMapObject getMapObject()
	{
		return this.mercury;
	}

	@Override
	public String getName()
	{
		return "Mercury";
	}

	@Override
	public IGalaxy getParentGalaxy()
	{
		return GalacticraftCore.galaxyMilkyWay;
	}

	@Override
	public Class<? extends WorldProvider> getWorldProvider()
	{
		return GCMercuryWorldProvider.class;
	}

	@Override
	public boolean isReachable()
	{
		return true;
	}
}
