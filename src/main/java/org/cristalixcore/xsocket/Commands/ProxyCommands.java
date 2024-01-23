package org.cristalixcore.xsocket.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.ChatColor;
import org.cristalixcore.xsocket.CristalixProxy;

public class ProxyCommands extends Command {

    private final CristalixProxy plugin;

    public ProxyCommands(CristalixProxy plugin) {
        super("bungee");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7[&cCristalixProxy&7] &d=== &fИнформация о сервере &d==="));
        sender.sendMessage("    ");
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7[&cCristalixProxy&7] &fЗапущено серверов: " + plugin.getProxy().getServers().size()));

        int onlinePlayers = plugin.getProxy().getOnlineCount();
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7[&cCristalixProxy&7] &fИгроков в сети: " + onlinePlayers));
    }
}
