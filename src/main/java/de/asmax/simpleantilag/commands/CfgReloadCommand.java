package de.asmax.simpleantilag.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class CfgReloadCommand implements CommandExecutor {

    File file = new File("plugins/SimpleAntiLag", "config.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player)sender;
        if(player.hasPermission("simpleantilag.reloadcfg")) {

            try {
                cfg.load(file);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidConfigurationException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}
