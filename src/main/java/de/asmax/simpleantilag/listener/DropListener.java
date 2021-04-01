package de.asmax.simpleantilag.listener;

import de.asmax.simpleantilag.utils.GameStateManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class DropListener implements Listener {

    @EventHandler
    public static void handleDrop(PlayerDropItemEvent event) {
        if(!GameStateManager.allowDrop) {
            event.setCancelled(true);
            ItemStack item = (ItemStack) event.getItemDrop();
            Player player = event.getPlayer();
            player.getInventory().addItem(item);
        }
    }
}
