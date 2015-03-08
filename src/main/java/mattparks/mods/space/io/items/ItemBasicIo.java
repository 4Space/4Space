package mattparks.mods.space.io.items;

import java.util.List;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.proxy.ClientProxy;
import mattparks.mods.space.io.IoCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBasicIo extends Item {
	private static String[] names = {};
	protected IIcon[] icons = new IIcon[ItemBasicIo.names.length];

	public ItemBasicIo() {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public CreativeTabs getCreativeTab() {
		return SpaceCore.spaceItemsTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return ClientProxy.spaceItem;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		int i = 0;

		for (String name : ItemBasicIo.names) {
			this.icons[i++] = iconRegister.registerIcon(IoCore.TEXTURE_PREFIX + name);
		}
	}

	@Override
	public IIcon getIconFromDamage(int damage) {
		if (this.icons.length > damage) {
			return this.icons[damage];
		}

		return super.getIconFromDamage(damage);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < ItemBasicIo.names.length; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		if (this.icons.length > par1ItemStack.getItemDamage()) {
			return "item." + ItemBasicIo.names[par1ItemStack.getItemDamage()];
		}

		return "unnamed";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		// if (par1ItemStack != null && par1ItemStack.getItemDamage() == 8)
		// {
		// par3List.add(SpaceUtil.translate("item.tier3.desc"));
		// }
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
}
