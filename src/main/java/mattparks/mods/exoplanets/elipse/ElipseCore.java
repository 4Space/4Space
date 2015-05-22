package mattparks.mods.exoplanets.elipse;

import java.io.File;

import mattparks.mods.exoplanets.core.Constants;
import mattparks.mods.exoplanets.core.ExoCore;
import mattparks.mods.exoplanets.elipse.blocks.ElipseBlocks;
import mattparks.mods.exoplanets.elipse.dimension.TeleportTypeElipse;
import mattparks.mods.exoplanets.elipse.dimension.WorldProviderElipse;
import mattparks.mods.exoplanets.elipse.items.ElipseItems;
import mattparks.mods.exoplanets.elipse.proxy.CommonProxyElipse;
import mattparks.mods.exoplanets.elipse.util.ConfigManagerElipse;
import mattparks.mods.exoplanets.elipse.util.RecipeManagerElipse;
import mattparks.mods.space.core.util.SpaceUtil;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Constants.MOD_ID_ELIPSE, name = Constants.MOD_NAME_ELIPSE, version = Constants.VERSION, dependencies = "required-after:GalacticraftCore;required-after:ExoCore;")
public class ElipseCore {
	public static final String ASSET_PREFIX = "exoplanetselipse";
	public static final String TEXTURE_PREFIX = ElipseCore.ASSET_PREFIX + ":";

	public static Planet planetElpis;

	@SidedProxy(clientSide = "mattparks.mods.exoplanets.elipse.proxy.ClientProxyElipse", serverSide = "mattparks.mods.exoplanets.elipse.proxy.CommonProxyElipse")
	public static CommonProxyElipse proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		new ConfigManagerElipse(new File(event.getModConfigurationDirectory(), "Exoplanets/elipse.cfg"));

		if (ConfigManagerElipse.idElipseEnabled) {
			ElipseBlocks.init();
			ElipseItems.init();
		}

		this.proxy.preInit(event);
	}

	public static void registerBlock(Block block, Class<? extends ItemBlock> itemBlockClass) {
		GameRegistry.registerBlock(block, itemBlockClass, block.getUnlocalizedName().replace("tile.", ""));
	}

	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().replace("item.", ""));
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		if (ConfigManagerElipse.idElipseEnabled) {
			ElipseCore.planetElpis = (Planet) new Planet("elpis").setParentSolarSystem(ExoCore.gliese581g).setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(0.3F).setRelativeSize(0.3519F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.45F, 0.45F)).setRelativeOrbitTime(1.86199F);
			ElipseCore.planetElpis.setBodyIcon(new ResourceLocation(ExoCore.ASSET_PREFIX, "textures/gui/celestialbodies/elpis.png"));
			ElipseCore.planetElpis.setDimensionInfo(ConfigManagerElipse.idDimensionElipse, WorldProviderElipse.class).setTierRequired(3);

			GalaxyRegistry.registerPlanet(ElipseCore.planetElpis);

			GalacticraftRegistry.registerTeleportType(WorldProviderElipse.class, new TeleportTypeElipse());

			GalacticraftRegistry.registerRocketGui(WorldProviderElipse.class, new ResourceLocation(ElipseCore.TEXTURE_PREFIX + "textures/gui/elipseRocketGui.png"));

			this.registerTileEntities();
			this.registerCreatures();
			this.registerOtherEntities();
		}

		this.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (ConfigManagerElipse.idElipseEnabled) {
			RecipeManagerElipse.loadRecipes();
		}

		this.proxy.postInit(event);
	}

	private void registerTileEntities() {
	}

	private void registerCreatures() {
		if (ConfigManagerElipse.idElipseEnabled) {
		}
	}

	private void registerOtherEntities() {
	}

	@EventHandler
	public static void PreLoad(FMLPreInitializationEvent PreEvent) {
		proxy.registerRenderInfo();
	}
}
