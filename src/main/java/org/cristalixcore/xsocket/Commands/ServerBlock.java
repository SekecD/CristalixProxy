package org.cristalixcore.xsocket.Commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import org.cristalixcore.xsocket.CristalixProxy;

public class ServerBlock extends Command {

    private final CristalixProxy plugin;

    public ServerBlock(CristalixProxy plugin) {
        super("server");
        this.plugin = plugin;
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&cCristalixCore&7]&f Используйте /gtp"));
    }
}
