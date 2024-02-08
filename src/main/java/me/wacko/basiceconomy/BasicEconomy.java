package me.wacko.basiceconomy;

import me.wacko.basiceconomy.command.PVCommands;
import me.wacko.basiceconomy.command.ShopCommand;

import me.wacko.basiceconomy.listener.PVListeners;
import me.wacko.basiceconomy.listener.ShopListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BasicEconomy extends JavaPlugin {

    private static BasicEconomy plugin;

    @Override
    public void onEnable() {
        plugin = this;


        //PersonalVault
        getCommand("pv").setExecutor(new PVCommands());
        getCommand("shop").setExecutor(new ShopCommand());

        getServer().getPluginManager().registerEvents(new PVListeners(), this);
        getServer().getPluginManager().registerEvents(new ShopListener(), this);

    }

    public static BasicEconomy getInstance(){
        return getPlugin(BasicEconomy.class);
    }

    public static BasicEconomy getPlugin() {
        return plugin;
    }
}
