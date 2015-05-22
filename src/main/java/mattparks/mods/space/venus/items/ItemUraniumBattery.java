package mattparks.mods.space.venus.items;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.proxy.ClientProxy;
import mattparks.mods.space.venus.VenusCore;
import micdoodle8.mods.galacticraft.core.energy.item.ItemElectricBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemUraniumBattery extends ItemElectricBase {
	public ItemUraniumBattery(String assetName) {
		super();
		this.setUnlocalizedName(assetName);
		this.setTextureName(VenusCore.TEXTURE_PREFIX + assetName);
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
		return 75000;
	}
}
