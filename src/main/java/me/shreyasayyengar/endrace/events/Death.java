package me.shreyasayyengar.endrace.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {
    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent event) {
        event.getDrops().removeIf(next -> (next.getType() == Material.COMPASS));
    }
}
