package de.asmax.simpleantilag.commands.highprio;

import de.asmax.simpleantilag.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class ReloadCommand implements Listener {

    @EventHandler(priority= EventPriority.HIGHEST)
    public void onersetzen(PlayerCommandPreprocessEvent event ) {
        Player player = event.getPlayer();
        String msg = event.getMessage().split(" ")[0];
        if (msg.equalsIgnoreCase("/reload") || msg.equalsIgnoreCase("/rl")) {
            event.setCancelled(true);

            player.sendMessage(Main.getPrefix() + "Der reload Befehl wurde vom AntiLagSystem übernommen, um eine effizientere Server Performance zu gewährleisten.");
            Bukkit.broadcastMessage(Main.getPrefix() + "§c§lDer Server wird vom AntiLagSystem in §2§leiner Minute §c§lneu geladen, dabei werden alle Spieler vom Server getrennt, um einen stabilen reload zu gewährleisten!");
            startReload();

        }
    }

    private void startReload() {
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                for(Player all : Bukkit.getOnlinePlayers()) {
                    all.kickPlayer("§cDer Server wird neu geladen. Dieser Befehl wurde vom AntiLagSystem übernommen, um eine effizientere Server Leistung zu gewährleisten. Bitte habe einen Moment Geduld.");
                    Main.getInstance().getServer().reload();
                }

            }
        }, 1200L);
    }

}
