package mattparks.mods.space.callisto;

import java.io.File;

import mattparks.mods.space.callisto.blocks.CallistoBlocks;
import mattparks.mods.space.callisto.dimension.TeleportTypeCallisto;
import mattparks.mods.space.callisto.dimension.WorldProviderCallisto;
import mattparks.mods.space.callisto.items.CallistoItems;
import mattparks.mods.space.callisto.proxy.CommonProxyCallisto;
import mattparks.mods.space.callisto.util.ConfigManagerCallisto;
import mattparks.mods.space.callisto.util.RecipeManagerCallisto;
import mattparks.mods.space.core.Constants;
import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.util.ConfigManagerCore;
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

@Mod(modid = Constants.MOD_ID_CALLISTO, name = Constants.MOD_NAME_CALLISTO, version = Constants.VERSION, dependencies = "required-after:GalacticraftCore;required-after:SpaceCore;")
public class CallistoCore {
	public static final String ASSET_PREFIX = "spacecallisto";
	public static final String TEXTURE_PREFIX = CallistoCore.ASSET_PREFIX + ":";

	public static Moon moonCallisto;

	@SidedProxy(clientSide = "mattparks.mods.space.callisto.proxy.ClientProxyCallisto", serverSide = "mattparks.mods.space.callisto.proxy.CommonProxyCallisto")
	public static CommonProxyCallisto proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		new ConfigManagerCallisto(new File(event.getModConfigurationDirectory(), "4Space/callisto.cfg"));

		if (ConfigManagerCallisto.idCallistoEnabled && ConfigManagerCore.idJupiterEnabled) {
			CallistoBlocks.init();
			CallistoItems.init();
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
		if (ConfigManagerCallisto.idCallistoEnabled && ConfigManagerCore.idJupiterEnabled) {
			CallistoCore.moonCallisto = (Moon) new Moon("callisto").setParentPlanet(SpaceCore.planetJupiter).setRelativeSize(0.1656F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(17F, 17F)).setRelativeOrbitTime(1 / 0.001125F);
			CallistoCore.moonCallisto.setDimensionInfo(ConfigManagerCallisto.idDimensionCallisto, WorldProviderCallisto.class).setTierRequired(3);
			CallistoCore.moonCallisto.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/callisto.png"));

			GalaxyRegistry.registerMoon(CallistoCore.moonCallisto);
			
			GalacticraftRegistry.registerTeleportType(WorldProviderCallisto.class, new TeleportTypeCallisto());
			
			GalacticraftRegistry.registerRocketGui(WorldProviderCallisto.class, new ResourceLocation(CallistoCore.TEXTURE_PREFIX + "textures/gui/callistoRocketGui.png"));
	
			this.registerTileEntities();
			this.registerCreatures();
			this.registerOtherEntities();
		}

		this.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (ConfigManagerCallisto.idCallistoEnabled && ConfigManagerCore.idJupiterEnabled) {
			RecipeManagerCallisto.loadRecipes();
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
