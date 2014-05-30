package mattparks.mods.venus.items;

import java.util.List;

import mattparks.mods.venus.GCVenus;
import micdoodle8.mods.galacticraft.core.client.ClientProxyCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
