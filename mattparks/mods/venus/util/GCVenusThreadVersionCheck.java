package mattparks.mods.venus.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import mattparks.mods.venus.GCVenus;
import micdoodle8.mods.galacticraft.core.GCLog;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class GCVenusThreadVersionCheck extends Thread
{
	public static GCVenusThreadVersionCheck instance = new GCVenusThreadVersionCheck();
	private int count = 0;

	public GCVenusThreadVersionCheck()
	{
		super("Galacticraft Venus Version Check Thread");
	}

	public static void startCheck(Side sideToCheck)
	{
		final Thread thread = new Thread(GCVenusThreadVersionCheck.instance);
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

		while (this.count < 3 && GCVenus.remoteBuildVer == 0)
		{
			try
			{
				final URL url = new URL("http://version.mattparks5855.webege.com/4-Space.html");
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
							GCVenus.remoteMajVer = Integer.parseInt(str2[0]);
							GCVenus.remoteMinVer = Integer.parseInt(str2[1]);
							GCVenus.remoteBuildVer = Integer.parseInt(str2[2]);
						}

						if (GCVenus.remoteMajVer > GCVenus.LOCALMAJVERSION || GCVenus.remoteMajVer == GCVenus.LOCALMAJVERSION && GCVenus.remoteMinVer > GCVenus.LOCALMINVERSION || GCVenus.remoteMajVer == GCVenus.LOCALMAJVERSION && GCVenus.remoteMinVer == GCVenus.LOCALMINVERSION && GCVenus.remoteBuildVer > GCVenus.LOCALBUILDVERSION)
						{
							Thread.sleep(5000);

							if (sideToCheck.equals(Side.CLIENT))
							{
								FMLClientHandler.instance().getClient().thePlayer.addChatMessage(EnumColor.GREY + "New " + EnumColor.DARK_AQUA + "Galacticraft Venus" + EnumColor.GREY + " version available! v" + String.valueOf(GCVenus.remoteMajVer) + "." + String.valueOf(GCVenus.remoteMinVer) + "." + String.valueOf(GCVenus.remoteBuildVer) + EnumColor.DARK_BLUE + " http://mattparks5855.webege.com/");
							}
							else if (sideToCheck.equals(Side.SERVER))
							{
								GCLog.severe("New Galacticraft Venus version available! v" + String.valueOf(GCVenus.remoteMajVer) + "." + String.valueOf(GCVenus.remoteMinVer) + "." + String.valueOf(GCVenus.remoteBuildVer) + " http://mattparks5855.webege.com/");
							}
						}
					}
				}
			}
			catch (final Exception e)
			{
			}

			if (GCVenus.remoteBuildVer == 0)
			{
				try
				{
					GCLog.severe(StatCollector.translateToLocal("newversion.failed.name"));
					Thread.sleep(15000);
				}
				catch (final InterruptedException e)
				{
				}
			}
			else
			{
				GCLog.info(StatCollector.translateToLocal("newversion.success.name") + " " + GCVenus.remoteMajVer + "." + GCVenus.remoteMinVer + "." + GCVenus.remoteBuildVer);
			}

			this.count++;
		}
	}
}
