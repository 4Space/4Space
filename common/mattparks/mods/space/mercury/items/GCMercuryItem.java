package mattparks.mods.space.mercury.items;

import java.util.List;

import mattparks.mods.space.mercury.GCMercury;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCMercuryItem extends Item
{
	public static String[] names = { "iridiumCrystals", "plateHeavyT4", "iridiumPlate" };
	protected Icon[] icons = new Icon[GCMercuryItem.names.length];

	public GCMercuryItem(int par1)
	{
		super(par1);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (par1ItemStack != null && par1ItemStack.getItemDamage() == 1)
		{
			par3List.add(StatCollector.translateToLocal("item.tier4.desc"));
		}
	}
	
	@Override
	public CreativeTabs getCreativeTab()
	{
		return GCMercury.galacticraftMercuryTab;
	}

	@Override
	public Icon getIconFromDamage(int damage)
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
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int i = 0; i < GCMercuryItem.names.length; i++)
		{
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
		if (this.icons.length > par1ItemStack.getItemDamage())
		{
			return "item." + GCMercuryItem.names[par1ItemStack.getItemDamage()];
		}

		return "unnamed";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		int i = 0;

		for (String name : GCMercuryItem.names)
		{
			this.icons[i++] = iconRegister.registerIcon("galacticraftmercury:" + name);
		}
	}
}