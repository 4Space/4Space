//package mattparks.mods.space.mercury.event;
//
//import java.net.MalformedURLException;
//
//import mattparks.mods.space.core.proxy.ClientProxySpace;
//import net.minecraft.client.audio.SoundHandler;
//import net.minecraft.client.audio.SoundPoolEntry;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.client.event.sound.SoundLoadEvent;
//import cpw.mods.fml.common.eventhandler.SubscribeEvent;
//import cpw.mods.fml.relauncher.Side;
//import cpw.mods.fml.relauncher.SideOnly;
//
//public class MercuryMusicEvents
//{
//	@SideOnly(Side.CLIENT)
//	@SubscribeEvent
//	public void onSoundLoad(SoundLoadEvent event)
//	{
//		ClientProxySpace.newMusic.add(this.func_110654_c(event.manager.sndHandler, "galacticraftmercury:music/Mercury_Magma.ogg"));
//		ClientProxySpace.newMusic.add(this.func_110654_c(event.manager.sndHandler, "galacticraftmercury:music/Mercury_Lava.ogg"));
//	}
//
//	@SideOnly(Side.CLIENT)
//	private SoundPoolEntry func_110654_c(SoundHandler sndHandler, String par1Str)
//	{
//		try
//		{
//			ResourceLocation resourcelocation = new ResourceLocation(par1Str);
//			String s1 = String.format("%s:%s:%s/%s", new Object[] { "mcsounddomain", resourcelocation.getResourceDomain(), "sound", resourcelocation.getResourcePath() });
//			SoundHandler soundpoolprotocolhandler = new SoundHandler(null, null);
//			return new SoundPoolEntry(resourcelocation, 0, 0, false);
//		}
//		catch (MalformedURLException e)
//		{
//			e.printStackTrace();
//		}
//		return null;
//	}
//}