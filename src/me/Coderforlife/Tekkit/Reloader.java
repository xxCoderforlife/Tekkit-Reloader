package me.Coderforlife.Tekkit;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Reloader
  extends JavaPlugin
{
  final String prefix = ChatColor.RED + "[" + ChatColor.GREEN + "TekkitReloader" + ChatColor.RED + "] ";
  Logger logger = Logger.getLogger("Minecraft");
  public boolean PVP = true;
  public boolean Item = true;
  
  public void onEnable()
  {
    getCommand("tstop").setExecutor(new cmds(this));
    getCommand("treload").setExecutor(new cmds(this));
    getCommand("thelp").setExecutor(new cmds(this));
    getCommand("tpvp").setExecutor(new cmds(this));
    getCommand("treset").setExecutor(new cmds(this));
    getCommand("tclear").setExecutor(new cmds(this));
    getCommand("tid").setExecutor(new cmds(this));
    getCommand("tworkbench").setExecutor(new cmds(this));
    getCommand("tender").setExecutor(new cmds(this));
    getCommand("tpickup").setExecutor(new cmds(this));
    getCommand("new").setExecutor(new cmds(this));
    PluginDescriptionFile pdffile = getDescription();
    this.logger.info(pdffile.getName() + ChatColor.RED + 
      " Has Been Enabled." + "Version: " + pdffile.getVersion() + " Website: " + pdffile.getWebsite());
    getConfig().options().header("Tekkit ToolKit Config By xxCoderforlife");
    getConfig().options().copyDefaults(true);
    saveConfig();
    getConfig().getBoolean("op-out.enabled.use");
    
    getServer().getPluginManager().registerEvents(new SmoothPlayer(this), this);
  }
  
  public void onDisable()
  {
    PluginDescriptionFile pdffile = getDescription();
    this.logger.info(pdffile.getName() + ChatColor.RED + 
      " Has Been Disabled!." + "Server Mod by: " + pdffile.getAuthors());
  }
}
