package mattparks.mods.MattparksCore;

import java.util.EnumSet;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy
{
    @Override
    public void init(FMLInitializationEvent event)
    {
        TickRegistry.registerTickHandler(new TickHandlerClient(), Side.CLIENT);
    }

	public static class TickHandlerClient implements ITickHandler
	{
		@Override
		public String getLabel()
		{
			return "Mattparks Core Client";
		}

		@Override
		public EnumSet<TickType> ticks()
		{
			return EnumSet.of(TickType.CLIENT);
		}

		@Override
		public void tickStart(EnumSet<TickType> type, Object... tickData) 
		{
			;
		}

		@Override
		public void tickEnd(EnumSet<TickType> type, Object... tickData) 
		{
			;
		}
	}
}