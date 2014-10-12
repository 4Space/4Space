package mattparks.mods.space.venus.blocks;

import mattparks.mods.space.core.util.ConfigManager;
import mattparks.mods.space.venus.GCVenus;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class VenusBlocks
{
	public static void initBlocks()
	{
		VenusBlocks.VenusGrass = new GCVenusGrass(ConfigManager.idBlockVenusGrass, null).setHardness(0.6F).setResistance(0.0F).setUnlocalizedName("VenusGrass").setTextureName("galacticraftvenus:grassVenus");
		
		VenusBlocks.VenusDirt = new GCVenusBlock(ConfigManager.idBlockVenusDirt, null).setHardness(1.0F).setResistance(0.0F).setUnlocalizedName("VenusDirt").setTextureName("galacticraftvenus:dirtVenus");
		
		VenusBlocks.VenusStone = new GCVenusBlock(ConfigManager.idBlockVenusStone, null).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("VenusStone").setTextureName("galacticraftvenus:stoneVenus");
		
		VenusBlocks.VenusBrick = new GCVenusBrick(ConfigManager.idBlockVenusBrick, null).setHardness(25.0F).setResistance(6000000.0F).setUnlocalizedName("VenusBrick").setTextureName("galacticraftvenus:venusBrick");
		
		VenusBlocks.EvolvedBlazeEgg = new GCVenusEgg(ConfigManager.idBlockVenusBlazeEgg).setHardness(15.0F).setResistance(0.0F).setUnlocalizedName("EvolvedBlazeEgg").setTextureName("galacticraftvenus:evolvedBlazeEgg");
	
		VenusBlocks.VenusRedGemBlock = new GCVenusDecoration(ConfigManager.idBlockVenusRedGemBlock, null).setHardness(5.0F).setResistance(10.0F).setUnlocalizedName("VenusGemBlock").setTextureName("galacticraftvenus:gemBlock");

		VenusBlocks.VenusSulfurBlock = new GCVenusDecoration(ConfigManager.idBlockVenusSulfurBlock, null).setHardness(5.0F).setResistance(10.0F).setUnlocalizedName("VenusSulfurBlock").setTextureName("galacticraftvenus:sulfurBlock");

		VenusBlocks.VenusUraniumBlock = new GCVenusDecoration(ConfigManager.idBlockVenusUraniumBlock, null).setHardness(5.0F).setResistance(10.0F).setUnlocalizedName("VenusUraniumBlock").setTextureName("galacticraftvenus:uraniumBlock");

		VenusBlocks.VenusCrystalBlock = new GCVenusCrystalBlock(ConfigManager.idBlockVenusCrystalBlock, null).setHardness(0.75F).setResistance(0.75F).setUnlocalizedName("VenusCrystalBlock").setTextureName("galacticraftvenus:VenusCrystalBlock");

		VenusBlocks.VenusCompositeBlock = new GCVenusDecoration(ConfigManager.idBlockVenusCompositeBlock, null).setHardness(0.75F).setResistance(0.75F).setUnlocalizedName("VenusCompositeBlock").setTextureName("galacticraftvenus:VenusCompositeBlock");

		VenusBlocks.VenusSulfurOre = new GCVenusOre(ConfigManager.idBlockVenusSulfurOre, null).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("VenusSulfurOre").setTextureName("galacticraftvenus:sulfurOre");

		VenusBlocks.VenusRedGemOre = new GCVenusOre(ConfigManager.idBlockVenusRedGemOre, null).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("VenusGemOre").setTextureName("galacticraftvenus:gemOre");

		VenusBlocks.VenusUraniumOre = new GCVenusOre(ConfigManager.idBlockVenusUraniumOre, null).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("VenusUraniumOre").setTextureName("galacticraftvenus:uraniumOre");

		VenusBlocks.VenusIronOre = new GCVenusOre(ConfigManager.idBlockVenusIronOre, null).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("VenusIronOre").setTextureName("galacticraftvenus:ironOre");

		VenusBlocks.VenusCoalOre = new GCVenusOre(ConfigManager.idBlockVenusCoalOre, null).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("VenusCoalOre").setTextureName("galacticraftvenus:coalOre");

		VenusBlocks.VenusTinOre = new GCVenusOre(ConfigManager.idBlockVenusTinOre, null).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("VenusTinOre").setTextureName("galacticraftvenus:tinOre");

		VenusBlocks.VenusCopperOre = new GCVenusOre(ConfigManager.idBlockVenusCopperOre, null).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("VenusCopperOre").setTextureName("galacticraftvenus:copperOre");

		VenusBlocks.VenusCrystalOre = new GCVenusOre(ConfigManager.idBlockVenusCrystalOre, null).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("VenusCrystalOre").setTextureName("galacticraftvenus:venusCrystalOre");
    
		VenusBlocks.FossilizedPlantOre = new GCVenusOre(ConfigManager.idBlockVenusFossilizedPlantOre, null).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("FossilizedPlantOre").setTextureName("galacticraftvenus:fossilizedPlantOre");
	    
		VenusBlocks.SulfurTorch = new GCVenusSulfurTorch(ConfigManager.idBlockVenusSulfurTorch).setHardness(0.1F).setUnlocalizedName("SulfurTorch").setTextureName("galacticraftvenus:sulfurTorch");

		VenusBlocks.VenusSpaceStone = new GCVenusSpaceStone(ConfigManager.idBlockVenusSpaceStone, null).setHardness(0.1F).setLightValue(1.0F).setUnlocalizedName("VenusSpaceStone").setTextureName("galacticraftvenus:spaceStone");

//		VenusBlocks.VurnBerryBush = (new GCVenusVurnBerryBush(ConfigManager.idBlockVurnBerryBush)).setUnlocalizedName("VurnBerryBush").setTextureName("galacticraftvenus:VurnBerryBush");
	}
	public static void registerBlocks()
	{
		GameRegistry.registerBlock(VenusBlocks.VenusGrass, ItemBlock.class, VenusBlocks.VenusGrass.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.VenusDirt, ItemBlock.class, VenusBlocks.VenusDirt.getUnlocalizedName(), GCVenus.MODID);

		GameRegistry.registerBlock(VenusBlocks.VenusStone, ItemBlock.class, VenusBlocks.VenusStone.getUnlocalizedName(), GCVenus.MODID);

		GameRegistry.registerBlock(VenusBlocks.VenusBrick, ItemBlock.class, VenusBlocks.VenusBrick.getUnlocalizedName(), GCVenus.MODID);

		GameRegistry.registerBlock(VenusBlocks.EvolvedBlazeEgg, ItemBlock.class, VenusBlocks.EvolvedBlazeEgg.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.VenusRedGemBlock, ItemBlock.class, VenusBlocks.VenusRedGemBlock.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.VenusSulfurBlock, ItemBlock.class, VenusBlocks.VenusSulfurBlock.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.VenusUraniumBlock, ItemBlock.class, VenusBlocks.VenusUraniumBlock.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.VenusCrystalBlock, ItemBlock.class, VenusBlocks.VenusCrystalBlock.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.VenusCompositeBlock, ItemBlock.class, VenusBlocks.VenusCompositeBlock.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.VenusSulfurOre, ItemBlock.class, VenusBlocks.VenusSulfurOre.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.VenusRedGemOre, ItemBlock.class, VenusBlocks.VenusRedGemOre.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.VenusUraniumOre, ItemBlock.class, VenusBlocks.VenusUraniumOre.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.VenusIronOre, ItemBlock.class, VenusBlocks.VenusIronOre.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.VenusCoalOre, ItemBlock.class, VenusBlocks.VenusCoalOre.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.VenusTinOre, ItemBlock.class, VenusBlocks.VenusTinOre.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.VenusCopperOre, ItemBlock.class, VenusBlocks.VenusCopperOre.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.VenusCrystalOre, ItemBlock.class, VenusBlocks.VenusCrystalOre.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.FossilizedPlantOre, ItemBlock.class, VenusBlocks.FossilizedPlantOre.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.SulfurTorch, ItemBlock.class, VenusBlocks.SulfurTorch.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.VenusSpaceStone, ItemBlock.class, VenusBlocks.VenusSpaceStone.getUnlocalizedName(), GCVenus.MODID);
		
//		GameRegistry.registerBlock(VenusBlocks.VurnBerryBush, ItemBlock.class, VenusBlocks.VurnBerryBush.getUnlocalizedName(), GCVenus.MODID);
	}
	public static void setHarvestLevels()
	{
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusGrass, "pickaxe", 1);
		
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusDirt, "pickaxe", 1);
		
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusStone, "pickaxe", 1);
		
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusBrick, "pickaxe", 1);
		
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.EvolvedBlazeEgg, "pickaxe", 1);
		
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusRedGemBlock, "pickaxe", 1);
		
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusSulfurBlock, "pickaxe", 1);
		
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusUraniumBlock, "pickaxe", 1);
		
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusCrystalBlock, "pickaxe", 1);
		
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusCompositeBlock, "pickaxe", 1);
		
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusSulfurOre, "pickaxe", 1);
		
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusRedGemOre, "pickaxe", 1);
		
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusIronOre, "pickaxe", 1);
		
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusCoalOre, "pickaxe", 1);
		
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusTinOre, "pickaxe", 1);
		
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusCopperOre, "pickaxe", 1);
		
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusCrystalOre, "pickaxe", 1);
		
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.FossilizedPlantOre, "pickaxe", 1);
		
//		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VurnBerryBush, "pickaxe", 1);
	}
	public static Block VenusGrass;
	public static Block VenusDirt;
	public static Block VenusStone;
	public static Block VenusBrick;
	public static Block EvolvedBlazeEgg;
	public static Block VenusRedGemBlock;
	public static Block VenusSulfurBlock;
	public static Block VenusUraniumBlock;
	public static Block VenusCrystalBlock;
	public static Block VenusCompositeBlock;
	public static Block VenusSulfurOre;
	public static Block VenusRedGemOre;
	public static Block VenusUraniumOre;
	public static Block VenusIronOre;
	public static Block VenusCoalOre;
	public static Block VenusTinOre;
	public static Block VenusCopperOre;
	public static Block VenusSpaceStone;
	
	public static Block VenusCrystalOre;

	public static Block FossilizedPlantOre;

	public static Block SulfurTorch;
//	public static Block VurnBerryBush;
}
