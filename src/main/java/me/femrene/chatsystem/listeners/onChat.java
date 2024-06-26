package me.femrene.chatsystem.listeners;

import me.femrene.chatsystem.ChatSystem;
import me.femrene.chatsystem.util.GradientTextUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.RegisteredServiceProvider;

public class onChat implements Listener {

    private static final MiniMessage MINI_MESSAGE = MiniMessage.builder().build();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String prefix = "";
        String suffix = "";
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            LuckPerms api = provider.getProvider();
            if (ChatSystem.getBooleanFromConf("useMetaKeyAsPrefix")) {
                prefix = api.getUserManager().getUser(p.getUniqueId()).getCachedData().getMetaData().getMetaValue(ChatSystem.getFromConf("metaPrefixString"));
            } else {
                prefix = api.getUserManager().getUser(p.getUniqueId()).getCachedData().getMetaData().getPrefix();
            }
            if (ChatSystem.getBooleanFromConf("useMetaKeyAsSuffix")) {
                suffix = api.getUserManager().getUser(p.getUniqueId()).getCachedData().getMetaData().getMetaValue(ChatSystem.getFromConf("metaSuffixString"));
            } else {
                suffix = api.getUserManager().getUser(p.getUniqueId()).getCachedData().getMetaData().getPrefix();
            }
        }
        String[] s = e.getMessage().split(" ");
        for (int i = 0; i < s.length; i++) {
            if (Bukkit.getPlayer(s[i]) != null && Bukkit.getPlayer(s[i]).getName().equals(s[i])) {
                s[i] = ChatSystem.getFromConf("mentionMessage").replace("%player", s[i]);
            } else if (Bukkit.getPlayer(s[i].replace("@","")) != null && Bukkit.getPlayer(s[i].replace("@","")).getName().equals(s[i].replace("@",""))) {
                //s[i] = "<"+mColor+">@"+s[i].replace("@","")+"<reset>";
                s[i] = ChatSystem.getFromConf("mentionMessage").replace("%player", s[i].replace("@",""));
            }
        }
        if (prefix != null)
            prefix = ChatColor.translateAlternateColorCodes('&',prefix);
        else
            prefix = "";
        e.setMessage(String.join(" ",s));
        e.setCancelled(true);
        String txt = ChatSystem.getFromConf("msg");
        txt = txt.replace("%prefix",prefix);
        txt = txt.replace("%arrow",ChatSystem.getFromConf("arrow"));
        txt = txt.replace("%player",p.getName());
        txt = txt.replace("%message",e.getMessage());
        txt = txt.replace("%suffix",suffix);
        if (p.hasPermission("chat.important")) {
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.sendMessage(translateHexColorCodes(ChatSystem.getFromConf("arrow")));
                onlinePlayer.sendMessage(translateHexColorCodes(txt));
                onlinePlayer.sendMessage(translateHexColorCodes(ChatSystem.getFromConf("arrow")));
            }
        } else if (p.hasPermission("chat.write")) {
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.sendMessage(translateHexColorCodes(txt));
            }
        }
    }

    public Component translateHexColorCodes(String message)
    {
        String gradientMessage = GradientTextUtil.applyGradient(message);
        return MINI_MESSAGE.deserialize(gradientMessage);
    }

}
