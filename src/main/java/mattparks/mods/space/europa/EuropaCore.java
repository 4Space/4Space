package mattparks.mods.space.europa;

import java.io.File;

import mattparks.mods.space.core.Constants;
import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.util.ConfigManagerCore;
import mattparks.mods.space.europa.blocks.EuropaBlocks;
import mattparks.mods.space.europa.dimension.TeleportTypeEuropa;
import mattparks.mods.space.europa.dimension.WorldProviderEuropa;
import mattparks.mods.space.europa.items.EuropaItems;
import mattparks.mods.space.europa.proxy.CommonProxyEuropa;
import mattparks.mods.space.europa.util.ConfigManagerEuropa;
import mattparks.mods.space.europa.util.RecipeManagerEuropa;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
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

@Mod(modid = Constants.MOD_ID_EUROPA, name = Constants.MOD_NAME_EUROPA, version = Constants.VERSION, dependencies = "required-after:GalacticraftCore;required-after:SpaceCore;")
public class EuropaCore {
	public static final String ASSET_PREFIX = "spaceeuropa";
	public static final String TEXTURE_PREFIX = EuropaCore.ASSET_PREFIX + ":";

	public static Moon moonEuropa;

	@SidedProxy(clientSide = "mattparks.mods.space.europa.proxy.ClientProxyEuropa", serverSide = "mattparks.mods.space.europa.proxy.CommonProxyEuropa")
	public static CommonProxyEuropa proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		new ConfigManagerEuropa(new File(event.getModConfigurationDirectory(), "4Space/europa.cfg"));

		if (ConfigManagerEuropa.idEuropaEnabled && ConfigManagerCore.idJupiterEnabled) {
			EuropaBlocks.init();
			EuropaItems.init();
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
		if (ConfigManagerEuropa.idEuropaEnabled && ConfigManagerCore.idJupiterEnabled) {
			EuropaCore.moonEuropa = (Moon) new Moon("europa").setParentPlanet(SpaceCore.planetJupiter).setRelativeSize(0.1656F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(14F, 14F)).setRelativeOrbitTime(1 / 0.001F);
			EuropaCore.moonEuropa.setDimensionInfo(ConfigManagerEuropa.idDimensionEuropa, WorldProviderEuropa.class).setTierRequired(3);
			EuropaCore.moonEuropa.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/europa.png"));

			GalaxyRegistry.registerMoon(EuropaCore.moonEuropa);

			GalacticraftRegistry.registerTeleportType(WorldProviderEuropa.class, new TeleportTypeEuropa());

			GalacticraftRegistry.registerRocketGui(WorldProviderEuropa.class, new ResourceLocation(EuropaCore.TEXTURE_PREFIX + "textures/gui/europaRocketGui.png"));

			this.registerTileEntities();
			this.registerCreatures();
			this.registerOtherEntities();
		}

		this.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (ConfigManagerEuropa.idEuropaEnabled && ConfigManagerCore.idJupiterEnabled) {
			RecipeManagerEuropa.loadRecipes();
		}

		this.proxy.postInit(event);
	}

	private void registerTileEntities() {
	}

	private void registerCreatures() {
	}

	private void registerOtherEntities() {
	}

	@EventHandler
	public static void PreLoad(FMLPreInitializationEvent PreEvent) {
		proxy.registerRenderInfo();
	}
}
