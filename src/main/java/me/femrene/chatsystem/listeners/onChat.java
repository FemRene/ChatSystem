package me.femrene.chatsystem.listeners;

import me.femrene.chatsystem.ChatSystem;
import net.kyori.adventure.text.Component;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.RegisteredServiceProvider;

public class onChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String prefix = "";
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            LuckPerms api = provider.getProvider();
            prefix = api.getUserManager().getUser(p.getUniqueId()).getCachedData().getMetaData().getPrefix();
        }
        String[] s = e.getMessage().split(" ");
        for (int i = 0; i < s.length; i++) {
            if (Bukkit.getPlayer(s[i]) != null && Bukkit.getPlayer(s[i]).getName().equals(s[i])) {
                s[i] = "§b@"+s[i]+"§r";
            } else if (Bukkit.getPlayer(s[i].replace("@","")) != null && Bukkit.getPlayer(s[i].replace("@","")).getName().equals(s[i].replace("@",""))) {
                s[i] = "§b@"+s[i].replace("@","")+"§r";
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
        if (p.hasPermission("chat.important")) {
            Bukkit.broadcast(Component.text(ChatSystem.getFromConf("arrow")));
            Bukkit.broadcast(Component.text(ChatColor.translateAlternateColorCodes('&',txt)));
            Bukkit.broadcast(Component.text(ChatSystem.getFromConf("arrow")));
        } else if (p.hasPermission("chat.write")) {
            //Bukkit.broadcast(Component.text(ChatColor.translateAlternateColorCodes('&',txt)));
            String finalTxt = txt;
            Bukkit.getOnlinePlayers().forEach(player -> {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', finalTxt));
            });
        }
    }

}
