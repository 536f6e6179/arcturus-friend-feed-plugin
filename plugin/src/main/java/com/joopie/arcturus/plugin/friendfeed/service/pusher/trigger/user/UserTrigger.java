package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import com.google.gson.annotations.Expose;
import com.joopie.arcturus.plugin.friendfeed.service.ITrigger;
import com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.Trigger;

import java.util.List;

/**
 * A trigger class containing data.
 */
public class UserTrigger extends Trigger implements ITrigger{
    @Expose
    public final int userId;
    @Expose
    public final String username;
    @Expose
    public final String userLook;

    /**
     *
     * @param channels
     * @param trigger
     * @param userId
     * @param username
     * @param userLook
     */
    public UserTrigger(List<String> channels, String trigger, int userId, String username, String userLook) {
        super(channels, trigger);

        this.userId = userId;
        this.username = username;
        this.userLook = userLook;
    }
}
