package mattparks.mods.space.europa.client;

import mattparks.mods.space.europa.GCEuropa;
import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

public class GCEuropaSlotRender implements ICelestialBodyRenderer
{
	@Override
	public String getPlanetName() 
	{
		return "Europa";
	}

	@Override
	public ResourceLocation getPlanetSprite() 
	{
		return new ResourceLocation(GCEuropa.TEXTURE_DOMAIN, "textures/gui/planets/Europa.png");
	}

	@Override
	public void renderSlot(int index, int x, int y, float slotHeight, Tessellator tessellator)
	{
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(x - slotHeight / 2 * 1.25, y + slotHeight / 2 * 1.25, -90.0D, 0.35D, 0.65D);
		tessellator.addVertexWithUV(x + slotHeight / 2 * 1.25, y + slotHeight / 2 * 1.25, -90.0D, 0.65D, 0.65D);
		tessellator.addVertexWithUV(x + slotHeight / 2 * 1.25, y - slotHeight / 2 * 1.25, -90.0D, 0.65D, 0.35D);
		tessellator.addVertexWithUV(x - slotHeight / 2 * 1.25, y - slotHeight / 2 * 1.25, -90.0D, 0.35D, 0.35D);
		tessellator.draw();
	}
}
