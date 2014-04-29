package Spells;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

public class Spells extends JavaPlugin {
  public static Logger log = Logger.getLogger("Minecraft");

  public void onLoad() {
    log.info("[Spells] Loadded");
  }

  public void onEnable(){
    log.info("[Spells] Loadded");
  }

  public void onDisplay(){
    log.info("[Spells] Stopping"); 
  }


  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
    if (commandLabel.equalsIgnoreCase("restore")) {
      restoreHealth(sender, args);
      return true;
    }

    if (commandLabel.equalsIgnoreCase("avadakedavra")){
      kill(sender, args);
    } 

    return false;
  }

  private void  restoreHealth(CommandSender sender, String[] args){
    Player me = (Player)sender;
    me.setHealth(me.getMaxHealth());
  }

  private void  kill(CommandSender sender, String[] args){
    Player victim = null;

    if (args.length > 0){
      String name = args[0];

      for(Player p : getServer().getOnlinePlayers()){
        if (p.getName() == name){
          victim = p;
          break;
        }
      }
    }

    if (victim == null){
      victim = (Player)sender;
    }

    victim.setHealth(0.0);
  }
}
