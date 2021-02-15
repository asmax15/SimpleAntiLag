package de.asmax.simpleantilag.listener;

import de.asmax.simpleantilag.main.Main;
import de.asmax.simpleantilag.utils.GameStateManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

import java.io.File;

public class FlyListener implements Listener {

    static File file = new File("plugins/SimpleAntiLag", "config.yml");
    static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    @EventHandler
    public static void handleFly(PlayerToggleFlightEvent event) {
        if(!GameStateManager.allowFlight) {
            event.setCancelled(true);
            Player player = event.getPlayer();
            if(cfg.getString("Language") == "de") {
                player.sendMessage(Main.getPrefix() + "§cDiese Funktion ist temporär von AntiLag System gesperrt, gedulde dich einen moment bis die Server Performance wieder auf §a" + cfg.getDouble("ServerWorker TPS") + " §r§cTPS gestiegen ist!");
            } else {
                player.sendMessage(Main.getPrefix() + "§cThis function is temporarily blocked by the AntiLag system, wait a moment until the server performance has increased to §a" + cfg.getDouble("ServerWorker TPS") + " §r§cTPS again!");
            }
        }
    }
}
