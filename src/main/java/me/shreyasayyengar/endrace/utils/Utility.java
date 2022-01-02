package me.shreyasayyengar.endrace.utils;

import me.shreyasayyengar.endrace.EndRacePlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Utility {

    public static int PLAYERS_READY = 0;
    public static final Set<UUID> ENTERED_END = new HashSet<>();
    public static int REQUIRED_PLAYERS = 0;

    public static String colourise(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void startGame() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.getInventory().addItem(new ItemStack(Material.COMPASS));
        }

        final int[] seconds = {5};

        new BukkitRunnable() {
            @Override
            public void run() {
                if (seconds[0] > 1) {
                    Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle(Utility.colourise("&cGame begins in:"), Utility.colourise("&e" + seconds[0] + " seconds!"), 0, 25, 0));
                }

                if (seconds[0] == 1) {
                    Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle(Utility.colourise("&cGame begins in:"), Utility.colourise("&e" + seconds[0] + " second!"), 0, 25, 0));
                }

                if (seconds[0] == 0) {
                    Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle(Utility.colourise("&aGame Begun!"), "", 0, 40, 0));
                    cancel();
                }

                seconds[0]--;
            }
        }.runTaskTimer(EndRacePlugin.getInstance(), 10L, 20L);
    }
}