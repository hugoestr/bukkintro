package Spells;

import java.util.logging.Logger;
import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Zombie;

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
    
    if (commandLabel.equalsIgnoreCase("expectopatronum") ||
        commandLabel.equalsIgnoreCase("ep") ){
      expectopatronum(sender, args);
      return true;
    }

    if (commandLabel.equalsIgnoreCase("restore")) {
      restoreHealth(sender, args);
      return true;
    }

    if (commandLabel.equalsIgnoreCase("rise")) {
      rise((Player)sender, args);
      return true;
    }

    if (commandLabel.equalsIgnoreCase("begone")) {
      begone((Player)sender, args);
      return true;
    }
    
    if (commandLabel.equalsIgnoreCase("norain")) {
      norain((Player)sender);
      return true;
    }
    if (commandLabel.equalsIgnoreCase("avadakedavra")){
      kill(sender, args);
      return true;
    } 
    
    return false;
  }

  private void norain(Player player){
    player.getWorld().setStorm(false);
  }

  private void begone(Player player, String[] args){
    ArrayList<Zombie> zombies = (ArrayList<Zombie>)player.getWorld().getEntitiesByClass(Zombie.class);
    for (Zombie z : zombies){
      z.setFireTicks(1000);
    }
  }

  private void rise(Player player, String[] args){
      Location location = player.getLocation();

      location.setX(location.getX() + 5);
      player.getWorld().spawn(location, Zombie.class);
  }

  private void expectopatronum(CommandSender sender, String[] args){
      Player player = (Player)sender;
      Location location = player.getLocation();

      location.setX(location.getX() + 5);
      player.getWorld().spawn(location, Chicken.class);
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
