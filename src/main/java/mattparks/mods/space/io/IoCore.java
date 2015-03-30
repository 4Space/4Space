package mattparks.mods.space.io;

import java.io.File;

import mattparks.mods.space.core.Constants;
import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.io.blocks.IoBlocks;
import mattparks.mods.space.io.dimension.TeleportTypeIo;
import mattparks.mods.space.io.dimension.WorldProviderIo;
import mattparks.mods.space.io.items.IoItems;
import mattparks.mods.space.io.proxy.CommonProxyIo;
import mattparks.mods.space.io.util.ConfigManagerIo;
import mattparks.mods.space.io.util.RecipeManagerIo;
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

@Mod(modid = Constants.MOD_ID_IO, name = Constants.MOD_NAME_IO, version = Constants.VERSION, dependencies = "required-after:GalacticraftCore;")
public class IoCore {
	public static final String ASSET_PREFIX = "spaceio";
	public static final String TEXTURE_PREFIX = IoCore.ASSET_PREFIX + ":";

	public static Moon moonIo;

	@SidedProxy(clientSide = "mattparks.mods.space.io.proxy.ClientProxyIo", serverSide = "mattparks.mods.space.io.proxy.CommonProxyIo")
	public static CommonProxyIo proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		new ConfigManagerIo(new File(event.getModConfigurationDirectory(), "4Space/io.cfg"));

		IoBlocks.init();
		IoItems.init();

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
		IoCore.moonIo = (Moon) new Moon("io").setParentPlanet(SpaceCore.planetJupiter).setRelativeSize(0.1367F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(10F, 10F)).setRelativeOrbitTime(1 / 0.01F);
		IoCore.moonIo.setDimensionInfo(ConfigManagerIo.idDimensionIo, WorldProviderIo.class).setTierRequired(3);
		IoCore.moonIo.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/io.png"));

		GalaxyRegistry.registerMoon(IoCore.moonIo);

		GalacticraftRegistry.registerTeleportType(WorldProviderIo.class, new TeleportTypeIo());

		GalacticraftRegistry.registerRocketGui(WorldProviderIo.class, new ResourceLocation(IoCore.TEXTURE_PREFIX + "textures/gui/ioRocketGui.png"));

		this.registerTileEntities();
		this.registerCreatures();
		this.registerOtherEntities();

		this.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		RecipeManagerIo.loadRecipes();

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
