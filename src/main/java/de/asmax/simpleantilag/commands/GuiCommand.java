package de.asmax.simpleantilag.commands;

import de.asmax.simpleantilag.main.Main;
import de.asmax.simpleantilag.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GuiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(Main.getPrefix() + "Nur ein Spieler kann diesen Befehl ausführen!");
            return true;
        }
        Player player = (Player)sender;

        if(player.hasPermission("AntiLagSystem.gui.open")) {

            Inventory guiMain = Bukkit.createInventory(null, 5*9, "§9GUI +++ Main");
            guiMain.setItem(19, new ItemBuilder(Material.CRAFTING_TABLE).setName("§6Einstellungen").setLore("§7Hier findest du die gleichen Einstellungen",
                    "§7wie in der §9config.yml").build());
            guiMain.setItem(21, new ItemBuilder(Material.BARRIER).setName("§cComing Soon").setLore().build());
            guiMain.setItem(23, new ItemBuilder(Material.BARRIER).setName("§cComing Soon").setLore().build());
            guiMain.setItem(25, new ItemBuilder(Material.BARRIER).setName("§cComing Soon").setLore().build());

            player.openInventory(guiMain);

        } else {
            player.sendMessage(Main.getPrefix() + "Dazu bist du nicht berechtigt.");
            return true;
        }
        return false;
    }
}
