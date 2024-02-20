package me.wacko.basiceconomy.command;

import me.wacko.basiceconomy.BasicEconomy;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VaultCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("Only players can run this command!");
            return true;
        } else if (sender instanceof Player){
            Player player = (Player) sender;
            Economy econ = BasicEconomy.getEconomy();

            if (args.length == 0){
                player.sendMessage(ChatColor.GREEN + "Current Balance: " + econ.getBalance(player));
            }
        }

        return true;
    }
}
