package mattparks.mods.space.venus.client.render.entities;

import mattparks.mods.space.venus.GCVenus;
import mattparks.mods.space.venus.client.model.GCVenusModelVenusianVillager;
import mattparks.mods.space.venus.entities.GCVenusEntityVenusianVillager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GCVenusRenderVenusianVillager extends RenderLiving
{
    private static final ResourceLocation villagerTexture = new ResourceLocation(GCVenus.TEXTURE_DOMAIN, "textures/model/villager.png");

    protected GCVenusModelVenusianVillager villagerModel;

    public GCVenusRenderVenusianVillager()
    {
        super(new GCVenusModelVenusianVillager(0.0F), 0.5F);
        this.villagerModel = (GCVenusModelVenusianVillager) this.mainModel;
    }

    @Override
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderVillager((GCVenusEntityVenusianVillager) par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderVillager((GCVenusEntityVenusianVillager) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation func_110902_a(GCVenusEntityVenusianVillager par1EntityVillager)
    {
        return GCVenusRenderVenusianVillager.villagerTexture;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110902_a((GCVenusEntityVenusianVillager) par1Entity);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderVillager((GCVenusEntityVenusianVillager) par1EntityLivingBase, par2);
    }

    protected void preRenderVillager(GCVenusEntityVenusianVillager par1EntityVillager, float par2)
    {
        float f1 = 0.9375F;

        if (par1EntityVillager.getGrowingAge() < 0)
        {
            f1 = (float) (f1 * 0.5D);
            this.shadowSize = 0.25F;
        }
        else
        {
            this.shadowSize = 0.5F;
        }

        GL11.glScalef(f1, f1, f1);
    }

    @Override
    protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.renderVillagerEquipedItems((GCVenusEntityVenusianVillager) par1EntityLivingBase, par2);
    }

    @Override
    public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderVillager((GCVenusEntityVenusianVillager) par1EntityLivingBase, par2, par4, par6, par8, par9);
    }

    public void renderVillager(GCVenusEntityVenusianVillager par1EntityVillager, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntityVillager, par2, par4, par6, par8, par9);
    }

    protected void renderVillagerEquipedItems(GCVenusEntityVenusianVillager par1EntityVillager, float par2)
    {
        super.renderEquippedItems(par1EntityVillager, par2);
    }

    @Override
    protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
    {
        return this.shouldVillagerRenderPass((GCVenusEntityVenusianVillager) par1EntityLivingBase, par2, par3);
    }

    protected int shouldVillagerRenderPass(GCVenusEntityVenusianVillager par1EntityVillager, int par2, float par3)
    {
        return -1;
    }
}
