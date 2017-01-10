package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import com.google.gson.annotations.Expose;
import com.joopie.arcturus.plugin.friendfeed.service.ITrigger;

import java.util.List;

/**
 * A trigger class containing data.
 */
public class UserAchievementLeveledTrigger extends UserTrigger implements ITrigger{
    public static final String TRIGGER = "user-achievement-leveled";

    @Expose
    public final String achievement;
    @Expose
    public final int oldLevel;
    @Expose
    public final int newLevel;

    /**
     *
     * @param channels
     * @param userId
     * @param username
     * @param userLook
     * @param achievement
     * @param oldLevel
     * @param newLevel
     */
    public UserAchievementLeveledTrigger(List<String> channels, int userId, String username, String userLook, String achievement, int oldLevel, int newLevel) {
        super(channels, TRIGGER, userId, username, userLook);

        this.achievement = achievement;
        this.oldLevel = oldLevel;
        this.newLevel = newLevel;
    }
}
