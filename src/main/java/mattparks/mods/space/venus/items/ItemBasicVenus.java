package mattparks.mods.space.venus.items;

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

public class ItemBasicVenus extends Item
{
	private static String[] names = {
		"sulfurDust",
		"ingotSulfur",
		"redGem",
		"ingotUranium",
		"venusCrystal",
		"sulfurPlate",
		"redGemPlate",
		"uraniumPlate",
		"tier4HeavyDutyPlate",
		"venusRod",
		"venusRodDust",
		"venusPowerCrystal",
	};

	private final IIcon[] icons = new IIcon[ItemBasicVenus.names.length];

	public ItemBasicVenus(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setHasSubtypes(true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (par1ItemStack != null && par1ItemStack.getItemDamage() == 8)
		{
			par3List.add(StatCollector.translateToLocal("item.tier3.desc"));
		}
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return SpaceCore.spaceItemsTab;
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

	@Override
	public int getMetadata(int par1)
	{
		return par1;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int i = 0; i < ItemBasicVenus.names.length; i++)
		{
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		if (this.icons.length > par1ItemStack.getItemDamage())
		{
			return "item." + ItemBasicVenus.names[par1ItemStack.getItemDamage()];
		}
		return "unnamed";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		if (par1ItemStack.getItemDamage() == 11)
		{
			return true;
		}
		return false;
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		int i = 0;

		for (final String name : ItemBasicVenus.names)
		{
			this.icons[i++] = iconRegister.registerIcon("galacticraftvenus:" + name);
		}
	}
}