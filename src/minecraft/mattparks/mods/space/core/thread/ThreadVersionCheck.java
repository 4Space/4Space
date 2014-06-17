package mattparks.mods.space.core.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import mattparks.mods.MattparksCore.Version;
import mattparks.mods.space.core.util.EnumColor;
import mattparks.mods.space.core.util.Log;
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
		super("4-Space Version Check Thread");
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

		while (this.count < 3 && Version.remoteBuildVer == 0)
		{
			try
			{
				final URL url = new URL("http://version.mattparks.webatu.com/MattCore.html");
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
							Version.remoteMajVer = Integer.parseInt(str2[0]);
							Version.remoteMinVer = Integer.parseInt(str2[1]);
							Version.remoteBuildVer = Integer.parseInt(str2[2]);
						}

						if (Version.remoteMajVer > Version.LOCALMAJVERSION || Version.remoteMajVer == Version.LOCALMAJVERSION && Version.remoteMinVer > Version.LOCALMINVERSION || Version.remoteMajVer == Version.LOCALMAJVERSION && Version.remoteMinVer == Version.LOCALMINVERSION && Version.remoteBuildVer > Version.LOCALBUILDVERSION)
						{
							Thread.sleep(5000);

							if (sideToCheck.equals(Side.CLIENT))
							{
								FMLClientHandler.instance().getClient().thePlayer.addChatMessage(EnumColor.GREY + "New " + EnumColor.DARK_AQUA + "4-Space" + EnumColor.GREY + " version available! v" + String.valueOf(Version.remoteMajVer) + "." + String.valueOf(Version.remoteMinVer) + "." + String.valueOf(Version.remoteBuildVer) + EnumColor.DARK_BLUE + " http://mattparks.webatu.com/mods-2/4-space");
							}
							else if (sideToCheck.equals(Side.SERVER))
							{
								Log.severe("New 4-Space version available! v" + String.valueOf(Version.remoteMajVer) + "." + String.valueOf(Version.remoteMinVer) + "." + String.valueOf(Version.remoteBuildVer) + " http://mattparks.webatu.com/mods-2/4-space");
							}
						}
					}
				}
			}
			catch (final Exception e)
			{
			}

			if (Version.remoteBuildVer == 0)
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
				Log.info(StatCollector.translateToLocal("newversion.success.name") + " " + Version.remoteMajVer + "." + Version.remoteMinVer + "." + Version.remoteBuildVer);
			}

			this.count++;
		}
	}
}
