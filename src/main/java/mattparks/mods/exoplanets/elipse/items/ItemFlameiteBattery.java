package mattparks.mods.exoplanets.elipse.items;

import mattparks.mods.exoplanets.elipse.ElipseCore;
import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.proxy.ClientProxy;
import micdoodle8.mods.galacticraft.core.energy.item.ItemElectricBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlameiteBattery extends ItemElectricBase {
	public ItemFlameiteBattery(String assetName) {
		super();
		this.setUnlocalizedName(assetName);
		this.setTextureName(ElipseCore.TEXTURE_PREFIX + assetName);
	}

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
	public float getMaxElectricityStored(ItemStack itemStack) {
		return 19200;
	}
}
