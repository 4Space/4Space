package mattparks.mods.space.core.util;

import mattparks.mods.space.core.thread.ThreadVersionCheck;
import cpw.mods.fml.relauncher.Side;

public class CoreUtil
{
	public static int convertTo32BitColor(int a, int r, int b, int g)
	{
		a = a << 24;
		r = r << 16;
		g = g << 8;

		return a | r | g | b;
	}
	
	public static void checkVersion(Side side)
	{
		ThreadVersionCheck.startCheck(side);
	}
}
