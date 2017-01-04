package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import com.google.gson.annotations.Expose;
import com.joopie.arcturus.plugin.friendfeed.service.ITrigger;

import java.util.List;

/**
 * Created by jospi on 3-1-2017.
 */
public class UserFriendshipAcceptedTrigger extends UserTrigger implements ITrigger {
    public static final String TRIGGER = "user-friendship-accepted";

    @Expose
    private int friendId;
    @Expose
    private String friendname;

    public UserFriendshipAcceptedTrigger(List<String> channels, int userId, String username, int friendId, String friendname) {
        super(channels, TRIGGER, userId, username);

        this.friendId = friendId;
        this.friendname = friendname;
    }

    public int getFriendId() {
        return this.friendId;
    }

    public String getFriendname() {
        return this.friendname;
    }
}