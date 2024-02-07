package me.wacko.basiceconomy;

import me.wacko.basiceconomy.vaults.PVCommands;
import me.wacko.basiceconomy.vaults.PVListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class BasicEconomy extends JavaPlugin {

    private static BasicEconomy plugin;

    @Override
    public void onEnable() {
        plugin = this;


        //PersonalVault
        getCommand("pv").setExecutor(new PVCommands());
        getServer().getPluginManager().registerEvents(new PVListeners(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static BasicEconomy getPlugin() {
        return plugin;
    }
}
