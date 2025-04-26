package me.mickpoletti.examplePlugin.listeners;

import me.mickpoletti.examplePlugin.ExamplePlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class JoinLeaveListener implements Listener {
    private final ExamplePlugin examplePlugin;
    public JoinLeaveListener(ExamplePlugin examplePlugin) {
        this.examplePlugin = examplePlugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String username = p.getDisplayName();
        String join_message = this.examplePlugin.getConfig().getString("join-message");
        List<String> foods = this.examplePlugin.getConfig().getStringList("foods");
        if (join_message != null) {
            join_message = join_message.replace("%player%", username);
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', join_message));
        } else {
            // Using the color codes isn't recommended but can still be done if needed
            String message = "Hey, \u00A73" + username + "\u00A7f I don't like your attitude.";
            if (p.hasPlayedBefore()) {
                message = "Well, well, well if it isn't "
                        + ChatColor.BOLD + ChatColor.DARK_RED + username
                        + ChatColor.RESET + " again... Addict.";
            }
            e.setJoinMessage(message);
        }
        if (!foods.isEmpty()) {
            p.sendMessage("Your favorite foods are: ");
            for (String food : foods) {
                p.sendMessage(food);
            }
        }
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        String username = e.getPlayer().getDisplayName();
        // Instead of using the color id as above we'll use the ChatColor class and bold the username
        String message = "Hey, " + ChatColor.AQUA + ChatColor.BOLD +
                          username + ChatColor.RESET + ChatColor.WHITE + " get outta here!";
        e.setQuitMessage(message);
        // Alternatively we could concat the message in the function call
        // e.setQuitMessage("Hey, \u00A73" + username + "\u00A7f get outta here!");
    }
}
