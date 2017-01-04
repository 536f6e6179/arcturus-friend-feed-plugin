package com.joopie.arcturus.plugin.friendfeed;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.users.Habbo;
import com.eu.habbo.plugin.HabboPlugin;
import com.joopie.arcturus.plugin.friendfeed.event.EventRegister;
import com.joopie.arcturus.plugin.friendfeed.service.IService;
import com.joopie.arcturus.plugin.friendfeed.service.ServiceFactory;

/**
 * Created by jospi on 3-1-2017.
 */
public class FriendFeedPlugin extends HabboPlugin {

    private IService service;

    public FriendFeedPlugin() {
        this.service = ServiceFactory.createService();

        Emulator.getPluginManager().registerEvents(this, new EventRegister(this));
    }

    @Override
    public void onEnable() {
        Emulator.getLogging().logStart("Starting Friend Feed Plugin!");
    }

    @Override
    public void onDisable() {
        Emulator.getLogging().logStart("Stopping Friend Feed Plugin :(.");
    }

    @Override
    public boolean hasPermission(Habbo habbo, String s) {
        return true;
    }

    public IService getService() {
        return this.service;
    }
}
