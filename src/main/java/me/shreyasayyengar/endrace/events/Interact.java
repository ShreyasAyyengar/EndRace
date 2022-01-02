package me.shreyasayyengar.endrace.events;

import me.shreyasayyengar.endrace.utils.Utility;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Interact implements Listener {

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.hasItem() && event.getItem().getType() == Material.COMPASS && (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)) {
            Player nearest = null;
            double distance = Double.MAX_VALUE;
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (onlinePlayer.equals(player) || !onlinePlayer.getWorld().equals(player.getWorld()))
                    continue;
                double distanceSquared = onlinePlayer.getLocation().distanceSquared(player.getLocation());
                if (distanceSquared < distance) {
                    distance = distanceSquared;
                    nearest = onlinePlayer;
                }
            }
            if (nearest == null) {
                player.sendMessage(Utility.colourise("&cNo players to track!"));
                return;
            }
            player.setCompassTarget(nearest.getLocation());
            player.sendMessage(Utility.colourise("&aCompass is now pointing to " + nearest.getName() + "."));
        }
    }
}
