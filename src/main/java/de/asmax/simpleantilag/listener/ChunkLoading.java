package de.asmax.simpleantilag.listener;

import de.asmax.simpleantilag.utils.GameStateManager;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

public class ChunkLoading implements Listener {

    @EventHandler
    public static void handleChunk(ChunkLoadEvent event) {
        Chunk c = event.getChunk();
        String w = event.getWorld().getName();
        if(!GameStateManager.allowChunkLoading) {

            Bukkit.getWorld(w).unloadChunk(c);

        }
    }
}
