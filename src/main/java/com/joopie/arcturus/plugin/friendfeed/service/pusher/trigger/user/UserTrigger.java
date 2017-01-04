package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import com.google.gson.annotations.Expose;
import com.joopie.arcturus.plugin.friendfeed.service.ITrigger;
import com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.Trigger;

import java.util.List;

/**
 * Created by jospi on 4-1-2017.
 */
public class UserTrigger extends Trigger implements ITrigger{
    @Expose
    private int userId;
    @Expose
    private String username;
    @Expose
    private String userLook;

    public UserTrigger(List<String> channels, String trigger, int userId, String username, String userLook) {
        super(channels, trigger);

        this.userId = userId;
        this.username = username;
        this.userLook = userLook;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getUsername() {
        return this.username;
    }

    public String getUserLook() {
        return this.userLook;
    }
}
