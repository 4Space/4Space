package mattparks.mods.space.mercury.items;

import mattparks.mods.space.mercury.GCMercury;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCMercuryItemIridiumArmor extends ItemArmor
{
    public boolean attachedMask;
    private final EnumArmorMaterial material;

    public GCMercuryItemIridiumArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, boolean breathable)
    {
        super(par1, par2EnumArmorMaterial, par3, par4);
        this.material = par2EnumArmorMaterial;
        this.attachedMask = breathable;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
    {
        if (this.material == GCMercuryItems.ARMORIRIDIUM)
        {
            if (stack.getItem().itemID == GCMercuryItems.iridiumHelmet.itemID)
            {
                return "textures/model/armor/iridium_1.png";
            }
            else if (stack.getItem().itemID == GCMercuryItems.iridiumChestplate.itemID || stack.getItem().itemID == GCMercuryItems.iridiumBoots.itemID)
            {
                return "textures/model/armor/iridium_2.png";
            }
            else if (stack.getItem().itemID == GCMercuryItems.iridiumLeggings.itemID)
            {
                return "textures/model/armor/iridium_3.png";
            }
        }

        return null;
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return GCMercury.galacticraftMercuryTab;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(this.getUnlocalizedName().replace("item.", "galacticraftmercury:"));
    }

    @Override
    public Item setUnlocalizedName(String par1Str)
    {
        super.setTextureName(par1Str);
        super.setUnlocalizedName(par1Str);
        return this;
    }
}
