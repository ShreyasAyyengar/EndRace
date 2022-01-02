package me.shreyasayyengar.endrace;

import me.shreyasayyengar.endrace.commands.BaseCommand;
import me.shreyasayyengar.endrace.events.*;
import me.shreyasayyengar.endrace.utils.Utility;
import org.bukkit.plugin.java.JavaPlugin;

public final class EndRacePlugin extends JavaPlugin {

    private static EndRacePlugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;

        getLogger().info(Utility.colourise("&6Plugin started with no errors!"));
        registerCommands();
        registerEvents();

    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new Death(), this);
        this.getServer().getPluginManager().registerEvents(new DropItem(), this);
        this.getServer().getPluginManager().registerEvents(new EnterEnd(), this);
        this.getServer().getPluginManager().registerEvents(new Interact(), this);
        this.getServer().getPluginManager().registerEvents(new Respawn(), this);
    }

    private void registerCommands() {
        this.getCommand("endrace").setExecutor(new BaseCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static EndRacePlugin getInstance() {
        return INSTANCE;
    }
}
