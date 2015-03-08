package mattparks.mods.space.mercury;

import java.io.File;

import mattparks.mods.space.core.Constants;
import mattparks.mods.space.mercury.blocks.MercuryBlocks;
import mattparks.mods.space.mercury.dimension.TeleportTypeMercury;
import mattparks.mods.space.mercury.dimension.WorldProviderMercury;
import mattparks.mods.space.mercury.items.MercuryItems;
import mattparks.mods.space.mercury.proxy.CommonProxyMercury;
import mattparks.mods.space.mercury.util.ConfigManagerMercury;
import mattparks.mods.space.mercury.util.RecipeManagerMercury;
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

@Mod(modid = Constants.MOD_ID_MERCURY, name = Constants.MOD_NAME_MERCURY, version = Constants.VERSION, dependencies = "required-after:GalacticraftCore;")
public class MercuryCore {
	public static final String ASSET_PREFIX = "spacemercury";
	public static final String TEXTURE_PREFIX = MercuryCore.ASSET_PREFIX + ":";

	public static Planet planetMercury;

	@SidedProxy(clientSide = "mattparks.mods.space.mercury.proxy.ClientProxyMercury", serverSide = "mattparks.mods.space.mercury.proxy.CommonProxyMercury")
	public static CommonProxyMercury proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		new ConfigManagerMercury(new File(event.getModConfigurationDirectory(), "4Space/mercury.cfg"));

		MercuryBlocks.init();
		MercuryItems.init();

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
		MercuryCore.planetMercury = (Planet) new Planet("mercury").setParentSolarSystem(GalacticraftCore.solarSystemSol).setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(2.0F).setRelativeSize(0.5319F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.5F, 0.5F)).setRelativeOrbitTime(0.24096385542168674698795180722892F);
		MercuryCore.planetMercury.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/mercury.png"));
		MercuryCore.planetMercury.setDimensionInfo(ConfigManagerMercury.idDimensionMercury, WorldProviderMercury.class).setTierRequired(2);
		MercuryCore.planetMercury.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.ARGON);

		GalaxyRegistry.registerPlanet(MercuryCore.planetMercury);

		GalacticraftRegistry.registerTeleportType(WorldProviderMercury.class, new TeleportTypeMercury());

		GalacticraftRegistry.registerRocketGui(WorldProviderMercury.class, new ResourceLocation(MercuryCore.TEXTURE_PREFIX + "textures/gui/mercuryRocketGui.png"));

		CompressorRecipes.addShapelessRecipe(new ItemStack(MercuryItems.mercuryBasicItem, 2, 1), new ItemStack(MercuryItems.mercuryBasicItem, 1, 0));

		CompressorRecipes.addShapelessRecipe(new ItemStack(MercuryItems.mercuryBasicItem, 3, 2), new ItemStack(MercuryItems.mercuryBasicItem, 1, 1), new ItemStack(MercuryItems.mercuryBasicItem, 1, 0), new ItemStack(MercuryItems.mercuryBasicItem, 1, 1));

		this.registerTileEntities();
		this.registerCreatures();
		this.registerOtherEntities();

		this.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		RecipeManagerMercury.loadRecipes();

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
