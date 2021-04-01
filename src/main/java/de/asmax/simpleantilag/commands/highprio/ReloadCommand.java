package de.asmax.simpleantilag.commands.highprio;

import de.asmax.simpleantilag.main.Main;
import de.asmax.simpleantilag.utils.MessageSender;
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

            player.sendMessage(MessageSender.sendReloadInfoToSender());
            Bukkit.broadcastMessage(MessageSender.initStableReload());
            startReload();

        }
    }

    private void startReload() {
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                for(Player all : Bukkit.getOnlinePlayers()) {
                    all.kickPlayer(MessageSender.sendReloadInfo());
                    Main.getInstance().getServer().reload();
                }

            }
        }, 1200L);
    }

}
