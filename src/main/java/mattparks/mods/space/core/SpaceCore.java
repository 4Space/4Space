package mattparks.mods.space.core;

import java.io.File;

import mattparks.mods.space.core.proxy.CommonProxy;
import mattparks.mods.space.core.util.ConfigManagerCore;
import mattparks.mods.space.core.util.CreativeTabsSpace;
import mattparks.mods.space.core.util.ThreadVersionCheck;
import mattparks.mods.space.venus.blocks.VenusBlocks;
import mattparks.mods.space.venus.items.VenusItems;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;

@Mod(modid = Constants.MOD_ID_CORE, name = Constants.MOD_NAME_CORE, version = Constants.VERSION, dependencies = "required-after:GalacticraftCore;")
public class SpaceCore {
	public static CreativeTabs spaceBlocksTab;
	public static CreativeTabs spaceItemsTab;

	public static Planet planetJupiter;
	public static Planet planetSaturn;
	public static Planet planetUranus;
	public static Planet planetNeptune;

	@SidedProxy(clientSide = "mattparks.mods.space.core.proxy.ClientProxy", serverSide = "mattparks.mods.space.core.proxy.CommonProxy")
	public static CommonProxy proxy;

	@Instance(Constants.MOD_ID_CORE)
	public static SpaceCore instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		new ConfigManagerCore(new File(event.getModConfigurationDirectory(), "4Space/core.cfg"));

		this.proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		if (ConfigManagerCore.idJupiterEnabled) {
			SpaceCore.planetJupiter = (Planet) new Planet("jupiter").setParentSolarSystem(GalacticraftCore.solarSystemSol).setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(2.3F).setRelativeSize(0.5319F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.5F, 1.5F)).setRelativeOrbitTime(11.861993428258488499452354874042F);
			SpaceCore.planetJupiter.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/jupiter.png"));
			SpaceCore.planetJupiter.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.ARGON);
			GalaxyRegistry.registerPlanet(SpaceCore.planetJupiter);
		}

		if (ConfigManagerCore.idSaturnEnabled) {
			SpaceCore.planetSaturn = (Planet) new Planet("saturn").setParentSolarSystem(GalacticraftCore.solarSystemSol).setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(3.7F).setRelativeSize(0.5319F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.75F, 1.75F)).setRelativeOrbitTime(29.463307776560788608981380065717F);
			SpaceCore.planetSaturn.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/saturn.png"));
			SpaceCore.planetSaturn.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.ARGON);
			GalaxyRegistry.registerPlanet(SpaceCore.planetSaturn);
		}

		if (ConfigManagerCore.idUranusEnabled) {
			SpaceCore.planetUranus = (Planet) new Planet("uranus").setParentSolarSystem(GalacticraftCore.solarSystemSol).setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(7.2F).setRelativeSize(0.5319F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.0F, 2.0F)).setRelativeOrbitTime(84.063526834611171960569550930997F);
			SpaceCore.planetUranus.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/uranus.png"));
			SpaceCore.planetUranus.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.ARGON);
			GalaxyRegistry.registerPlanet(SpaceCore.planetUranus);
		}

		if (ConfigManagerCore.idNeptuneEnabled) {
			SpaceCore.planetNeptune = (Planet) new Planet("neptune").setParentSolarSystem(GalacticraftCore.solarSystemSol).setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(36.1F).setRelativeSize(0.5319F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.25F, 2.25F)).setRelativeOrbitTime(164.84118291347207009857612267251F);
			SpaceCore.planetNeptune.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/neptune.png"));
			SpaceCore.planetNeptune.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.ARGON);
			GalaxyRegistry.registerPlanet(SpaceCore.planetNeptune);
		}

		this.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		SpaceCore.spaceBlocksTab = new CreativeTabsSpace(CreativeTabs.getNextID(), "SpaceBlocks", Item.getItemFromBlock(VenusBlocks.venusBasicBlock), 4);
		SpaceCore.spaceItemsTab = new CreativeTabsSpace(CreativeTabs.getNextID(), "SpaceItems", VenusItems.venusBasicItem, 2);

		this.proxy.postInit(event);
	}

	@EventHandler
	public void serverInit(FMLServerStartedEvent event) {
		if (ConfigManagerCore.updateCheck) {
			ThreadVersionCheck.startCheck();
		}
	}
}
