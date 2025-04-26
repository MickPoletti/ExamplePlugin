package me.mickpoletti.examplePlugin.commands;

import me.mickpoletti.examplePlugin.ExamplePlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetMessageCommand implements CommandExecutor {
    private final ExamplePlugin examplePlugin;
    public SetMessageCommand(ExamplePlugin examplePlugin) {
        this.examplePlugin = examplePlugin;
    }
    // /setmessage
    @Override
    public boolean onCommand(CommandSender sender, Command c, String label, String[] args ) {
        if (sender instanceof Player p) {
            if (args.length > 0) {
                StringBuilder message = new StringBuilder();
                for (String arg : args) {
                    message.append(arg);
                }
                examplePlugin.getConfig().set("join-message", message.toString());
                examplePlugin.saveConfig();
                p.sendMessage(ChatColor.BOLD + p.getDisplayName() + ChatColor.RESET +
                        ", you have set the join message to:");
                p.sendMessage(message.toString());
            } else {
                p.sendMessage(ChatColor.RED + "ERROR: " +  ChatColor.RESET + "You must " +
                              "provide at least one argument.");
            }
        } else {
            System.out.println("WARNING: The setmessage command was issued by a non-player entity!");
        }
        return true;
    }
}