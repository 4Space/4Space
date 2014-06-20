package mattparks.mods.MattparksCore;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class ConfigManager
{
    public static boolean loaded;

    public static Configuration configuration;
    public static boolean capesEnabled;
    
    public ConfigManager(File file)
    {
        if (!ConfigManager.loaded)
        {
            ConfigManager.configuration = new Configuration(file);
            this.setDefaultValues();
        }
    }

    private void setDefaultValues()
    {
        try
        {
            ConfigManager.configuration.load();
            
            ConfigManager.capesEnabled = ConfigManager.configuration.get(Configuration.CATEGORY_GENERAL, "Enable Mattparks donator capes", true).getBoolean(true);
        }
        
        catch (final Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "Mattparks Config has a problem loading it's configuration");
        }
        
        finally
        {
            ConfigManager.configuration.save();
            ConfigManager.loaded = true;
        }
    }
}