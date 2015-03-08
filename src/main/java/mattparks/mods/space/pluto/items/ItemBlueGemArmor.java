package mattparks.mods.space.pluto.items;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.proxy.ClientProxy;
import mattparks.mods.space.pluto.PlutoCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlueGemArmor extends ItemArmor {
	private final ArmorMaterial material;

	public ItemBlueGemArmor(String name, ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
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
		if (this.material == PlutoItems.ARMOR_BLUEGEM) {
			if (stack.getItem() == PlutoItems.blueGemHelmet) {
				return PlutoCore.TEXTURE_PREFIX + "textures/model/armor/blueGem_1.png";
			} else if (stack.getItem() == PlutoItems.blueGemChestplate || stack.getItem() == PlutoItems.blueGemBoots) {
				return PlutoCore.TEXTURE_PREFIX + "textures/model/armor/blueGem_2.png";
			} else if (stack.getItem() == PlutoItems.blueGemLeggings) {
				return PlutoCore.TEXTURE_PREFIX + "textures/model/armor/blueGem_3.png";
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
		this.itemIcon = par1IconRegister.registerIcon(this.getUnlocalizedName().replace("item.", PlutoCore.TEXTURE_PREFIX));
	}

	@Override
	public Item setUnlocalizedName(String par1Str) {
		super.setTextureName(par1Str);
		super.setUnlocalizedName(par1Str);
		return this;
	}
}
