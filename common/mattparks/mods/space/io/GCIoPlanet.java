package mattparks.mods.space.io;

import mattparks.mods.space.core.util.ConfigManager;
import mattparks.mods.space.io.client.GCMapEuropa;
import mattparks.mods.space.io.dimension.GCIoWorldProvider;
import mattparks.mods.space.jupiter.GCJupiter;
import micdoodle8.mods.galacticraft.api.world.IMapObject;
import micdoodle8.mods.galacticraft.api.world.IMoon;
import micdoodle8.mods.galacticraft.api.world.IPlanet;
import net.minecraft.world.WorldProvider;

public class GCIoPlanet implements IMoon
{
	private final IMapObject io = new GCMapEuropa();

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
		return ConfigManager.dimensionIDIo;
	}

	@Override
	public IMapObject getMapObject()
	{
		return this.io;
	}

	@Override
	public String getName()
	{
		return "Io";
	}

	@Override
	public IPlanet getParentPlanet()
	{
		return GCJupiter.jupiter;
	}

	@Override
	public Class<? extends WorldProvider> getWorldProvider()
	{
		return GCIoWorldProvider.class;
	}

	@Override
	public boolean isReachable()
	{
		return true;
	}
}
