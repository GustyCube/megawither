package xyz.gustycube.megawither;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import revxrsal.commands.bukkit.BukkitCommandHandler;

import java.util.logging.Level;

public final class MegaWither extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        BukkitCommandHandler handler = BukkitCommandHandler.create(this);
        handler.register(new WitherCommand(this));

        HitTracker hitTracker = new HitTracker();
        HitListener hitListener = new HitListener(hitTracker); // Pass HitTracker instance to HitListener


        handler.register(new HitsCommand(hitTracker));


        Bukkit.getPluginManager().registerEvents(hitListener, this);

        this.getLogger().log(Level.INFO, "MegaWither enabled!");
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().log(Level.INFO, "MegaWither disabled!");
    }


}
