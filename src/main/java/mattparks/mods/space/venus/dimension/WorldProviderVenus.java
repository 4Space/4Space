package mattparks.mods.space.venus.dimension;

import mattparks.mods.space.venus.worldgen.ChunkProviderVenus;
import mattparks.mods.space.venus.worldgen.WorldChunkManagerVenus;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderVenus extends WorldProviderSpace implements IGalacticraftWorldProvider, ISolarLevel
{
	@Override
	public Vector3 getFogColor()
	{
		return new Vector3(182, 108, 10);
	}

	@Override
	public Vector3 getSkyColor()
	{
		return new Vector3(242, 145, 13);
	}

	@Override
	public boolean canRainOrSnow()
	{
		return false;
	}

	@Override
	public boolean hasSunset()
	{
		return false;
	}

	@Override
	public long getDayLength()
	{
		return 160000L;
	}

	@Override
	public boolean shouldForceRespawn()
	{
		return !ConfigManagerCore.forceOverworldRespawn;
	}

	@Override
	public Class<? extends IChunkProvider> getChunkProviderClass()
	{
		return ChunkProviderVenus.class;
	}

	@Override
	public Class<? extends WorldChunkManager> getWorldChunkManagerClass()
	{
		return WorldChunkManagerVenus.class;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1)
	{
		final float f1 = this.worldObj.getCelestialAngle(par1);
		float f2 = 1.0F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);

		if (f2 < 0.0F)
		{
			f2 = 0.0F;
		}

		if (f2 > 1.0F)
		{
			f2 = 1.0F;
		}
		return f2 * f2 * 0.75F;
	}

	@Override
	public double getHorizon()
	{
		return 44.0D;
	}

	@Override
	public int getAverageGroundLevel()
	{
		return 44;
	}

	@Override
	public boolean canCoordinateBeSpawn(int var1, int var2)
	{
		return true;
	}

	@Override
	public double getSolarEnergyMultiplier()
	{
		return 4.5D;
	}

	@Override
	public float getGravity()
	{
		return 0.034F;
	}

	@Override
	public int getHeight()
	{
		return 800;
	}

	@Override
	public double getMeteorFrequency()
	{
		return 6.5D;
	}

	@Override
	public double getFuelUsageMultiplier()
	{
		return 0.9D;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier)
	{
		return tier >= 3;
	}

	@Override
	public float getFallDamageModifier()
	{
		return 0.64F;
	}

	@Override
	public float getSoundVolReductionAmount()
	{
		return 15.0F;
	}

	@Override
	public CelestialBody getCelestialBody()
	{
		return GalacticraftCore.planetVenus;
	}

	@Override
	public boolean hasBreathableAtmosphere()
	{
		return false;
	}

	@Override
	public float getThermalLevelModifier()
	{
		return 5.0F;
	}

	@Override
	public float getWindLevel()
	{
		return 0.7F;
	}
}