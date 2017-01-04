package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import com.google.gson.annotations.Expose;
import com.joopie.arcturus.plugin.friendfeed.service.ITrigger;

import java.util.List;

/**
 * Created by jospi on 3-1-2017.
 */
public class UserAchievementLeveledTrigger extends UserTrigger implements ITrigger{
    public static final String TRIGGER = "user-achievement-leveled";

    @Expose
    private String achievement;
    @Expose
    private int oldLevel;
    @Expose
    private int newLevel;

    public UserAchievementLeveledTrigger(List<String> channels, int userId, String username, String userLook, String achievement, int oldLevel, int newLevel) {
        super(channels, TRIGGER, userId, username, userLook);

        this.achievement = achievement;
        this.oldLevel = oldLevel;
        this.newLevel = newLevel;
    }

    public String getAchievement() {
        return this.achievement;
    }

    public int getOldLevel() {
        return this.oldLevel;
    }

    public int getNewLevel() {
        return this.newLevel;
    }
}
