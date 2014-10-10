package mattparks.mods.space.venus.dimension;

import mattparks.mods.space.core.util.ConfigManager;
import mattparks.mods.space.venus.world.gen.GCVenusChunkProvider;
import mattparks.mods.space.venus.world.gen.GCVenusWorldChunkManager;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusWorldProvider extends WorldProvider implements IGalacticraftWorldProvider
{
	@Override
	public float[] calcSunriseSunsetColors(float var1, float var2)
	{
		return null;
	}

    @Override
	public float calculateCelestialAngle(long par1, float par3)
	{    
		if (!ConfigManager.NormalDays)
		{
			final int var4 = (int) (par1 % 24000L);
		
			float var5 = (var4 + par3) / 24000.0F - 0.25F;

			if (var5 < 0.0F)
			{
				++var5;
			}

			if (var5 > 1.0F)
			{
				--var5;
			}

			final float var6 = var5;
			var5 = 1.0F - (float) ((Math.cos(var5 * Math.PI) + 1.0D) / 2.0D);
			var5 = var6 + (var5 - var6) / 3.0F;
			return var5;
		}
		
		else
		{
			final int var4 = (int) (par1 % 2802000L);
		
			float var5 = (var4 + par3) / 2802000.0F - 0.25F;

			if (var5 < 0.0F)
			{
				++var5;
			}

			if (var5 > 1.0F)
			{
				--var5;
			}

			final float var6 = var5;
			var5 = 1.0F - (float) ((Math.cos(var5 * Math.PI) + 1.0D) / 2.0D);
			var5 = var6 + (var5 - var6) / 3.0F;
			return var5;
		}
	}

	public float calculateDeimosAngle(long par1, float par3)
	{
		return this.calculatePhobosAngle(par1, par3) * 0.0000000001F;
	}

    public float calculatePhobosAngle(long par1, float par3)
	{
		return this.calculateCelestialAngle(par1, par3) * 3000;
	}

	@Override
	public boolean canBlockFreeze(int x, int y, int z, boolean byWater)
	{
		return false;
	}

	@Override
	public boolean canCoordinateBeSpawn(int var1, int var2)
	{
		return true;
	}

	@Override
	public boolean canDoLightning(Chunk chunk)
	{
		return true;
	}
	
	@Override
	public boolean canDoRainSnowIce(Chunk chunk)
	{
		return false;
	}

	@Override
	public boolean canRespawnHere()
	{
		return !GCCoreConfigManager.forceOverworldRespawn;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier)
	{
		return tier >= 2;
	}

    @Override
    public IChunkProvider createChunkGenerator()
    {
        return new GCVenusChunkProvider(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled());
    }

	@Override
	protected void generateLightBrightnessTable()
    {
        float f = 0.0F;

        for (int i = 0; i <= 15; ++i)
        {
            float f1 = 1.0F - i / 15.0F;
            this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
        }
    }

	@Override
	public int getAverageGroundLevel()
	{
		return 45;
	}

	@Override
	public String getDepartMessage()
	{
		return "Leaving Venus";
	}

	@Override
	public String getDimensionName()
	{
		return "Venus";
	}

	@Override
	public float getFallDamageModifier()
	{
		return 0.9F;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Vec3 getFogColor(float var1, float var2)
	{
		return this.worldObj.getWorldVec3Pool().getVecFromPool((double) 150F / 255F, (double) 120F / 255F, (double) 59F / 255F);
	}

	@Override
	public double getFuelUsageMultiplier()
	{
		return 0.9D;
	}

	@Override
	public float getGravity()
	{
		return 0.021F;
	}

	@Override
	public int getHeight()
	{
		return 800;
	}

	@Override
	public double getHorizon()
	{
		return 45.0D;
	}

	@Override
	public double getMeteorFrequency()
	{
		return 99.9D;
	}

	@Override
	public String getSaveFolder()
	{
		return "DIM" + ConfigManager.dimensionIDVenus;
	}

	@Override
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
	{
		return this.worldObj.getWorldVec3Pool().getVecFromPool(145 / 255.0F, 125 / 255.0F, 50 / 255.0F);
	}

	@Override
	public float getSoundVolReductionAmount()
	{
		return 6.0F;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1)
	{
        float f1 = this.worldObj.getCelestialAngle(par1);
        float f2 = 1.0F - (MathHelper.cos(f1 * (float)Math.PI * 2.0F) * 2.0F + 0.25F);

        if (f2 < 0.0F)
        {
            f2 = 0.0F;
        }

        if (f2 > 0.9F)
        {
            f2 = 0.9F;
        }

        return f2 * f2 * 1.0F;
	}

	@Override
	public String getWelcomeMessage()
	{
		return "Entering Venus";
	}

	@Override
	public boolean isSkyColored()
	{
		return true;
	}

	@Override
	public boolean isSurfaceWorld()
	{
		return true;
	}

	@Override
    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new GCVenusWorldChunkManager();
    }

	@Override
	public void setDimension(int var1)
	{
		this.dimensionId = var1;
		super.setDimension(var1);
	}

	@Override
	public void updateWeather()
	{
		this.worldObj.getWorldInfo().setRainTime(0);
		this.worldObj.getWorldInfo().setRaining(false);
		this.worldObj.getWorldInfo().setThunderTime(0);
		this.worldObj.getWorldInfo().setThundering(true);
    	this.worldObj.rainingStrength = 0.0F;
    	this.worldObj.thunderingStrength = 99.9F;
	}
}