package de.asmax.simpleantilag.system;

import de.asmax.simpleantilag.utils.MessageSender;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.*;

import java.io.File;

public class AntiLag {

    static File file = new File("plugins/SimpleAntiLag", "config.yml");
    static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static double LTPS = cfg.getDouble("Lowest TPS");
    public static double TPS = Lag.getTPS();
    static int maxEnteties = cfg.getInt("Max Entities");

    public static void AntiLag() {

        if(Lag.getTPS() < LTPS || Bukkit.getWorld(cfg.getString("Default Level Name")).getEntities().size() > maxEnteties) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                if(cfg.getBoolean("Kick Player if Server runs out of TPS")) {
                    all.kickPlayer(MessageSender.kickRunOfTPS());
                    for (World w : Bukkit.getWorlds()) {
                        for (Entity e : w.getEntities()) {
                            if(!(e instanceof Minecart || e instanceof Villager || e instanceof Sheep || e instanceof Chicken || e instanceof Pig
                                    || e instanceof Horse || e instanceof Donkey || e instanceof Wither || e instanceof EnderDragon || e instanceof IronGolem
                                    || e instanceof Cow || e instanceof ArmorStand || e instanceof Player || e instanceof Llama || e instanceof WanderingTrader || e instanceof Panda || e instanceof Cat)) {
                                e.remove();
                            }
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
                        //System.out.println("Chunk unloaded by SimpleAntiLag");
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
