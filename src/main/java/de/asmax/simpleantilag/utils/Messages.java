package de.asmax.simpleantilag.utils;

import de.asmax.simpleantilag.main.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Messages {

    static File file = new File("plugins/SimpleAntiLag", "config.yml");
    static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static String getLanguage() {
        String lang = cfg.getString("Language");
        return lang;
    }

    public static String reloadInfoSenderDE = Main.getPrefix() + "Der reload Befehl wurde vom AntiLagSystem übernommen, um eine effizientere Server Performance zu gewährleisten.";
    public static String reloadInfoSenderEN = Main.getPrefix() + "The reload Command has been handled by the AntiLagSystem, to guaranteed a more efficient server performance.";

    public static String reloadInfoDE = "§cDer Server wird neu geladen. Dieser Befehl wurde vom AntiLagSystem übernommen, um eine effizientere Server Leistung zu gewährleisten. Bitte habe einen Moment Geduld.";
    public static String reloadInfoEN = "§cThe Server is reloading. This Command has been handled by the AntiLagSystem, to guarantee a more efficient server performance. Please be patient a moment.";

    public static String initReloadDE = Main.getPrefix() + "§c§lDer Server wird vom AntiLagSystem in §2§leiner Minute §c§lneu geladen, dabei werden alle Spieler vom Server getrennt, um einen stabilen reload zu gewährleisten!";
    public static String initReloadEN = Main.getPrefix() + "§c§lThe Server is going to reload in §2§lone Minute§c§l. In this process all Player will be disconnected from Server to guarantee a stable reload!";

    public static String stopInfoSenderDE = Main.getPrefix() + "Dieser Befehl wurde vom AntiLagSystem übernommen, um ein effizienteres Herunterfahren zu gewährleisten.";
    public static String stopInfoSenderEN = Main.getPrefix() + "This commands has been handled by the AntiLagSystem to guarantee a more efficient server performance.";

    public static String stopInfoDE = Main.getPrefix() + "§4§lDer Server wird in §a§leiner Minute §4§lHeruntergefahren. Diese Aktion wude vom AntiLagSystem übernommen, um eine effizienteres Herunterfahren des Servers zu gewährleisten.";
    public static String stopInfoEN = Main.getPrefix() + "§4§lThe Server will shutdown in §a§lone Minute. §4§lThis Action has been handled by the AntiLagSystem to guarantee a more efficient shutdown.";

    public static String shutdownKickDE = "§cDer Server wird heruntergefahren. Dieser Befehl wurde vom AntiLagSystem übernommen, um eine effizientere Server Leistung zu gewährleisten. §4§lServer closed!";
    public static String shutdownKickEN = "§cThe Server is going to shutdown. This command was handled by the AntiLagSystem to guarantee a more efficient server performance. §4§lServer closed!";

    public static String kickRunOfTPSDE = "§cDas AntiLag System hat einen Schwerwiegenden Einbruch der Server Leistung festgestellt. Der Server wird nun vom AntiLag System bereinigt. Bitte habe einen Moment Geduld.";
    public static String kickRunOfTPSEN = "§cThe AntiLagSystem had noticed a massive impact to the Server Performance. The Server are beeing cleaned by the AntiLagSystem. Please be patient a moment.";

    public static String liveLag18RedDELine1 = Main.getPrefix() + "§6Die Server Performance ist unter 18 TPS gefallen!";
    public static String liveLag18RedENLine1 = Main.getPrefix() + "§6The Server Performance has decreased under 18 TPS!";

    public static String liveLag16RedDELine1 = Main.getPrefix() + "§6Die Server Performance ist unter 16 TPS gefallen!";
    public static String liveLag16RedENLine1 = Main.getPrefix() + "§6The Server Performance has decreased under 16 TPS!";

    public static String liveLag18RedDELine2 = Main.getPrefix() + "§cFolgende Maßnahmen wurden ergriffen:";
    public static String liveLag18RedENLine2 = Main.getPrefix() + "§cThe Following measures have been taken:";

    public static String liveLag18RedDELine3 = Main.getPrefix() + "§7* Items auf dem Boden wurden entfernt";
    public static String liveLag18RedENLine3 = Main.getPrefix() + "§7* Items on the ground are removed";

    public static String liveLag18RedDELine4 = Main.getPrefix() + "§7* Redstone zeitweise deaktiviert";
    public static String liveLag18RedENLine4 = Main.getPrefix() + "§7* Redstone temporary disabled";

    public static String liveLag18RedDELine5 = Main.getPrefix() + "§7* Mob Spawning zeitweise deaktiviert";
    public static String liveLag18RedENLine5 = Main.getPrefix() + "§7* Mob spawning temporary disabled";
}
