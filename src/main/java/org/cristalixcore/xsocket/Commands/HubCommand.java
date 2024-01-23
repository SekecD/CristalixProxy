package org.cristalixcore.xsocket.Commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.protocol.packet.Chat;
import org.cristalixcore.xsocket.CristalixProxy;

public class HubCommand extends Command {

    private final CristalixProxy plugin;

    public HubCommand(CristalixProxy plugin) {
        super("hub");
        this.plugin = plugin;
    }


    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage("Only for players");
            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;
        String targetServer = "lobby";

        if (!plugin.getProxy().getServers().containsKey(targetServer)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&cCristalixProxy&7] &fНет доступных серверов."));
            return;
        }

        if (player.getServer().getInfo().getName().equalsIgnoreCase(targetServer)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&cCristalixProxy&7] &fВы итак находитесь на сервере &d" + targetServer));
            return;
        }

        player.connect(plugin.getProxy().getServerInfo(targetServer), (result, throwable) -> {});
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &fВы были перемещены на сервер &d" + targetServer));
    }
}
