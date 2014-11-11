package mattparks.mods.space.core.util;

import mattparks.mods.space.core.SpaceCore;
import net.minecraft.entity.Entity;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

public class EntityRegisterUtil
{
	public static void registerSpaceCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
	{
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
		{
			LanguageRegistry.instance().addStringLocalization("entity." + var1 + ".name", StatCollector.translateToLocal("entity.MorePlanet." + var1 + ".name"));
		}
		EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
		EntityRegistry.registerModEntity(var0, var1, id, SpaceCore.instance, 80, 3, true);
	}

	public static void registerSpaceNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
	{
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
		{
			LanguageRegistry.instance().addStringLocalization("entity." + var1 + ".name", StatCollector.translateToLocal("entity.MorePlanet." + var1 + ".name"));
		}
		EntityRegistry.registerModEntity(var0, var1, id, SpaceCore.instance, trackingDistance, updateFreq, sendVel);
	}
}