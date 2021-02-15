package de.asmax.simpleantilag.system;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

import java.io.File;

public class AntiLag {

    static File file = new File("plugins/SimpleAntiLag", "config.yml");
    static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static double LTPS = cfg.getDouble("Lowest TPS");
    public static double TPS = Lag.getTPS();
    static int maxEnteties = cfg.getInt("Max Enteties");

    public static void AntiLag() {

        if(TPS < LTPS || Bukkit.getWorld(cfg.getString("Default Level Name")).getEntities().size() > maxEnteties) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                if(cfg.getBoolean("Kick Player if Server runs out of TPS")) {
                    all.kickPlayer("§cDas AntiLag System hat einen Schwerwiegenden Einbruch der Server Leistung festgestellt. Der Server wird nun vom AntiLag System bereinigt. Bitte habe einen Moment Geduld.");
                    for (World w : Bukkit.getWorlds()) {
                        for (Entity e : w.getEntities()) {
                            e.remove();
                            //System.out.println("§f§lLAG REMOVED! by SimpleAntiLag");
                        }
                    }

                } else {
                    for (World w : Bukkit.getWorlds()) {
                        for (Entity e : w.getEntities()) {
                            if(e instanceof Item) {
                                e.remove();
                                //System.out.println("§f§lLAG REMOVED! by SimpleAntiLag");
                            }
                        }
                    }
                }
            }

        }
    }

    public static void unloadUselessChunks() {
        if(cfg.getBoolean("Unload useless Chunks")) {
            if(Lag.getTPS() < cfg.getDouble("Lower TPS")) {

                String NetherName = cfg.getString("Level Nether Name");
                String DefaultLevel = cfg.getString("Default Level Name");

                if (Bukkit.getWorld(NetherName).getPlayers().size() < 1) {
                    World world = Bukkit.getWorld(NetherName);

                    for (Chunk c : world.getLoadedChunks()) {
                        c.unload();
                        System.out.println("Chunk unloaded by SimpleAntiLag");
                    }

                }

                World world = Bukkit.getWorld(DefaultLevel);
                for (Chunk c : world.getLoadedChunks()) {
                    c.unload();
                }

            }
        } else {
            return;
        }
    }

}
