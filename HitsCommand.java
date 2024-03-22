package xyz.gustycube.megawither;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;

import java.util.Map;

public class HitsCommand {

    private HitTracker hitTracker;

    public HitsCommand(HitTracker hitTracker) {
        this.hitTracker = hitTracker;
    }

    @Command({"witherhits"})
    public void megawither(CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by players.");
        } else {

        Player player = (Player) sender;

        Map<String, Integer> hitCounts = hitTracker.getHitCounts();
        player.sendMessage("Wither Hit Counts:");
        for (Map.Entry<String, Integer> entry : hitCounts.entrySet()) {
            player.sendMessage(entry.getKey() + ": " + entry.getValue());
        }

    }
    }
}
