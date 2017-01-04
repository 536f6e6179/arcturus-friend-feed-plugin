package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by jospi on 4-1-2017.
 */
public class UserTriggerTest {
    public static final int TEST_USER_ID = 1;
    public static final String TEST_USERNAME = "test-username";

    private UserTrigger trigger;

    @Before
    public void setUp() throws Exception {
        this.trigger = new UserTrigger(new ArrayList<String>(), "", TEST_USER_ID, TEST_USERNAME);
    }

    @Test
    public void getUserId() throws Exception {
        assertEquals(TEST_USER_ID, this.trigger.getUserId());
    }

    @Test
    public void getUsername() throws Exception {
        assertEquals(TEST_USERNAME, this.trigger.getUsername());
    }

}