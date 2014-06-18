package mattparks.mods.space.io;

import mattparks.mods.MattparksCore.Version;
import mattparks.mods.space.io.blocks.IoBlocks;
import mattparks.mods.space.io.dimension.GCIoTeleportType;
import mattparks.mods.space.io.dimension.GCIoWorldProvider;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(name = GCIo.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION + "-" + Version.LOCALGITVERSION, useMetadata = true, modid = GCIo.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCIo.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCIo
{
	public static final String NAME = "Galacticraft Io";
	public static final String MODID = "GCIo";
	public static final String CHANNEL = "GCIo";
	public static final String CHANNELENTITIES = "GCIoEntities";

	public static final String LANGUAGE_PATH = "/assets/galacticraftio/lang/";

	@SidedProxy(clientSide = "mattparks.mods.space.io.client.ClientProxyIo", serverSide = "mattparks.mods.space.io.CommonProxyIo")
	public static CommonProxyIo proxy;

	@Instance(GCIo.MODID)
	public static GCIo instance;

	public static final String TEXTURE_DOMAIN = "galacticraftio";
	public static final String TEXTURE_PREFIX = GCIo.TEXTURE_DOMAIN + ":";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		IoBlocks.initBlocks();
		IoBlocks.registerBlocks();
		IoBlocks.setHarvestLevels();
		
		GCIo.proxy.preInit(event);
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event)
	{
		;
	}

	public void registerTileEntities()
	{
		;
	}

	public void registerCreatures()
	{
		;
	}

	public void registerOtherEntities()
	{
		;
	}

	@EventHandler
	public void postLoad(FMLPostInitializationEvent event)
	{
		GCIo.proxy.postInit(event);
		GCIo.proxy.registerRenderInformation();
	}

	public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
	{
		EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
		EntityRegistry.registerModEntity(var0, var1, id, GCIo.instance, 80, 3, true);
	}

	public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
	{
		EntityList.addMapping(var0, var1, id);
		EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		this.registerTileEntities();
		this.registerCreatures();
		this.registerOtherEntities();
		GCIo.proxy.init(event);
		
        GalacticraftRegistry.registerTeleportType(GCIoWorldProvider.class, new GCIoTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCIoPlanet());
        GalacticraftRegistry.registerRocketGui(GCIoWorldProvider.class, new ResourceLocation(GCIo.TEXTURE_DOMAIN, "textures/gui/ioRocketGui.png"));
   	}
}
