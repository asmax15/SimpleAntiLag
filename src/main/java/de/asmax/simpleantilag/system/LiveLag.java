package de.asmax.simpleantilag.system;

import de.asmax.simpleantilag.main.Main;
import de.asmax.simpleantilag.utils.GameStateManager;
import de.asmax.simpleantilag.utils.MessageSender;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.io.File;

public class LiveLag implements Listener {

     static File file = new File("plugins/SimpleAntiLag", "config.yml");
     static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

     static boolean PerformanceCheck = cfg.getBoolean("PerformanceCheck");
     static int intervall = cfg.getInt("CheckerIntervall");
     static boolean redstoneDisable = cfg.getBoolean("Allow LiveLag disable Redstone");

    public static void InitLiveLag() {

        if(PerformanceCheck) {

            Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {

                    if(Lag.getTPS() < 18.00 && Lag.getTPS() > 16.00) {
                        if(redstoneDisable) {

                            GameStateManager.redstoneDisabled = true;

                            for (World w : Bukkit.getWorlds()) {
                                for (Entity e : w.getEntities()) {
                                    if(e instanceof Item) {
                                        e.remove();
                                    }
                                }
                            }

                            Bukkit.broadcastMessage(MessageSender.liveLag18RedLine1());
                            Bukkit.broadcastMessage(MessageSender.liveLag18RedLine2());
                            Bukkit.broadcastMessage(MessageSender.liveLag18RedLine3());
                            Bukkit.broadcastMessage(MessageSender.liveLag18RedLine4());
                            initAntiLive();

                        } else {
                            for (World w : Bukkit.getWorlds()) {
                                for (Entity e : w.getEntities()) {
                                    if(e instanceof Item) {
                                        e.remove();
                                    }
                                }
                            }

                            Bukkit.broadcastMessage(MessageSender.liveLag18RedLine1());
                            Bukkit.broadcastMessage(MessageSender.liveLag18RedLine2());
                            Bukkit.broadcastMessage(MessageSender.liveLag18RedLine3());
                            initAntiLive();

                        }
                    } else if(Lag.getTPS() < 16.00 && Lag.getTPS() > 13.00) {
                        if(redstoneDisable) {

                            GameStateManager.redstoneDisabled = true;

                            for (World w : Bukkit.getWorlds()) {
                                for (Entity e : w.getEntities()) {
                                    if(e instanceof Item) {
                                        e.remove();
                                    }
                                }
                            }

                            GameStateManager.spawningDisabled = true;

                            Bukkit.broadcastMessage(MessageSender.liveLag16RedLine1());
                            Bukkit.broadcastMessage(MessageSender.liveLag18RedLine2());
                            Bukkit.broadcastMessage(Main.getPrefix() + "§7* Items auf dem Boden wurden entfernt");
                            Bukkit.broadcastMessage(Main.getPrefix() + "§7* Redstone zeitweise deaktiviert");
                            Bukkit.broadcastMessage(Main.getPrefix() + "§7* Mob Spawning zeitweise deaktiviert");
                            initAntiLive();

                        } else {

                            for (World w : Bukkit.getWorlds()) {
                                for (Entity e : w.getEntities()) {
                                    if(e instanceof Item) {
                                        e.remove();
                                    }
                                }
                            }

                            GameStateManager.spawningDisabled = true;

                            Bukkit.broadcastMessage(Main.getPrefix() + "§6Die Server Performance ist unter 16 TPS gefallen!");
                            Bukkit.broadcastMessage(Main.getPrefix() + "§cFolgende Maßnahmen wurden ergriffen:");
                            Bukkit.broadcastMessage(Main.getPrefix() + "§7* Items auf dem Boden wurden entfernt");
                            Bukkit.broadcastMessage(Main.getPrefix() + "§7* Mob Spawning zeitweise deaktiviert");
                            initAntiLive();
                        }
                    } else if(Lag.getTPS() < 13.00) {
                        if(redstoneDisable) {

                            GameStateManager.redstoneDisabled = true;

                            for (World w : Bukkit.getWorlds()) {
                                for (Entity e : w.getEntities()) {
                                    if(e instanceof Item) {
                                        e.remove();
                                    }
                                }
                            }

                            GameStateManager.spawningDisabled = true;

                            for(Player all : Bukkit.getOnlinePlayers()) {
                                all.setAllowFlight(false);
                            }

                            Bukkit.broadcastMessage(Main.getPrefix() + "§6Die Server Performance ist unter 13 TPS gefallen!");
                            Bukkit.broadcastMessage(Main.getPrefix() + "§cFolgende Maßnahmen wurden ergriffen:");
                            Bukkit.broadcastMessage(Main.getPrefix() + "§7* Items auf dem Boden wurden entfernt");
                            Bukkit.broadcastMessage(Main.getPrefix() + "§7* Redstone zeitweise deaktiviert");
                            Bukkit.broadcastMessage(Main.getPrefix() + "§7* Mob Spawning zeitweise deaktiviert");
                            Bukkit.broadcastMessage(Main.getPrefix() + "§7* Fliegen zeitweise deaktiviert");
                            initAntiLive();

                        } else {

                            for (World w : Bukkit.getWorlds()) {
                                for (Entity e : w.getEntities()) {
                                    if(e instanceof Item) {
                                        e.remove();
                                    }
                                }
                            }

                            GameStateManager.spawningDisabled = true;

                            for(Player all : Bukkit.getOnlinePlayers()) {
                                all.setAllowFlight(false);
                            }

                            Bukkit.broadcastMessage(Main.getPrefix() + "§6Die Server Performance ist unter 13 TPS gefallen!");
                            Bukkit.broadcastMessage(Main.getPrefix() + "§cFolgende Maßnahmen wurden ergriffen:");
                            Bukkit.broadcastMessage(Main.getPrefix() + "§7* Items auf dem Boden wurden entfernt");
                            Bukkit.broadcastMessage(Main.getPrefix() + "§7* Mob Spawning zeitweise deaktiviert");
                            Bukkit.broadcastMessage(Main.getPrefix() + "§7* Fliegen zeitweise deaktiviert");
                            initAntiLive();
                        }
                    }

                }
            }, 0, intervall);

        } else {
            return;
        }

    }

    public static void initAntiLive() {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                if(Lag.getTPS() > 18.00) {
                    GameStateManager.redstoneDisabled = false;
                    GameStateManager.spawningDisabled = false;
                    Bukkit.broadcastMessage(Main.getPrefix() + "§aDie Server Performance ist über 18 TPS gestiegen, alle Funktionen wieder freigegeben!");
                }

            }
        }, 1200);
    }

}
