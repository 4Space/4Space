package mattparks.mods.venus.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class GCVenusModelEvolvedBlaze extends ModelBase
{
	ModelRenderer oxygenMask;//
	
    /** The sticks that fly around the Blaze. */
    private ModelRenderer[] blazeSticks = new ModelRenderer[12];
    private ModelRenderer blazeHead;

    public GCVenusModelEvolvedBlaze()
    {
        for (int i = 0; i < this.blazeSticks.length; ++i)
        {
            this.blazeSticks[i] = new ModelRenderer(this, 0, 16);
            this.blazeSticks[i].addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
        }

//		this.oxygenMask = new ModelRenderer(this, 48, 0);//
//		this.oxygenMask.addBox(-5F, -9F, -5F, 10, 10, 10);//
//		this.oxygenMask.setRotationPoint(0F, 0F, 0F);//
//		this.oxygenMask.setTextureSize(128, 64);//
//		this.oxygenMask.mirror = true;//
//		this.setRotation(this.oxygenMask, 0F, 0F, 0F);//
		
        this.blazeHead = new ModelRenderer(this, 0, 0);
        this.blazeHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
    }

//	private void setRotation(ModelRenderer model, float x, float y, float z)//
//	{//
//		model.rotateAngleX = x;//
//		model.rotateAngleY = y;//
//		model.rotateAngleZ = z;//
//	}//
	
    public int func_78104_a()
    {
        return 8;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        this.blazeHead.render(par7);

//        this.oxygenMask.render(f5);//
        
        for (int i = 0; i < this.blazeSticks.length; ++i)
        {
            this.blazeSticks[i].render(par7);
        }
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
    {
//		this.oxygenMask.rotateAngleY = par4 / (180F / (float) Math.PI);//
//		this.oxygenMask.rotateAngleX = par5 / (180F / (float) Math.PI);//
		
        float f6 = par3 * (float)Math.PI * -0.1F;
        int i;

        for (i = 0; i < 4; ++i)
        {
            this.blazeSticks[i].rotationPointY = -2.0F + MathHelper.cos(((float)(i * 2) + par3) * 0.25F);
            this.blazeSticks[i].rotationPointX = MathHelper.cos(f6) * 9.0F;
            this.blazeSticks[i].rotationPointZ = MathHelper.sin(f6) * 9.0F;
            ++f6;
        }

        f6 = ((float)Math.PI / 4F) + par3 * (float)Math.PI * 0.03F;

        for (i = 4; i < 8; ++i)
        {
            this.blazeSticks[i].rotationPointY = 2.0F + MathHelper.cos(((float)(i * 2) + par3) * 0.25F);
            this.blazeSticks[i].rotationPointX = MathHelper.cos(f6) * 7.0F;
            this.blazeSticks[i].rotationPointZ = MathHelper.sin(f6) * 7.0F;
            ++f6;
        }

        f6 = 0.47123894F + par3 * (float)Math.PI * -0.05F;

        for (i = 8; i < 12; ++i)
        {
            this.blazeSticks[i].rotationPointY = 11.0F + MathHelper.cos(((float)i * 1.5F + par3) * 0.5F);
            this.blazeSticks[i].rotationPointX = MathHelper.cos(f6) * 5.0F;
            this.blazeSticks[i].rotationPointZ = MathHelper.sin(f6) * 5.0F;
            ++f6;
        }

        this.blazeHead.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.blazeHead.rotateAngleX = par5 / (180F / (float)Math.PI);
    }
}
