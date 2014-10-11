package mattparks.mods.space.venus;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.util.ConfigManager;
import mattparks.mods.space.core.util.Version;
import mattparks.mods.space.venus.blocks.VenusBlocks;
import mattparks.mods.space.venus.dimension.GCVenusTeleportType;
import mattparks.mods.space.venus.dimension.GCVenusWorldProvider;
import mattparks.mods.space.venus.entities.GCVenusEntityEvolvedBlaze;
import mattparks.mods.space.venus.entities.GCVenusEntityVenusianVillager;
import mattparks.mods.space.venus.items.GCVenusItems;
import mattparks.mods.space.venus.recipe.GCVenusRecipeManager;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
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

@Mod(name = GCVenus.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = GCVenus.MODID, dependencies = "required-after:" + SpaceCore.MODID + ";")
@NetworkMod(channels = { GCVenus.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCVenus
{
	public static final String NAME = "Galacticraft Venus";
	public static final String MODID = "GCVenus";
	public static final String CHANNEL = "GCVenus";
	public static final String CHANNELENTITIES = "GCVenusEntities";

	public static final String LANGUAGE_PATH = "/assets/galacticraftvenus/lang/";

	@SidedProxy(clientSide = "mattparks.mods.space.venus.client.ClientProxyVenus", serverSide = "mattparks.mods.space.venus.CommonProxyVenus")
	public static CommonProxyVenus proxy;

    public static long tick;
    public static long slowTick;
    
	@Instance(GCVenus.MODID)
	public static GCVenus instance;

	public static CreativeTabs galacticraftVenusTab = new CreativeTabs("galacticraftVenusTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(VenusBlocks.EvolvedBlazeEgg, 1, 0);
		}
	};

	public static final String TEXTURE_DOMAIN = "galacticraftvenus";
	public static final String TEXTURE_PREFIX = GCVenus.TEXTURE_DOMAIN + ":";

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		this.registerTileEntities();
		this.registerCreatures();
		this.registerOtherEntities();
		
		
		GCVenus.proxy.init(event);
		
        GalacticraftRegistry.registerTeleportType(GCVenusWorldProvider.class, new GCVenusTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCVenusPlanet());
        GalacticraftRegistry.registerRocketGui(GCVenusWorldProvider.class, new ResourceLocation(GCVenus.TEXTURE_DOMAIN, "textures/gui/venusRocketGui.png"));
	}

	@EventHandler
	public void postLoad(FMLPostInitializationEvent event)
	{
		GCVenus.proxy.postInit(event);
		GCVenus.proxy.registerRenderInformation();
		GCVenusRecipeManager.loadRecipes();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new GCVenusEvents());
		
		GCVenusItems.initItems();
		
		VenusBlocks.initBlocks();
		VenusBlocks.registerBlocks();
		VenusBlocks.setHarvestLevels();

		GCVenus.proxy.preInit(event);
		

		CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 5), new ItemStack(GCVenusItems.venusItemBasic, 1, 1));

		CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 6), new ItemStack(GCVenusItems.venusItemBasic, 1, 2));

		CompressorRecipes.addShapelessRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 7), new ItemStack(GCVenusItems.venusItemBasic, 1, 3));

		CompressorRecipes.addRecipe(new ItemStack(GCVenusItems.venusItemBasic, 1, 8), "SUR", 'S', new ItemStack(GCVenusItems.venusItemBasic, 1, 5), 'U', new ItemStack(GCVenusItems.venusItemBasic, 1, 6), 'R', new ItemStack(GCVenusItems.venusItemBasic, 1, 7));
	}

	public void registerCreatures()
	{
	        GCCoreUtil.registerGalacticraftCreature(GCVenusEntityVenusianVillager.class, "VenusianVillager", ConfigManager.idEntityVenusianVillager, GCCoreUtil.convertTo32BitColor(255, 103, 181, 145), 16167425);
	        GCCoreUtil.registerGalacticraftCreature(GCVenusEntityEvolvedBlaze.class, "EvolvedBlaze", ConfigManager.idEntityVenusEvolvedBlaze, 16167425, 16775294);
	}

	public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
	{
		EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
		EntityRegistry.registerModEntity(var0, var1, id, GCVenus.instance, 80, 3, true);
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
