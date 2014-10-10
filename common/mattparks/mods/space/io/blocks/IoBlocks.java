package mattparks.mods.space.io.blocks;

import mattparks.mods.space.core.util.ConfigManager;
import mattparks.mods.space.io.GCIo;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;


public class IoBlocks
{
	public static void initBlocks()
	{
		IoBlocks.IoSlab = new GCIoSlab(ConfigManager.idBlockIoSlab, null).setHardness(0.6F).setResistance(0.0F).setUnlocalizedName( "IoSlab").setTextureName("galacticraftio:IoSlab");

		IoBlocks.IoFull = new GCIoBlock(ConfigManager.idBlockIoFull, null).setHardness(0.6F).setResistance(0.0F).setUnlocalizedName( "IoFull").setTextureName("galacticraftio:IoFull");

		IoBlocks.IoStone = new GCIoBlock(ConfigManager.idBlockIoStone, null).setHardness(1.0F).setResistance(0.0F).setUnlocalizedName( "IoStone").setTextureName("galacticraftio:IoStone");
	}
	public static void registerBlocks()
	{
		GameRegistry.registerBlock(IoBlocks.IoSlab, ItemBlock.class, IoBlocks.IoSlab.getUnlocalizedName(), GCIo.MODID);
		GameRegistry.registerBlock(IoBlocks.IoFull, ItemBlock.class, IoBlocks.IoFull.getUnlocalizedName(), GCIo.MODID);
		GameRegistry.registerBlock(IoBlocks.IoStone, ItemBlock.class, IoBlocks.IoStone.getUnlocalizedName(), GCIo.MODID);
	}
	public static void setHarvestLevels()
	{
		MinecraftForge.setBlockHarvestLevel(IoBlocks.IoSlab, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(IoBlocks.IoFull, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(IoBlocks.IoStone, "pickaxe", 1);
	}

	
	public static Block IoSlab;

	public static Block IoFull;

	public static Block IoStone;
}
