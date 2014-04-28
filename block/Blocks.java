package Blocks;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.Material;
import org.bukkit.Location;

public class Blocks extends JavaPlugin {
  public static Logger log = Logger.getLogger("Minecraft");

  public void onLoad() {
    log.info("[Block] Loadded");
  }

  public void onEnable(){
    log.info("[Block] Loadded");
  }

  public void onDisplay(){
    log.info("[Block] Stopping"); 
  }


  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
    if (commandLabel.equalsIgnoreCase("block")) {
      createBlock((Player)sender);
      return true;
    }

    return false;
  }

  private void  createBlock(Player me){
    Location location = me.getLocation();
    location.setX(location.getX() + 1);

    location.getWorld().getBlockAt(location).setType(Material.STONE);
  }

}
