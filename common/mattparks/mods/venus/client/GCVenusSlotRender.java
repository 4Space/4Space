package mattparks.mods.venus.client;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import mattparks.mods.venus.GCVenus;
import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;

public class GCVenusSlotRender implements ICelestialBodyRenderer{

	@Override
	public ResourceLocation getPlanetSprite() {
		return new ResourceLocation(GCVenus.ASSET_DOMAIN, "textures/gui/planets/pixelearth.png");
	}

	@Override
	public String getPlanetName() {
		return "PixelEarth";
	}

	@Override
	public void renderSlot(int index, int x, int y, float slotHeight, Tessellator tessellator)
    {
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x - slotHeight * 0.9, y + slotHeight * 0.9, -90.0D, 0.0, 1.0);
        tessellator.addVertexWithUV(x + slotHeight * 0.9, y + slotHeight * 0.9, -90.0D, 1.0, 1.0);
        tessellator.addVertexWithUV(x + slotHeight * 0.9, y - slotHeight * 0.9, -90.0D, 1.0, 0.0);
        tessellator.addVertexWithUV(x - slotHeight * 0.9, y - slotHeight * 0.9, -90.0D, 0.0, 0.0);
        tessellator.draw();
    }

}
