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

public class ItemSapphireArmor extends ItemArmor {
	private final ArmorMaterial material;

	public ItemSapphireArmor(String name, ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
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
		if (this.material == PlutoItems.ARMOR_SAPPHIRE) {
			if (stack.getItem() == PlutoItems.sapphireHelmet) {
				return PlutoCore.TEXTURE_PREFIX + "textures/model/armor/sapphire_1.png";
			} else if (stack.getItem() == PlutoItems.sapphireChestplate || stack.getItem() == PlutoItems.sapphireBoots) {
				return PlutoCore.TEXTURE_PREFIX + "textures/model/armor/sapphire_2.png";
			} else if (stack.getItem() == PlutoItems.sapphireLeggings) {
				return PlutoCore.TEXTURE_PREFIX + "textures/model/armor/sapphire_3.png";
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
