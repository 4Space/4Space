package mattparks.mods.space.jupiter;

import mattparks.mods.MattparksCore.Version;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
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

@Mod(name = GCJupiter.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION + "-" + Version.LOCALGITVERSION, useMetadata = true, modid = GCJupiter.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCJupiter.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCJupiter
{
	public static final String NAME = "Galacticraft Jupiter";
	public static final String MODID = "GCJupiter";
	public static final String CHANNEL = "GCJupiter";
	public static final String CHANNELENTITIES = "GCJupiterEntities";

	public static GCJupiterPlanet jupiter;
	
	public static final String LANGUAGE_PATH = "/assets/galacticraftjupiter/lang/";

	@SidedProxy(clientSide = "mattparks.mods.space.jupiter.client.ClientProxyJupiter", serverSide = "mattparks.mods.space.jupiter.CommonProxyJupiter")
	public static CommonProxyJupiter proxy;

	@Instance(GCJupiter.MODID)
	public static GCJupiter instance;

	public static final String TEXTURE_DOMAIN = "galacticraftjupiter";
	public static final String TEXTURE_PREFIX = GCJupiter.TEXTURE_DOMAIN + ":";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		GCJupiter.proxy.preInit(event);
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
		GCJupiter.proxy.postInit(event);
		GCJupiter.proxy.registerRenderInformation();
	}

	public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
	{
		EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
		EntityRegistry.registerModEntity(var0, var1, id, GCJupiter.instance, 80, 3, true);
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
		GCJupiter.proxy.init(event);

        GalacticraftRegistry.registerCelestialBody(new GCJupiterPlanet());
	}
}
