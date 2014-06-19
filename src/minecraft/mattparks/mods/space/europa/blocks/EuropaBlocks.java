package mattparks.mods.space.europa.blocks;

import mattparks.mods.space.core.ConfigManager;
import mattparks.mods.space.europa.GCEuropa;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;


public class EuropaBlocks
{
	public static Block EuropaSurface;
	public static Block EuropaIce;
//	public static Block EuropaMeteorOre;

	
	public static void initBlocks()
	{
		EuropaBlocks.EuropaSurface = new GCEuropaBlock(ConfigManager.idBlockEuropaSurface, null).setHardness(0.6F).setResistance(0.0F).setUnlocalizedName( "EuropaSurface").setTextureName("galacticrafteuropa:SurfaceEuropa");

		EuropaBlocks.EuropaIce = new GCEuropaBlock(ConfigManager.idBlockEuropaIce, null).setHardness(1.0F).setResistance(0.0F).setUnlocalizedName( "EuropaIce").setTextureName("galacticrafteuropa:BottemEuropa");

//		EuropaBlocks.EuropaMeteorOre = new GCEuropaOre(ConfigManager.idBlockEuropaMeteorOre, null).setHardness(3.0F).setResistance(5.0F).setUnlocalizedName("EuropaMeteorOre").setTextureName("galacticraftEuropa:meteorOre"); 
	}

	public static void setHarvestLevels()
	{
		MinecraftForge.setBlockHarvestLevel(EuropaBlocks.EuropaSurface, "pickaxe", 1);
//		MinecraftForge.setBlockHarvestLevel(EuropaBlocks.EuropaIce, "shovel", 1);
//		MinecraftForge.setBlockHarvestLevel(EuropaBlocks.EuropaMeteorOre, "pickaxe", 1);
	}

	public static void registerBlocks()
	{
		GameRegistry.registerBlock(EuropaBlocks.EuropaSurface, ItemBlock.class, EuropaBlocks.EuropaSurface.getUnlocalizedName(), GCEuropa.MODID);
		GameRegistry.registerBlock(EuropaBlocks.EuropaIce, ItemBlock.class, EuropaBlocks.EuropaIce.getUnlocalizedName(), GCEuropa.MODID);
//		GameRegistry.registerBlock(EuropaBlocks.EuropaMeteorOre, ItemBlock.class, EuropaBlocks.EuropaMeteorOre.getUnlocalizedName(), GCEuropa.MODID);
	}
}
