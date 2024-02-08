package me.wacko.basiceconomy.util;

import org.bukkit.Material;
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

        return i;

    }

}
