package me.mickpoletti.examplePlugin.listeners;

import me.mickpoletti.examplePlugin.ExamplePlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
    private final ExamplePlugin examplePlugin;
    public DeathListener(ExamplePlugin examplePlugin) {
        this.examplePlugin = examplePlugin;
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        // Now we can use the above to get a config from the plugin
        // for an admin defined death message
        // examplePlugin.getConfig();
    }
}
