package mattparks.mods.space.neptune;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.util.Version;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
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

@Mod(name = GCNeptune.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = GCNeptune.MODID, dependencies = "required-after:" + SpaceCore.MODID + ";")
@NetworkMod(channels = { GCNeptune.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCNeptune
{
	public static final String NAME = "Galacticraft Neptune";
	public static final String MODID = "GCNeptune";
	public static final String CHANNEL = "GCNeptune";
	public static final String CHANNELENTITIES = "GCNeptuneEntities";

	public static GCNeptunePlanet neptune;
	
	public static final String LANGUAGE_PATH = "/assets/galacticraftneptune/lang/";

	@SidedProxy(clientSide = "mattparks.mods.space.neptune.client.ClientProxyNeptune", serverSide = "mattparks.mods.space.neptune.CommonProxyNeptune")
	public static CommonProxyNeptune proxy;

	@Instance(GCNeptune.MODID)
	public static GCNeptune instance;

	public static final String TEXTURE_DOMAIN = "galacticraftneptune";
	public static final String TEXTURE_PREFIX = GCNeptune.TEXTURE_DOMAIN + ":";

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		this.registerTileEntities();
		this.registerCreatures();
		this.registerOtherEntities();
		GCNeptune.proxy.init(event);

        GalacticraftRegistry.registerCelestialBody(new GCNeptunePlanet());
	}

	@EventHandler
	public void postLoad(FMLPostInitializationEvent event)
	{
		GCNeptune.proxy.postInit(event);
		GCNeptune.proxy.registerRenderInformation();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		GCNeptune.proxy.preInit(event);
	}

	public void registerCreatures()
	{
		;
	}

	public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
	{
		EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
		EntityRegistry.registerModEntity(var0, var1, id, GCNeptune.instance, 80, 3, true);
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
