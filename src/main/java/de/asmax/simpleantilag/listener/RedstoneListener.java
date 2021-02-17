package de.asmax.simpleantilag.listener;

import de.asmax.simpleantilag.utils.GameStateManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;

public class RedstoneListener implements Listener {

    @EventHandler
    public static void handleRedstone(BlockRedstoneEvent event) {

        if(GameStateManager.redstoneDisabled) {

            event.setNewCurrent(0);

        }

    }
}
