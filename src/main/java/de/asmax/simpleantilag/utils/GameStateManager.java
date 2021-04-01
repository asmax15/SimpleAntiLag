package de.asmax.simpleantilag.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class GameStateManager {

    static File file = new File("plugins/SimpleAntiLag", "config.yml");
    static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static boolean allowDrop = true;

    public static boolean allowFlight = true;

    public static boolean allowChunkLoading = true;

    public static boolean redstoneDisabled = false;

    public static boolean spawningDisabled = false;

    public static String Language;


}
