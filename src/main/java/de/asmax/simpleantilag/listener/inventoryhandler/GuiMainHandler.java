package de.asmax.simpleantilag.listener.inventoryhandler;

import de.asmax.simpleantilag.inventorys.GuiSettingsInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GuiMainHandler implements Listener {

    @EventHandler
    public void handleGuiMainWindow(InventoryClickEvent event) {
        if(!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();

        if(event.getView().getTitle().equalsIgnoreCase("§9GUI +++ Main")) {

            switch (event.getCurrentItem().getType()) {
                case CRAFTING_TABLE:
                    event.setCancelled(true);
                    GuiSettingsInventory.openSettingsGUI(player);
                    break;
                default:
                    event.setCancelled(true);
                    break;
            }

        }
    }
}
