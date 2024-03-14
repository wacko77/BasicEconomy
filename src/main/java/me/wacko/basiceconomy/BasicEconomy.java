package me.wacko.basiceconomy;

import me.wacko.basiceconomy.auction.command.AuctionCommand;
import me.wacko.basiceconomy.auction.manager.AuctionManager;
import me.wacko.basiceconomy.auction.model.Auction;
import me.wacko.basiceconomy.core.common.listener.GiveawaysListener;
import me.wacko.basiceconomy.playervault.command.PVCommands;
import me.wacko.basiceconomy.shop.command.ShopCommand;

import me.wacko.basiceconomy.core.command.VaultCommands;
import me.wacko.basiceconomy.playervault.listener.PVListeners;
import me.wacko.basiceconomy.shop.util.ShopUtil;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public final class BasicEconomy extends JavaPlugin {

    private static BasicEconomy plugin;
    public static Economy economy = null;
    private final List<Auction> activeAuctions = new ArrayList<>();
    private AuctionManager am = new AuctionManager(this, activeAuctions);

    @Override
    public void onEnable() {
        plugin = this;

        if (!setupEconomy() ) {
            System.out.println("Disabled due to no Vault dependency found!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        getCommand("playervault").setExecutor(new PVCommands());
        getCommand("shop").setExecutor(new ShopCommand());
        getCommand("balance").setExecutor(new VaultCommands());
        getCommand("auctions").setExecutor(new AuctionCommand(this));

        ShopUtil shopUtil = new ShopUtil(economy);

        getServer().getPluginManager().registerEvents(new PVListeners(), this);
        getServer().getPluginManager().registerEvents(new GiveawaysListener(), this);

    }

    public static BasicEconomy getInstance(){
        return getPlugin(BasicEconomy.class);
    }

    public static BasicEconomy getPlugin() {
        return plugin;
    }

    public boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    public static Economy getEconomy() {
        return economy;
    }

    public List<Auction> getActiveAuctions(){return activeAuctions;}
    public AuctionManager getAuctionManager(){return am;}

}
