package me.mickpoletti.examplePlugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;
import org.bukkit.block.Block;

public class XPBottleBreakListener implements Listener {
    @EventHandler
    public void onXPBottleBreak(ExpBottleEvent e) {
        // For example, we could break the block when hit with an XP bottle
        Block block = e.getHitBlock();
        // block.breakNaturally() could return null if what was hit with the bottle
        // was not a block so ensure that we have a block and not an entity
        if (block != null && e.getHitEntity() == null) {
            block.breakNaturally();
        }
        // Additionally, we could turn off the bubble effect when the bottle explodes
        e.setShowEffect(false);
    }
}
