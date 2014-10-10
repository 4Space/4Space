package mattparks.mods.space.europa;

import mattparks.mods.space.core.util.ConfigManager;
import mattparks.mods.space.europa.client.GCMapEuropa;
import mattparks.mods.space.europa.dimension.GCEuropaWorldProvider;
import mattparks.mods.space.jupiter.GCJupiter;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IMoon;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import net.minecraft.world.WorldProvider;

public class GCEuropaPlanet implements IMoon
{
	private final IMapObject europa = new GCMapEuropa();

	@Override
	public boolean addToList()
	{
		return true;
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
		return ConfigManager.dimensionIDEuropa;
	}

	@Override
	public IMapObject getMapObject()
	{
		return this.europa;
	}

	@Override
	public String getName()
	{
		return "Europa";
	}

	@Override
	public IPlanet getParentPlanet()
	{
		return GCJupiter.jupiter;
	}

	@Override
	public Class<? extends WorldProvider> getWorldProvider()
	{
		return GCEuropaWorldProvider.class;
	}

	@Override
	public boolean isReachable()
	{
		return true;
	}
}
