package de.asmax.simpleantilag.commands.highprio;

import de.asmax.simpleantilag.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class ForceReloadCommand implements Listener {

    @EventHandler(priority= EventPriority.HIGHEST)
    public void onersetzen(PlayerCommandPreprocessEvent event ) {
        Player player = event.getPlayer();
        String msg = event.getMessage().split(" ")[0];
        if (msg.equalsIgnoreCase("/forcereload") || msg.equalsIgnoreCase("/frl")) {
            event.setCancelled(true);

            player.sendMessage(Main.getPrefix() + "Der reload Befehl wurde vom AntiLagSystem übernommen, um eine effizientere Server Performance zu gewährleisten.");

            for(Player all : Bukkit.getOnlinePlayers()) {
                all.kickPlayer("§cDer Server wird neu geladen. Dieser Befehl wurde vom AntiLagSystem übernommen, um eine effizientere Server Leistung zu gewährleisten. Bitte habe einen Moment Geduld.");
                Main.getInstance().getServer().reload();
            }

        }
    }
}
