package org.cristalixcore.xsocket.Commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.cristalixcore.xsocket.CristalixProxy;

public class MsgChannel extends Command {

    private final CristalixProxy plugin;

    public MsgChannel(CristalixProxy plugin) {
        super("msg");
        this.plugin = plugin;


    }
    @Override
    public void execute(CommandSender sender, String[] args) {

        ProxiedPlayer player = (ProxiedPlayer) sender;

        if (args.length < 2) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &fИспользуйте /msg [Игрок] [Сообщение]"));
            return;
        }

        String targetPlayerName = args[0];

        if (targetPlayerName.equalsIgnoreCase(player.getName())) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c&7]&f Вы не можете отправить сообщение самому себе"));
            return;
        }


        ProxiedPlayer targetPlayer = plugin.getProxy().getPlayer(targetPlayerName);

        if (targetPlayer == null) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &fИгрок &e" + targetPlayerName + " &fне найден&7/&fили не в сети."));
            return;
        }

        String message = ChatColor.translateAlternateColorCodes('&', String.join(" ", args).substring(targetPlayerName.length() + 1));

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &fВы отправили сообщение игроку &e" + targetPlayerName + "&f: " + message));

        targetPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &fИгрок &e" + sender.getName() + " &fотправил вам сообщение " + message));
    }
}
