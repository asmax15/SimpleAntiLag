package de.asmax.simpleantilag.listener;

import de.asmax.simpleantilag.utils.GameStateManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropListener implements Listener {

    @EventHandler
    public static void handleDrop(PlayerDropItemEvent event) {
        if(!GameStateManager.allowDrop) {
            event.setCancelled(true);
        }
    }
}
