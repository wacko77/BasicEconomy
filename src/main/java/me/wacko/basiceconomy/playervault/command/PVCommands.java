package me.wacko.basiceconomy.playervault.command;

import me.wacko.basiceconomy.playervault.util.PVUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class PVCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if(args.length > 0){
                if (args[0].equalsIgnoreCase("open")){

                    ArrayList<ItemStack> pvItems = PVUtils.getItems(p);

                    Inventory vault = Bukkit.createInventory(p, 54, "Your Personal Vault");

                    pvItems.stream()
                            .forEach(itemStack -> vault.addItem(itemStack));

                    p.openInventory(vault);

                }

            }
        }else{
            sender.sendMessage("Only players can use this command!");
        }

        return true;
    }
}
