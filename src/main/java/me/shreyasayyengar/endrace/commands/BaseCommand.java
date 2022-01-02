package me.shreyasayyengar.endrace.commands;

import me.shreyasayyengar.endrace.utils.Utility;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BaseCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("ready")) {
                    int requiredPlayers = Utility.REQUIRED_PLAYERS;
                    int readyPlayers = Utility.PLAYERS_READY;

                    if (Utility.REQUIRED_PLAYERS == 0) {
                        player.sendMessage(Utility.colourise("&cThe required players is currently set to 0"));
                        player.sendMessage(Utility.colourise("&cPlease do /endrace setplayers <number>"));
                        return false;
                    }

                    if (requiredPlayers >= readyPlayers) {
                        Utility.startGame();
                    }
                }
            }

            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("setplayers")) {
                    try {
                        int amount = Integer.parseInt(args[1]);
                        if (amount <= 0) {
                            player.sendMessage(Utility.colourise("&cThe number must be greater than 0!"));
                            return false;
                        } else {
                            Utility.REQUIRED_PLAYERS = amount;
                            player.sendMessage(Utility.colourise("&aSet the amount of players to start to " + amount));
                        }
                    } catch (NumberFormatException x) {
                        player.sendMessage(Utility.colourise("&4That is not a valid number!"));
                    }
                }
            }
        }

        return false;
    }
}
