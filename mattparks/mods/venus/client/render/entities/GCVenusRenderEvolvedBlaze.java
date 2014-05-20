package mattparks.mods.venus.client.render.entities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mattparks.mods.venus.GCVenus;
import mattparks.mods.venus.entities.GCVenusEntityEvolvedBlaze;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GCVenusRenderEvolvedBlaze extends RenderLiving
{
    private static final ResourceLocation blazeTextures = new ResourceLocation(GCVenus.TEXTURE_DOMAIN, "textures/model/EvolvedBlaze.png");
    private int field_77068_a;

    public GCVenusRenderEvolvedBlaze()
    {
        super(new ModelBlaze(), 0.5F);
        this.field_77068_a = ((ModelBlaze)this.mainModel).func_78104_a();
    }

    public void renderBlaze(EntityBlaze par1EntityBlaze, double par2, double par4, double par6, float par8, float par9)
    {
        int i = ((ModelBlaze)this.mainModel).func_78104_a();

        if (i != this.field_77068_a)
        {
            this.field_77068_a = i;
            this.mainModel = new ModelBlaze();
        }

        super.doRenderLiving(par1EntityBlaze, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getBlazeTextures(EntityBlaze par1EntityBlaze)
    {
        return blazeTextures;
    }

    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderBlaze((EntityBlaze)par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderBlaze((EntityBlaze)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getBlazeTextures((EntityBlaze)par1Entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    @Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderBlaze((GCVenusEntityEvolvedBlaze)par1Entity, par2, par4, par6, par8, par9);
    }
    
    public void renderBlaze(GCVenusEntityEvolvedBlaze par1EntityEvolvedBlaze, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityEvolvedBlaze, par2, par4, par6, par8, par9);
    }
}
