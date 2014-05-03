package Hydra;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Zombie;
import org.bukkit.Location;


public class Hydra extends JavaPlugin implements Listener {
  public static Logger log = Logger.getLogger("Minecraft");

  boolean playerHitLast;

  public Hydra(){
    playerHitLast = false;
  }

  public void onLoad() {
    log.info("[Hydra] Loadded");
  }

  public void onEnable(){
    getServer().getPluginManager().registerEvents(this, this);
    log.info("[Hydra] Loadded");
  }

  public void onDisplay(){
    log.info("[Hydra] Stopping"); 
  }

  @EventHandler 
  public void  ZombieAttacked(EntityDamageEvent event){
    EntityType type = event.getEntityType();
    DamageCause  cause = event.getCause();

    if (type == EntityType.ZOMBIE && cause == DamageCause.ENTITY_ATTACK){
      playerHitLast = true;
    }
    else {
      playerHitLast = false;
    }
  }

  @EventHandler
  public void ZombieDead(EntityDeathEvent event){
    EntityType type = event.getEntityType();
    
    if (type == EntityType.ZOMBIE && playerHitLast ){
      Entity dead = event.getEntity();
     
      Location location = dead.getLocation();
      location.setX(location.getX() + 5);
      
      dead.getWorld().spawn(location, Zombie.class);
      dead.getWorld().spawn(location, Zombie.class);
    }
  }
}
