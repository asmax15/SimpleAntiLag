package de.asmax.simpleantilag.main;

import de.asmax.simpleantilag.commands.CfgReloadCommand;
import de.asmax.simpleantilag.commands.DebugCommand;
import de.asmax.simpleantilag.commands.highprio.ForceReloadCommand;
import de.asmax.simpleantilag.commands.highprio.ReloadCommand;
import de.asmax.simpleantilag.commands.highprio.StopCommand;
import de.asmax.simpleantilag.listener.DropListener;
import de.asmax.simpleantilag.listener.FlyListener;
import de.asmax.simpleantilag.listener.RedstoneListener;
import de.asmax.simpleantilag.listener.SpawnListener;
import de.asmax.simpleantilag.system.AntiLag;
import de.asmax.simpleantilag.system.Lag;
import de.asmax.simpleantilag.system.LiveLag;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {

    private static Main instance;
    FileConfiguration cfg = getConfig();

    @Override
    public void onEnable() {
        instance = this;

        CommandRegistration();
        ListenerRegistration();

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Lag(), 20L, 1L);

        initConfig();
        initAntiLag();
        initRestart();
        LiveLag.InitLiveLag();

    }

    @Override
    public void onDisable() {

    }

    public static Main getInstance() {
        return instance;
    }

    private void CommandRegistration() {
        getCommand("debug").setExecutor(new DebugCommand());
        getCommand("rlconfig").setExecutor(new CfgReloadCommand());
    }

    private void ListenerRegistration() {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new DropListener(), this);
        pluginManager.registerEvents(new FlyListener(), this);
        pluginManager.registerEvents(new ReloadCommand(), this);
        pluginManager.registerEvents(new ForceReloadCommand(), this);
        pluginManager.registerEvents(new StopCommand(), this);
        pluginManager.registerEvents(new RedstoneListener(), this);
        pluginManager.registerEvents(new SpawnListener(), this);
    }

    private void initConfig() {
        cfg.addDefault("Language", "en");
        cfg.addDefault("Prefix", "§8[§cSimpleAntiLag§8] §7");
        cfg.addDefault("Lowest TPS", 18.00);
        cfg.addDefault("Kick Player if Server runs out of TPS", true);
        cfg.addDefault("Unload useless Chunks", true);
        cfg.addDefault("Level Nether Name", "world_nether");
        cfg.addDefault("Default Level Name", "world");
        cfg.addDefault("Max Entities", 1000);
        cfg.addDefault("Lower TPS", 19.00);
        cfg.addDefault("PerformanceCheck", true);
        cfg.addDefault("CheckerIntervall", 2400);
        cfg.addDefault("Allow LiveLag disable Redstone", false);
        cfg.addDefault("AutoRestart", true);
        cfg.addDefault("AutoRestartIntervallTICKS", 72000);
        cfg.options().copyDefaults(true);
        saveConfig();
        System.out.println(getPrefix() + "§aConfig successfully loaded!");
    }

    private static void initAntiLag() {
        System.out.println(getPrefix() + "§aAntiLag System successfully loaded!");
        Bukkit.getScheduler().scheduleSyncRepeatingTask(getInstance(), new Runnable() {
            @Override
            public void run() {

                AntiLag.AntiLag();
                AntiLag.unloadUselessChunks();

            }
        }, 20L, 10L);
    }

    public static String getPrefix() {
        File file = new File("plugins/SimpleAntiLag", "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        return config.getString("Prefix");
    }

    private void initRestart() {
        boolean restart = cfg.getBoolean("AutoRestart");
        int intervall = cfg.getInt("AutoRestartIntervallTICKS");

        if(restart) {

            Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                @Override
                public void run() {

                    for(Player all : Bukkit.getOnlinePlayers()) {
                        all.kickPlayer("§cDer Server wurde vom AntiLagSystem automatisch neu gestartet um eine effiziente Server Leistung zu erzielen. Bitte habe einen Moment Geduld.");
                        Bukkit.getServer().shutdown();
                    }

                }
            }, intervall);

        }
    }

}
