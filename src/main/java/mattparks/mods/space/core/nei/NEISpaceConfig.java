package mattparks.mods.space.core.nei;

import mattparks.mods.space.core.Constants;
import mattparks.mods.space.mercury.blocks.MercuryBlocks;
import net.minecraft.item.ItemStack;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEISpaceConfig implements IConfigureNEI
{
	@Override
	public void loadConfig()
	{
		this.registerRecipe();
	}

	@Override
	public String getName()
	{
		return "4Space NEI Plugin";
	}

	@Override
	public String getVersion()
	{
		return Constants.VERSION;
	}

	public void registerRecipe()
	{
		this.registerHideBlocks();
	}

	private void registerHideBlocks()
	{
		API.hideItem(new ItemStack(MercuryBlocks.caravanModuleDummy, 1, 0));
	}
}
