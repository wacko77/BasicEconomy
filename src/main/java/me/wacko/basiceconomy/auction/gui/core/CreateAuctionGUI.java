package me.wacko.basiceconomy.auction.gui.core;

import me.wacko.basiceconomy.core.common.gui.AbstractGUI;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CreateAuctionGUI extends AbstractGUI {

    private boolean itemSet;

    public CreateAuctionGUI() {
        super(9*6, "Auction Creation");

        if (isItemSet()) {
            setItem(13, new ItemStack(Material.STONE_BUTTON));
            setItem(29, new ItemStack(Material.RED_WOOL));
        } else {
            // setItem(13, clickedItemFromInventory, player -> {
                // remove from gui back into player inv
            // });
            setItem(29, new ItemStack(Material.GREEN_WOOL), player -> {
                // create auction logic
            });
        }

    }

    public boolean isItemSet(){return itemSet;}
}
