package mattparks.mods.space.venus.items;

import mattparks.mods.space.venus.GCVenus;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCVenusItemSulfurArmor extends ItemArmor
{
    public boolean attachedMask;
    private final EnumArmorMaterial material;

    public GCVenusItemSulfurArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, boolean breathable)
    {
        super(par1, par2EnumArmorMaterial, par3, par4);
        this.material = par2EnumArmorMaterial;
        this.attachedMask = breathable;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
    {
        if (this.material == GCVenusItems.ARMORSULFUR)
        {
            if (stack.getItem().itemID == GCVenusItems.sulfurHelmet.itemID)
            {
                return "textures/model/armor/sulfur_1.png";
            }
            else if (stack.getItem().itemID == GCVenusItems.sulfurChestplate.itemID || stack.getItem().itemID == GCVenusItems.sulfurBoots.itemID)
            {
                return "textures/model/armor/sulfur_2.png";
            }
            else if (stack.getItem().itemID == GCVenusItems.sulfurLeggings.itemID)
            {
                return "textures/model/armor/sulfur_3.png";
            }
        }

        return null;
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return GCVenus.galacticraftVenusTab;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(this.getUnlocalizedName().replace("item.", "galacticraftvenus:"));
    }

    @Override
    public Item setUnlocalizedName(String par1Str)
    {
        super.setTextureName(par1Str);
        super.setUnlocalizedName(par1Str);
        return this;
    }
}
