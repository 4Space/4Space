package mattparks.mods.space.pluto.items;

import java.util.List;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.proxy.ClientProxy;
import mattparks.mods.space.pluto.PlutoCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBasicPluto extends Item {
	private static String[] names = { 
		"sapphire", // 0
		"ununpetiumRaw", // 1
		"ingotFrozenIron", // 2
		"sapphirePlate", // 3
		"frozenIronPlate", // 4
		"ununpetiumPlate", // 5
		"plateHeavyT6", // 6
	};
	protected IIcon[] icons = new IIcon[ItemBasicPluto.names.length];

	public ItemBasicPluto() {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@SideOnly(Side.CLIENT)
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
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		int i = 0;

		for (String name : ItemBasicPluto.names) {
			this.icons[i++] = iconRegister.registerIcon(PlutoCore.TEXTURE_PREFIX + name);
		}
	}

	@Override
	public IIcon getIconFromDamage(int damage) {
		if (this.icons.length > damage) {
			return this.icons[damage];
		}

		return super.getIconFromDamage(damage);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < ItemBasicPluto.names.length; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		if (this.icons.length > par1ItemStack.getItemDamage()) {
			return "item." + ItemBasicPluto.names[par1ItemStack.getItemDamage()];
		}

		return "unnamed";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		// if (par1ItemStack != null && par1ItemStack.getItemDamage() == 6)
		// {
		// par3List.add(SpaceUtil.translate("item.tier6.desc"));
		// }
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
}
