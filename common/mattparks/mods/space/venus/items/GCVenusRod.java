package mattparks.mods.space.venus.items;

import mattparks.mods.space.venus.GCVenus;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GCVenusRod extends Item
{
	public GCVenusRod(int id, String assetName)
	{
		super(id);
		this.setUnlocalizedName(assetName);
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return GCVenus.galacticraftVenusTab;
	}
}
