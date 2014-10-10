package mattparks.mods.space.venus.client.render.entities;

import mattparks.mods.space.venus.GCVenus;
import mattparks.mods.space.venus.client.model.GCVenusModelEvolvedBlaze;
import mattparks.mods.space.venus.entities.GCVenusEntityEvolvedBlaze;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GCVenusRenderEvolvedBlaze extends RenderLiving
{
    private static final ResourceLocation evolvedBlazeTextures = new ResourceLocation(GCVenus.TEXTURE_DOMAIN, "textures/model/EvolvedBlaze.png");
    private int field_77068_a;

    public GCVenusRenderEvolvedBlaze()
    {
        super(new GCVenusModelEvolvedBlaze(), 0.5F);
        this.field_77068_a = ((GCVenusModelEvolvedBlaze)this.mainModel).func_78104_a();
    }

    @Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderEvolvedBlaze((GCVenusEntityEvolvedBlaze)par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderEvolvedBlaze((GCVenusEntityEvolvedBlaze)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    @Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getEvolvedBlazeTextures((GCVenusEntityEvolvedBlaze)par1Entity);
    }

    protected ResourceLocation getEvolvedBlazeTextures(GCVenusEntityEvolvedBlaze par1EntityBlaze)
    {
        return evolvedBlazeTextures;
    }

    public void renderEvolvedBlaze(GCVenusEntityEvolvedBlaze par1EntityEvolvedBlaze, double par2, double par4, double par6, float par8, float par9)
    {
        int i = ((GCVenusModelEvolvedBlaze)this.mainModel).func_78104_a();

        if (i != this.field_77068_a)
        {
            this.field_77068_a = i;
            this.mainModel = new GCVenusModelEvolvedBlaze();
        }

        super.doRenderLiving(par1EntityEvolvedBlaze, par2, par4, par6, par8, par9);
    }

    @Override
	public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderEvolvedBlaze((GCVenusEntityEvolvedBlaze)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }
}
