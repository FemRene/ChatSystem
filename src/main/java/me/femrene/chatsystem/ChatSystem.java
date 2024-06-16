package me.femrene.chatsystem;

import me.femrene.chatsystem.listeners.onChat;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatSystem extends JavaPlugin {

    private static ChatSystem instance;

    @Override
    public void onEnable() {
        instance = this;
        setConf();
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new onChat(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ChatSystem getInstance() {
        return instance;
    }

    public static String getFromConf(String path) {
        FileConfiguration config = instance.getConfig();
        return config.getString(path);
    }

    private static void setConf() {
        instance.saveDefaultConfig();
        FileConfiguration config = instance.getConfig();
        if (!config.contains("arrow")) {
            config.set("arrow", "§8»");
        }
        if (!config.contains("msg")) {
            config.set("msg", "%prefix %arrow &7%player: &r%message");
        }
        instance.saveConfig();
    }
}
