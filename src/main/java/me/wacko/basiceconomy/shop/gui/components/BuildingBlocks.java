package me.wacko.basiceconomy.shop.gui.components;

import me.wacko.basiceconomy.core.common.gui.AbstractGUI;
import me.wacko.basiceconomy.shop.util.ShopUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BuildingBlocks extends AbstractGUI {

    public BuildingBlocks() {
        super(9*6, ChatColor.AQUA + "Building Blocks");

        ItemStack getDirt = ShopUtil.getItem("Dirt", Material.DIRT,"Buy: $5");
        setItem(0, getDirt, player -> {

        });
    }
}
