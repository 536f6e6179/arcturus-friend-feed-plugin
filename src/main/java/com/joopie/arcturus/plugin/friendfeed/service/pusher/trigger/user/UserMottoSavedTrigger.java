package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import com.google.gson.annotations.Expose;
import com.joopie.arcturus.plugin.friendfeed.service.ITrigger;

import java.util.List;

/**
 * Created by jospi on 3-1-2017.
 */
public class UserMottoSavedTrigger extends UserTrigger implements ITrigger {
    public static final String TRIGGER = "user-motto-saved";

    @Expose
    private String oldMotto;
    @Expose
    private String newMotto;

    public UserMottoSavedTrigger(List<String> channels, int userId, String username, String oldMotto, String newMotto) {
        super(channels, TRIGGER, userId, username);

        this.oldMotto = oldMotto;
        this.newMotto = newMotto;
    }

    public String getOldMotto() {
        return this.oldMotto;
    }

    public String getNewMotto() {
        return this.newMotto;
    }
}