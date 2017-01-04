package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by jospi on 4-1-2017.
 */
public class UserAchievementLeveledTriggerTest {
    public static final String TEST_ACHIEVEMENT = "test-achievement";
    public static final int TEST_OLD_LEVEL = 1;
    public static final int TEST_NEW_LEVEL = 2;

    private UserAchievementLeveledTrigger trigger;

    @Before
    public void setUp() throws Exception {
        this.trigger = new UserAchievementLeveledTrigger(new ArrayList<String>(), 0, "", "", TEST_ACHIEVEMENT, TEST_OLD_LEVEL, TEST_NEW_LEVEL);
    }

    @Test
    public void getAchievement() throws Exception {
        assertEquals(TEST_ACHIEVEMENT, this.trigger.getAchievement());
    }

    @Test
    public void getOldLevel() throws Exception {
        assertEquals(TEST_OLD_LEVEL, this.trigger.getOldLevel());
    }

    @Test
    public void getNewLevel() throws Exception {
        assertEquals(TEST_NEW_LEVEL, this.trigger.getNewLevel());
    }

}