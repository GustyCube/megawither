package xyz.gustycube.megawither;

import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;

public class HitTracker {
    private Map<String, Integer> hitCounts;

    public HitTracker() {
        hitCounts = new HashMap<>();
    }


    public void logWitherHit(Player player) {
        String playerName = player.getName();
        int currentCount = hitCounts.getOrDefault(playerName, 0);
        hitCounts.put(playerName, currentCount + 1);
    }

    public Map<String, Integer> getHitCounts() {
        return hitCounts;
    }
}
