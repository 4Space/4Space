package mattparks.mods.space.venus.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GCVenusModelEvolvedBlaze extends ModelBase
{
    public GCVenusModelEvolvedBlaze()
    {
    	;
    }

    public int func_78104_a()
    {
        return 8;
    }

    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    }
}