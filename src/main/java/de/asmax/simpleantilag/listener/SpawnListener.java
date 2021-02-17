package de.asmax.simpleantilag.listener;

import de.asmax.simpleantilag.utils.GameStateManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class SpawnListener implements Listener {

    @EventHandler
    public void handleSpawn(EntitySpawnEvent event) {
        if(GameStateManager.spawningDisabled) {
            event.setCancelled(true);
        }
    }
}
