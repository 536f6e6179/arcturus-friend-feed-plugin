package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import com.joopie.arcturus.plugin.friendfeed.service.ITrigger;

import java.util.List;

/**
 * Created by jospi on 3-1-2017.
 */
public class UserLoggedInTrigger extends UserTrigger implements ITrigger {
    public static final String TRIGGER = "user-logged-in";

    public UserLoggedInTrigger(List<String> channels, int userId, String username, String userLook) {
        super(channels, TRIGGER, userId, username, userLook);
    }
}