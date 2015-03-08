package mattparks.mods.space.hole.itemblocks;

import mattparks.mods.space.core.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBasicHole extends ItemBlock {
	private static final String[] types = new String[] { "surfaceRock", "subSurface", "rock", "cobblestone", "brick", "flameiteOre", "flameiteBlock", };

	public ItemBlockBasicHole(Block par1) {
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

		if (meta < 0 || meta >= ItemBlockBasicHole.types.length) {
			meta = 0;
		}

		return super.getUnlocalizedName() + "." + ItemBlockBasicHole.types[meta];
	}
}
