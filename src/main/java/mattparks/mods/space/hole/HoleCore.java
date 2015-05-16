package mattparks.mods.space.hole;

import java.io.File;

import mattparks.mods.space.core.Constants;
import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.util.ConfigManagerCore;
import mattparks.mods.space.core.util.SpaceUtil;
import mattparks.mods.space.hole.blocks.HoleBlocks;
import mattparks.mods.space.hole.dimension.TeleportTypeHole;
import mattparks.mods.space.hole.dimension.WorldProviderHole;
import mattparks.mods.space.hole.entites.EntityMakianVillager;
import mattparks.mods.space.hole.items.HoleItems;
import mattparks.mods.space.hole.proxy.CommonProxyHole;
import mattparks.mods.space.hole.util.ConfigManagerHole;
import mattparks.mods.space.hole.util.RecipeManagerHole;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
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

@Mod(modid = Constants.MOD_ID_HOLE, name = Constants.MOD_NAME_HOLE, version = Constants.VERSION, dependencies = "required-after:GalacticraftCore;required-after:SpaceCore;")
public class HoleCore {
	public static final String ASSET_PREFIX = "spacehole";
	public static final String TEXTURE_PREFIX = HoleCore.ASSET_PREFIX + ":";

	public static Moon moonHole;

	@SidedProxy(clientSide = "mattparks.mods.space.hole.proxy.ClientProxyHole", serverSide = "mattparks.mods.space.hole.proxy.CommonProxyHole")
	public static CommonProxyHole proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		new ConfigManagerHole(new File(event.getModConfigurationDirectory(), "4Space/hole.cfg"));

		if (ConfigManagerHole.idHoleEnabled && ConfigManagerCore.idSaturnEnabled) {
			HoleBlocks.init();
			HoleItems.init();
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
		if (ConfigManagerHole.idHoleEnabled && ConfigManagerCore.idSaturnEnabled) {
			HoleCore.moonHole = (Moon) new Moon("hole").setParentPlanet(SpaceCore.planetSaturn).setRelativeSize(0.2667F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(18F, 18F)).setRelativeOrbitTime(1 / 0.01F);
			HoleCore.moonHole.setDimensionInfo(ConfigManagerHole.idDimensionHole, WorldProviderHole.class).setTierRequired(3); // 4
			HoleCore.moonHole.setBodyIcon(new ResourceLocation(HoleCore.ASSET_PREFIX, "textures/gui/celestialbodies/wormhole.png"));
	
			GalaxyRegistry.registerMoon(HoleCore.moonHole);
	
			GalacticraftRegistry.registerTeleportType(WorldProviderHole.class, new TeleportTypeHole());
	
			GalacticraftRegistry.registerRocketGui(WorldProviderHole.class, new ResourceLocation(HoleCore.TEXTURE_PREFIX + "textures/gui/holeRocketGui.png"));
	
			this.registerTileEntities();
			this.registerCreatures();
			this.registerOtherEntities();
		}

		this.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (ConfigManagerHole.idHoleEnabled && ConfigManagerCore.idSaturnEnabled) {
			RecipeManagerHole.loadRecipes();
		}

		this.proxy.postInit(event);
	}

	private void registerTileEntities() {
	}

	private void registerCreatures() {
		SpaceUtil.registerSpaceCreature(EntityMakianVillager.class, "MakianVillager", SpaceUtil.to32BitColor(255, 103, 181, 145), 16167425);
	}

	private void registerOtherEntities() {
	}

	@EventHandler
	public static void PreLoad(FMLPreInitializationEvent PreEvent) {
		proxy.registerRenderInfo();
	}
}
