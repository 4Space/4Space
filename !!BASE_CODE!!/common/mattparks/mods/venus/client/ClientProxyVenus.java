package mattparks.mods.venus.client;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.EnumSet;

import mattparks.mods.venus.CommonProxyVenus;
import mattparks.mods.venus.dimension.GCVenusWorldProvider;
import micdoodle8.mods.galacticraft.core.client.GCCoreCloudRenderer;
import micdoodle8.mods.galacticraft.core.client.sounds.GCCoreSoundUpdaterSpaceship;
import micdoodle8.mods.galacticraft.core.util.PacketUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class ClientProxyVenus extends CommonProxyVenus
{
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		;
	}

	@Override
	public void init(FMLInitializationEvent event)
	{
		;
	}

	@Override
	public void postInit(FMLPostInitializationEvent event)
	{
		;
	}

	@Override
	public void registerRenderInformation()
	{
//		RenderingRegistry.addNewArmourRendererPrefix("armor_name");
	}

	public class ClientPacketHandler implements IPacketHandler
	{
		@Override
		public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player p)
		{
			final DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
			final int packetType = PacketUtil.readPacketID(data);
			EntityPlayer player = (EntityPlayer) p;

			if (packetType == 0)
			{
				final Class<?>[] decodeAs = { Integer.class, Integer.class, Integer.class };
				final Object[] packetReadout = PacketUtil.readPacketData(data, decodeAs);

				int entityID = 0;
				Entity entity = null;
			}
		}
	}

	public static class TickHandlerClient implements ITickHandler
	{
		@Override
		public void tickStart(EnumSet<TickType> type, Object... tickData)
		{
			final Minecraft minecraft = FMLClientHandler.instance().getClient();

			final WorldClient world = minecraft.theWorld;

			if (type.equals(EnumSet.of(TickType.CLIENT)))
			{
				if (world != null)
				{
					if (world.provider instanceof GCVenusWorldProvider)
					{
						if (world.provider.getSkyRenderer() == null)
						{
							world.provider.setSkyRenderer(new GCVenusSkyProvider());
						}

						if (world.provider.getCloudRenderer() == null)
						{
							world.provider.setCloudRenderer(new GCCoreCloudRenderer());
						}
					}
				}
			}
		}
	    

		@Override
		public void tickEnd(EnumSet<TickType> type, Object... tickData)
		{
			;
		}

		@Override
		public String getLabel()
		{
			return "Galacticraft Venus Client";
		}

		@Override
		public EnumSet<TickType> ticks()
		{
			return EnumSet.of(TickType.CLIENT);
		}
	}
}
