package me.femrene.chatsystem;

import me.femrene.chatsystem.commands.PluginReload;
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
        // Listener
        Bukkit.getPluginManager().registerEvents(new onChat(), this);
        // Commands
        getCommand("creload").setExecutor(new PluginReload());
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

    public static boolean getBooleanFromConf(String path) {
        FileConfiguration config = instance.getConfig();
        return config.getBoolean(path);
    }

    private static void setConf() {
        instance.saveDefaultConfig();
        FileConfiguration config = instance.getConfig();
        if (!config.contains("arrow")) {
            config.set("arrow", "<#555555>»");
        }
        if (!config.contains("msg")) {
            config.set("msg", "%prefix %arrow <#AAAAAA>%player %suffix: <reset>%message");
        }
        if (!config.contains("mentionMessage")) {
            config.set("mentionMessage", "<#55FFFF>@%player<reset>");
        }
        if (!config.contains("useMetaKeyAsPrefix")) {
            config.set("useMetaKeyAsPrefix", false);
        }
        if (!config.contains("metaPrefixString")) {
            config.set("metaPrefixString", "META-KEY");
        }
        if (!config.contains("useMetaKeyAsSuffix")) {
            config.set("useMetaKeyAsSuffix", false);
        }
        if (!config.contains("metaSuffixString")) {
            config.set("metaSuffixString", "META-KEY");
        }
        instance.saveConfig();
    }
}
