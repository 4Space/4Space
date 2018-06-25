package mattparks.mods.space.pluto.proxy;

import java.util.EnumSet;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxyPluto {
	public void preInit(FMLPreInitializationEvent event) {
	}

	public void init(FMLInitializationEvent event) {
	}

	public void postInit(FMLPostInitializationEvent event) {
	}

	public void registerRenderInfo() {
	}

	public int getSapphireArmorRenderIndex() {
		return 0;
	}

	public int getBlockRender(Block block) {
		return -1;
	}

	public void tickStart(EnumSet type, Object[] tickData) {
	}

}
