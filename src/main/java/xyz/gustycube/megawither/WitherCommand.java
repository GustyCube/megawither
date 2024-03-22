package xyz.gustycube.megawither;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import revxrsal.commands.annotation.Command;

import java.util.logging.Level;

public class WitherCommand {

    private MegaWither main;

    public WitherCommand(MegaWither main) {this.main = main;}

    @Command({"megawither"})
    public void megawither(
            CommandSender sender
    ) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location location = player.getLocation();
            Wither megaWither = player.getWorld().spawn(player.getLocation(), Wither.class);
            megaWither.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(600.00);
            megaWither.setHealth(600.00);
            megaWither.setCustomName(ChatColor.RED + "Mega Wither");
            megaWither.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(16.00);
            main.getServer().broadcastMessage(ChatColor.RED + "The Mega Wither has been summoned!");

        }
    }

}
