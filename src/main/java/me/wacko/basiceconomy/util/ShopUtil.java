package me.wacko.basiceconomy.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ShopUtil {

    public static ItemStack getItem(String name, Material mat, int amount, String... lore){

        ItemStack i = new ItemStack(mat, amount);

        ItemMeta meta = i.getItemMeta();

        meta.setDisplayName(name);

        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        meta.setLore(Arrays.asList(lore));

        i.setItemMeta(meta);

        amount = ShopBuy.buyPrice;

        return i;

    }

    public static ItemStack getDirt = ShopUtil.getItem("Dirt", Material.DIRT, 1, "Buy: $$$ Sell: $$$");
    public static ItemStack getGrassBlock = ShopUtil.getItem("Grass Block", Material.GRASS_BLOCK, 1, "Buy: $$$ Sell: $$$");


}
