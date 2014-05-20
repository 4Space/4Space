package mattparks.mods.venus.util;

import mattparks.mods.venus.GCVenusThreadVersionCheck;
import cpw.mods.fml.relauncher.Side;


public class GCVenusUtil
{
//	public static void addRocketBenchT2Recipe(ItemStack result, HashMap<Integer, ItemStack> input)
//	{
//		GalacticraftRegistry.addT2RocketRecipe(new GCCoreNasaWorkbenchRecipe(result, input));
//	}
	
	public static void checkVersion(Side side)
	{
		GCVenusThreadVersionCheck.startCheck(side);
	}
}
