package me.shreyasayyengar.endrace.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropItem implements Listener {

    @EventHandler
    public void onPlayerDropItemEvent(PlayerDropItemEvent event) {
        if (event.getItemDrop().getItemStack().getType() == Material.COMPASS) {
            event.setCancelled(true);
        }
    }
}
