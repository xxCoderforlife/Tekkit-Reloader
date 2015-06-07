package me.Coderforlife.Tekkit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class cmds
  implements CommandExecutor
{
  public boolean PVP = true;
  public boolean Item = true;
  final String prefix = ChatColor.RED + "[" + ChatColor.GREEN + "TekkitToolKit" + ChatColor.RED + "] ";
  final String prem = ChatColor.RED + "You Dont Have Permission To Do This Command";
  final String help = ChatColor.RED + "[" + ChatColor.GREEN + "Tekkit Help" + ChatColor.RED + "]";
  final String dash = ChatColor.GRAY + "- ";
  final String player = ChatColor.RED + "Silly Console man you can't do that ^-^";
  final String Console = "[CONSOLE COMMANDS: TEKKIT TOOLKIT]";
  private Reloader plugin;
  
  public cmds(Reloader plugin)
  {
    setPlugin(plugin);
  }
  
  public Reloader getPlugin()
  {
    return this.plugin;
  }
  
  public void setPlugin(Reloader plugin) {}
  
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String Commandlabel, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("treload"))
    {
      if ((sender instanceof Player))
      {
        Player player = (Player)sender;
        if (player.hasPermission("tekkit.reload"))
        {
          Bukkit.broadcastMessage(this.prefix + ChatColor.RED + "Reloading Server...");
          player.getServer().getBukkitVersion().toLowerCase();
          player.getServer().reload();
          Bukkit.broadcastMessage(this.prefix + ChatColor.RED + "Reloaded Tekkit Server");
        }
        else
        {
          sender.sendMessage(this.prem);
        }
      }
      else
      {
        Bukkit.broadcastMessage(this.prefix + ChatColor.RED + "Reloading Server...");
        Bukkit.getServer().reload();
        Bukkit.broadcastMessage(this.prefix + ChatColor.RED + "Reloaded Tekkit Server");
      }
    }
    else if (cmd.getName().equalsIgnoreCase("tstop"))
    {
      if ((sender instanceof Player))
      {
        Player player = (Player)sender;
        if (player.hasPermission("tekkit.stop"))
        {
          Bukkit.broadcastMessage(this.prefix + ChatColor.RED + "Stopping Server!");
          Bukkit.getServer().resetRecipes();
          Bukkit.getServer().shutdown();
        }
        else
        {
          sender.sendMessage(this.prem);
        }
      }
      else
      {
        Bukkit.broadcastMessage(this.prefix + ChatColor.RED + "Stopping Server!");
        Bukkit.getServer().resetRecipes();
        Bukkit.getServer().shutdown();
      }
    }
    else if (cmd.getName().equalsIgnoreCase("thelp"))
    {
      if ((sender instanceof Player))
      {
        Player player = (Player)sender;
        if (player.hasPermission("tekkit.help"))
        {
          sender.sendMessage(ChatColor.RED + "------------" + this.help + ChatColor.RED + "-------------");
          sender.sendMessage(this.dash + ChatColor.GREEN + "/trelaod " + this.dash + ChatColor.GREEN + "Reloads the Tekkit Server");
          sender.sendMessage(this.dash + ChatColor.GREEN + "/tstop " + this.dash + ChatColor.GREEN + "Stops the Tekkit Server");
          sender.sendMessage(this.dash + ChatColor.GREEN + "/thelp " + this.dash + ChatColor.GREEN + "Brings you Here");
          sender.sendMessage(this.dash + ChatColor.GREEN + "/tpvp " + this.dash + ChatColor.GREEN + "Toggles Your PVP");
          sender.sendMessage(this.dash + ChatColor.GREEN + "/tclear " + this.dash + ChatColor.GREEN + "Clears the world of Enetites");
          sender.sendMessage(this.dash + ChatColor.GREEN + "/treset " + this.dash + ChatColor.GREEN + "Resets the Recpies!");
          sender.sendMessage(this.dash + ChatColor.GREEN + "/tid " + this.dash + ChatColor.GREEN + "Shows the ID of the Block in your hand.t");
          sender.sendMessage(this.dash + ChatColor.GREEN + "/workbench" + this.dash + ChatColor.GREEN + "Opens WorkBench");
          sender.sendMessage(this.dash + ChatColor.GREEN + "/tpickup" + this.dash + ChatColor.GREEN + "Toggles your abilty to pickup items");
          sender.sendMessage(ChatColor.RED + "--------------------------------------------------");
        }
        else
        {
          sender.sendMessage(this.prefix + this.prem);
        }
      }
      else
      {
        sender.sendMessage(ChatColor.RED + "------------" + this.Console + ChatColor.RED + "-------------");
        sender.sendMessage(this.dash + ChatColor.GREEN + "/trelaod " + this.dash + ChatColor.GREEN + "Reloads the Tekkit Server");
        sender.sendMessage(this.dash + ChatColor.GREEN + "/tstop " + this.dash + ChatColor.GREEN + "Stops the Tekkit Server");
        sender.sendMessage(this.dash + ChatColor.GREEN + "/thelp " + this.dash + ChatColor.GREEN + "Brings you Here");
        sender.sendMessage(this.dash + ChatColor.GREEN + "/tclear " + this.dash + ChatColor.GREEN + "Clears the world of Enetites");
        sender.sendMessage(this.dash + ChatColor.GREEN + "/treset " + this.dash + ChatColor.GREEN + "Resets the Recpies!");
        sender.sendMessage(ChatColor.RED + "----------------------------------------------");
      }
    }
    else if (cmd.getName().equalsIgnoreCase("tpvp"))
    {
      if ((sender instanceof Player))
      {
        Player player = (Player)sender;
        if (player.hasPermission("tekkit.pvp"))
        {
          if (args.length == 0) {
            if (!this.PVP)
            {
              this.PVP = true;
              sender.sendMessage(ChatColor.GOLD + "PVP On!");
            }
            else
            {
              this.PVP = false;
              sender.sendMessage(ChatColor.GOLD + "PVP Off!");
            }
          }
        }
        else {
          sender.sendMessage(this.prem);
        }
      }
      else
      {
        sender.sendMessage(this.prefix + this.player);
      }
    }
    else if (cmd.getName().equalsIgnoreCase("tclear"))
    {
      if ((sender instanceof Player))
      {
        Player player = (Player)sender;
        if (player.hasPermission("tekkit.clear"))
        {
          player.getWorld().getEntities().clear();
          player.getWorld().getLivingEntities().clear();
          player.sendMessage(this.prefix + ChatColor.GREEN + "Cleared all world entities!");
        }
        else
        {
          sender.sendMessage(this.prem);
        }
      }
      else
      {
        sender.sendMessage(this.prefix + this.player);
      }
    }
    else if (cmd.getName().equalsIgnoreCase("treset"))
    {
      if ((sender instanceof Player))
      {
        Player player = (Player)sender;
        if (player.hasPermission("tekkit.reset"))
        {
          sender.sendMessage(ChatColor.GREEN + "Reseting the Recpies...");
          Bukkit.getServer().resetRecipes();
          sender.sendMessage(ChatColor.GREEN + "Reset All Recpises!");
        }
        else
        {
          sender.sendMessage(this.prem);
        }
      }
      else
      {
        sender.sendMessage(ChatColor.GREEN + "Reseting the Recpies...");
        Bukkit.getServer().resetRecipes();
        sender.sendMessage(ChatColor.GREEN + "Reset All Recpises!");
      }
    }
    else if (cmd.getName().equalsIgnoreCase("tid"))
    {
      if ((sender instanceof Player))
      {
        Player player = (Player)sender;
        if (player.hasPermission("tekkit.id"))
        {
          player.sendMessage(ChatColor.DARK_RED + "ItemID: " + ChatColor.RED + player.getItemInHand().getTypeId());
          player.sendMessage(ChatColor.DARK_RED + "ItemName: " + ChatColor.RED + player.getItemInHand().getType());
        }
        else
        {
          sender.sendMessage(this.prem);
        }
      }
      else
      {
        sender.sendMessage(this.prefix + this.player);
      }
    }
    else if (cmd.getName().equalsIgnoreCase("tworkbench"))
    {
      if ((sender instanceof Player))
      {
        Player player = (Player)sender;
        if (player.hasPermission("tekkit.bench"))
        {
          sender.sendMessage(ChatColor.GOLD + "Opening Work Bench...");
          player.openWorkbench(player.getEyeLocation(), true);
        }
        else
        {
          sender.sendMessage(this.prem);
        }
      }
      else
      {
        sender.sendMessage(this.prefix + this.player);
      }
    }
    else if (cmd.getName().equalsIgnoreCase("tender"))
    {
      if ((sender instanceof Player))
      {
        Player player = (Player)sender;
        if (player.hasPermission("tekkit.ender"))
        {
          player.getEnderChest().addItem(new ItemStack[] { player.getItemInHand() });
          player.sendMessage(ChatColor.RED + "Sending " + ChatColor.GOLD + player.getItemInHand().getType() + ChatColor.RED + " to your ender chest");
          player.getInventory().setItemInHand(null);
        }
        else
        {
          player.sendMessage(this.prem);
        }
      }
    }
    else if ((cmd.getName().equalsIgnoreCase("tpickup")) && 
      ((sender instanceof Player)))
    {
      Player player = (Player)sender;
      if ((player.hasPermission("tekkit.pick")) && 
        (args.length == 0)) {
        if (this.Item)
        {
          this.Item = true;
          sender.sendMessage(ChatColor.GOLD + "You can pick up items now!");
        }
        else
        {
          this.Item = false;
          sender.sendMessage(ChatColor.GOLD + "You can't pick up items now!");
        }
      }
    }else
    if ((cmd.getName().equalsIgnoreCase("new"))){
    	Player player = (Player)sender;
    	if ((player.hasPermission("new.tekkit"))){
    		player.getAllowFlight();
    		player.sendMessage(ChatColor.BLACK + "You can fly bitch!");
    		
    	}else{
    		player.sendMessage(this.prem);
    	}
    }
    return true;
  }
}
