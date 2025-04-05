package me.mickpoletti.examplePlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command c, String label, String[] args ) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.isInvulnerable()) {
                p.setInvulnerable(false);
                p.sendMessage(ChatColor.RED + "And on the seventh day he rested. God mode disabled.");
            } else {
                p.setInvulnerable(true);
                p.sendMessage(ChatColor.DARK_GREEN + "HE HATH RISEN.");
            }
        }
        return true;
    }
}
