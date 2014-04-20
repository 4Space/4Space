package mattparks.mods.venus;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="GCVenus", name="GCVenus", version="2.0.0", dependencies = "required-after:GalacticraftCore;")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class GCVenus 
{
	
	public static String ASSET_DOMAIN = "galacticraftvenus";
	
	public static GCPlanetVenus venus;

        @Instance("GCVenus")
        public static GCVenus instance;

        public static CommonProxyVenus proxy;
       
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) 
        {
        	GCVenus.venus = new GCPlanetVenus();
        	GalacticraftRegistry.registerCelestialBody(GCVenus.venus);
        }
       
        @EventHandler
        public void load(FMLInitializationEvent event) 
        {
        	;
        }
       
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) 
        {
        	;
        }  
}
