package me.wacko.basiceconomy.listener;

import me.wacko.basiceconomy.BasicEconomy;
import me.wacko.basiceconomy.util.PVUtils;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Arrays;

public class PVListeners implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        PersistentDataContainer data = p.getPersistentDataContainer();

        if(!data.has(new NamespacedKey(BasicEconomy.getPlugin(), "pv"),PersistentDataType.STRING)) {
            data.set(new NamespacedKey(BasicEconomy.getPlugin(), "pv"),PersistentDataType.STRING, "");

        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e){

        Player p = (Player) e.getPlayer();

        if(e.getView().getTitle().equalsIgnoreCase("Your Personal Vault")){

            ArrayList<ItemStack> prunedItems = new ArrayList<>();

            Arrays.stream(e.getInventory().getContents())
                    .filter(itemStack -> {
                        if (itemStack == null){
                            return false;
                        }
                        return true;
            })
                    .forEach(itemStack -> prunedItems.add(itemStack));

            System.out.println("size: " + prunedItems.size());

            PVUtils.storeItems(prunedItems, p);

        }


    }

}
