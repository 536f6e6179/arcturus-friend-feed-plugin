package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by jospi on 4-1-2017.
 */
public class UserFriendshipAcceptedTriggerTest {
    public static final int TEST_FRIEND_ID = 3;
    public static final String TEST_FRIENDNAME = "test-friendname";
    public static final String TEST_FRIEND_LOOK = "test-look";

    private UserFriendshipAcceptedTrigger trigger;

    @Before
    public void setUp() throws Exception {
        this.trigger = new UserFriendshipAcceptedTrigger(new ArrayList<String>(), 0, "", "", TEST_FRIEND_ID, TEST_FRIENDNAME, TEST_FRIEND_LOOK);
    }

    @Test
    public void getFriendId() throws Exception {
        assertEquals(TEST_FRIEND_ID, this.trigger.getFriendId());
    }

    @Test
    public void getFriendname() throws Exception {
        assertEquals(TEST_FRIENDNAME, this.trigger.getFriendname());
    }

    @Test
    public void getFriendLook() throws Exception {
        assertEquals(TEST_FRIEND_LOOK, this.trigger.getFriendLook());
    }
}