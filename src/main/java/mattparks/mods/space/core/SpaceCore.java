package mattparks.mods.space.core;

import java.io.File;

import mattparks.mods.space.callisto.blocks.CallistoBlocks;
import mattparks.mods.space.callisto.dimension.WorldProviderCallisto;
import mattparks.mods.space.core.dimension.TeleportTypeSpace;
import mattparks.mods.space.core.event.SpaceEvents;
import mattparks.mods.space.core.proxy.CommonProxySpace;
import mattparks.mods.space.core.tick.SkyProviderHandler;
import mattparks.mods.space.core.util.ConfigManagerSpace;
import mattparks.mods.space.core.util.CreativeTabsSpace;
import mattparks.mods.space.core.util.EntityRegisterUtil;
import mattparks.mods.space.core.util.Version;
import mattparks.mods.space.eris.blocks.ErisBlocks;
import mattparks.mods.space.eris.dimension.WorldProviderEris;
import mattparks.mods.space.europa.blocks.EuropaBlocks;
import mattparks.mods.space.europa.dimension.WorldProviderEuropa;
import mattparks.mods.space.europa.items.EuropaItems;
import mattparks.mods.space.ganymede.blocks.GanymedeBlocks;
import mattparks.mods.space.gas.blocks.GasBlocks;
import mattparks.mods.space.io.blocks.IoBlocks;
import mattparks.mods.space.io.dimension.WorldProviderIo;
import mattparks.mods.space.io.items.IoItems;
import mattparks.mods.space.mercury.blocks.MercuryBlocks;
import mattparks.mods.space.mercury.dimension.WorldProviderMercury;
import mattparks.mods.space.mercury.items.MercuryItems;
import mattparks.mods.space.mercury.tile.TileEntityMercuryTreasureChest;
import mattparks.mods.space.pluto.blocks.PlutoBlocks;
import mattparks.mods.space.sedna.blocks.SednaBlocks;
import mattparks.mods.space.titan.blocks.TitanBlocks;
import mattparks.mods.space.titan.items.TitanItems;
import mattparks.mods.space.venus.blocks.VenusBlocks;
import mattparks.mods.space.venus.dimension.WorldProviderVenus;
import mattparks.mods.space.venus.entities.EntityEvolvedBlaze;
import mattparks.mods.space.venus.entities.EntityFlameling;
import mattparks.mods.space.venus.entities.EntityVenusianTNT;
import mattparks.mods.space.venus.entities.EntityVenusianVillager;
import mattparks.mods.space.venus.items.VenusItems;
import mattparks.mods.space.venus.tile.TileEntityVenusTreasureChest;
import mattparks.mods.space.vesta.blocks.VestaBlocks;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody.ScalableDistance;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(name = SpaceCore.NAME, version = Version.LOCALMAJVERSION + "." + Version.LOCALMINVERSION + "." + Version.LOCALBUILDVERSION, useMetadata = true, modid = SpaceCore.MODID, dependencies = "required-after:MattCore; required-after:GalacticraftCore;")
public class SpaceCore
{
	public static final String NAME = "4-Space Core";
	public static final String MODID = "4Space";

	@SidedProxy(clientSide = "mattparks.mods.space.core.proxy.ClientProxySpace", serverSide = "mattparks.mods.space.core.proxy.CommonProxySpace")
	public static CommonProxySpace proxy;

	@Instance(SpaceCore.MODID)
	public static SpaceCore instance;

	public static CreativeTabs spaceBlocksTab;
	public static CreativeTabs spaceItemsTab;

	public static Planet eris;
	public static Moon europa;
	public static Moon io;
	public static Moon callisto;
	public static Moon ganymede;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		new ConfigManagerSpace(new File(event.getModConfigurationDirectory(), "Galacticraft/4-Space.cfg"));

		VenusBlocks.init();
		MercuryBlocks.init();
		EuropaBlocks.init();
		IoBlocks.init();
		CallistoBlocks.init();
		ErisBlocks.init();
		GanymedeBlocks.init();
		PlutoBlocks.init();
		SednaBlocks.init();
		VestaBlocks.init();
		TitanBlocks.init();
		GasBlocks.init();

		MercuryItems.init();
		VenusItems.init();
		IoItems.init();
		TitanItems.init();
		EuropaItems.init();

		MinecraftForge.EVENT_BUS.register(new SpaceEvents());
		
		SpaceCore.proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		SpaceCore.proxy.init(event);

		FMLCommonHandler.instance().bus().register(new SkyProviderHandler());

		SpaceCore.spaceBlocksTab = new CreativeTabsSpace(CreativeTabs.getNextID(), "SpaceBlocks", Item.getItemFromBlock(VenusBlocks.venusTreasureChest), 0);
		SpaceCore.spaceItemsTab = new CreativeTabsSpace(CreativeTabs.getNextID(), "SpaceItems", VenusItems.venusBasicItem, 3);

		GalacticraftCore.planetMercury = new Planet("mercury").setParentSolarSystem(GalacticraftCore.solarSystemSol);
		GalacticraftCore.planetMercury.setTierRequired(3);
		GalacticraftCore.planetMercury.setRingColorRGB(0.1F, 0.9F, 0.6F);
		GalacticraftCore.planetMercury.setPhaseShift(1.45F);
		GalacticraftCore.planetMercury.setRelativeOrbitTime(0.24096385542168674698795180722892F);
		GalacticraftCore.planetMercury.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F));
		GalacticraftCore.planetMercury.setDimensionInfo(ConfigManagerSpace.idDimensionMercury, WorldProviderMercury.class);
		GalacticraftCore.planetMercury.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.HELIUM);

		GalacticraftCore.planetVenus = new Planet("venus").setParentSolarSystem(GalacticraftCore.solarSystemSol);
		GalacticraftCore.planetVenus.setTierRequired(3);
		GalacticraftCore.planetVenus.setRingColorRGB(0.1F, 0.9F, 0.6F);
		GalacticraftCore.planetVenus.setPhaseShift(2.0F);
		GalacticraftCore.planetVenus.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.75F, 0.75F));
		GalacticraftCore.planetVenus.setRelativeOrbitTime(0.61527929901423877327491785323111F);
		GalacticraftCore.planetVenus.setDimensionInfo(ConfigManagerSpace.idDimensionVenus, WorldProviderVenus.class);
		GalacticraftCore.planetVenus.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.ARGON);

		SpaceCore.eris = new Planet("eris").setParentSolarSystem(GalacticraftCore.solarSystemSol);
		SpaceCore.eris.setRingColorRGB(1.07F, 1.54F, 1.93F);
		SpaceCore.eris.setPhaseShift(4.5F);
		SpaceCore.eris.setRelativeDistanceFromCenter(new ScalableDistance(8.25F, 8.25F));
		SpaceCore.eris.setRelativeOrbitTime(12.5F);
		SpaceCore.eris.setTierRequired(3);
		SpaceCore.eris.setBodyIcon(new ResourceLocation("galacticrafteris:textures/gui/celestialbodies/eris.png"));
		SpaceCore.eris.setDimensionInfo(ConfigManagerSpace.idDimensionEris, WorldProviderEris.class);

		SpaceCore.europa = new Moon("europa").setParentPlanet(GalacticraftCore.planetJupiter);
		SpaceCore.europa.setPhaseShift(3.2F);
		SpaceCore.europa.setRelativeDistanceFromCenter(new ScalableDistance(6.0F, 6.0F));
		SpaceCore.europa.setRelativeOrbitTime(1 / 0.01F);
		SpaceCore.europa.setTierRequired(3);
		SpaceCore.europa.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/europa.png"));
		SpaceCore.europa.setDimensionInfo(ConfigManagerSpace.idDimensionEuropa, WorldProviderEuropa.class);
		SpaceCore.europa.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.NITROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.WATER);

		SpaceCore.io = new Moon("io").setParentPlanet(GalacticraftCore.planetJupiter);
		SpaceCore.io.setPhaseShift(10.2F);
		SpaceCore.io.setRelativeDistanceFromCenter(new ScalableDistance(8.0F, 8.0F));
		SpaceCore.io.setRelativeOrbitTime(1 / 0.5F);
		SpaceCore.io.setTierRequired(3);
		SpaceCore.io.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/io.png"));
		SpaceCore.io.setDimensionInfo(ConfigManagerSpace.idDimensionIo, WorldProviderIo.class);
		SpaceCore.io.atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.METHANE);

		SpaceCore.callisto = new Moon("callisto").setParentPlanet(GalacticraftCore.planetJupiter);
		SpaceCore.callisto.setPhaseShift(10.2F);
		SpaceCore.callisto.setRelativeDistanceFromCenter(new ScalableDistance(8.0F, 8.0F));
		SpaceCore.callisto.setRelativeOrbitTime(1 / 0.5F);
		SpaceCore.callisto.setTierRequired(3);
		SpaceCore.callisto.setBodyIcon(new ResourceLocation("galacticraftcallisto:textures/gui/celestialbodies/callisto.png"));
		SpaceCore.callisto.setDimensionInfo(ConfigManagerSpace.idDimensionCallisto, WorldProviderCallisto.class);
		SpaceCore.callisto.atmosphereComponent(IAtmosphericGas.CO2);

		GalaxyRegistry.registerMoon(europa);
		GalaxyRegistry.registerMoon(io);
		GalaxyRegistry.registerMoon(callisto);
		GalaxyRegistry.registerPlanet(eris);
		GalaxyRegistry.registerPlanet(GalacticraftCore.planetMercury);
		GalaxyRegistry.registerPlanet(GalacticraftCore.planetVenus);

		TeleportTypeSpace teleport = new TeleportTypeSpace();

		GalacticraftRegistry.registerTeleportType(WorldProviderMercury.class, teleport);
		GalacticraftRegistry.registerTeleportType(WorldProviderVenus.class, teleport);
		GalacticraftRegistry.registerTeleportType(WorldProviderEuropa.class, teleport);
		GalacticraftRegistry.registerTeleportType(WorldProviderIo.class, teleport);
		GalacticraftRegistry.registerTeleportType(WorldProviderEris.class, teleport);
		GalacticraftRegistry.registerTeleportType(WorldProviderCallisto.class, teleport);

		GalacticraftRegistry.registerRocketGui(WorldProviderVenus.class, new ResourceLocation("galacticraftvenus:textures/gui/venusRocketGui.png"));
		GalacticraftRegistry.registerRocketGui(WorldProviderMercury.class, new ResourceLocation("galacticraftmercury:textures/gui/mercuryRocketGui.png"));
		GalacticraftRegistry.registerRocketGui(WorldProviderEuropa.class, new ResourceLocation("galacticrafteuropa:textures/gui/europaRocketGui.png"));
		GalacticraftRegistry.registerRocketGui(WorldProviderIo.class, new ResourceLocation("galacticraftio:textures/gui/ioRocketGui.png"));
		GalacticraftRegistry.registerRocketGui(WorldProviderEris.class, new ResourceLocation("galacticrafteris:textures/gui/erisRocketGui.png"));
		GalacticraftRegistry.registerRocketGui(WorldProviderCallisto.class, new ResourceLocation("galacticraftcallisto:textures/gui/callistoRocketGui.png"));

		this.registerTileEntities();
		this.registerCreatures();
		this.registerOtherEntities();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		SpaceCore.proxy.postInit(event);
	}

	private void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityVenusTreasureChest.class, "VenusTreasureChest");
		GameRegistry.registerTileEntity(TileEntityMercuryTreasureChest.class, "MercuryTreasureChest");
	}

	private void registerCreatures()
	{
		EntityRegisterUtil.registerSpaceCreature(EntityEvolvedBlaze.class, "EvolvedBlaze", ConfigManagerSpace.idEntityEvolvedBlaze, -771829, -870131);
		EntityRegisterUtil.registerSpaceCreature(EntityFlameling.class, "Flameling", ConfigManagerSpace.idEntityFlameling, -771829, -870131);
		EntityRegisterUtil.registerSpaceCreature(EntityVenusianVillager.class, "VenusianVillager", ConfigManagerSpace.idEntityVenusianVillager, -771829, -870131);
	}

	private void registerOtherEntities()
	{
		EntityRegisterUtil.registerSpaceNonMobEntity(EntityVenusianTNT.class, "VenusianTNT", ConfigManagerSpace.idEntityVenusianTNT, 150, 1, true);
	}

	public static void registerBlock(Block block, Class<? extends ItemBlock> itemBlockClass)
	{
		GameRegistry.registerBlock(block, itemBlockClass, block.getUnlocalizedName().replace("tile.", ""));
	}

	public static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName().replace("item.", ""));
	}
}