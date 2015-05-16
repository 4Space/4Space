package mattparks.mods.space.venus;

import java.io.File;

import mattparks.mods.space.core.Constants;
import mattparks.mods.space.core.util.SpaceUtil;
import mattparks.mods.space.venus.blocks.VenusBlocks;
import mattparks.mods.space.venus.dimension.TeleportTypeVenus;
import mattparks.mods.space.venus.dimension.WorldProviderVenus;
import mattparks.mods.space.venus.entities.EntityEvolvedBlaze;
import mattparks.mods.space.venus.entities.EntityVenusianTNT;
import mattparks.mods.space.venus.entities.EntityVenusianVillager;
import mattparks.mods.space.venus.items.VenusItems;
import mattparks.mods.space.venus.proxy.CommonProxyVenus;
import mattparks.mods.space.venus.util.ConfigManagerVenus;
import mattparks.mods.space.venus.util.RecipeManagerVenus;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Constants.MOD_ID_VENUS, name = Constants.MOD_NAME_VENUS, version = Constants.VERSION, dependencies = "required-after:GalacticraftCore;required-after:SpaceCore;")
public class VenusCore {
	public static final String ASSET_PREFIX = "spacevenus";
	public static final String TEXTURE_PREFIX = VenusCore.ASSET_PREFIX + ":";

	public static Planet planetVenus;

	@SidedProxy(clientSide = "mattparks.mods.space.venus.proxy.ClientProxyVenus", serverSide = "mattparks.mods.space.venus.proxy.CommonProxyVenus")
	public static CommonProxyVenus proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		new ConfigManagerVenus(new File(event.getModConfigurationDirectory(), "4Space/venus.cfg"));

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
		if (ConfigManagerVenus.idVenusEnabled) {
			VenusBlocks.init();
			VenusItems.init();

			VenusCore.planetVenus = (Planet) new Planet("venus").setParentSolarSystem(GalacticraftCore.solarSystemSol).setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(2.0F).setRelativeSize(0.5319F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.75F, 0.75F)).setRelativeOrbitTime(0.61527929901423877327491785323111F);
			VenusCore.planetVenus.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/venus.png"));
			VenusCore.planetVenus.setDimensionInfo(ConfigManagerVenus.idDimensionVenus, WorldProviderVenus.class).setTierRequired(2);
			VenusCore.planetVenus.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.ARGON);
	
			GalaxyRegistry.registerPlanet(VenusCore.planetVenus);
	
			GalacticraftRegistry.registerTeleportType(WorldProviderVenus.class, new TeleportTypeVenus());
	
			GalacticraftRegistry.registerRocketGui(WorldProviderVenus.class, new ResourceLocation(VenusCore.TEXTURE_PREFIX + "textures/gui/venusRocketGui.png"));
	
			CompressorRecipes.addShapelessRecipe(new ItemStack(VenusItems.venusBasicItem, 2, 5), new ItemStack(VenusItems.venusBasicItem, 1, 0));
			CompressorRecipes.addShapelessRecipe(new ItemStack(VenusItems.venusBasicItem, 1, 5), new ItemStack(VenusItems.venusBasicItem, 1, 1));
			CompressorRecipes.addShapelessRecipe(new ItemStack(VenusItems.venusBasicItem, 1, 6), new ItemStack(VenusItems.venusBasicItem, 1, 2));
			CompressorRecipes.addShapelessRecipe(new ItemStack(VenusItems.venusBasicItem, 1, 7), new ItemStack(VenusItems.venusBasicItem, 1, 3));
	
			CompressorRecipes.addShapelessRecipe(new ItemStack(VenusItems.venusBasicItem, 3, 8), new ItemStack(VenusItems.venusBasicItem, 1, 5), new ItemStack(VenusItems.venusBasicItem, 1, 6), new ItemStack(VenusItems.venusBasicItem, 1, 7));

			this.registerTileEntities();
			this.registerCreatures();
			this.registerOtherEntities();
		}
		
		this.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		RecipeManagerVenus.loadRecipes();

		this.proxy.postInit(event);
	}

	private void registerTileEntities() {
	}

	private void registerCreatures() {
		SpaceUtil.registerSpaceCreature(EntityEvolvedBlaze.class, "EvolvedBlaze", -771829, -870131);
		SpaceUtil.registerSpaceCreature(EntityVenusianVillager.class, "VenusianVillager", SpaceUtil.to32BitColor(255, 103, 181, 145), 16167425);
	}

	private void registerOtherEntities() {
		SpaceUtil.registerSpaceNonMobEntity(EntityVenusianTNT.class, "VenusianTNT", 150, 1, true);
	}

	@EventHandler
	public static void PreLoad(FMLPreInitializationEvent PreEvent) {
		proxy.registerRenderInfo();
	}
}
