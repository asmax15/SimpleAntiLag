package de.asmax.simpleantilag.commands.highprio;

import de.asmax.simpleantilag.main.Main;
import de.asmax.simpleantilag.utils.MessageSender;
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
            player.sendMessage(MessageSender.sendStopInfoToSender());
            Bukkit.broadcastMessage(MessageSender.sendStopInfo());
            initStop();

        } else if(msg.equalsIgnoreCase("/forcestop")) {
            player.sendMessage(MessageSender.sendStopInfoToSender());
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.kickPlayer(MessageSender.sendShutdownKick());
                Main.getInstance().getServer().shutdown();
            }
        }
    }

    private void initStop() {
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                for(Player all : Bukkit.getOnlinePlayers()) {
                    all.kickPlayer(MessageSender.sendShutdownKick());
                    Main.getInstance().getServer().shutdown();
                }

            }
        }, 1200L);
    }

}
