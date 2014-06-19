package mattparks.mods.space.mercury.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class GCMercuryModelEvolvedSlime extends ModelBase
{
    ModelRenderer evolvedSlimeBodies;

    ModelRenderer evolvedSlimeRightEye;

    ModelRenderer evolvedSlimeLeftEye;

    ModelRenderer evolvedSlimeMouth;

    public GCMercuryModelEvolvedSlime(int par1)
    {
        this.evolvedSlimeBodies = new ModelRenderer(this, 0, par1);
        this.evolvedSlimeBodies.addBox(-4.0F, 16.0F, -4.0F, 8, 8, 8);

        if (par1 > 0)
        {
            this.evolvedSlimeBodies = new ModelRenderer(this, 0, par1);
            this.evolvedSlimeBodies.addBox(-3.0F, 17.0F, -3.0F, 6, 6, 6);
            this.evolvedSlimeRightEye = new ModelRenderer(this, 32, 0);
            this.evolvedSlimeRightEye.addBox(-3.25F, 18.0F, -3.5F, 2, 2, 2);
            this.evolvedSlimeLeftEye = new ModelRenderer(this, 32, 4);
            this.evolvedSlimeLeftEye.addBox(1.25F, 18.0F, -3.5F, 2, 2, 2);
            this.evolvedSlimeMouth = new ModelRenderer(this, 32, 8);
            this.evolvedSlimeMouth.addBox(0.0F, 21.0F, -3.5F, 1, 1, 1);
        }
    }

    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        this.evolvedSlimeBodies.render(par7);

        if (this.evolvedSlimeRightEye != null)
        {
            this.evolvedSlimeRightEye.render(par7);
            this.evolvedSlimeLeftEye.render(par7);
            this.evolvedSlimeMouth.render(par7);
        }
    }
}
