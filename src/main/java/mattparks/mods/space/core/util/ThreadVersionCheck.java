package mattparks.mods.space.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import mattparks.mods.space.core.Constants;
import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class ThreadVersionCheck extends Thread {
    public static ThreadVersionCheck INSTANCE = new ThreadVersionCheck();
    private int count = 0;

    public static int remoteMajVer;
    public static int remoteMinVer;
    public static int remoteBuildVer;

    public ThreadVersionCheck() {
        super("4Space Version Check Thread");
    }

    public static void startCheck() {
        final Thread thread = new Thread(ThreadVersionCheck.INSTANCE);
        thread.start();
    }

    @Override
    public void run() {
        final Side sideToCheck = FMLCommonHandler.instance().getSide();

        if (sideToCheck == null) {
            return;
        }

        while (this.count <= 3 && remoteBuildVer == 0) {
        	BufferedReader in = null;
            try {
                final URL url = new URL("http://4space.mods.center/version.html");
                final HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.addRequestProperty("User-Agent", "Mozilla/4.76");
                InputStreamReader streamReader = new InputStreamReader(http.getInputStream());
                in = new BufferedReader(streamReader);
                String str;
                String str2[] = null;

                while ((str = in.readLine()) != null) {
                    if (str.contains("Version")) {
                        str = str.replace("Version=", "");

                        str2 = str.split("#");

                        if (str2.length == 3) {
                            remoteMajVer = Integer.parseInt(str2[0]);
                            remoteMinVer = Integer.parseInt(str2[1]);
                            remoteBuildVer = Integer.parseInt(str2[2]);
                        }

                        if (remoteMajVer == Constants.LOCALMAJVERSION && (remoteMinVer > Constants.LOCALMINVERSION || (remoteMinVer == Constants.LOCALMINVERSION && remoteBuildVer > Constants.LOCALBUILDVERSION))) {
                            Thread.sleep(5000);

                            if (sideToCheck.equals(Side.CLIENT)) {
                                FMLClientHandler.instance().getClient().thePlayer.addChatMessage(new ChatComponentText(EnumColor.GREY + "New " + EnumColor.DARK_AQUA + "4Space" + EnumColor.GREY + " version available! v" + String.valueOf(remoteMajVer) + "." + String.valueOf(remoteMinVer) + "." + String.valueOf(remoteBuildVer) + EnumColor.DARK_BLUE + " http://4space.mods.center"));
                            } else if (sideToCheck.equals(Side.SERVER)) {
                                SpaceLog.severe("New 4Space version available! v" + String.valueOf(remoteMajVer) + "." + String.valueOf(remoteMinVer) + "." + String.valueOf(remoteBuildVer) + " http://4space.mods.center");
                            }
                        }
                    }
                }
                
                in.close();
                streamReader.close();
            } catch (final Exception e) {
            	if (in != null) {
                	try  {
						in.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
            	}
            }

            if (remoteBuildVer == 0) {
                try {
                    SpaceLog.severe(SpaceUtil.translate("4update.failed.name"));
                    Thread.sleep(15000);
                } catch (final InterruptedException e) {
                }
            } else {
            	SpaceLog.info(SpaceUtil.translate("4update.success.name") + " " + remoteMajVer + "." + remoteMinVer + "." + remoteBuildVer);
            }

            this.count++;
        }
    }
}
