package me.wacko.basiceconomy.auction.gui;

import me.wacko.basiceconomy.auction.gui.core.ActiveAuctionsGUI;
import me.wacko.basiceconomy.auction.gui.core.CreateAuctionGUI;
import me.wacko.basiceconomy.auction.gui.core.PlayerBidsGUI;
import me.wacko.basiceconomy.auction.util.ItemUtilForGUI;
import me.wacko.basiceconomy.core.common.gui.AbstractGUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class AuctionGUI extends AbstractGUI {

    public AuctionGUI() {
        super(9*3, "Auctions");

        List<String> aaLore = getAALore();
        ItemStack aaItem = ItemUtilForGUI.setItemMeta(ChatColor.GOLD + "Active Auctions", Material.GOLD_BLOCK, aaLore.toString());
        setItem(11, aaItem, player -> {
            ActiveAuctionsGUI aaGUI = new ActiveAuctionsGUI();
            aaGUI.open(player);
        });

        List<String> pbLore = getPBLore();
        ItemStack pbItem = ItemUtilForGUI.setItemMeta(ChatColor.GREEN + "View your bids!", Material.GOLDEN_CARROT, pbLore.toString());
        setItem(13, pbItem, player -> {
            PlayerBidsGUI pbGUI = new PlayerBidsGUI();
            pbGUI.open(player);
        });

        List<String> caLore = getCALore();
        ItemStack caItem = ItemUtilForGUI.setItemMeta(ChatColor.GREEN + "Create Auction!", Material.GOLDEN_HORSE_ARMOR, caLore.toString());
        setItem(15, caItem, player -> {
            CreateAuctionGUI caGUI = new CreateAuctionGUI();
            caGUI.open(player);
        });

    }

    private List<String> getAALore() {
        List<String> lore = new ArrayList<>();

        lore.add("Find items for sale in Active Auctions!");
        lore.add("\n\n");
        lore.add("Auctions you find here are created");
        lore.add("by players and you need to win the");
        lore.add("top bid to obtain the item!");
        lore.add(ChatColor.GOLD + "Click to Browse!");

        return lore;
    }

    private List<String> getPBLore() {
        List<String> lore = new ArrayList<>();

        lore.add("View and manage your bids.");
        lore.add("\n\n");
        lore.add(ChatColor.YELLOW + "Click to view!");

        return lore;
    }

    private List<String> getCALore() {
        List<String> lore = new ArrayList<>();

        lore.add("Create your own auction to put");
        lore.add("in active auctions.");
        lore.add("\n\n");
        lore.add(ChatColor.YELLOW + "Click to create an auction!");

        return lore;
    }

}
