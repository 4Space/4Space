package mattparks.mods.space.venus.blocks.items;

import mattparks.mods.space.core.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockDecorVenus extends ItemBlock {
	private static final String[] types = new String[] { 
		"sulfurBlock", 
		"uraniumBlock", 
		"rubyBlock", 
		"crystalBlock", 
	};

	public ItemBlockDecorVenus(Block par1) {
		super(par1);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta) {
		return meta;
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return ClientProxy.spaceItem;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		int meta = itemstack.getItemDamage();

		if (meta < 0 || meta >= ItemBlockDecorVenus.types.length) {
			meta = 0;
		}

		return super.getUnlocalizedName() + "." + ItemBlockDecorVenus.types[meta];
	}
}
