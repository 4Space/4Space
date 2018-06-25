package mattparks.mods.space.mercury.items;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.proxy.ClientProxy;
import mattparks.mods.space.mercury.MercuryCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemIridiumArmor extends ItemArmor {
	private final ArmorMaterial material;

	public ItemIridiumArmor(String name, ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
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
		if (this.material == MercuryItems.ARMOR_IRIDIUM) {
			if (stack.getItem() == MercuryItems.iridiumHelmet) {
				return MercuryCore.TEXTURE_PREFIX + "textures/model/armor/iridium_1.png";
			} else if (stack.getItem() == MercuryItems.iridiumChestplate || stack.getItem() == MercuryItems.iridiumBoots) {
				return MercuryCore.TEXTURE_PREFIX + "textures/model/armor/iridium_2.png";
			} else if (stack.getItem() == MercuryItems.iridiumLeggings) {
				return MercuryCore.TEXTURE_PREFIX + "textures/model/armor/iridium_3.png";
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
		this.itemIcon = par1IconRegister.registerIcon(this.getUnlocalizedName().replace("item.", MercuryCore.TEXTURE_PREFIX));
	}

	@Override
	public Item setUnlocalizedName(String par1Str) {
		super.setTextureName(par1Str);
		super.setUnlocalizedName(par1Str);
		return this;
	}
}
