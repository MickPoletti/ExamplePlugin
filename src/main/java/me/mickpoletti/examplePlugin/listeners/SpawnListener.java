package me.mickpoletti.examplePlugin.listeners;

import me.mickpoletti.examplePlugin.ExamplePlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListener implements Listener {
    private final ExamplePlugin examplePlugin;
    public SpawnListener(ExamplePlugin examplePlugin) {
        this.examplePlugin = examplePlugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String username = p.getDisplayName();
        if (!p.hasPlayedBefore()) {
            Location location = examplePlugin.getConfig().getLocation("spawn");
            if (location != null) {
                p.teleport(location);
                p.sendMessage(ChatColor.BOLD + p.getDisplayName() + ChatColor.RESET +
                        ", you have been teleported to spawn.");
            } else {
                p.sendMessage(ChatColor.BOLD + p.getDisplayName() + ChatColor.RESET +
                        ", the world spawn location had not been set. Please use /setspawn to set it.");
            }
        }
    }
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Location location = examplePlugin.getConfig().getLocation("spawn");
        if (location != null) {
            e.setRespawnLocation(location);
        }
    }
}
