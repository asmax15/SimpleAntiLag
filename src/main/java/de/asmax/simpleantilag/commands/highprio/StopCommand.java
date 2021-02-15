package de.asmax.simpleantilag.commands.highprio;

import de.asmax.simpleantilag.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class StopCommand implements Listener {

    @EventHandler(priority= EventPriority.HIGHEST)
    public void onersetzen(PlayerCommandPreprocessEvent event ) {
        Player player = event.getPlayer();
        String msg = event.getMessage().split(" ")[0];
        if(msg.equalsIgnoreCase("/stop")) {

            event.setCancelled(true);
            player.sendMessage(Main.getPrefix() + "Dieser Befehl wurde vom AntiLagSystem übernommen, um ein effizienteres Herunterfahren zu gewährleisten.");
            Bukkit.broadcastMessage(Main.getPrefix() + "§4§lDer Server wird in §a§leiner Minute §4§lHeruntergefahren. Diese Aktion wude vom AntiLagSystem übernommen, um eine effizienteres Herunterfahren des Servers zu gewährleisten.");
            initStop();

        } else if(msg.equalsIgnoreCase("/forcestop")) {
            player.sendMessage(Main.getPrefix() + "Dieser Befehl wurde vom AntiLagSystem übernommen, um ein effizienteres Herunterfahren zu gewährleisten.");
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.kickPlayer("§cDer Server wird heruntergefahren. Dieser Befehl wurde vom AntiLagSystem übernommen, um eine effizientere Server Leistung zu gewährleisten. §4§lServer closed!");
                Main.getInstance().getServer().shutdown();
            }
        }
    }

    private void initStop() {
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                for(Player all : Bukkit.getOnlinePlayers()) {
                    all.kickPlayer("§cDer Server wird heruntergefahren. Dieser Befehl wurde vom AntiLagSystem übernommen, um eine effizientere Server Leistung zu gewährleisten. §4§lServer closed!");
                    Main.getInstance().getServer().shutdown();
                }

            }
        }, 1200L);
    }

}
