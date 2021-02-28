package de.asmax.simpleantilag.inventorys;

import de.asmax.simpleantilag.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GuiSettingsInventory {

    public static void openSettingsGUI(Player player) {

        if(player.hasPermission("AntiLagSystem.gui.open.settings")) {

            Inventory settings = Bukkit.createInventory(null, 5*9, "§9GUI +++ Einstellungen");

            player.openInventory(settings);

        } else {
            player.sendMessage(Main.getPrefix() + "Dazu hast du keine Berechtigung.");
        }

    }

}
