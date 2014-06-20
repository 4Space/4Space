package mattparks.mods.space.venus.blocks;
//package mattparks.mods.venus.blocks;

//import cpw.mods.fml.relauncher.Side;
//import cpw.mods.fml.relauncher.SideOnly;
//import mattparks.mods.venus.items.GCVenusItems;
//import net.minecraft.block.BlockCrops;
//import net.minecraft.client.renderer.texture.IconRegister;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.Icon;
//import net.minecraft.world.World;

//public class GCVenusVurnBerryBush extends BlockCrops
//{
//    @SideOnly(Side.CLIENT)
//    private Icon[] iconArray;

//    public GCVenusVurnBerryBush(int par1)
//    {
//        super(par1);
//    }

//    @SideOnly(Side.CLIENT)
//    public Icon getIcon(int par1, int par2)
//    {
//        if (par2 < 7)
//        {
//            if (par2 == 6)
//            {
//                par2 = 5;
//            }

//            return this.iconArray[par2 >> 1];
//        }
//        else
//        {
//            return this.iconArray[3];
//        }
//    }

//    protected int getSeedItem()
//    {
//        return GCVenusItems.vurnBerry.itemID;
//    }

//    protected int getCropItem()
//    {
//        return GCVenusItems.vurnBerry.itemID;
//    }

//    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
//    {
//        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

//        if (!par1World.isRemote)
//        {
//            if (par5 >= 7 && par1World.rand.nextInt(50) == 0)
//            {
//                this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(Item.potato));
//            }
//        }
//    }

//    @SideOnly(Side.CLIENT)
//    public void registerIcons(IconRegister par1IconRegister)
//    {
//        this.iconArray = new Icon[4];
//
//        for (int i = 0; i < this.iconArray.length; ++i)
//        {
//            this.iconArray[i] = par1IconRegister.registerIcon(this.getTextureName() + "_stage_" + i);
//        }
//    }
//}
