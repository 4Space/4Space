package mattparks.mods.space.sedna.itemblocks;

import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockSedna extends ItemBlock
{
	private static final String[] types = new String[] {
		"surfaceRock",
		"subSurface",
		"rock",
		"cobblestone",
		"palladium",
		"palladiumBlock",
		"dungeonBrick"
	};

	public ItemBlockSedna(Block par1)
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
		if (meta < 0 || meta >= ItemBlockSedna.types.length)
		{
			meta = 0;
		}
		return super.getUnlocalizedName() + "." + ItemBlockSedna.types[meta];
	}
}