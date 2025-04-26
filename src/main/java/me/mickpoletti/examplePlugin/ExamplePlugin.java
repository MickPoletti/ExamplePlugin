package me.mickpoletti.examplePlugin;

import me.mickpoletti.examplePlugin.commands.*;
import me.mickpoletti.examplePlugin.listeners.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.plugin.java.JavaPlugin;

// This is a first example of how to use a listener, however they should be
// separated into their own classes.
public final class ExamplePlugin extends JavaPlugin implements Listener {
    // Plugin startup logic
    @Override
    public void onEnable() {
        System.out.println("Hello World!");
        // config.yml handling
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Register your events here
        getServer().getPluginManager().registerEvents(this, this);
        // Register XP bottle break event
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        // Register never nude sheep event
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);
        // Register join leave messages
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(this), this);
        // Register death handler
        getServer().getPluginManager().registerEvents(new DeathListener(this), this);
        getServer().getPluginManager().registerEvents(new SpawnListener(this), this);
        // Handle commands
        getCommand("god").setExecutor(new GodCommand());
        getCommand("eat").setExecutor(new FeedCommand());
        getCommand("pog").setExecutor(new PogCommand());
        getCommand("repeat").setExecutor(new RepeatCommand());
        getCommand("fwoe_up").setExecutor(new FwoeUpCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("setmessage").setExecutor(new SetMessageCommand(this));
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Goodbye.");
    }
    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent e) {
        Player player = e.getPlayer();
        player.sendMessage("Hey wait a sec, you should maybe get a little more sleep.");
    }
}
