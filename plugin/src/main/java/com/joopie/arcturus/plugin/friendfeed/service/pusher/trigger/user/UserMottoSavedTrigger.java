package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import com.google.gson.annotations.Expose;
import com.joopie.arcturus.plugin.friendfeed.service.ITrigger;

import java.util.List;

/**
 * A trigger class containing data.
 */
public class UserMottoSavedTrigger extends UserTrigger implements ITrigger {
    public static final String TRIGGER = "user-motto-saved";

    @Expose
    public final String oldMotto;
    @Expose
    public final String newMotto;

    /**
     *
     * @param channels
     * @param userId
     * @param username
     * @param userLook
     * @param oldMotto
     * @param newMotto
     */
    public UserMottoSavedTrigger(List<String> channels, int userId, String username, String userLook, String oldMotto, String newMotto) {
        super(channels, TRIGGER, userId, username, userLook);

        this.oldMotto = oldMotto;
        this.newMotto = newMotto;
    }
}