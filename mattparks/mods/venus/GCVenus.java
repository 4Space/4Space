package mattparks.mods.venus;

import java.io.File;

import mattparks.mods.venus.blocks.GCVenusBlock;
import mattparks.mods.venus.blocks.GCVenusBrick;
import mattparks.mods.venus.blocks.GCVenusEgg;
import mattparks.mods.venus.blocks.GCVenusGrass;
import mattparks.mods.venus.blocks.GCVenusOre;
import mattparks.mods.venus.blocks.GCVenusVurnBerryBush;
import mattparks.mods.venus.dimension.GCVenusTeleportType;
import mattparks.mods.venus.dimension.GCVenusWorldProvider;
import mattparks.mods.venus.entities.GCVenusEntityEvolvedBlaze;
import mattparks.mods.venus.entities.GCVenusEntityVenusianVillager;
import mattparks.mods.venus.event.GCVenusEvents;
import mattparks.mods.venus.items.GCVenusItems;
import mattparks.mods.venus.network.GCVenusPacketHandlerServer;
import mattparks.mods.venus.recipe.GCVenusRecipeManager;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.mars.GCMarsConfigManager;
import micdoodle8.mods.galacticraft.mars.GalacticraftMars;
import micdoodle8.mods.galacticraft.mars.blocks.GCMarsBlock;
import micdoodle8.mods.galacticraft.mars.blocks.GCMarsBlockCreeperEgg;
import micdoodle8.mods.galacticraft.mars.blocks.GCMarsBlockMachine;
import micdoodle8.mods.galacticraft.mars.blocks.GCMarsBlockSlimelingEgg;
import micdoodle8.mods.galacticraft.mars.blocks.GCMarsBlockSludge;
import micdoodle8.mods.galacticraft.mars.blocks.GCMarsBlockT2TreasureChest;
import micdoodle8.mods.galacticraft.mars.blocks.GCMarsBlockTintedGlassPane;
import micdoodle8.mods.galacticraft.mars.blocks.GCMarsBlockVine;
import micdoodle8.mods.galacticraft.mars.blocks.GCMarsBlocks;
import micdoodle8.mods.galacticraft.mars.items.GCMarsItemBlock;
import micdoodle8.mods.galacticraft.mars.items.GCMarsItemBlockMachine;
import micdoodle8.mods.galacticraft.mars.items.GCMarsItemBlockRock;
import micdoodle8.mods.galacticraft.mars.items.GCMarsItemBlockTintedGlassPane;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemBlock;
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
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(name = GCVenus.NAME, version = GCVenus.LOCALMAJVERSION + "." + GCVenus.LOCALMINVERSION + "." + GCVenus.LOCALBUILDVERSION, useMetadata = true, modid = GCVenus.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCVenus.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCVenus
{
	public static final int LOCALMAJVERSION = 2;
	public static final int LOCALMINVERSION = 0;
	public static final int LOCALBUILDVERSION = 1;
	public static int remoteMajVer;
	public static int remoteMinVer;
	public static int remoteBuildVer;
	
	public static final String NAME = "Galacticraft Venus";
	public static final String MODID = "GCVenus";
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
		new GCVenusConfigManager(new File(event.getModConfigurationDirectory(), "Galacticraft/venus.conf"));

		MinecraftForge.EVENT_BUS.register(new GCVenusEvents());
		
		GCVenusItems.initItems();

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
	        GCCoreUtil.registerGalacticraftCreature(GCVenusEntityVenusianVillager.class, "VenusianVillager", GCVenusConfigManager.idEntityVenusianVillager, GCCoreUtil.convertTo32BitColor(255, 103, 181, 145), 12422002);
	        GCCoreUtil.registerGalacticraftCreature(GCVenusEntityEvolvedBlaze.class, "EvolvedBlaze", GCVenusConfigManager.idEntityEvolvedBlaze, 44975, 7969893);
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
        GameRegistry.registerBlock(GCVenus.VenusSulfurBlock, "VenusSulfurBlock");
        GameRegistry.registerBlock(GCVenus.VenusRedGemOre, "VenusRedGemOre");
        GameRegistry.registerBlock(GCVenus.VenusMeteorOre, "VenusMeteorOre");
        GameRegistry.registerBlock(GCVenus.VenusSulfurOre, "VenusSulfurOre");
        GameRegistry.registerBlock(GCVenus.VenusIronOre, "VenusIronOre");
        GameRegistry.registerBlock(GCVenus.VenusCoalOre, "VenusCoalOre");
        GameRegistry.registerBlock(GCVenus.VenusTinOre, "VenusTinOre");
        GameRegistry.registerBlock(GCVenus.VenusCopperOre, "VenusCopperOre");
        GameRegistry.registerBlock(GCVenus.VenusGoldOre, "VenusGoldOre");
        GameRegistry.registerBlock(GCVenus.EvolvedBlazeEgg, "EvolvedBlazeEgg");
        GameRegistry.registerBlock(GCVenus.VenusCrystalOre, "VenusCrystalOre");
        GameRegistry.registerBlock(GCVenus.FossilizedPlantOre, "FossilizedPlantOre");
	}

	//TODO: Create configurable ID's
	
	public static final Block VenusGrass = new GCVenusGrass(760, null).setHardness(0.4F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusGrass").setTextureName("galacticraftvenus:grassVenus").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusDirt = new GCVenusBlock(761, null).setHardness(0.3F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusDirt").setTextureName("galacticraftvenus:dirtVenus").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusStone = new GCVenusBlock(762, null).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusStone").setTextureName("galacticraftvenus:stoneVenus").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusBrick = new GCVenusBrick(763, null).setHardness(99999.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusBrick").setTextureName("galacticraftvenus:venusBrick").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block EvolvedBlazeEgg = new GCVenusEgg(764, 0, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("EvolvedBlazeEgg").setTextureName("galacticraftvenus:evolvedBlazeEgg").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusRedGemBlock = new GCVenusBlock(765, null).setHardness(2.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusGemBlock").setTextureName("galacticraftvenus:gemBlock").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusMeteorBlock = new GCVenusBlock(766, null).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusMeteorBlock").setTextureName("galacticraftvenus:meteorBlock").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusSulfurBlock = new GCVenusOre(767, null).setHardness(2.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusSulfurBlock").setTextureName("galacticraftvenus:sulfurBlock").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusSulfurOre = new GCVenusOre(768, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusSulfurOre").setTextureName("galacticraftvenus:sulfurOre").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusMeteorOre = new GCVenusOre(769, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusMeteorOre").setTextureName("galacticraftvenus:meteorOre").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusRedGemOre = new GCVenusOre(770, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusGemOre").setTextureName("galacticraftvenus:gemOre").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusIronOre = new GCVenusOre(771, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusIronOre").setTextureName("galacticraftvenus:ironOre").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusCoalOre = new GCVenusOre(772, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusCoalOre").setTextureName("galacticraftvenus:coalOre").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusTinOre = new GCVenusOre(773, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusTinOre").setTextureName("galacticraftvenus:tinOre").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VenusCopperOre = new GCVenusOre(774, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusCopperOre").setTextureName("galacticraftvenus:copperOre").setCreativeTab(GCVenus.galacticraftVenusTab);

    public static final Block VenusCrystalOre = new GCVenusOre(775, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusCrystalOre").setTextureName("galacticraftvenus:venusCrystalOre").setCreativeTab(GCVenus.galacticraftVenusTab);
    
    public static final Block VenusGoldOre = new GCVenusOre(776, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VenusGoldOre").setTextureName("galacticraftvenus:goldOre").setCreativeTab(GCVenus.galacticraftVenusTab);
    
    public static final Block FossilizedPlantOre = new GCVenusOre(777, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("FossilizedPlantOre").setTextureName("galacticraftvenus:fossilizedPlantOre").setCreativeTab(GCVenus.galacticraftVenusTab);

	public static final Block VurnBerryBush = new GCVenusVurnBerryBush(778).setHardness(0.25F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("VurnBerryBush").setTextureName("galacticraftvenus:VurnBerryBush").setCreativeTab(GCVenus.galacticraftVenusTab);
}
