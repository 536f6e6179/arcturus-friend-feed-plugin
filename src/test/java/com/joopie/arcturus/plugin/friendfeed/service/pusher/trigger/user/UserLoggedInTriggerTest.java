package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by jospi on 4-1-2017.
 */
public class UserLoggedInTriggerTest {
    private UserLoggedInTrigger trigger;

    @Before
    public void setUp() throws Exception {
        this.trigger = new UserLoggedInTrigger(new ArrayList<String>(), 0, "");
    }

    @Test
    public void testInstance() {
        assertTrue(this.trigger instanceof UserLoggedInTrigger);
    }
}