package mattparks.mods.space.mercury.items;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.proxy.ClientProxy;
import mattparks.mods.space.mercury.MercuryCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemAxeMercury extends ItemAxe {
	public ItemAxeMercury(String name, ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setUnlocalizedName(name);
	}

	@Override
	public CreativeTabs getCreativeTab() {
		return SpaceCore.spaceItemsTab;
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return ClientProxy.spaceItem;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(this.getUnlocalizedName().replace("item.", MercuryCore.TEXTURE_PREFIX));
	}
}
