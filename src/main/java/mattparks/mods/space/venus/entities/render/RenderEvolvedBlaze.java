package mattparks.mods.space.venus.entities.render;

import mattparks.mods.space.venus.VenusCore;
import mattparks.mods.space.venus.entities.EntityEvolvedBlaze;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEvolvedBlaze extends RenderLiving
{
	private static final ResourceLocation evolvedBlazeTextures = new ResourceLocation(VenusCore.TEXTURE_PREFIX + "textures/model/evolvedBlaze.png");
	private int field_77068_a;

	public RenderEvolvedBlaze()
	{
		super(new ModelBlaze(), 0.5F);
		this.field_77068_a = ((ModelBlaze)this.mainModel).func_78104_a();
	}

	public void renderEvolvedBlaze(EntityEvolvedBlaze par1EntityEvolvedBlaze, double par2, double par4, double par6, float par8, float par9)
	{
		final int i = ((ModelBlaze)this.mainModel).func_78104_a();

		if (i != this.field_77068_a)
		{
			this.field_77068_a = i;
			this.mainModel = new ModelBlaze();
		}
		super.doRender(par1EntityEvolvedBlaze, par2, par4, par6, par8, par9);
	}

	protected ResourceLocation getEvolvedBlazeTextures(EntityEvolvedBlaze par1EntityBlaze)
	{
		return evolvedBlazeTextures;
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderEvolvedBlaze((EntityEvolvedBlaze)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderEvolvedBlaze((EntityEvolvedBlaze)par1EntityLivingBase, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEvolvedBlazeTextures((EntityEvolvedBlaze)par1Entity);
	}

	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderEvolvedBlaze((EntityEvolvedBlaze)par1Entity, par2, par4, par6, par8, par9);
	}
}