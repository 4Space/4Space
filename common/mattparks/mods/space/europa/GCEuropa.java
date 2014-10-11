package mattparks.mods.space.europa;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.util.Version;
import mattparks.mods.space.europa.blocks.EuropaBlocks;
import mattparks.mods.space.europa.dimension.GCEuropaTeleportType;
import mattparks.mods.space.europa.dimension.GCEuropaWorldProvider;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
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
import cpw.mods.fml.common.registry.EntityRegistry;

@Mod(name = GCEuropa.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = GCEuropa.MODID, dependencies = "required-after:" + SpaceCore.MODID + ";")
@NetworkMod(channels = { GCEuropa.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCEuropa
{
	public static final String NAME = "Galacticraft Europa";
	public static final String MODID = "GCEuropa";
	public static final String CHANNEL = "GCEuropa";
	public static final String CHANNELENTITIES = "GCEuropaEntities";

	public static final String LANGUAGE_PATH = "/assets/galacticrafteuropa/lang/";

	@SidedProxy(clientSide = "mattparks.mods.space.europa.client.ClientProxyEuropa", serverSide = "mattparks.mods.space.europa.CommonProxyEuropa")
	public static CommonProxyEuropa proxy;

	@Instance(GCEuropa.MODID)
	public static GCEuropa instance;

	public static final String TEXTURE_DOMAIN = "galacticrafteuropa";
	public static final String TEXTURE_PREFIX = GCEuropa.TEXTURE_DOMAIN + ":";

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		this.registerTileEntities();
		this.registerCreatures();
		this.registerOtherEntities();
		GCEuropa.proxy.init(event);
		
        GalacticraftRegistry.registerTeleportType(GCEuropaWorldProvider.class, new GCEuropaTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCEuropaPlanet());
        GalacticraftRegistry.registerRocketGui(GCEuropaWorldProvider.class, new ResourceLocation(GCEuropa.TEXTURE_DOMAIN, "textures/gui/europaRocketGui.png"));
   	}

	@EventHandler
	public void postLoad(FMLPostInitializationEvent event)
	{
		GCEuropa.proxy.postInit(event);
		GCEuropa.proxy.registerRenderInformation();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		EuropaBlocks.initBlocks();
		EuropaBlocks.registerBlocks();
		EuropaBlocks.setHarvestLevels();
		
		GCEuropa.proxy.preInit(event);
	}

	public void registerCreatures()
	{
		;
	}

	public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
	{
		EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
		EntityRegistry.registerModEntity(var0, var1, id, GCEuropa.instance, 80, 3, true);
	}

	public void registerGalacticraftNonMobEntity(Class<? extends Entity> var0, String var1, int id, int trackingDistance, int updateFreq, boolean sendVel)
	{
		EntityList.addMapping(var0, var1, id);
		EntityRegistry.registerModEntity(var0, var1, id, this, trackingDistance, updateFreq, sendVel);
	}

	public void registerOtherEntities()
	{
		;
	}

	public void registerTileEntities()
	{
		;
	}
	
	@EventHandler
	public void serverStarting(FMLServerStartingEvent event)
	{
		;
	}
}
