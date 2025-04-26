package me.mickpoletti.examplePlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class PogCommand implements CommandExecutor {
    // uuid = is the userid of the player
    // Long = the epoch time when the player issued the command
    private final HashMap<UUID, Long> cooldown;

    public PogCommand() {
        this.cooldown = new HashMap<>();
    }
    @Override
    public boolean onCommand(CommandSender sender, Command c, String label, String[] args ) {
        if (sender instanceof Player) {
            Player p = ((Player) sender).getPlayer();
            UUID uuid = p.getUniqueId();
            long time_elapsed = System.currentTimeMillis() - cooldown.get(uuid);
            long TIMEOUT = 10000;
            if (!this.cooldown.containsKey(uuid) || time_elapsed > TIMEOUT) {
                PogCommandMessage(p);
                this.cooldown.put(uuid, System.currentTimeMillis());
            } else {
                p.sendMessage(ChatColor.RED + "ERROR: " + ChatColor.RESET +
                            "You cannot use this command for another "
                            + (TIMEOUT - time_elapsed) + " milliseconds.");
            }
        }
        return true;
    }

    public final void PogCommandMessage(Player p) {
        if (p.hasPermission("exampleplugin.pog")) {
            p.sendMessage("You are indeed "
                    + ChatColor.BOLD + ChatColor.DARK_PURPLE + "POG");
        } else {
            p.sendMessage("YOU ARE "
                    + ChatColor.BOLD + ChatColor.DARK_RED + ChatColor.UNDERLINE + "NOT"
                    + ChatColor.RESET + " POG!!!!!!! ☹");
        }
    }
}
