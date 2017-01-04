package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by jospi on 4-1-2017.
 */
public class UserRoomEnteredTriggerTest {
    public static final int TEST_ROOM_ID = 2;
    public static final String TEST_ROOM_NAME = "test-room-name";

    private UserRoomEnteredTrigger trigger;

    @Before
    public void setUp() throws Exception {
        this.trigger = new UserRoomEnteredTrigger(new ArrayList<String>(), 0, "", "", TEST_ROOM_ID, TEST_ROOM_NAME);
    }

    @Test
    public void getRoomId() throws Exception {
        assertEquals(TEST_ROOM_ID, this.trigger.getRoomId());
    }

    @Test
    public void getRoomName() throws Exception {
        assertEquals(TEST_ROOM_NAME, this.trigger.getRoomName());
    }

}