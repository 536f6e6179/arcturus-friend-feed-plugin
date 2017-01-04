package com.joopie.arcturus.plugin.friendfeed.service;

import com.eu.habbo.habbohotel.messenger.MessengerBuddy;
import com.eu.habbo.habbohotel.users.Habbo;
import com.eu.habbo.plugin.events.users.UserEnterRoomEvent;
import com.eu.habbo.plugin.events.users.UserLoginEvent;
import com.eu.habbo.plugin.events.users.UserSavedMottoEvent;
import com.eu.habbo.plugin.events.users.achievements.UserAchievementLeveledEvent;
import com.eu.habbo.plugin.events.users.friends.UserAcceptFriendRequestEvent;
import com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jospi on 4-1-2017.
 */
public class TriggerFactory {
    public static ITrigger createTrigger(UserAchievementLeveledEvent event) {
        List<String> channels = getChannelListFromHabbo(event.habbo);
        return new UserAchievementLeveledTrigger(
                channels,
                event.habbo.getHabboInfo().getId(),
                event.habbo.getHabboInfo().getUsername(),
                event.achievement.name,
                event.oldLevel.level,
                event.newLevel.level);
    }

    public static ITrigger createTrigger(UserAcceptFriendRequestEvent event) {
        List<String> channels = getChannelListFromHabbo(event.habbo);
        return new UserFriendshipAcceptedTrigger(
                channels,
                event.habbo.getHabboInfo().getId(),
                event.habbo.getHabboInfo().getUsername(),
                event.friend.getId(),
                event.friend.getUsername());
    }

    public static ITrigger createTrigger(UserLoginEvent event) {
        List<String> channels = getChannelListFromHabbo(event.habbo);
        return new UserLoggedInTrigger(
                channels,
                event.habbo.getHabboInfo().getId(),
                event.habbo.getHabboInfo().getUsername());
    }

    public static ITrigger createTrigger(UserSavedMottoEvent event) {
        List<String> channels = getChannelListFromHabbo(event.habbo);
        return new UserMottoSavedTrigger(
                channels,
                event.habbo.getHabboInfo().getId(),
                event.habbo.getHabboInfo().getUsername(),
                event.oldMotto,
                event.newMotto);
    }

    public static ITrigger createTrigger(UserEnterRoomEvent event) {
        List<String> channels = getChannelListFromHabbo(event.habbo);
        return new UserRoomEnteredTrigger(
                channels,
                event.habbo.getHabboInfo().getId(),
                event.habbo.getHabboInfo().getUsername(),
                event.room.getId(),
                event.room.getName());
    }

    private static List<String> getChannelListFromHabbo(Habbo habbo) {
        List<String> channels = new ArrayList<String>();
        channels.add("private-user-" + habbo.getHabboInfo().getId());

        for (MessengerBuddy buddy : habbo.getMessenger().getFriends().values()) {
            channels.add("private-user-" + buddy.getId());
        }

        return channels;
    }
}