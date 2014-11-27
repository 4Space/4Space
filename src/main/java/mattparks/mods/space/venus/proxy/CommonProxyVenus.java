package mattparks.mods.space.venus.proxy;

import java.util.EnumSet;

import net.minecraft.block.Block;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxyVenus 
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

	public int getSulfurArmorRenderIndex() 
	{
		return 0;
	}

	public int getGemArmorRenderIndex() 
	{
		return 0;
	}

	public int getJetpackArmorRenderIndex() 
	{
		return 0;
	}
	
	public int getBlockRender(Block block) 
	{
		return -1;
	}

	public void tickStart(EnumSet type, Object[] tickData) 
	{
	}

}
