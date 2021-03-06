package de.asmax.simpleantilag.commands;

import de.asmax.simpleantilag.main.Main;
import de.asmax.simpleantilag.system.AntiLag;
import de.asmax.simpleantilag.system.Lag;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;

import java.io.File;

public class DebugCommand implements CommandExecutor {

    File file = new File("plugins/SimpleAntiLag", "config.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1) {

            if(args[0].equalsIgnoreCase("LTPS")) {
                sender.sendMessage(Main.getPrefix() + cfg.getDouble("Lowest TPS"));
            } else if(args[0].equalsIgnoreCase("TPS")) {
                sender.sendMessage(Main.getPrefix() + Lag.getTPS());
            } else if(args[0].equalsIgnoreCase("LLTPS")) {
                sender.sendMessage(Main.getPrefix() + AntiLag.LTPS);
            } else if(args[0].equalsIgnoreCase("TTPS")) {
                sender.sendMessage(Main.getPrefix() + AntiLag.TPS);
            } else if(args[0].equalsIgnoreCase("items")) {
                for (World w : Bukkit.getWorlds()) {
                    for (Entity e : w.getEntities()) {
                        if(e instanceof Item) {
                            e.remove();
                            System.out.println("Items removed by LiveLag!");
                        }
                    }
                }
            } else {
                sender.sendMessage(Main.getPrefix() + "Syntax Error: /debug <LTPS | TPS>");
            }

        } else {
                sender.sendMessage(Main.getPrefix() + "Syntax Error: /debug <LTPS | TPS>");
        }
        return false;
    }
}
