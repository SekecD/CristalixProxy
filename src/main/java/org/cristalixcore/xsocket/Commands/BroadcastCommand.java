package org.cristalixcore.xsocket.Commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.cristalixcore.xsocket.CristalixProxy;

import java.util.Locale;


public class BroadcastCommand extends Command {

    private final CristalixProxy plugin;

    public BroadcastCommand(CristalixProxy plugin) {
        super("bc");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 2) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &fИспользуй: /bc &7[&fСервер&7] &7[&fСобщение&7]"));
            return;
        }

        String server = args[0].toLowerCase();
        String message = ChatColor.translateAlternateColorCodes('&', String.join(" ", args).substring(server.length() + 1));

        if (server.equals("all")) {
            plugin.getProxy().broadcast(new TextComponent(" §7[§с!§7] §f" + message));
        } else {
            ProxiedPlayer targetServer = plugin.getProxy().getPlayer(server);
            if (targetServer != null) {
                targetServer.sendMessage(new TextComponent(" §7[§с!§7] §f" + message));
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &fСервер не найден или не в сети."));
            }
        }

    }
}
