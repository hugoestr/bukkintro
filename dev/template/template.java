package CHANGE_ME;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class CHANGE_ME extends JavaPlugin {
  public static Logger log = Logger.getLogger("Minecraft");

  public void onLoad() {
    log.info("[CHANGE_ME] Loadded");
  }

  public void onEnable(){
    log.info("[CHANGE_ME] Loadded");
  }

  public void onDisplay(){
    log.info("[CHANGE_ME] Stopping"); 
  }


  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
    if (commandLabel.equalsIgnoreCase("hello")) {
      String message = "[Server] Yo " + args[0]; 
      getServer().broadcastMessage(message); 
    } 

    return false;
  }
}
