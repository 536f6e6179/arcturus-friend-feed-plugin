package com.joopie.arcturus.plugin.friendfeed.event;

import com.eu.habbo.plugin.EventHandler;
import com.eu.habbo.plugin.EventListener;
import com.eu.habbo.plugin.events.users.UserEnterRoomEvent;
import com.eu.habbo.plugin.events.users.UserLoginEvent;
import com.eu.habbo.plugin.events.users.UserSavedMottoEvent;
import com.eu.habbo.plugin.events.users.achievements.UserAchievementLeveledEvent;
import com.eu.habbo.plugin.events.users.friends.UserAcceptFriendRequestEvent;
import com.joopie.arcturus.plugin.friendfeed.FriendFeedPlugin;
import com.joopie.arcturus.plugin.friendfeed.service.TriggerFactory;

/**
 * Created by jospi on 3-1-2017.
 */
public class EventRegister implements EventListener {
    private FriendFeedPlugin plugin;

    public EventRegister(FriendFeedPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onUserAchievementLeveled(UserAchievementLeveledEvent event) {
        this.plugin.getService().trigger(
                TriggerFactory.createTrigger(event)
        );
    }

    @EventHandler
    public void onUserAcceptFriendRequest(UserAcceptFriendRequestEvent event) {
        this.plugin.getService().trigger(
                TriggerFactory.createTrigger(event)
        );
    }

    @EventHandler
    public void onUserLogin(UserLoginEvent event) {
        this.plugin.getService().trigger(
                TriggerFactory.createTrigger(event)
        );
    }

    @EventHandler
    public void onUserMottoSaved(UserSavedMottoEvent event) {
        this.plugin.getService().trigger(
                TriggerFactory.createTrigger(event)
        );
    }

    @EventHandler
    public void onUserEnterRoom(UserEnterRoomEvent event) {
        this.plugin.getService().trigger(
                TriggerFactory.createTrigger(event)
        );
    }
}
