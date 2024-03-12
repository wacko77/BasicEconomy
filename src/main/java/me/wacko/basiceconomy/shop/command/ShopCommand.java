package me.wacko.basiceconomy.shop.command;

import me.wacko.basiceconomy.shop.gui.MainShopGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopCommand implements CommandExecutor {

    private MainShopGUI mainShopGUI;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){

            sender.sendMessage("Only players can use this command!");

            return true;

        }

        Player p = (Player) sender;

        mainShopGUI = new MainShopGUI();
        mainShopGUI.open(p);

        return true;
    }
}
