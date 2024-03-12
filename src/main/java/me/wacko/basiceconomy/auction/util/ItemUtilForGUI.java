package me.wacko.basiceconomy.auction.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.ChatPaginator;

import java.util.Arrays;

public class ItemUtilForGUI {

    public static ItemStack setItemMeta(String name, Material mat, String lore) {

        ItemStack i = new ItemStack(mat);

        ItemMeta meta = i.getItemMeta();

        meta.setDisplayName(name);

        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        meta.setLore(Arrays.asList(ChatPaginator.wordWrap(lore, 35)));

        i.setItemMeta(meta);

        return i;

    }

}
