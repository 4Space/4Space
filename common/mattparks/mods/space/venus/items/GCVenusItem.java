package mattparks.mods.space.venus.items;

import java.util.List;

import mattparks.mods.space.venus.GCVenus;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusItem extends Item
{
    public static String[] names = { "sulfurDust", "ingotSulfur", "redGem", "ingotUranium", "venusCrystal", "sulfurPlate", "redGemPlate", "uraniumPlate", "plateHeavyT3", "venusRodDust", "jetpackThruster", "jetpackBody", "venusPowerCrystal", 
	//"FossilizedPlant" 
	};
    protected Icon[] icons = new Icon[GCVenusItem.names.length];

    public GCVenusItem(int par1)
    {
        super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (par1ItemStack != null && par1ItemStack.getItemDamage() == 8)
		{
			par3List.add(StatCollector.translateToLocal("item.tier3.desc"));
		}
	}

    @Override
    public CreativeTabs getCreativeTab()
    {
        return GCVenus.galacticraftVenusTab;
    }

    @Override
    public Icon getIconFromDamage(int damage)
    {
        if (this.icons.length > damage)
        {
            return this.icons[damage];
        }

        return super.getIconFromDamage(damage);
    }

    @Override
    public int getMetadata(int par1)
    {
        return par1;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int i = 0; i < GCVenusItem.names.length; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        if (this.icons.length > par1ItemStack.getItemDamage())
        {
            return "item." + GCVenusItem.names[par1ItemStack.getItemDamage()];
        }

        return "unnamed";
    }
    
    @Override
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
	{
    	if(par1ItemStack.getItemDamage() == 12)
    	{
    		return true;
    	}
    	
    	return false;
	}
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        int i = 0;

        for (String name : GCVenusItem.names)
        {
            this.icons[i++] = iconRegister.registerIcon(GCVenus.TEXTURE_PREFIX + name);
        }
    }
}
