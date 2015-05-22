package mattparks.mods.space.venus.items;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.proxy.ClientProxy;
import mattparks.mods.space.venus.VenusCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRubyArmor extends ItemArmor {
	private final ArmorMaterial material;

	public ItemRubyArmor(String name, ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par2EnumArmorMaterial, par3, par4);
		this.material = par2EnumArmorMaterial;
		this.setUnlocalizedName(name);
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return ClientProxy.spaceItem;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
		if (this.material == VenusItems.ARMOR_RUBY) {
			if (stack.getItem() == VenusItems.rubyHelmet) {
				return VenusCore.TEXTURE_PREFIX + "textures/model/armor/ruby_1.png";
			} else if (stack.getItem() == VenusItems.rubyChestplate || stack.getItem() == VenusItems.rubyBoots) {
				return VenusCore.TEXTURE_PREFIX + "textures/model/armor/ruby_2.png";
			} else if (stack.getItem() == VenusItems.rubyLeggings) {
				return VenusCore.TEXTURE_PREFIX + "textures/model/armor/ruby_3.png";
			}
		}

		return null;
	}

	@Override
	public CreativeTabs getCreativeTab() {
		return SpaceCore.spaceItemsTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(this.getUnlocalizedName().replace("item.", VenusCore.TEXTURE_PREFIX));
	}

	@Override
	public Item setUnlocalizedName(String par1Str) {
		super.setTextureName(par1Str);
		super.setUnlocalizedName(par1Str);
		
		return this;
	}
}
