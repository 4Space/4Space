package mattparks.mods.space.uranus;

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

@Mod(name = GCUranus.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = GCUranus.MODID, dependencies = "required-after:" + SpaceCore.MODID + ";")
@NetworkMod(channels = { GCUranus.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCUranus
{
	public static final String NAME = "Galacticraft Uranus";
	public static final String MODID = "GCUranus";
	public static final String CHANNEL = "GCUranus";
	public static final String CHANNELENTITIES = "GCUranusEntities";

	public static GCUranusPlanet uranus;
	
	public static final String LANGUAGE_PATH = "/assets/galacticrafturanus/lang/";

	@SidedProxy(clientSide = "mattparks.mods.space.uranus.client.ClientProxyUranus", serverSide = "mattparks.mods.space.uranus.CommonProxyUranus")
	public static CommonProxyUranus proxy;

	@Instance(GCUranus.MODID)
	public static GCUranus instance;

	public static final String TEXTURE_DOMAIN = "galacticrafturanus";
	public static final String TEXTURE_PREFIX = GCUranus.TEXTURE_DOMAIN + ":";

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		this.registerTileEntities();
		this.registerCreatures();
		this.registerOtherEntities();
		GCUranus.proxy.init(event);

        GalacticraftRegistry.registerCelestialBody(new GCUranusPlanet());
	}

	@EventHandler
	public void postLoad(FMLPostInitializationEvent event)
	{
		GCUranus.proxy.postInit(event);
		GCUranus.proxy.registerRenderInformation();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		GCUranus.proxy.preInit(event);
	}

	public void registerCreatures()
	{
		;
	}

	public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
	{
		EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
		EntityRegistry.registerModEntity(var0, var1, id, GCUranus.instance, 80, 3, true);
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
