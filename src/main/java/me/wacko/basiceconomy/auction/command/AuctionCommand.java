package me.wacko.basiceconomy.auction.command;

import me.wacko.basiceconomy.BasicEconomy;
import me.wacko.basiceconomy.auction.gui.AuctionGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AuctionCommand implements CommandExecutor {

    private final BasicEconomy plugin;

    public AuctionCommand(BasicEconomy plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only players can run this command!");
        }

        Player player = (Player) sender;

        AuctionGUI aGUI = new AuctionGUI(plugin);
        aGUI.open(player);

        return true;
    }
}
