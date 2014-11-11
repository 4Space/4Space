package mattparks.mods.space.venus.items;

import mattparks.mods.space.core.SpaceCore;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGemArmor extends ItemArmor
{
	private final ArmorMaterial material;

	public ItemGemArmor(String name, ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.material = par2EnumArmorMaterial;
		this.setUnlocalizedName(name);
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer)
	{
		if (this.material == VenusItems.ARMOR_GEM)
		{
			if (stack.getItem() == VenusItems.gemHelmet)
			{
				return "textures/model/armor/gem_1.png";
			}
			else if (stack.getItem() == VenusItems.gemChestplate || stack.getItem() == VenusItems.gemBoots)
			{
				return "textures/model/armor/gem_2.png";
			}
			else if (stack.getItem() == VenusItems.gemLeggings)
			{
				return "textures/model/armor/gem_3.png";
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
		this.itemIcon = par1IconRegister.registerIcon(this.getUnlocalizedName().replace("item.", "galacticraftvenus:"));
	}

	@Override
	public Item setUnlocalizedName(String par1Str)
	{
		super.setTextureName(par1Str);
		super.setUnlocalizedName(par1Str);
		return this;
	}
}
