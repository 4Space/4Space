package mattparks.mods.space.saturn;

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

@Mod(name = GCSaturn.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = GCSaturn.MODID, dependencies = "required-after:" + SpaceCore.MODID + ";")
@NetworkMod(channels = { GCSaturn.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCSaturn
{
	public static final String NAME = "Galacticraft Saturn";
	public static final String MODID = "GCSaturn";
	public static final String CHANNEL = "GCSaturn";
	public static final String CHANNELENTITIES = "GCSaturnEntities";

	public static GCSaturnPlanet saturn;
	
	public static final String LANGUAGE_PATH = "/assets/galacticraftsaturn/lang/";

	@SidedProxy(clientSide = "mattparks.mods.space.saturn.client.ClientProxySaturn", serverSide = "mattparks.mods.space.saturn.CommonProxySaturn")
	public static CommonProxySaturn proxy;

	@Instance(GCSaturn.MODID)
	public static GCSaturn instance;

	public static final String TEXTURE_DOMAIN = "galacticraftsaturn";
	public static final String TEXTURE_PREFIX = GCSaturn.TEXTURE_DOMAIN + ":";

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		this.registerTileEntities();
		this.registerCreatures();
		this.registerOtherEntities();
		GCSaturn.proxy.init(event);

        GalacticraftRegistry.registerCelestialBody(new GCSaturnPlanet());
	}

	@EventHandler
	public void postLoad(FMLPostInitializationEvent event)
	{
		GCSaturn.proxy.postInit(event);
		GCSaturn.proxy.registerRenderInformation();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		GCSaturn.proxy.preInit(event);
	}

	public void registerCreatures()
	{
		;
	}

	public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
	{
		EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
		EntityRegistry.registerModEntity(var0, var1, id, GCSaturn.instance, 80, 3, true);
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
