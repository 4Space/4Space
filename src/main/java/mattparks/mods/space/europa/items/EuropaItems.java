package mattparks.mods.space.europa.items;

import mattparks.mods.space.europa.EuropaCore;
import mattparks.mods.space.europa.blocks.EuropaBlocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class EuropaItems
{
	public static Item europaWaterBucket;

	public static void init()
	{
		initItems();
		registerItems();
		registerHarvestLevels();
		registerFluidContainer();
	}

	private static void initItems()
	{
		EuropaItems.europaWaterBucket = new ItemEuropaWaterBucket("europa_water_bucket");
	}

	private static void registerHarvestLevels()
	{
	}

	private static void registerItems()
	{
		EuropaCore.registerItem(europaWaterBucket);
	}
	
	private static void registerFluidContainer()
	{
		FluidContainerRegistry.registerFluidContainer(EuropaBlocks.europaWaterFluid, new ItemStack(europaWaterBucket), new ItemStack(Items.bucket));
	}
}