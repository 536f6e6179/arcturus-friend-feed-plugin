package com.joopie.arcturus.plugin.friendfeed;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.users.Habbo;
import com.eu.habbo.plugin.EventHandler;
import com.eu.habbo.plugin.EventListener;
import com.eu.habbo.plugin.HabboPlugin;
import com.eu.habbo.plugin.events.users.UserEnterRoomEvent;
import com.eu.habbo.plugin.events.users.UserLoginEvent;
import com.eu.habbo.plugin.events.users.UserSavedMottoEvent;
import com.eu.habbo.plugin.events.users.achievements.UserAchievementLeveledEvent;
import com.eu.habbo.plugin.events.users.friends.UserAcceptFriendRequestEvent;
import com.joopie.arcturus.plugin.friendfeed.service.IService;
import com.joopie.arcturus.plugin.friendfeed.service.ServiceFactory;
import com.joopie.arcturus.plugin.friendfeed.service.TriggerFactory;

/**
 * Created by jospi on 3-1-2017.
 */
public class FriendFeedPlugin extends HabboPlugin implements EventListener {

    private IService service;

    public FriendFeedPlugin() {
        this.service = ServiceFactory.createService();

        Emulator.getPluginManager().registerEvents(this, this);
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

    @EventHandler
    public void onUserAchievementLeveled(UserAchievementLeveledEvent event) {
        this.service.trigger(
                TriggerFactory.createTrigger(event)
        );
    }

    @EventHandler
    public void onUserAcceptFriendRequest(UserAcceptFriendRequestEvent event) {
        this.service.trigger(
                TriggerFactory.createTrigger(event)
        );
    }

    @EventHandler
    public void onUserLogin(UserLoginEvent event) {
        this.service.trigger(
                TriggerFactory.createTrigger(event)
        );
    }

    @EventHandler
    public void onUserMottoSaved(UserSavedMottoEvent event) {
        this.service.trigger(
                TriggerFactory.createTrigger(event)
        );
    }

    @EventHandler
    public void onUserEnterRoom(UserEnterRoomEvent event) {
        this.service.trigger(
                TriggerFactory.createTrigger(event)
        );
    }
}
