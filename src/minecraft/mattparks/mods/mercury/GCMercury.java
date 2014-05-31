package mattparks.mods.mercury;

import java.io.File;

import mattparks.mods.MattparksCore.MattCore;
import mattparks.mods.MattparksCore.ConfigManager;
import mattparks.mods.mercury.blocks.GCMercuryBlock;
import mattparks.mods.mercury.blocks.GCMercuryBrick;
import mattparks.mods.mercury.blocks.GCMercuryGrass;
import mattparks.mods.mercury.blocks.GCMercuryOre;
import mattparks.mods.mercury.dimension.GCMercuryTeleportType;
import mattparks.mods.mercury.dimension.GCMercuryWorldProvider;
import mattparks.mods.mercury.event.GCMercuryEvents;
import mattparks.mods.mercury.items.GCMercuryItems;
import mattparks.mods.mercury.network.GCMercuryPacketHandlerServer;
import mattparks.mods.mercury.recipe.GCMercuryRecipeManager;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.GCCoreConnectionHandler;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketManager;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.block.Block;
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
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(name = GCMercury.NAME, version = MattCore.LOCALMAJVERSION + "." + MattCore.LOCALMINVERSION + "." + MattCore.LOCALBUILDVERSION, useMetadata = true, modid = GCMercury.MODID, dependencies = "required-after:" + GalacticraftCore.MODID + ";")
@NetworkMod(channels = { GCMercury.CHANNEL }, clientSideRequired = true, serverSideRequired = false, connectionHandler = GCCoreConnectionHandler.class, packetHandler = GCCorePacketManager.class)
public class GCMercury
{
	public static final String NAME = "Galacticraft Mercury";
	public static final String MODID = "GCMercury";
	public static final String CHANNEL = "GCMercury";
	public static final String CHANNELENTITIES = "GCMercuryEntities";

	public static final String LANGUAGE_PATH = "/assets/galacticraftmercury/lang/";

	@SidedProxy(clientSide = "mattparks.mods.mercury.client.ClientProxyMercury", serverSide = "mattparks.mods.mercury.CommonProxyMercury")
	public static CommonProxyMercury proxy;

	@Instance(GCMercury.MODID)
	public static GCMercury instance;

	public static CreativeTabs galacticraftMercuryTab = new CreativeTabs("galacticraftMercuryTab") {
		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(GCMercury.BlueGlowstone, 1, 0);
		}
	};

	public static final String TEXTURE_DOMAIN = "galacticraftmercury";
	public static final String TEXTURE_PREFIX = GCMercury.TEXTURE_DOMAIN + ":";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new GCMercuryEvents());
		
		GCMercuryItems.initItems();

		GCMercury.proxy.preInit(event);
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event)
	{
		NetworkRegistry.instance().registerChannel(new GCMercuryPacketHandlerServer(), GCMercury.CHANNEL, Side.SERVER);
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
		GCMercury.proxy.postInit(event);
		GCMercury.proxy.registerRenderInformation();
		GCMercuryRecipeManager.loadRecipes();
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

        GameRegistry.registerBlock(GCMercury.MercuryGrass,  "MercuryGrass");
        GameRegistry.registerBlock(GCMercury.MercuryDirt,  "MercuryDirt");
        GameRegistry.registerBlock(GCMercury.MercuryStone,  "MercuryStone");
        GameRegistry.registerBlock(GCMercury.MercuryIridiumBlock,  "MercuryIridiumBlock");
        GameRegistry.registerBlock(GCMercury.MercuryBrick,  "MercuryBrick");
        GameRegistry.registerBlock(GCMercury.MercuryIridiumOre,  "MercuryIridiumOre");
        GameRegistry.registerBlock(GCMercury.MercuryTinOre,  "MercuryTinOre");
        GameRegistry.registerBlock(GCMercury.MercuryCopperOre,  "MercuryCopperOre");
        
       	GameRegistry.registerBlock(GCMercury.BlackGlowstone, "BlackGlowstone");
    	GameRegistry.registerBlock(GCMercury.BlueGlowstone, "BlueGlowstone");
    	GameRegistry.registerBlock(GCMercury.BrownGlowstone, "BrownGlowstone");
    	GameRegistry.registerBlock(GCMercury.CyanGlowstone, "CyanGlowstone");
    	GameRegistry.registerBlock(GCMercury.GreenGlowstone, "GreenGlowstone");
    	GameRegistry.registerBlock(GCMercury.GreyGlowstone, "GreyGlowstone");
    	GameRegistry.registerBlock(GCMercury.SilverGlowstone, "SilverGlowstone");
    	GameRegistry.registerBlock(GCMercury.LightBlueGlowstone, "LightBlueGlowstone");
    	GameRegistry.registerBlock(GCMercury.LimeGlowstone, "LimeGlowstone");
    	GameRegistry.registerBlock(GCMercury.MagentaGlowstone, "MagentaGlowstone");
    	GameRegistry.registerBlock(GCMercury.OrangeGlowstone, "OrangeGlowstone");
    	GameRegistry.registerBlock(GCMercury.PinkGlowstone, "PinkGlowstone");
    	GameRegistry.registerBlock(GCMercury.PurpleGlowstone, "PurpleGlowstone");
    	GameRegistry.registerBlock(GCMercury.RedGlowstone, "RedGlowstone");
    	GameRegistry.registerBlock(GCMercury.WhiteGlowstone, "WhiteGlowstone");
    	GameRegistry.registerBlock(GCMercury.YellowGlowstone, "YellowGlowstone");
 //       GameRegistry.registerBlock(GCMercury.caravanModule, "CaravanModule");
//        GameRegistry.registerBlock(GCMercury.caravanModulePart, "CaravanModulePart");
	}

	public static final Block MercuryGrass = new GCMercuryGrass(493, null).setHardness(0.6F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName( "MercuryGrass").setTextureName("galacticraftmercury:grassMercury").setCreativeTab(GCMercury.galacticraftMercuryTab);

	public static final Block MercuryDirt = new GCMercuryBlock(494, null).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName( "MercuryDirt").setTextureName("galacticraftmercury:dirtMercury").setCreativeTab(GCMercury.galacticraftMercuryTab);

	public static final Block MercuryStone = new GCMercuryBlock(495, null).setHardness(1.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName( "MercuryStone").setTextureName("galacticraftmercury:stoneMercury").setCreativeTab(GCMercury.galacticraftMercuryTab);

	public static final Block MercuryBrick = new GCMercuryBrick(496, null).setHardness(6000000.0F).setResistance(6000000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName( "MercuryBrick").setTextureName("galacticraftmercury:mercuryBrick").setCreativeTab(GCMercury.galacticraftMercuryTab);

	public static final Block MercuryIridiumBlock = new GCMercuryBlock(497, null).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName( "MercuryIridiumBlock").setTextureName("galacticraftmercury:iridiumBlock").setCreativeTab(GCMercury.galacticraftMercuryTab);

	public static final Block MercuryIridiumOre = new GCMercuryOre(498, null).setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName( "MercuryIridiumOre").setTextureName("galacticraftmercury:iridiumOre").setCreativeTab(GCMercury.galacticraftMercuryTab);

	public static final Block MercuryTinOre = new GCMercuryOre(499, null).setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName( "MercuryTinOre").setTextureName("galacticraftmercury:tinOre").setCreativeTab(GCMercury.galacticraftMercuryTab);

	public static final Block MercuryCopperOre = new GCMercuryOre(500, null).setHardness(3.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName( "MercuryCopperOre").setTextureName("galacticraftmercury:copperOre").setCreativeTab(GCMercury.galacticraftMercuryTab);


    public final static Block BlackGlowstone = new GCMercuryBlock(501, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("BlackGlowstone").setLightValue(1.0f).setTextureName("galacticraftmercury:glowstone_black").setCreativeTab(GCMercury.galacticraftMercuryTab);

    public static final Block BlueGlowstone = new GCMercuryBlock(502, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("BlueGlowstone").setLightValue(1.0f).setTextureName("galacticraftmercury:glowstone_blue").setCreativeTab(GCMercury.galacticraftMercuryTab);

    public static final Block BrownGlowstone = new GCMercuryBlock(503, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("BrownGlowstone").setLightValue(1.0f).setTextureName("galacticraftmercury:glowstone_brown").setCreativeTab(GCMercury.galacticraftMercuryTab);

    public static final Block CyanGlowstone = new GCMercuryBlock(504, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("CyanGlowstone").setLightValue(1.0f).setTextureName("galacticraftmercury:glowstone_cyan").setCreativeTab(GCMercury.galacticraftMercuryTab);

    public static final Block GreenGlowstone = new GCMercuryBlock(505, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("GreenGlowstone").setLightValue(1.0f).setTextureName("galacticraftmercury:glowstone_green").setCreativeTab(GCMercury.galacticraftMercuryTab);

    public static final Block GreyGlowstone = new GCMercuryBlock(506, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("GreyGlowstone").setLightValue(1.0f).setTextureName("galacticraftmercury:glowstone_grey").setCreativeTab(GCMercury.galacticraftMercuryTab);

    public static final Block LightBlueGlowstone = new GCMercuryBlock(507, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("LightBlueGlowstone").setLightValue(1.0f).setTextureName("galacticraftmercury:glowstone_light_blue").setCreativeTab(GCMercury.galacticraftMercuryTab);

    public static final Block SilverGlowstone = new GCMercuryBlock(508, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("SilverGlowstone").setLightValue(1.0f).setTextureName("galacticraftmercury:glowstone_silver").setCreativeTab(GCMercury.galacticraftMercuryTab);

    public static final Block LimeGlowstone = new GCMercuryBlock(509, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("LimeGlowstone").setLightValue(1.0f).setTextureName("galacticraftmercury:glowstone_lime").setCreativeTab(GCMercury.galacticraftMercuryTab);

    public static final Block MagentaGlowstone = new GCMercuryBlock(510, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("MagentaGlowstone").setLightValue(1.0f).setTextureName("galacticraftmercury:glowstone_magenta").setCreativeTab(GCMercury.galacticraftMercuryTab);

    public static final Block OrangeGlowstone = new GCMercuryBlock(511, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("OrangeGlowstone").setLightValue(1.0f).setTextureName("galacticraftmercury:glowstone_orange").setCreativeTab(GCMercury.galacticraftMercuryTab);

    public static final Block PinkGlowstone = new GCMercuryBlock(512, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("PinkGlowstone").setLightValue(1.0f).setTextureName("galacticraftmercury:glowstone_pink").setCreativeTab(GCMercury.galacticraftMercuryTab);

    public static final Block PurpleGlowstone = new GCMercuryBlock(513, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("PurpleGlowstone").setLightValue(1.0f).setTextureName("galacticraftmercury:glowstone_purple").setCreativeTab(GCMercury.galacticraftMercuryTab);

    public static final Block RedGlowstone = new GCMercuryBlock(515, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("RedGlowstone").setLightValue(1.0f).setTextureName("galacticraftmercury:glowstone_red").setCreativeTab(GCMercury.galacticraftMercuryTab);

    public static final Block WhiteGlowstone = new GCMercuryBlock(516, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("WhiteGlowstone").setLightValue(1.0f).setTextureName("galacticraftmercury:glowstone_white").setCreativeTab(GCMercury.galacticraftMercuryTab);

    public static final Block YellowGlowstone = new GCMercuryBlock(517, null).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("YellowGlowstone").setLightValue(1.0f).setTextureName("galacticraftmercury:glowstone_yellow").setCreativeTab(GCMercury.galacticraftMercuryTab);

//	public static final Block caravanModule = new SCCaravanModule(518, null).setHardness(0.4F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("caravanModule").setTextureName("galacticraftmercury:caravanModule").setCreativeTab(GCMercury.galacticraftMercuryTab);

//	public static final Block caravanModulePart = new GCMercuryBlock(519, null).setHardness(30.0F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("caravanModulePart").setTextureName("galacticraftmercury:caravanModulePart");
}
