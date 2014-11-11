package mattparks.mods.space.nei;

import mattparks.mods.space.core.util.Version;
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
		return Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION;
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