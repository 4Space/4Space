package mattparks.mods.space.callisto.itemblocks;

import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockCallisto extends ItemBlock
{
	private static final String[] types = new String[] {
		"surfaceRock",
		"subSurface",
		"rock",
		"cobblestone",
		"tin",
		"copper",
		"iron",
		"copper",
		"gold",
		"iridiumBlock",
		"meteorBlock",
		"dungeonBrick"
	};

	public ItemBlockCallisto(Block par1)
	{
		super(par1);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		int meta = itemstack.getItemDamage();
		if (meta < 0 || meta >= ItemBlockCallisto.types.length)
		{
			meta = 0;
		}
		return super.getUnlocalizedName() + "." + ItemBlockCallisto.types[meta];
	}
}