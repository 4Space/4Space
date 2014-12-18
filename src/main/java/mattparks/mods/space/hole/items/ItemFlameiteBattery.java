package mattparks.mods.space.hole.items;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.proxy.ClientProxy;
import mattparks.mods.space.hole.HoleCore;
import micdoodle8.mods.galacticraft.api.item.IItemElectric;
import micdoodle8.mods.galacticraft.core.energy.item.ItemElectricBase;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlameiteBattery extends ItemElectricBase implements IItemElectric
{
	public ItemFlameiteBattery(String name)
	{
		super();
		this.setUnlocalizedName(name);
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return SpaceCore.spaceItemsTab;
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return ClientProxy.spaceItem;
	}

	@Override
	public float getMaxElectricityStored(ItemStack itemStack)
	{
		return 19200;
	}

	@Override
	public int getTierGC(ItemStack itemStack)
	{
		return 3;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(HoleCore.TEXTURE_PREFIX + "flameiteBattery");
	}
}