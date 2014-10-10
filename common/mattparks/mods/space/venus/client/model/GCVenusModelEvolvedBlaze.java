package mattparks.mods.space.venus.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GCVenusModelEvolvedBlaze extends ModelBase
{
    private ModelRenderer[] evolvedBlazeSticks = new ModelRenderer[12];
    private ModelRenderer evolvedBlazeHead;

    public GCVenusModelEvolvedBlaze()
    {
        for (int i = 0; i < this.evolvedBlazeSticks.length; ++i)
        {
            this.evolvedBlazeSticks[i] = new ModelRenderer(this, 0, 16);
            this.evolvedBlazeSticks[i].addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
        }

        this.evolvedBlazeHead = new ModelRenderer(this, 0, 0);
        this.evolvedBlazeHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
    }

    public int func_78104_a()
    {
        return 8;
    }

    @Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        this.evolvedBlazeHead.render(par7);

        for (int i = 0; i < this.evolvedBlazeSticks.length; ++i)
        {
            this.evolvedBlazeSticks[i].render(par7);
        }
    }

    @Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
    {
        float f6 = par3 * (float)Math.PI * -0.1F;
        int i;

        for (i = 0; i < 4; ++i)
        {
            this.evolvedBlazeSticks[i].rotationPointY = -2.0F + MathHelper.cos((i * 2 + par3) * 0.25F);
            this.evolvedBlazeSticks[i].rotationPointX = MathHelper.cos(f6) * 9.0F;
            this.evolvedBlazeSticks[i].rotationPointZ = MathHelper.sin(f6) * 9.0F;
            ++f6;
        }

        f6 = ((float)Math.PI / 4F) + par3 * (float)Math.PI * 0.03F;

        for (i = 4; i < 8; ++i)
        {
            this.evolvedBlazeSticks[i].rotationPointY = 2.0F + MathHelper.cos((i * 2 + par3) * 0.25F);
            this.evolvedBlazeSticks[i].rotationPointX = MathHelper.cos(f6) * 7.0F;
            this.evolvedBlazeSticks[i].rotationPointZ = MathHelper.sin(f6) * 7.0F;
            ++f6;
        }

        f6 = 0.47123894F + par3 * (float)Math.PI * -0.05F;

        for (i = 8; i < 12; ++i)
        {
            this.evolvedBlazeSticks[i].rotationPointY = 11.0F + MathHelper.cos((i * 1.5F + par3) * 0.5F);
            this.evolvedBlazeSticks[i].rotationPointX = MathHelper.cos(f6) * 5.0F;
            this.evolvedBlazeSticks[i].rotationPointZ = MathHelper.sin(f6) * 5.0F;
            ++f6;
        }

        this.evolvedBlazeHead.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.evolvedBlazeHead.rotateAngleX = par5 / (180F / (float)Math.PI);
    }
}
