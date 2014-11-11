package mattparks.mods.space.titan.items;

import mattparks.mods.space.core.SpaceCore;
import net.minecraft.item.Item;

public class TitanItems
{
	public static Item wetClayBall;

	public static void init()
	{
		initItems();
		registerItems();
	}

	private static void initItems()
	{
		TitanItems.wetClayBall = new ItemWetClayBall("wet_clay_ball");
	}

	private static void registerItems()
	{
		SpaceCore.registerItem(wetClayBall);
	}
}