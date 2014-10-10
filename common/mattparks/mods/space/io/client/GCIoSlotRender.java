package mattparks.mods.space.io.client;

import mattparks.mods.space.io.GCIo;
import micdoodle8.mods.galacticraft.api.world.ICelestialBodyRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

public class GCIoSlotRender implements ICelestialBodyRenderer
{
	@Override
	public String getPlanetName() 
	{
		return "Io";
	}

	@Override
	public ResourceLocation getPlanetSprite() 
	{
		return new ResourceLocation(GCIo.TEXTURE_DOMAIN, "textures/gui/planets/Io.png");
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
