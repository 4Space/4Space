package mattparks.mods.space.core.proxy;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy 
{
	public static EnumRarity spaceItem = EnumHelper.addRarity("SpaceRarity", EnumChatFormatting.RED, "Space");
	
    @Override
    public void preInit(FMLPreInitializationEvent event) 
    {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) 
    {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) 
    {
        super.postInit(event);
    }
}
