package me.femrene.chatsystem.commands;

import me.femrene.chatsystem.ChatSystem;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PluginReload implements CommandExecutor {

    /**
     * Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("chatsystem.reload")) {
                ChatSystem.getInstance().reloadConfig();
                player.sendMessage(Component.text("§aThe ChatSystem configuration has been reloaded successfully."));
                return true;
            } else {
                player.sendMessage(Component.text("§cYou don't have permission to use this command."));
                return true;
            }
        } else {
            // Allow console to reload the config
            ChatSystem.getInstance().reloadConfig();
            sender.sendMessage(Component.text("The ChatSystem configuration has been reloaded successfully."));
            return true;
        }
    }
}