package mattparks.mods.space.mercury.items;

import java.util.List;

import mattparks.mods.space.core.SpaceCore;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBasicMercury extends Item
{
	private static String[] names = {
		"iridiumCrystals",
		"iridiumPlate",
		"tier4HeavyDutyPlate",
	};

	private final IIcon[] icons = new IIcon[ItemBasicMercury.names.length];

	public ItemBasicMercury(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setHasSubtypes(true);
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (par1ItemStack.getItemDamage() == 1)
		{
			par3List.add(StatCollector.translateToLocal("item.tier4.desc"));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		int i = 0;

		for (final String name : ItemBasicMercury.names)
		{
			this.icons[i++] = iconRegister.registerIcon("galacticraftmercury:" + name);
		}
	}

	@Override
	public IIcon getIconFromDamage(int damage)
	{
		if (this.icons.length > damage)
		{
			return this.icons[damage];
		}
		return super.getIconFromDamage(damage);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int i = 0; i < ItemBasicMercury.names.length; i++)
		{
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		if (this.icons.length > par1ItemStack.getItemDamage())
		{
			return "item." + ItemBasicMercury.names[par1ItemStack.getItemDamage()];
		}
		return "unnamed";
	}

	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return SpaceCore.spaceItemsTab;
	}
}