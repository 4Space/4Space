package mattparks.mods.space.mercury.items;

import mattparks.mods.space.core.SpaceCore;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArmorIridium extends ItemArmor
{
	private final ArmorMaterial material;

	public ItemArmorIridium(String name, ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
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
		if (this.material == MercuryItems.ARMOR_IRIDIUM)
		{
			if (stack.getItem() == MercuryItems.iridiumHelmet)
			{
				return "galacticraftmercury:textures/model/armor/iridium_1.png";
			}
			else if (stack.getItem() == MercuryItems.iridiumChestplate || stack.getItem() == MercuryItems.iridiumBoots)
			{
				return "galacticraftmercury:textures/model/armor/iridium_2.png";
			}
			else if (stack.getItem() == MercuryItems.iridiumLeggings)
			{
				return "galacticraftmercury:textures/model/armor/iridium_3.png";
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
		this.itemIcon = par1IconRegister.registerIcon(this.getUnlocalizedName().replace("item.", "galacticraftmercury:"));
	}
}