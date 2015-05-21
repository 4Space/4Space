package mattparks.mods.exoplanets.core;

import java.io.File;

import mattparks.mods.exoplanets.core.proxy.CommonProxy;
import mattparks.mods.exoplanets.core.util.ConfigManagerCore;
import mattparks.mods.exoplanets.elipse.ElipseCore;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;

@Mod(modid = Constants.MOD_ID_CORE, name = Constants.MOD_NAME_CORE, version = Constants.VERSION, dependencies = "required-after:GalacticraftCore;required-after:SpaceCore;")
public class ExoCore {
	public static final String ASSET_PREFIX = "exoplanetscore";
	public static final String TEXTURE_PREFIX = ExoCore.ASSET_PREFIX + ":";

	// public static CreativeTabs exoplanetsBlocksTab;
	// public static CreativeTabs exoplanetsItemsTab;

	public static SolarSystem gliese581g;
	public static Moon moonElpis_M1;
	public static Planet planetHestia;
	public static Moon moonHestia_M1;
	public static Planet planetHera;
	public static Moon moonHera_M1;
	public static Moon moonHera_M2;
	public static Planet planetCeto;
	public static Moon moonCeto_M1;

	@SidedProxy(clientSide = "mattparks.mods.exoplanets.core.proxy.ClientProxy", serverSide = "mattparks.mods.exoplanets.core.proxy.CommonProxy")
	public static CommonProxy proxy;

	@Instance(Constants.MOD_ID_CORE)
	public static ExoCore instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		new ConfigManagerCore(new File(event.getModConfigurationDirectory(), "Exoplanets/core.cfg"));

		this.proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		ExoCore.gliese581g = new SolarSystem("gliese581g", "milkyWay").setMapPosition(new Vector3(0.1F, 0.1F));
		Star star581g = (Star) new Star("581g").setParentSolarSystem(ExoCore.gliese581g).setTierRequired(-1);
		star581g.setBodyIcon(new ResourceLocation(ExoCore.ASSET_PREFIX, "textures/gui/celestialbodies/star581.png"));
		ExoCore.gliese581g.setMainStar(star581g);
		GalaxyRegistry.registerSolarSystem(ExoCore.gliese581g);

		ExoCore.moonElpis_M1 = (Moon) new Moon("elpis_m1").setParentPlanet(ElipseCore.planetElpis).setRelativeSize(0.1656F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(17F, 17F)).setRelativeOrbitTime(1 / 0.001125F);
		ExoCore.moonElpis_M1.setBodyIcon(new ResourceLocation(ExoCore.ASSET_PREFIX, "textures/gui/celestialbodies/moons581.png"));
		GalaxyRegistry.registerMoon(ExoCore.moonElpis_M1);

		ExoCore.planetHestia = (Planet) new Planet("hestia").setParentSolarSystem(ExoCore.gliese581g).setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(3.9F).setRelativeSize(0.4319F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.7F, 0.7F)).setRelativeOrbitTime(3.86199F);
		ExoCore.planetHestia.setBodyIcon(new ResourceLocation(ExoCore.ASSET_PREFIX, "textures/gui/celestialbodies/hestia.png"));
		ExoCore.planetHestia.atmosphereComponent(IAtmosphericGas.CO2);
		GalaxyRegistry.registerPlanet(ExoCore.planetHestia);

		ExoCore.moonHestia_M1 = (Moon) new Moon("hestia_m1").setParentPlanet(ExoCore.planetHestia).setRelativeSize(0.1656F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(17F, 24F)).setRelativeOrbitTime(1 / 0.001125F);
		ExoCore.moonHestia_M1.setBodyIcon(new ResourceLocation(ExoCore.ASSET_PREFIX, "textures/gui/celestialbodies/moons581.png"));
		GalaxyRegistry.registerMoon(ExoCore.moonHestia_M1);

		ExoCore.planetHera = (Planet) new Planet("hera").setParentSolarSystem(ExoCore.gliese581g).setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(99.7F).setRelativeSize(0.7319F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.1F, 1.1F)).setRelativeOrbitTime(6.86199F);
		ExoCore.planetHera.setBodyIcon(new ResourceLocation(ExoCore.ASSET_PREFIX, "textures/gui/celestialbodies/hera.png"));
		ExoCore.planetHera.atmosphereComponent(IAtmosphericGas.OXYGEN).atmosphereComponent(IAtmosphericGas.WATER).atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.NITROGEN).atmosphereComponent(IAtmosphericGas.ARGON);
		GalaxyRegistry.registerPlanet(ExoCore.planetHera);

		ExoCore.moonHera_M1 = (Moon) new Moon("hera_m1").setParentPlanet(ExoCore.planetHera).setRelativeSize(0.1656F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(14F, 16F)).setRelativeOrbitTime(1 / 0.001125F);
		ExoCore.moonHera_M1.setBodyIcon(new ResourceLocation(ExoCore.ASSET_PREFIX, "textures/gui/celestialbodies/moons581.png"));
		GalaxyRegistry.registerMoon(ExoCore.moonHera_M1);

		ExoCore.moonHera_M2 = (Moon) new Moon("hera_m2").setParentPlanet(ExoCore.planetHera).setRelativeSize(0.1656F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(23F, 24F)).setRelativeOrbitTime(8 / 0.001125F);
		ExoCore.moonHera_M2.setBodyIcon(new ResourceLocation(ExoCore.ASSET_PREFIX, "textures/gui/celestialbodies/moons581.png"));
		GalaxyRegistry.registerMoon(ExoCore.moonHera_M2);

		ExoCore.planetCeto = (Planet) new Planet("ceto").setParentSolarSystem(ExoCore.gliese581g).setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(7.9F).setRelativeSize(0.6319F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.75F, 2.5F)).setRelativeOrbitTime(9.86199F);
		ExoCore.planetCeto.setBodyIcon(new ResourceLocation(ExoCore.ASSET_PREFIX, "textures/gui/celestialbodies/ceto.png"));
		ExoCore.planetCeto.atmosphereComponent(IAtmosphericGas.HYDROGEN).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.NITROGEN);
		GalaxyRegistry.registerPlanet(ExoCore.planetCeto);

		ExoCore.moonCeto_M1 = (Moon) new Moon("ceto_m1").setParentPlanet(ExoCore.planetCeto).setRelativeSize(0.1656F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(17F, 16F)).setRelativeOrbitTime(1 / 0.001125F);
		ExoCore.moonCeto_M1.setBodyIcon(new ResourceLocation(ExoCore.ASSET_PREFIX, "textures/gui/celestialbodies/moons581.png"));
		GalaxyRegistry.registerMoon(ExoCore.moonCeto_M1);

		this.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// ExoCore.exoplanetsBlocksTab = new
		// CreativeTabsSpace(CreativeTabs.getNextID(), "ExoplanetsBlocks",
		// Item.getItemFromBlock(VenusBlocks.venusBasicBlock), 4);
		// ExoCore.exoplanetsItemsTab = new
		// CreativeTabsSpace(CreativeTabs.getNextID(), "ExoplanetsItems",
		// VenusItems.venusBasicItem, 2);

		this.proxy.postInit(event);
	}

	@EventHandler
	public void serverInit(FMLServerStartedEvent event) {
	}
}
