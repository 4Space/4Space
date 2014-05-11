package mattparks.mods.venus.items;

import mattparks.mods.venus.GCVenusConfigManager;
import net.minecraft.item.Item;

public class VenusItems
{
    public static Item venusItemBasic;

    public static void initItems()
    {
        VenusItems.venusItemBasic = new SCVenusItem(GCVenusConfigManager.idItemVenusBasic);
    }
    
    public static void registerHarvestLevels()
    {

    }
}
