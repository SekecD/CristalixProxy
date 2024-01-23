package org.cristalixcore.xsocket.Commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Command;
import org.cristalixcore.xsocket.CristalixProxy;

import java.util.Map;

public class ServerList extends Command {

    private final CristalixProxy plugin;

    public ServerList(CristalixProxy plugin) {
        super("slist");
        this.plugin = plugin;
    }
    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&cCristalixProxy&7] &d=== &fСписок серверов &d==="));

        Map<String, ServerInfo> servers = plugin.getProxy().getServers();
        for (Map.Entry<String, ServerInfo> entry : servers.entrySet()) {
            String serverName = entry.getKey();
            ServerInfo serverInfo = entry.getValue();

            int onlinePlayers = serverInfo.getPlayers().size();

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&cCristalixProxy&7] &f Сервер: " + serverName + "&7 » &fИгроков: &f" + onlinePlayers));
        }

    }
}
