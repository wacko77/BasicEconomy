package me.wacko.basiceconomy.util;

import me.wacko.basiceconomy.BasicEconomy;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.entity.Player;

public class ShopBuy {

    public static int buyPrice;


    public static void Buy (Player p) {

        Economy econ = BasicEconomy.getEconomy();

        EconomyResponse response = econ.withdrawPlayer(p, buyPrice);

        if(response.transactionSuccess()){
            p.sendMessage("Worked");
        } else {
            p.sendMessage("no work");
        }

    }

}
