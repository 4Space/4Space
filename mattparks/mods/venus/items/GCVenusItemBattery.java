package mattparks.mods.venus.items;

import mattparks.mods.venus.GCVenus;
import micdoodle8.mods.galacticraft.api.transmission.core.item.ItemElectric;
import micdoodle8.mods.galacticraft.core.client.ClientProxyCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusItemBattery extends ItemElectric
{
	public GCVenusItemBattery(int id, String assetName)
	{
		super(id);
		this.setUnlocalizedName(assetName);
		this.setTextureName(GCVenus.TEXTURE_PREFIX + assetName);
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return GCVenus.galacticraftVenusTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	public float getMaxElectricityStored(ItemStack itemStack)
	{
		return 7500;
	}

	@Override
	public float getVoltage(ItemStack itemStack)
	{
		return 120;
	}
}
