package mattparks.mods.space.core;

import java.io.File;

import mattparks.mods.MattparksCore.*;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(name = SpaceCore.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION + "-" + Version.LOCALGITVERSION, useMetadata = true, modid = SpaceCore.MODID, dependencies = "required-after:" + MattCore.MODID + ";")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class SpaceCore
{
	public static final String NAME = "Space Core";
	public static final String MODID = "SpaceCore";
	public static final String CHANNEL = "SpaceCore";
	public static final String CHANNELENTITIES = "SpaceCoreEntities";

	@SidedProxy(clientSide = "mattparks.mods.space.core.ClientProxy", serverSide = "mattparks.mods.space.core.CommonProxy")
	public static CommonProxy proxy;

	@Instance(SpaceCore.MODID)
	public static SpaceCore instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		new ConfigManager(new File(event.getModConfigurationDirectory(), "Galacticraft/mattparks.conf"));
		
		SpaceCore.proxy.preInit(event);
	}

    @EventHandler
    public void init (FMLInitializationEvent event)
    {
    	;
    }
    
	@EventHandler
	public void serverInit(FMLServerStartedEvent event)
	{
		;
	}

	@EventHandler
	public void postLoad(FMLPostInitializationEvent event)
	{
		SpaceCore.proxy.postInit(event);
		SpaceCore.proxy.registerRenderInformation();
	}

	public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
	{
		EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
		EntityRegistry.registerModEntity(var0, var1, id, SpaceCore.instance, 80, 3, true);
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
		SpaceCore.proxy.init(event);
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

}
