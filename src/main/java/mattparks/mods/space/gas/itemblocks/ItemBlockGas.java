package mattparks.mods.space.gas.itemblocks;

import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockGas extends ItemBlock
{
	private static final String[] types = new String[] {
		"surfaceRock",
		"subSurface",
		"rock",
		"cobblestone",
		"iridium",
		"meteor",
		"tin",
		"copper",
		"gold",
		"iridiumBlock",
		"meteorBlock",
		"dungeonBrick"
	};

	public ItemBlockGas(Block par1)
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
		if (meta < 0 || meta >= ItemBlockGas.types.length)
		{
			meta = 0;
		}
		return super.getUnlocalizedName() + "." + ItemBlockGas.types[meta];
	}
}