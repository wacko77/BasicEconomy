package me.wacko.basiceconomy.auction.gui.core;

import me.wacko.basiceconomy.BasicEconomy;
import me.wacko.basiceconomy.auction.model.Auction;
import me.wacko.basiceconomy.auction.util.ItemUtilForGUI;
import me.wacko.basiceconomy.core.common.gui.AbstractGUI;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ActiveAuctionsGUI extends AbstractGUI {

    public ActiveAuctionsGUI(BasicEconomy plugin) {
        super(9*6, "Active Auctions");
        int slotIndex = 0;
        List<Auction> activeAuctions = plugin.getActiveAuctions();

        if (activeAuctions != null) {
            for (Auction auction : activeAuctions) {
                ItemStack item = createItem(auction);
                setItem(slotIndex++, item, player -> {
                    player.sendMessage("Entered Auction!");
                });
            }
        }
    }

    private ItemStack createItem(Auction auction) {
        List<String> lore = getLore(auction);
        ItemStack item = ItemUtilForGUI.setItemMeta(auction.getItem().getType().toString(), auction.getItem().getType(), lore.toString());

        return item;
    }

    private List<String> getLore(Auction auction) {
        List<String> lore = new ArrayList<>();

        ItemStack item = auction.getItem();
        Player host = auction.getHost();

        lore.add("Item for auction: " + item);
        lore.add("Auction host: " + host);

        return lore;
    }
}
