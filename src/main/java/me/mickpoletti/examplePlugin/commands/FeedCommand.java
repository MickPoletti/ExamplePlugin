package me.mickpoletti.examplePlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command c, String label, String[] args ) {
        if (sender instanceof Player) {
            Player p = ((Player) sender).getPlayer();
            // I initially started with setting the food level to 100 but
            // that is way over the amount needed to max the player's food bar
            p.setFoodLevel(20);
            // Insert reference to G4's The Feed news show
            p.sendMessage(ChatColor.GOLD +
                    "I'm Christin Holt, and you've just been fed.");
        }
        return true;
    }
}
