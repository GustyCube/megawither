package xyz.gustycube.megawither;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HitListener implements Listener {
    private HitTracker hitTracker;

    public HitListener(HitTracker hitTracker) {
        this.hitTracker = hitTracker; // Assign the parameter to the class field
    }

    @EventHandler
    public void onWitherHit(EntityDamageByEntityEvent event) {
        if (event.getEntityType() == EntityType.WITHER && event.getDamager() instanceof Player) {
            Wither wither = (Wither) event.getEntity();
            Player player = (Player) event.getDamager();

            if (wither.getCustomName() != null && wither.getCustomName().equals(ChatColor.RED + "Mega Wither")) {
                hitTracker.logWitherHit(player);
            }
        }
    }
}

