package me.mickpoletti.examplePlugin.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

// In this class we use the setCancelled function in interface Cancellable
// to stop an event that we don't want to happen (in this case having naked sheep)
public class ShearSheepListener implements Listener {
    @EventHandler
    public void onSheepShear(PlayerShearEntityEvent e) {
        Player player = e.getPlayer();
        Entity entity = e.getEntity();
        if (entity.getType() == EntityType.SHEEP) {
            player.sendMessage("Dude you can't make sheep naked here. That's wrong. You're banned.");
            e.setCancelled(true);
            // Then we could ban the player, but that's a little ridiculous...
            // player.ban();
        } else {
            player.sendMessage("It does seem that this animal is not a sheep. Okay they can be naked.");
        }

    }
}
