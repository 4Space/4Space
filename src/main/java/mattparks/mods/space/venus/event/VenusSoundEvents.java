//package mattparks.mods.space.venus.event;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import mattparks.mods.space.core.proxy.ClientProxySpace;
//import net.minecraft.client.audio.SoundPoolEntry;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.client.event.sound.SoundLoadEvent;
//import cpw.mods.fml.common.eventhandler.SubscribeEvent;
//import cpw.mods.fml.relauncher.Side;
//import cpw.mods.fml.relauncher.SideOnly;
//
//public class VenusSoundEvents
//{
//	@SideOnly(Side.CLIENT)
//	@SubscribeEvent
//	public void onSoundLoad(SoundLoadEvent event)
//	{
//		ClientProxySpace.newMusic.add(this.func_110654_c(event.manager.soundPoolMusic, "galacticraftvenus:music/Venus_1.ogg"));
//		ClientProxySpace.newMusic.add(this.func_110654_c(event.manager.soundPoolMusic, "galacticraftvenus:music/Venus_2.ogg"));
//		ClientProxySpace.newMusic.add(this.func_110654_c(event.manager.soundPoolMusic, "galacticraftvenus:music/Venus_Ambience.ogg"));
//		ClientProxySpace.newMusic.add(this.func_110654_c(event.manager.soundPoolMusic, "galacticraftvenus:music/Venus_Bells.ogg"));
//	}
//
//	@SideOnly(Side.CLIENT)
//	private SoundPoolEntry func_110654_c(SoundPool pool, String par1Str)
//	{
//		try
//		{
//			ResourceLocation resourcelocation = new ResourceLocation(par1Str);
//			String s1 = String.format("%s:%s:%s/%s", new Object[] { "mcsounddomain", resourcelocation.getResourceDomain(), "sound", resourcelocation.getResourcePath() });
//			SoundPoolProtocolHandler soundpoolprotocolhandler = new SoundPoolProtocolHandler(pool);
//			return new SoundPoolEntry(par1Str, new URL((URL) null, s1, soundpoolprotocolhandler));
//		}
//		catch (MalformedURLException e)
//		{
//			e.printStackTrace();
//		}
//		return null;
//	}
//}