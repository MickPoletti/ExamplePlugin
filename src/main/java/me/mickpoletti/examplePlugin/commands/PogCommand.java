package me.mickpoletti.examplePlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PogCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command c, String label, String[] args ) {
        if (sender instanceof Player) {
            Player p = ((Player) sender).getPlayer();
            if (p.hasPermission("exampleplugin.pog")) {
                p.sendMessage("You are indeed "
                        + ChatColor.BOLD + ChatColor.DARK_PURPLE + "POG");
            } else {
                p.sendMessage("YOU ARE "
                        + ChatColor.BOLD + ChatColor.DARK_RED + ChatColor.UNDERLINE + "NOT"
                        + ChatColor.RESET + " POG!!!!!!! ☹");
            }
        }
        return true;
    }
}
