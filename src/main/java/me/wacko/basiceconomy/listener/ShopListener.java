package me.wacko.basiceconomy.listener;

import me.wacko.basiceconomy.BasicEconomy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class ShopListener implements Listener {

    @EventHandler
    public static void onClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if (p.hasMetadata("OpenedMenu")){

            e.setCancelled(true);

            if(e.getSlot() == 10) {

                Inventory bb = Bukkit.createInventory(p, 9*6, ChatColor.AQUA + "Building Blocks");



                p.openInventory(bb);

            } else if (e.getSlot() == 12){

                Inventory farming = Bukkit.createInventory(p, 9*6, ChatColor.GREEN + "Farming");
                p.openInventory(farming);

            } else if (e.getSlot() == 14) {

                Inventory md = Bukkit.createInventory(p, 9*6, ChatColor.GRAY + "Mob Drops");
                p.openInventory(md);

            } else if (e.getSlot() == 16){

                Inventory enchantments = Bukkit.createInventory(p, 9*6, ChatColor.LIGHT_PURPLE + "Enchantments");
                p.openInventory(enchantments);

            } else if (e.getSlot() == 20){

                Inventory food = Bukkit.createInventory(p, 9*6, ChatColor.YELLOW + "Food");
                p.openInventory(food);

            } else if (e.getSlot() == 22){

                Inventory potions = Bukkit.createInventory(p, 9*6, ChatColor.RED + "Potions");
                p.openInventory(potions);

            } else if (e.getSlot() == 24){

                Inventory ores = Bukkit.createInventory(p, 9*6, ChatColor.BLUE + "Ores");
                p.openInventory(ores);

            } else if (e.getSlot() == 31){

                Inventory spawners = Bukkit.createInventory(p, 9*6, ChatColor.BLACK + "Spawners");
                p.openInventory(spawners);

            }

        }

    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {

        Player p = (Player) e.getPlayer();

        if(p.hasMetadata("OpenedMenu")){
            p.removeMetadata("OpenedMenu", BasicEconomy.getInstance());
        }

    }

}
