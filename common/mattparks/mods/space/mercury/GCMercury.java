package mattparks.mods.space.mercury;

import java.util.Random;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.util.Version;
import mattparks.mods.space.mercury.blocks.MercuryBlocks;
import mattparks.mods.space.mercury.dimension.GCMercuryTeleportType;
import mattparks.mods.space.mercury.dimension.GCMercuryWorldProvider;
import mattparks.mods.space.mercury.items.GCMercuryItems;
import mattparks.mods.space.mercury.recipe.GCMercuryRecipeManager;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.core.items.GCCoreItems;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
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

@Mod(name = GCMercury.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = GCMercury.MODID, dependencies = "required-after:" + SpaceCore.MODID + ";")
@NetworkMod(channels = { GCMercury.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCMercury
{
	public static final String NAME = "Galacticraft Mercury";
	public static final String MODID = "GCMercury";
	public static final String CHANNEL = "GCMercury";
	public static final String CHANNELENTITIES = "GCMercuryEntities";

	public static final String LANGUAGE_PATH = "/assets/galacticraftmercury/lang/";

	@SidedProxy(clientSide = "mattparks.mods.space.mercury.client.ClientProxyMercury", serverSide = "mattparks.mods.space.mercury.CommonProxyMercury")
	public static CommonProxyMercury proxy;

	@Instance(GCMercury.MODID)
	public static GCMercury instance;

	public static CreativeTabs galacticraftMercuryTab = new CreativeTabs("galacticraftMercuryTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(MercuryBlocks.MercuryStone, 1, 0);
		}
	};

	public static final String TEXTURE_DOMAIN = "galacticraftmercury";
	public static final String TEXTURE_PREFIX = GCMercury.TEXTURE_DOMAIN + ":";

	public static Random rand = new Random();
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		this.registerTileEntities();
		this.registerCreatures();
		this.registerOtherEntities();
		GCMercury.proxy.init(event);
		
        GalacticraftRegistry.registerTeleportType(GCMercuryWorldProvider.class, new GCMercuryTeleportType());
        GalacticraftRegistry.registerCelestialBody(new GCMercuryPlanet());
        GalacticraftRegistry.registerRocketGui(GCMercuryWorldProvider.class, new ResourceLocation(GCMercury.TEXTURE_DOMAIN, "textures/gui/mercuryRocketGui.png"));
	}

	@EventHandler
	public void postLoad(FMLPostInitializationEvent event)
	{
		GCMercury.proxy.postInit(event);
		GCMercury.proxy.registerRenderInformation();
		GCMercuryRecipeManager.loadRecipes();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new GCMercuryEvents());
		
		GCMercuryItems.initItems();
		
		MercuryBlocks.initBlocks();
		MercuryBlocks.registerBlocks();
		MercuryBlocks.setHarvestLevels();

		GCMercury.proxy.preInit(event);
		
		CompressorRecipes.addShapelessRecipe(new ItemStack(GCMercuryItems.mercuryItemBasic, 1, 2), new ItemStack(GCMercuryItems.mercuryItemBasic, 1, 0));
		
		CompressorRecipes.addRecipe(new ItemStack(GCMercuryItems.mercuryItemBasic, 1, 1), "SUS", 'S', new ItemStack(GCMercuryItems.mercuryItemBasic, 1, 2), 'U', new ItemStack(GCCoreItems.meteoricIronIngot, 1, 1));

	}

	public void registerCreatures()
	{
		;
	}

	public void registerGalacticraftCreature(Class<? extends Entity> var0, String var1, int id, int back, int fore)
	{
		EntityRegistry.registerGlobalEntityID(var0, var1, id, back, fore);
		EntityRegistry.registerModEntity(var0, var1, id, GCMercury.instance, 80, 3, true);
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
