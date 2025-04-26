package me.mickpoletti.examplePlugin.commands;

import me.mickpoletti.examplePlugin.ExamplePlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    private final ExamplePlugin examplePlugin;
    public SpawnCommand(ExamplePlugin examplePlugin) {
        this.examplePlugin = examplePlugin;
    }
    // /setspawn
    @Override
    public boolean onCommand(CommandSender sender, Command c, String label, String[] args ) {
        if (sender instanceof Player p) {
            Location location = examplePlugin.getConfig().getLocation("spawn");
            if (location != null) {
                p.teleport(location);
                p.sendMessage(ChatColor.BOLD + p.getDisplayName() + ChatColor.RESET +
                              ", you have been teleported to spawn.");
            } else {
                p.sendMessage(ChatColor.BOLD + p.getDisplayName() + ChatColor.RESET +
                        ", the world spawn location had not been set. Please use /setspawn to set it.");
            }
        } else {
            System.out.println("WARNING: The spawn command was issued by a non-player entity!");
        }
        return true;
    }
}