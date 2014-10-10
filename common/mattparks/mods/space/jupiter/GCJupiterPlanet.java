package mattparks.mods.space.jupiter;

import mattparks.mods.space.jupiter.client.GCMapJupiter;
import micdoodle8.mods.galacticraft.api.world.IGalaxy;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.world.WorldProvider;

public class GCJupiterPlanet implements IPlanet
{
	private final IMapObject jupiter = new GCMapJupiter();

	@Override
	public boolean addToList()
	{
		return false;
	}

	@Override
	public boolean autoRegister()
	{
		return false;
	}

	@Override
	public boolean forceStaticLoad()
	{
		return true;
	}

	@Override
	public int getDimensionID()
	{
		return -1;
	}

	@Override
	public IMapObject getMapObject()
	{
		return this.jupiter;
	}

	@Override
	public String getName()
	{
		return "Jupiter";
	}

	@Override
	public IGalaxy getParentGalaxy()
	{
		return GalacticraftCore.galaxyMilkyWay;
	}

	@Override
	public Class<? extends WorldProvider> getWorldProvider()
	{
		return null;
	}

	@Override
	public boolean isReachable()
	{
		return false;
	}
}
