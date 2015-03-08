package mattparks.mods.space.io.items;

import mattparks.mods.space.io.IoCore;
import net.minecraft.item.Item;

public class IoItems {
	public static Item venusBasicItem;
	public static Item ioBucket;

	public static void init() {
		initItems();
		registerItems();
		registerHarvestLevels();
	}

	private static void initItems() {
		IoItems.venusBasicItem = new ItemBasicIo();
		IoItems.ioBucket = new ItemIoBucket("io_bucket");
	}

	private static void registerHarvestLevels() {
	}

	private static void registerItems() {
		IoCore.registerItem(venusBasicItem);
		IoCore.registerItem(ioBucket);
	}
}
