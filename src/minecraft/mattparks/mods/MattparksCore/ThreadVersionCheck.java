package mattparks.mods.MattparksCore;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.minecraft.util.StatCollector;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class ThreadVersionCheck extends Thread
{
	public static ThreadVersionCheck instance = new ThreadVersionCheck();
	private int count = 0;

	public ThreadVersionCheck()
	{
		super("Mattparks Core Version Check Thread");
	}

	public static void startCheck(Side sideToCheck)
	{
		final Thread thread = new Thread(ThreadVersionCheck.instance);
		thread.start();
	}

	@Override
	public void run()
	{
		final Side sideToCheck = FMLCommonHandler.instance().getSide();

		if (sideToCheck == null)
		{
			return;
		}

		while (this.count < 3 && MattCore.remoteBuildVer == 0)
		{
			try
			{
				final URL url = new URL("http://version.mattparks.host22.com/MattparksCore.html");
				final HttpURLConnection http = (HttpURLConnection) url.openConnection();
				http.addRequestProperty("User-Agent", "Mozilla/4.76");
				final BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
				String str;
				String str2[] = null;

				while ((str = in.readLine()) != null)
				{

					if (str.contains("Version"))
					{
						str = str.replace("Version=", "");

						str2 = str.split("#");

						if (str2 != null && str2.length == 3)
						{
							MattCore.remoteMajVer = Integer.parseInt(str2[0]);
							MattCore.remoteMinVer = Integer.parseInt(str2[1]);
							MattCore.remoteBuildVer = Integer.parseInt(str2[2]);
						}

						if (MattCore.remoteMajVer > MattCore.LOCALMAJVERSION || MattCore.remoteMajVer == MattCore.LOCALMAJVERSION && MattCore.remoteMinVer > MattCore.LOCALMINVERSION || MattCore.remoteMajVer == MattCore.LOCALMAJVERSION && MattCore.remoteMinVer == MattCore.LOCALMINVERSION && MattCore.remoteBuildVer > MattCore.LOCALBUILDVERSION)
						{
							Thread.sleep(5000);

							if (sideToCheck.equals(Side.CLIENT))
							{
								FMLClientHandler.instance().getClient().thePlayer.addChatMessage(EnumColor.GREY + "New " + EnumColor.DARK_AQUA + "Galacticraft Venus" + EnumColor.GREY + " version available! v" + String.valueOf(MattCore.remoteMajVer) + "." + String.valueOf(MattCore.remoteMinVer) + "." + String.valueOf(MattCore.remoteBuildVer) + EnumColor.DARK_BLUE + " http://mattparks.host22.com/");
							}
							else if (sideToCheck.equals(Side.SERVER))
							{
								Log.severe("New Mattparks mod versions available! v" + String.valueOf(MattCore.remoteMajVer) + "." + String.valueOf(MattCore.remoteMinVer) + "." + String.valueOf(MattCore.remoteBuildVer) + " http://mattparks.host22.com/");
							}
						}
					}
				}
			}
			catch (final Exception e)
			{
			}

			if (MattCore.remoteBuildVer == 0)
			{
				try
				{
					Log.severe(StatCollector.translateToLocal("newversion.failed.name"));
					Thread.sleep(15000);
				}
				catch (final InterruptedException e)
				{
				}
			}
			else
			{
				Log.info(StatCollector.translateToLocal("newversion.success.name") + " " + MattCore.remoteMajVer + "." + MattCore.remoteMinVer + "." + MattCore.remoteBuildVer);
			}

			this.count++;
		}
	}
}
