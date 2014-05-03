package Hello;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Hello extends JavaPlugin {
  public static Logger log = Logger.getLogger("Minecraft");

  public void onLoad() {
    log.info("[HelloWorld] Loadded");
  }

  public void onEnable(){
    log.info("[HelloWorld] Loadded");
  }

  public void onDisplay(){
    log.info("[HelloWorld] Stopping"); 
  }


  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
    if (commandLabel.equalsIgnoreCase("hello")) {
      String message = "[Server] Yo " + args[0]; 
      getServer().broadcastMessage(message); 
    } 

    return false;
  }
}
