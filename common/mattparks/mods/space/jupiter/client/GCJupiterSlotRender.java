package mattparks.mods.space.jupiter.client;

import mattparks.mods.space.jupiter.GCJupiter;
import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

public class GCJupiterSlotRender implements ICelestialBodyRenderer
{
	@Override
	public String getPlanetName() 
	{
		return "Jupiter";
	}

	@Override
	public ResourceLocation getPlanetSprite() 
	{
		return new ResourceLocation(GCJupiter.TEXTURE_DOMAIN, "textures/gui/planets/Jupiter.png");
	}

	@Override
	public void renderSlot(int index, int x, int y, float slotHeight, Tessellator tessellator)
	{
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x - slotHeight / 2 * 1.3, y + slotHeight / 2 * 1.3, -90.0D, 0.35D, 0.65D);
        tessellator.addVertexWithUV(x + slotHeight / 2 * 1.3, y + slotHeight / 2 * 1.3, -90.0D, 0.65D, 0.65D);
        tessellator.addVertexWithUV(x + slotHeight / 2 * 1.3, y - slotHeight / 2 * 1.3, -90.0D, 0.65D, 0.35D);
        tessellator.addVertexWithUV(x - slotHeight / 2 * 1.3, y - slotHeight / 2 * 1.3, -90.0D, 0.35D, 0.35D);
        tessellator.draw();
	}
}
