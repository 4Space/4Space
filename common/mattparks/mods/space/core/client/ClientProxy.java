package mattparks.mods.space.core.client;

import java.util.EnumSet;

import mattparks.mods.space.core.CommonProxy;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy
{
    public static class TickHandlerClient implements ITickHandler
	{
		@Override
		public String getLabel()
		{
			return "4-Space Core Client";
		}

		@Override
		public void tickEnd(EnumSet<TickType> type, Object... tickData) 
		{
		}

		@Override
		public EnumSet<TickType> ticks()
		{
			return EnumSet.of(TickType.CLIENT);
		}

		@Override
		public void tickStart(EnumSet<TickType> type, Object... tickData) 
		{
		}
	}

	public static void registerHandlers()
	{
		TickRegistry.registerTickHandler(new TickHandlerClient(), Side.CLIENT);
	}

	@Override
    public void init(FMLInitializationEvent event)
    {
        TickRegistry.registerTickHandler(new TickHandlerClient(), Side.CLIENT);
    }
}