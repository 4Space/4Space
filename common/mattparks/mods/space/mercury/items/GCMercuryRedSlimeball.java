package mattparks.mods.space.mercury.items;

import mattparks.mods.space.mercury.GCMercury;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GCMercuryRedSlimeball extends Item
{
	public GCMercuryRedSlimeball(int id, String assetName)
	{
		super(id);
		this.setUnlocalizedName(assetName);
		this.maxStackSize = 16;
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return GCMercury.galacticraftMercuryTab;
	}
}
