package me.wacko.basiceconomy.command;

import me.wacko.basiceconomy.BasicEconomy;
import me.wacko.basiceconomy.util.ShopUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

public class ShopCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){

            sender.sendMessage("Only players can use this command!");

            return true;

        }

        Player p = (Player) sender;

        Inventory inv = Bukkit.createInventory(p, 9*6, ChatColor.AQUA + "SHOP");

        ItemStack getBuildingBlocks = ShopUtil.getItem(ChatColor.AQUA + "Building Blocks", Material.CYAN_WOOL, 1,
                ChatColor.DARK_AQUA + "General building blocks for building things");

        ItemStack getFarming = ShopUtil.getItem(ChatColor.GREEN + "Farming", Material.WHEAT, 1,
                ChatColor.DARK_GREEN + "General farming for farming things");

        ItemStack getMobDrops = ShopUtil.getItem(ChatColor.GRAY + "Mob Drops", Material.BONE, 1,
                ChatColor.DARK_GRAY + "General mob drops from mobs that drop");

        ItemStack getEnchantments = ShopUtil.getItem(ChatColor.LIGHT_PURPLE + "Enchantments", Material.ENCHANTED_BOOK, 1,
                ChatColor.DARK_PURPLE + "General enchantments for enchanting things");

        ItemStack getFood = ShopUtil.getItem(ChatColor.YELLOW + "Food", Material.COOKED_BEEF, 1,
                ChatColor.GOLD + "General food for eating things");

        ItemStack getSpawners = ShopUtil.getItem(ChatColor.WHITE + "Spawners", Material.SPAWNER, 1,
                ChatColor.GRAY + "General spawners for spawning things");

        ItemStack getOres = ShopUtil.getItem(ChatColor.BLUE + "Ores", Material.DIAMOND, 1,
                ChatColor.DARK_BLUE + "General ores for being rich");

        ItemStack getPotions = ShopUtil.getItem(ChatColor.RED + "Potions", Material.POTION, 1,
                ChatColor.DARK_RED + "General potions for drinking things");


        inv.setItem(10,getBuildingBlocks);
        inv.setItem(12, getFarming);
        inv.setItem(14, getMobDrops);
        inv.setItem(16, getEnchantments);
        inv.setItem(20, getFood);
        inv.setItem(31, getSpawners);
        inv.setItem(24, getOres);
        inv.setItem(22, getPotions);


        p.openInventory(inv);
        p.setMetadata("OpenedMenu", new FixedMetadataValue(BasicEconomy.getInstance(), "SHOP"));

        return true;
    }
}
