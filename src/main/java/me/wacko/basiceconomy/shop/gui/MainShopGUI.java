package me.wacko.basiceconomy.shop.gui;

import me.wacko.basiceconomy.core.common.gui.AbstractGUI;
import me.wacko.basiceconomy.shop.gui.components.*;
import me.wacko.basiceconomy.shop.util.ShopUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Mob;
import org.bukkit.inventory.ItemStack;

public class MainShopGUI extends AbstractGUI {

    public MainShopGUI() {
        super(9*6, "SHOP");

        ItemStack getBuildingBlocks = ShopUtil.getItem(ChatColor.AQUA + "Building Blocks", Material.CYAN_WOOL,
                ChatColor.DARK_AQUA + "General building blocks for building things");

        setItem(10, getBuildingBlocks, player -> {
            BuildingBlocks bb = new BuildingBlocks();
            bb.open(player);
        });

        ItemStack getFarming = ShopUtil.getItem(ChatColor.GREEN + "Farming", Material.WHEAT,
                ChatColor.DARK_GREEN + "General farming for farming things");

        setItem(12, getFarming, player -> {
            Farming farm = new Farming();
            farm.open(player);
        });

        ItemStack getMobDrops = ShopUtil.getItem(ChatColor.GRAY + "Mob Drops", Material.BONE,
                ChatColor.DARK_GRAY + "General mob drops from mobs that drop");

        setItem(14, getMobDrops, player -> {
            MobDrops md = new MobDrops();
            md.open(player);
        });

        ItemStack getEnchantments = ShopUtil.getItem(ChatColor.LIGHT_PURPLE + "Enchantments", Material.ENCHANTED_BOOK,
                ChatColor.DARK_PURPLE + "General enchantments for enchanting things");

        setItem(16, getEnchantments, player -> {
            Enchantments enchant = new Enchantments();
            enchant.open(player);
        });

        ItemStack getFood = ShopUtil.getItem(ChatColor.YELLOW + "Food", Material.COOKED_BEEF,
                ChatColor.GOLD + "General food for eating things");

        setItem(20, getFood, player -> {
            Food food = new Food();
            food.open(player);
        });

        ItemStack getSpawners = ShopUtil.getItem(ChatColor.WHITE + "Spawners", Material.SPAWNER,
                ChatColor.GRAY + "General spawners for spawning things");

        setItem(22, getSpawners, player -> {
            Spawners spawn = new Spawners();
            spawn.open(player);
        });

        ItemStack getOres = ShopUtil.getItem(ChatColor.BLUE + "Ores", Material.DIAMOND,
                ChatColor.DARK_BLUE + "General ores for being rich");

        setItem(24, getOres, player -> {
            Ores ores = new Ores();
            ores.open(player);
        });

        ItemStack getPotions = ShopUtil.getItem(ChatColor.RED + "Potions", Material.POTION,
                ChatColor.DARK_RED + "General potions for drinking things");

        setItem(31, getPotions, player -> {
            Potions pots = new Potions();
            pots.open(player);
        });

    }

}
