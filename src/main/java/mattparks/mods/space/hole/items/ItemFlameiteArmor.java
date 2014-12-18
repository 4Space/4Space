package mattparks.mods.space.hole.items;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.proxy.ClientProxy;
import mattparks.mods.space.hole.HoleCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlameiteArmor extends ItemArmor
{
	private final ArmorMaterial material;

	public ItemFlameiteArmor(String name, ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.material = par2EnumArmorMaterial;
		this.setUnlocalizedName(name);
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return ClientProxy.spaceItem;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		if (this.material == HoleItems.ARMOR_FLAMEITE)
		{
			if (stack.getItem() == HoleItems.flameiteHelmet)
			{
				return HoleCore.TEXTURE_PREFIX + "textures/model/armor/flameite_1.png";
			}
			else if (stack.getItem() == HoleItems.flameiteChestplate || stack.getItem() == HoleItems.flameiteBoots)
			{
				return HoleCore.TEXTURE_PREFIX + "textures/model/armor/flameite_2.png";
			}
			else if (stack.getItem() == HoleItems.flameiteLeggings)
			{
				return HoleCore.TEXTURE_PREFIX + "textures/model/armor/flameite_3.png";
			}
		}
		return null;
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return SpaceCore.spaceItemsTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(this.getUnlocalizedName().replace("item.", HoleCore.TEXTURE_PREFIX));
	}
}