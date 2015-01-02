package mattparks.mods.space.hole.proxy;

import net.minecraft.block.Block;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxyHole
{
	public void preInit(FMLPreInitializationEvent event)
	{
	}

	public void init(FMLInitializationEvent event)
	{
	}

	public void postInit(FMLPostInitializationEvent event)
	{
	}

	public void registerRenderInfo()
	{
	}

	public int getBlockRender(Block block)
	{
		return -1;
	}

	public int getFlameiteArmorRenderIndex()
	{
		return 0;
	}
}
