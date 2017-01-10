package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import com.joopie.arcturus.plugin.friendfeed.service.ITrigger;

import java.util.List;

/**
 * A trigger class containing data.
 */
public class UserLoggedInTrigger extends UserTrigger implements ITrigger {
    public static final String TRIGGER = "user-logged-in";

    /**
     *
     * @param channels
     * @param userId
     * @param username
     * @param userLook
     */
    public UserLoggedInTrigger(List<String> channels, int userId, String username, String userLook) {
        super(channels, TRIGGER, userId, username, userLook);
    }
}