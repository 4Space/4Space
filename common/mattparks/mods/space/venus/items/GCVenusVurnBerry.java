package mattparks.mods.space.venus.items;
//package mattparks.mods.venus.items;

//import net.minecraft.block.Block;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.item.ItemFood;
//import net.minecraft.item.ItemStack;
//import net.minecraft.world.World;
//import net.minecraftforge.common.EnumPlantType;
//import net.minecraftforge.common.ForgeDirection;
//import net.minecraftforge.common.IPlantable;

//public class GCVenusVurnBerry extends ItemFood implements IPlantable
//{
//    private int cropId;

//    private int soilId;

//    public GCVenusVurnBerry(int par1, int par2, float par3, int par4, int par5)
//    {
//        super(par1, par2, par3, false);
//        this.cropId = par4;
//        this.soilId = par5;
//    }

//    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
//    {
//        if (par7 != 1)
//        {
//            return false;
//        }
//        else if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack))
//        {
//            int i1 = par3World.getBlockId(par4, par5, par6);
//            Block soil = Block.blocksList[i1];
//
//            if (soil != null && soil.canSustainPlant(par3World, par4, par5, par6, ForgeDirection.UP, this) && par3World.isAirBlock(par4, par5 + 1, par6))
//            {
//                par3World.setBlock(par4, par5 + 1, par6, this.cropId);
//                --par1ItemStack.stackSize;
//                return true;
//            }
//            else
//            {
//                return false;
//            }
//        }
//        else
//        {
//            return false;
//        }
//    }

//    @Override
//    public EnumPlantType getPlantType(World world, int x, int y, int z)
//    {
//        return EnumPlantType.Crop;
//    }

//    @Override
//    public int getPlantID(World world, int x, int y, int z)
//    {
//        return cropId;
//    }

//    @Override
//    public int getPlantMetadata(World world, int x, int y, int z)
//    {
//        return 0;
//    }
//}
