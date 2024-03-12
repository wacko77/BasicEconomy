package me.wacko.basiceconomy.auction.command;

import me.wacko.basiceconomy.auction.gui.AuctionGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AuctionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only players can run this command!");
        }

        Player player = (Player) sender;

        AuctionGUI aGUI = new AuctionGUI();
        aGUI.open(player);

        return true;
    }
}
