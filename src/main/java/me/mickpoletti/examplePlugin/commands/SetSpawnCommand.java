package me.mickpoletti.examplePlugin.commands;

import me.mickpoletti.examplePlugin.ExamplePlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {
    private final ExamplePlugin examplePlugin;
    public SetSpawnCommand(ExamplePlugin examplePlugin) {
        this.examplePlugin = examplePlugin;
    }
    // /setspawn
    @Override
    public boolean onCommand(CommandSender sender, Command c, String label, String[] args ) {
        if (sender instanceof Player p) {
            Location location = p.getLocation();
            examplePlugin.getConfig().set("spawn", location);
            examplePlugin.saveConfig();
            p.sendMessage(ChatColor.BOLD + p.getDisplayName() + ChatColor.RESET +
                          ", your spawn location has been set.");
        } else {
            System.out.println("WARNING: The setspawn command was issued by a non-player entity!");
        }
        return true;
    }
}