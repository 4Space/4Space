package mattparks.mods.space.core.proxy;

import java.util.ArrayList;

import mattparks.mods.space.core.render.blocks.BlockRendererMercuryTreasureChest;
import mattparks.mods.space.core.render.blocks.BlockRendererVenusTreasureChest;
import mattparks.mods.space.core.render.tile.TileEntityMercuryTreasureChestRenderer;
import mattparks.mods.space.core.render.tile.TileEntityVenusTreasureChestRenderer;
import mattparks.mods.space.europa.particles.EntityEuropaWaterDripFX;
import mattparks.mods.space.mercury.blocks.MercuryBlocks;
import mattparks.mods.space.mercury.tile.TileEntityMercuryTreasureChest;
import mattparks.mods.space.venus.blocks.VenusBlocks;
import mattparks.mods.space.venus.entities.EntityEvolvedBlaze;
import mattparks.mods.space.venus.entities.EntityFlameling;
import mattparks.mods.space.venus.entities.EntityVenusianTNT;
import mattparks.mods.space.venus.entities.EntityVenusianVillager;
import mattparks.mods.space.venus.render.entities.RenderEvolvedBlaze;
import mattparks.mods.space.venus.render.entities.RenderFlameling;
import mattparks.mods.space.venus.render.entities.RenderVenusianTNT;
import mattparks.mods.space.venus.render.entities.RenderVenusianVillager;
import mattparks.mods.space.venus.tile.TileEntityVenusTreasureChest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.client.particle.EntityFX;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxySpace extends CommonProxySpace
{
	public static ArrayList<SoundPoolEntry> newMusic = new ArrayList<SoundPoolEntry>();
	private static Minecraft mc = FMLClientHandler.instance().getClient();
	private static int venusTreasureChestRenderID;
	private static int mercuryTreasureChestRenderID;

	@Override
	public void init(FMLInitializationEvent event)
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedBlaze.class, new RenderEvolvedBlaze());
		RenderingRegistry.registerEntityRenderingHandler(EntityFlameling.class, new RenderFlameling());
		RenderingRegistry.registerEntityRenderingHandler(EntityVenusianVillager.class, new RenderVenusianVillager());
		RenderingRegistry.registerEntityRenderingHandler(EntityVenusianTNT.class, new RenderVenusianTNT());

		ClientProxySpace.venusTreasureChestRenderID = RenderingRegistry.getNextAvailableRenderId();
		ClientProxySpace.mercuryTreasureChestRenderID = RenderingRegistry.getNextAvailableRenderId();

		RenderingRegistry.registerBlockHandler(new BlockRendererVenusTreasureChest(ClientProxySpace.venusTreasureChestRenderID));
		RenderingRegistry.registerBlockHandler(new BlockRendererMercuryTreasureChest(ClientProxySpace.mercuryTreasureChestRenderID));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVenusTreasureChest.class, new TileEntityVenusTreasureChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMercuryTreasureChest.class, new TileEntityMercuryTreasureChestRenderer());
	}

	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
	}

	@Override
	public void postInit(FMLPostInitializationEvent event)
	{
	}

	@Override
	public int getBlockRender(Block block)
	{
		if (block == VenusBlocks.venusTreasureChest)
		{
			return ClientProxySpace.venusTreasureChestRenderID;
		}
		else if (block == MercuryBlocks.mercuryTreasureChest)
		{
			return ClientProxySpace.mercuryTreasureChestRenderID;
		}
		return -1;
	}

	@Override
	public void spawnParticle(String string, double x, double y, double z)
	{
		EntityFX entityfx = null;

		if (string == "europaWaterDrip")
		{
			entityfx = new EntityEuropaWaterDripFX(mc.theWorld, x, y, z, Material.water);
		}
		mc.effectRenderer.addEffect(entityfx);
	}
}