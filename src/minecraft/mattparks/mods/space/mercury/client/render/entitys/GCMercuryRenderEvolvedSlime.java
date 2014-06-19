package mattparks.mods.space.mercury.client.render.entitys;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mattparks.mods.space.mercury.GCMercury;
import mattparks.mods.space.mercury.entity.GCMercuryEntityEvolvedSlime;
import mattparks.mods.space.mercury.entity.GCMercuryEntityEvolvedSlime;
import mattparks.mods.space.venus.GCVenus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GCMercuryRenderEvolvedSlime extends RenderLiving
{
    private static final ResourceLocation evolvedSlimeTextures = new ResourceLocation(GCMercury.TEXTURE_DOMAIN, "textures/model/EvolvedSlime.png");
    private ModelBase scaleAmount;

    public GCMercuryRenderEvolvedSlime(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
    {
        super(par1ModelBase, par3);
        this.scaleAmount = par2ModelBase;
    }

    protected int shouldEvolvedSlimeRenderPass(GCMercuryEntityEvolvedSlime par1EntityEvolvedSlime, int par2, float par3)
    {
        if (par1EntityEvolvedSlime.isInvisible())
        {
            return 0;
        }
        else if (par2 == 0)
        {
            this.setRenderPassModel(this.scaleAmount);
            GL11.glEnable(GL11.GL_NORMALIZE);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            return 1;
        }
        else
        {
            if (par2 == 1)
            {
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }

            return -1;
        }
    }

    protected void scaleEvolvedSlime(GCMercuryEntityEvolvedSlime par1EntityEvolvedSlime, float par2)
    {
        float f1 = (float)par1EntityEvolvedSlime.getEvolvedSlimeSize();
        float f2 = (par1EntityEvolvedSlime.prevSquishFactor + (par1EntityEvolvedSlime.squishFactor - par1EntityEvolvedSlime.prevSquishFactor) * par2) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GL11.glScalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    protected ResourceLocation getEvolvedSlimeTextures(GCMercuryEntityEvolvedSlime par1EntityEvolvedSlime)
    {
        return evolvedSlimeTextures;
    }

    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleEvolvedSlime((GCMercuryEntityEvolvedSlime)par1EntityLivingBase, par2);
    }

    protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
    {
        return this.shouldEvolvedSlimeRenderPass((GCMercuryEntityEvolvedSlime)par1EntityLivingBase, par2, par3);
    }

    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getEvolvedSlimeTextures((GCMercuryEntityEvolvedSlime)par1Entity);
    }
}
