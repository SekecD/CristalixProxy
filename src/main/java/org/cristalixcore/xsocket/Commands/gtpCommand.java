package org.cristalixcore.xsocket.Commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.cristalixcore.xsocket.CristalixProxy;


public class gtpCommand extends Command {

    private final CristalixProxy plugin;

    public gtpCommand(CristalixProxy plugin) {
        super("gtp");
        this.plugin = plugin;


    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7[&cCristalixProxy&7] &fЭту команду могут использовать только игроки"));
            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;

        if (args.length < 1) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7[&cCristalixProxy&7] &f/gtp &7[&fСервер&7]"));
            return;
        }

        String targetServer = args[0].toLowerCase();
        ProxyServer proxy = plugin.getProxy();

        if (!proxy.getServers().containsKey(targetServer)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7[&cCristalixProxy&7] &fУказанный сервер не найден."));
            return;
        }

        if (player.getServer().getInfo().getName().equalsIgnoreCase(targetServer)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7[&cCristalixProxy&7] &fВы уже находитесь на этом сервере"));
        }

        player.connect(proxy.getServerInfo(targetServer), (result, throwable) -> {});
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7[&cCristalixProxy&7] &fВы были перемещены на сервер &e " + targetServer));
    }

}
