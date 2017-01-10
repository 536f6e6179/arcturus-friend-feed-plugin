package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import com.google.gson.annotations.Expose;
import com.joopie.arcturus.plugin.friendfeed.service.ITrigger;

import java.util.List;

/**
 * A trigger class containing data.
 */
public class UserFriendshipAcceptedTrigger extends UserTrigger implements ITrigger {
    public static final String TRIGGER = "user-friendship-accepted";

    @Expose
    public final int friendId;
    @Expose
    public final String friendname;
    @Expose
    public final String friendLook;

    /**
     *
     * @param channels
     * @param userId
     * @param username
     * @param userLook
     * @param friendId
     * @param friendname
     * @param friendLook
     */
    public UserFriendshipAcceptedTrigger(List<String> channels, int userId, String username, String userLook, int friendId, String friendname, String friendLook) {
        super(channels, TRIGGER, userId, username, userLook);

        this.friendId = friendId;
        this.friendname = friendname;
        this.friendLook = friendLook;
    }
}