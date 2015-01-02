package mattparks.mods.space.pluto;

import java.io.File;

import mattparks.mods.space.core.Constants;
import mattparks.mods.space.pluto.blocks.PlutoBlocks;
import mattparks.mods.space.pluto.dimension.TeleportTypePluto;
import mattparks.mods.space.pluto.dimension.WorldProviderPluto;
import mattparks.mods.space.pluto.items.PlutoItems;
import mattparks.mods.space.pluto.proxy.CommonProxyPluto;
import mattparks.mods.space.pluto.util.ConfigManagerPluto;
import mattparks.mods.space.pluto.util.RecipeManagerPluto;
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

@Mod(modid = Constants.MOD_ID_PLUTO, name = Constants.MOD_NAME_PLUTO, version = Constants.VERSION, dependencies = "required-after:GalacticraftCore;")
public class PlutoCore
{
	public static final String ASSET_PREFIX = "spacepluto";
	public static final String TEXTURE_PREFIX = PlutoCore.ASSET_PREFIX + ":";

	public static Planet planetPluto;

	@SidedProxy(clientSide = "mattparks.mods.space.pluto.proxy.ClientProxyPluto", serverSide = "mattparks.mods.space.pluto.proxy.CommonProxyPluto")
	public static CommonProxyPluto proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		new ConfigManagerPluto(new File(event.getModConfigurationDirectory(), "4Space/pluto.cfg"));

		PlutoBlocks.init();
		PlutoItems.init();

		this.proxy.preInit(event);
	}

	public static void registerBlock(Block block, Class<? extends ItemBlock> itemBlockClass)
	{
		GameRegistry.registerBlock(block, itemBlockClass, block.getUnlocalizedName().replace("tile.", ""));
	}

	public static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName().replace("item.", ""));
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		PlutoCore.planetPluto = (Planet) new Planet("pluto").setParentSolarSystem(GalacticraftCore.solarSystemSol).setRingColorRGB(0.1F, 0.9F, 0.6F).setPhaseShift(2.0F).setRelativeSize(0.5319F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.5F, 2.5F)).setRelativeOrbitTime(194.84118291347207009857612267251F);
		PlutoCore.planetPluto.setBodyIcon(new ResourceLocation(PlutoCore.ASSET_PREFIX, "textures/gui/celestialbodies/pluto.png"));
		PlutoCore.planetPluto.setDimensionInfo(ConfigManagerPluto.idDimensionPluto, WorldProviderPluto.class).setTierRequired(2);
		PlutoCore.planetPluto.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.HELIUM).atmosphereComponent(IAtmosphericGas.ARGON);

		GalaxyRegistry.registerPlanet(PlutoCore.planetPluto);

		GalacticraftRegistry.registerTeleportType(WorldProviderPluto.class, new TeleportTypePluto());

		GalacticraftRegistry.registerRocketGui(WorldProviderPluto.class, new ResourceLocation(PlutoCore.TEXTURE_PREFIX + "textures/gui/plutoRocketGui.png"));

		CompressorRecipes.addShapelessRecipe(new ItemStack(PlutoItems.plutoBasicItem, 2, 3), new ItemStack(PlutoItems.plutoBasicItem, 1, 0));
		CompressorRecipes.addShapelessRecipe(new ItemStack(PlutoItems.plutoBasicItem, 1, 4), new ItemStack(PlutoItems.plutoBasicItem, 1, 1));
		CompressorRecipes.addShapelessRecipe(new ItemStack(PlutoItems.plutoBasicItem, 1, 5), new ItemStack(PlutoItems.plutoBasicItem, 1, 2));

		CompressorRecipes.addShapelessRecipe(new ItemStack(PlutoItems.plutoBasicItem, 3, 6), new ItemStack(PlutoItems.plutoBasicItem, 1, 3), new ItemStack(PlutoItems.plutoBasicItem, 1, 5), new ItemStack(PlutoItems.plutoBasicItem, 1, 4));

		this.registerTileEntities();
		this.registerCreatures();
		this.registerOtherEntities();

		this.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		RecipeManagerPluto.loadRecipes();

		this.proxy.postInit(event);
	}

	private void registerTileEntities()
	{
	}

	private void registerCreatures()
	{
	}

	private void registerOtherEntities()
	{
	}

	@EventHandler
	public static void PreLoad(FMLPreInitializationEvent PreEvent)
	{
		proxy.registerRenderInfo();
	}
}
