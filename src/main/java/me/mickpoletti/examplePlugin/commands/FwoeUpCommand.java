package me.mickpoletti.examplePlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FwoeUpCommand implements CommandExecutor {
    // /fwoe_up <player_name>
    @Override
    public boolean onCommand(CommandSender sender, Command c, String label, String[] args ) {
        if (sender instanceof Player p) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD +
                        "You're gonna do it....");
                for (int i = 0; i < 50000; i++) {
                    // do nothing
                }
                p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD +
                        " You fwew up everywhere.");
                p.setFoodLevel(0);
            } else {
                String player_name = args[0];
                Player target = Bukkit.getServer().getPlayerExact(player_name);
                if (target == null) {
                    p.sendMessage("I'm sorry, unfortunately that player is not online, so you can't make the fwoe up now.");
                } else {
                    p.sendMessage("You just made " + ChatColor.BOLD + target.getDisplayName()
                                  + ChatColor.RESET + " fwoe up.");
                    target.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + p.getDisplayName() +
                                        " just made you fwoe up everywhere how gwoss.");
                    target.setFoodLevel(0);
                }
            }

        }
        return true;
    }
}