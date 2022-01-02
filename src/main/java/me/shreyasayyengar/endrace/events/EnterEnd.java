package me.shreyasayyengar.endrace.events;

import me.shreyasayyengar.endrace.utils.Utility;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class EnterEnd implements Listener {

    @EventHandler
    public void onPlayerPortal(PlayerChangedWorldEvent event) {
        Player eventPlayer = event.getPlayer();

        if (eventPlayer.getWorld().getEnvironment() == World.Environment.THE_END) {

            if (Utility.ENTERED_END.size() > 0) {
                eventPlayer.sendTitle(Utility.colourise("&bTHE END! YOU'VE MADE IT!"), Utility.colourise("&cBut someone got here before you!"), 35, 100, 35);
            } else eventPlayer.sendTitle(Utility.colourise("&bTHE END! YOU'VE MADE IT!"), null, 35, 100, 35);

            Utility.ENTERED_END.add(eventPlayer.getUniqueId());
        }
    }
}
