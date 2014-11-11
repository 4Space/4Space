package mattparks.mods.space.io.items;

import mattparks.mods.space.core.SpaceCore;
import net.minecraft.item.Item;

public class IoItems
{
	public static Item ioBucket;

	public static void init()
	{
		initItems();
		registerItems();
	}

	private static void initItems()
	{
		IoItems.ioBucket = new ItemIoBucket("io_bucket");
	}

	private static void registerItems()
	{
		SpaceCore.registerItem(ioBucket);
	}
}