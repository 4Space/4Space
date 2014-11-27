package mattparks.mods.space.core.util;

import java.util.Arrays;
import java.util.List;

import mattparks.mods.space.core.SpaceCore;
import net.minecraft.entity.Entity;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

public class SpaceUtil
{
    public static int to32BitColor(int a, int r, int g, int b)
    {
        a = a << 24;
        r = r << 16;
        g = g << 8;

        return a | r | g | b;
    }

    public static String translate(String key)
    {
        String result = StatCollector.translateToLocal(key);
        int comment = result.indexOf('#');
        return (comment > 0) ? result.substring(0, comment).trim() : result;
    }

    public static List<String> translateWithSplit(String key)
    {
        String translated = translate(key);
        int comment = translated.indexOf('#');
        translated = (comment > 0) ? translated.substring(0, comment).trim() : translated;
        return Arrays.asList(translated.split("\\$"));
    }

    public static String translateWithFormat(String key, Object... values)
    {
        String result = StatCollector.translateToLocalFormatted(key, values);
        int comment = result.indexOf('#');
        return (comment > 0) ? result.substring(0, comment).trim() : result;
    }
    
	public static void registerSpaceCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
	{
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
		{
			LanguageRegistry.instance().addStringLocalization("entity." + var1 + ".name", StatCollector.translateToLocal("entity.SpaceCore." + var1 + ".name"));
		}
		EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
		EntityRegistry.registerModEntity(var0, var1, id, SpaceCore.instance, 80, 3, true);
	}

	public static void registerSpaceNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
	{
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
		{
			LanguageRegistry.instance().addStringLocalization("entity." + var1 + ".name", StatCollector.translateToLocal("entity.SpaceCore." + var1 + ".name"));
		}
		EntityRegistry.registerModEntity(var0, var1, id, SpaceCore.instance, trackingDistance, updateFreq, sendVel);
	}
}