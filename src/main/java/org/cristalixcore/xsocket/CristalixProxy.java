package org.cristalixcore.xsocket;

import net.md_5.bungee.api.plugin.Plugin;
import org.cristalixcore.xsocket.Commands.*;

public final class CristalixProxy extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerCommand(this, new ProxyCommands(this));
        getProxy().getPluginManager().registerCommand(this, new BroadcastCommand(this));
        getProxy().getPluginManager().registerCommand(this, new ServerList(this));
        getProxy().getPluginManager().registerCommand(this, new gtpCommand(this));
        getProxy().getPluginManager().registerCommand(this, new HubCommand(this));
        getProxy().getPluginManager().registerCommand(this, new MsgChannel(this));
        getProxy().getPluginManager().registerCommand(this, new ServerBlock(this));

    }

    @Override
    public void onDisable() {
    }
}
