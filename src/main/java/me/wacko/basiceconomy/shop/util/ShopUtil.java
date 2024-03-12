package me.wacko.basiceconomy.shop.util;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ShopUtil {

    private static Economy econ;

    public ShopUtil (Economy econ){
        this.econ = econ;
    }

    public static ItemStack getItem(String name, Material mat, String... lore){

        ItemStack i = new ItemStack(mat);

        ItemMeta meta = i.getItemMeta();

        meta.setDisplayName(name);

        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        meta.setLore(Arrays.asList(lore));

        i.setItemMeta(meta);

        return i;

    }

    public static void Buy (Player p, int buyPrice) {

        if (econ != null) {
            if (econ.getBalance(p) >= buyPrice) {
                econ.withdrawPlayer(p, buyPrice);
                p.sendMessage("You have successfully withdrawn " + buyPrice + " from your account.");
            } else {
                p.sendMessage("You don't have enough money to perform this transaction.");
            }
        } else {
            p.sendMessage("Economy system is not available at the moment.");
        }

    }

    public static void Sell (Player p, int sellPrice){

        if (econ != null) {
            econ.depositPlayer(p, sellPrice);
            p.sendMessage("Worked");
        } else{
            p.sendMessage("Did not work");
        }

    }


}
