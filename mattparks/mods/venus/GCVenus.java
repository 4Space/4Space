package mattparks.mods.venus;

import java.io.File;

import mattparks.mods.venus.blocks.*;
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
	public static final String MODID = "galacticraftvenus";
	public static final String CHANNEL = "GCVenus";
	public static final String CHANNELENTITIES = "GCVenusEntities";

	public static final String LANGUAGE_PATH = "/assets/galacticraftvenus/lang/";

	@SidedProxy(clientSide = "mattparks.mods.venus.client.ClientProxyVenus", serverSide = "mattparks.mods.venus.CommonProxyVenus")
	public static CommonProxyVenus proxy;

    public static long tick;
    public static long slowTick;
    
	@Instance(GCVenus.MODID)
	public static GCVenus instance;

	public static CreativeTabs galacticraftVenusTab = new CreativeTabs("galacticraftVenusTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(GCVenus.EvolvedBlazeEgg, 1, 0);
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
        GameRegistry.registerBlock(GCVenus.VenusRedGemBlock, "VenusRedGemBlock");
        GameRegistry.registerBlock(GCVenus.VenusMeteorBlock, "VenusMeteorBlock");
        GameRegistry.registerBlock(GCVenus.VenusBrick, "VenusBrick");
        GameRegistry.registerBlock(GCVenus.VenusSulferBlock, "VenusSulferBlock");
        GameRegistry.registerBlock(GCVenus.VenusRedGemOre, "VenusRedGemOre");
        GameRegistry.registerBlock(GCVenus.VenusMeteorOre, "VenusMeteorOre");
        GameRegistry.registerBlock(GCVenus.VenusSulferOre, "VenusSulferOre");
        GameRegistry.registerBlock(GCVenus.VenusIronOre, "VenusIronOre");
        GameRegistry.registerBlock(GCVenus.VenusCoalOre, "VenusCoalOre");
        GameRegistry.registerBlock(GCVenus.VenusTinOre, "VenusTinOre");
        GameRegistry.registerBlock(GCVenus.VenusCopperOre, "VenusCopperOre");
//        GameRegistry.registerBlock(GCVenus.VenusianTNT, "VenusianTNT");
        GameRegistry.registerBlock(GCVenus.EvolvedBlazeEgg, "EvolvedBlazeEgg");
        GameRegistry.registerBlock(GCVenus.VenusCrystalOre, "VenusCrystalOre");
        GameRegistry.registerBlock(GCVenus.FossilizedPlantOre, "FossilizedPlantOre");
	}
	
	public static final Block VenusGrass = new GCVenusGrass(760, null).setHardness(0.4F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusGrass").setTextureName("galacticraftvenus:grassVenus").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusDirt = new GCVenusBlock(761, null).setHardness(0.3F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusDirt").setTextureName("galacticraftvenus:dirtVenus").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusStone = new GCVenusBlock(762, null).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusStone").setTextureName("galacticraftvenus:stoneVenus").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusBrick = new GCVenusBlock(764, null).setHardness(15.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusBrick").setTextureName("galacticraftvenus:venusBrick").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block EvolvedBlazeEgg = new GCVenusEgg(765, 0, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("EvolvedBlazeEgg").setTextureName("galacticraftvenus:evolvedBlazeEgg").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusRedGemBlock = new GCVenusBlock(766, null).setHardness(2.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusGem").setTextureName("galacticraftvenus:gemBlock").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusMeteorBlock = new GCVenusBlock(767, null).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusMeteor").setTextureName("galacticraftvenus:meteorBlock").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusSulferBlock = new GCVenusOre(768, null).setHardness(2.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusSulfer").setTextureName("galacticraftvenus:sulferBlock").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusSulferOre = new GCVenusOre(769, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusSulferOre").setTextureName("galacticraftvenus:sulferOre").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusMeteorOre = new GCVenusOre(770, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusMeteorOre").setTextureName("galacticraftvenus:meteorOre").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusRedGemOre = new GCVenusOre(771, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusGemOre").setTextureName("galacticraftvenus:gemOre").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusIronOre = new GCVenusOre(772, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusIronOre").setTextureName("galacticraftvenus:ironOre").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusCoalOre = new GCVenusOre(773, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusCoalOre").setTextureName("galacticraftvenus:coalOre").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusTinOre = new GCVenusOre(774, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusTinOre").setTextureName("galacticraftvenus:tinOre").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusCopperOre = new GCVenusOre(775, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusCopperOre").setTextureName("galacticraftvenus:copperOre").setCreativeTab(GCVenus.galacticraftVenusTab);

    public static final Block VenusCrystalOre = new GCVenusOre(776, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusCrystalOre").setTextureName("galacticraftvenus:venusCrystalOre").setCreativeTab(GCVenus.galacticraftVenusTab);
    
    public static final Block FossilizedPlantOre = new GCVenusOre(777, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("FossilizedPlantOre").setTextureName("galacticraftvenus:fossilizedPlantOre").setCreativeTab(GCVenus.galacticraftVenusTab);

//	public static final Block VenusianTNT = new GCVenusVenusianTNT(778, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusianTNT").setTextureName("galacticraftvenus:venusianTNT").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VurnBerryBush = new GCVenusVurnBerryBush(779).setHardness(0.25F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VurnBerryBush").setTextureName("galacticraftvenus:VurnBerryBush").setCreativeTab(GCVenus.galacticraftVenusTab);

}
