package mattparks.mods.venus.util;

import mattparks.mods.venus.GCVenusThreadVersionCheck;
import cpw.mods.fml.relauncher.Side;

public class GCVenusUtil
{
	public static void checkVersion(Side side)
	{
		GCVenusThreadVersionCheck.startCheck(side);
	}
}
