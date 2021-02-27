package de.asmax.simpleantilag.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

import java.io.File;

public class LagCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player)sender;

         File file = new File("plugins/SimpleAntiLag", "config.yml");
         FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

          double LTPS = cfg.getDouble("Lowest TPS");
          double TPS = de.asmax.simpleantilag.system.Lag.getTPS();
         int maxEnteties = cfg.getInt("Max Entities");

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

        return false;
    }
}
