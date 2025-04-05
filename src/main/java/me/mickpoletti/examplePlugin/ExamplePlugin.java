package me.mickpoletti.examplePlugin;

import me.mickpoletti.examplePlugin.listeners.JoinLeaveListener;
import me.mickpoletti.examplePlugin.listeners.ShearSheepListener;
import me.mickpoletti.examplePlugin.listeners.XPBottleBreakListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

// This is a first example of how to use a listener, however they should be
// separated into their own classes.
public final class ExamplePlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Hello World!");
        // Register your events here
        getServer().getPluginManager().registerEvents(this, this);
        // Register XP bottle break event
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        // Register never nude sheep event
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);
        // Register join leave messages
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Goodbye.");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        String username = e.getPlayer().getName();
        String message = "Hey, \u00A73" + username + "\u00A7f I don't like your attitude.";
        e.setJoinMessage(message);
    }

    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent e) {
        Player player = e.getPlayer();
        player.sendMessage("Hey wait a sec, you should maybe get a little more sleep.");
    }
}
