package mattparks.mods.venus;

import java.io.File;

import mattparks.mods.venus.blocks.GCVenusBlock;
import mattparks.mods.venus.blocks.GCVenusEgg;
import mattparks.mods.venus.blocks.GCVenusGrass;
import mattparks.mods.venus.blocks.GCVenusStone;
import mattparks.mods.venus.dimension.GCVenusTeleportType;
import mattparks.mods.venus.dimension.GCVenusWorldProvider;
import mattparks.mods.venus.items.VenusItems;
import mattparks.mods.venus.network.GCVenusPacketHandlerServer;
import mattparks.mods.venus.recipe.GCVenusRecipeManager;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;
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
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(name = GCVenus.NAME, version = GalacticraftCore.LOCALMAJVERSION + "." + GalacticraftCore.LOCALMINVERSION + "." + GalacticraftCore.LOCALBUILDVERSION, useMetadata = true, modid = GCVenus.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCVenus.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCVenus
{
	public static final String NAME = "Galacticraft Venus";
	public static final String MODID = "GalacticraftVenus";
	public static final String CHANNEL = "GCVenus";
	public static final String CHANNELENTITIES = "GCVenusEntities";

	public static final String LANGUAGE_PATH = "/assets/galacticraftvenus/lang/";

	@SidedProxy(clientSide = "mattparks.mods.venus.client.ClientProxyVenus", serverSide = "mattparks.mods.venus.CommonProxyVenus")
	public static CommonProxyVenus proxy;

	@Instance(GCVenus.MODID)
	public static GCVenus instance;

	public static CreativeTabs galacticraftVenusTab = new CreativeTabs("galacticraftVenusTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(Block.dirt, 1, 0);
		}
	};

	public static final String TEXTURE_DOMAIN = "galacticraftvenus";
	public static final String TEXTURE_PREFIX = GCVenus.TEXTURE_DOMAIN + ":";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		new GCVenusConfigManager(new File(event.getModConfigurationDirectory(), "Galacticraft/Venus.conf"));

		VenusItems.initItems();

		GCVenus.proxy.preInit(event);
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event)
	{
		NetworkRegistry.instance().registerChannel(new GCVenusPacketHandlerServer(), GCVenus.CHANNEL, Side.SERVER);
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
		GCVenus.proxy.postInit(event);
		GCVenus.proxy.registerRenderInformation();
		GCVenusRecipeManager.loadRecipes();
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

        GameRegistry.registerBlock(GCVenus.VenusGrass, "VenusGrass");
        GameRegistry.registerBlock(GCVenus.VenusDirt, "VenusDirt");
        GameRegistry.registerBlock(GCVenus.VenusStone, "VenusStone");
        GameRegistry.registerBlock(GCVenus.VenusCobblestone, "VenusCobblestone");
        GameRegistry.registerBlock(GCVenus.VenusBrick, "VenusBrick");
        GameRegistry.registerBlock(GCVenus.EvolvedBlazeEgg, "EvolvedBlazeEgg");
	}
	
	public static final Block VenusGrass = new GCVenusGrass(760, null).setHardness(0.4F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusGrass").setTextureName("galacticraftvenus:grassVenus").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusDirt = new GCVenusBlock(761, null).setHardness(0.3F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusDirt").setTextureName("galacticraftvenus:dirtVenus").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusStone = new GCVenusStone(762, null).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusStone").setTextureName("galacticraftvenus:stoneVenus").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusCobblestone = new GCVenusBlock(763, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusCobblestone").setTextureName("galacticraftvenus:cobblestoneVenus").setCreativeTab(GCVenus.galacticraftVenusTab);


	public static final Block VenusBrick = new GCVenusBlock(772, null).setHardness(15.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusBrick").setTextureName("galacticraftvenus:venusBrick").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block EvolvedBlazeEgg = new GCVenusEgg(784, 0, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("EvolvedBlazeEgg").setTextureName("galacticraftvenus:evolvedBlazeEgg").setCreativeTab(GCVenus.galacticraftVenusTab);
}
