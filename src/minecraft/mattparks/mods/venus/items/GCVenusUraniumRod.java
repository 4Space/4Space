package mattparks.mods.venus.items;

import erogenousbeef.bigreactors.api.IReactorFuel;
import mattparks.mods.venus.GCVenus;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;

public class GCVenusUraniumRod extends Item implements IReactorFuel
{
	public GCVenusUraniumRod(int id, String assetName)
	{
		super(id);
		this.setUnlocalizedName(assetName);
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return GCVenus.galacticraftVenusTab;
	}

	@Override
	public boolean isFuelEqual(IReactorFuel otherFuel) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFuelEqual(Fluid fluid) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Fluid getReferenceFluid() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFuelColor() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Fluid getProductFluid() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFuel() 
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isWaste() 
	{
		// TODO Auto-generated method stub
		return false;
	}
}
