package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by jospi on 4-1-2017.
 */
public class UserMottoSavedTriggerTest {
    public static final String TEST_OLD_MOTTO = "test-old-motto";
    public static final String TEST_NEW_MOTTO = "test-new-motto";

    private UserMottoSavedTrigger trigger;

    @Before
    public void setUp() throws Exception {
        this.trigger = new UserMottoSavedTrigger(new ArrayList<String>(), 0, "", TEST_OLD_MOTTO, TEST_NEW_MOTTO);
    }

    @Test
    public void getOldMotto() throws Exception {
        assertEquals(TEST_OLD_MOTTO, this.trigger.getOldMotto());
    }

    @Test
    public void getNewMotto() throws Exception {
        assertEquals(TEST_NEW_MOTTO, this.trigger.getNewMotto());
    }

}