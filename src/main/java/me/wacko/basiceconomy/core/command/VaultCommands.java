package me.wacko.basiceconomy.core.command;

import me.wacko.basiceconomy.BasicEconomy;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VaultCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;

            Economy economy = BasicEconomy.getEconomy();

            if (args.length == 0){

                player.sendMessage(ChatColor.GREEN + "Current Balance: " + ChatColor.GOLD  + economy.format(economy.getBalance(player)));

            }else if(args.length == 2 && args[0].equalsIgnoreCase("withdraw")){

                double withdraw_amount = Double.valueOf(args[1]);

                EconomyResponse response = economy.withdrawPlayer(player, withdraw_amount);

                if (response.transactionSuccess()){

                    player.sendMessage("You have successfully removed: " + economy.format(response.amount));
                    player.sendMessage("Your new balance is: " + economy.format(response.balance));

                } else{

                    player.sendMessage("Failed to withdraw money from your balance.");
                    player.sendMessage(response.errorMessage);

                }
            } else if (args.length == 2 && args[0].equalsIgnoreCase("deposit")){

                double deposit_amount = Double.valueOf(args[1]);

                EconomyResponse response = economy.depositPlayer(player, deposit_amount);

                if (response.transactionSuccess()){

                    player.sendMessage("You have successfully deposited: " + economy.format(response.amount));
                    player.sendMessage("Your new balance is: " + economy.format(response.balance));

                } else{

                    player.sendMessage("Failed to deposit money into your balance.");
                    player.sendMessage(response.errorMessage);

                }

            }
        }


        return true;
    }
}
