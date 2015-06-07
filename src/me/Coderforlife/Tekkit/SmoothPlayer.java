package me.Coderforlife.Tekkit;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class SmoothPlayer
  implements Listener
{
  Logger logger = Logger.getLogger("Minecraft");
  private Reloader plugin;
  
  public SmoothPlayer(Reloader plugin)
  {
    setPlugin(plugin);
  }
  
  public Reloader getPlugin()
  {
    return this.plugin;
  }
  
  public void setPlugin(Reloader plugin)
  {
    this.plugin = plugin;
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void onPlayerJoin(PlayerJoinEvent evt)
  {
    Player player = evt.getPlayer();
    player.setTicksLived(1000);
    player.playEffect(player.getLocation(), Effect.SMOKE, 90);
    player.getWorld().getEntities().clear();
    player.getWorld().getLivingEntities().clear();
    player.getWorld().getKeepSpawnInMemory();
  }
  
  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent evt)
  {
    Player player = evt.getPlayer();
    player.getPlayerTime();
    player.resetPlayerTime();
    player.getWorld().getEntities().clear();
    player.getWorld().getLivingEntities().clear();
    player.getWorld().getKeepSpawnInMemory();
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void onPlayer(PlayerMoveEvent evt)
  {
    Player player = evt.getPlayer();
    player.setTicksLived(10);
    Bukkit.getServer().getMap((short)5);
    player.getWorld().getChunkAt(player.getLocation().add(player.getLocation()));
    if (this.plugin.PVP) {
      player.getWorld().setPVP(true);
    }
    if (this.plugin.Item) {
      player.setCanPickupItems(true);
    }
    if ((player.hasPermission("tekkit.specialwalk")) && 
      (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.ICE))) {
      player.setSprinting(true);
    }
  }
  
  @EventHandler
  public void onPlayerEvent(PlayerBedLeaveEvent evt)
  {
    Player player = evt.getPlayer();
    player.sendMessage(ChatColor.GOLD + "Leaving bed..");
    player.getHealth();
    player.getSaturation();
    player.getFoodLevel();
    player.setHealth(20.0D);
    player.setSaturation(20.0F);
    player.setFoodLevel(20);
  }
  
  @EventHandler
  public void onBlockBreak(BlockBreakEvent evt)
  {
    Player player = evt.getPlayer();
    if (player.hasPermission("tekkit.blockXP"))
    {
      player.getExp();
      player.giveExp(5);
    }
  }
}
