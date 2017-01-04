package com.joopie.arcturus.plugin.friendfeed.service.pusher;

import com.joopie.arcturus.plugin.friendfeed.service.ITrigger;
import com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user.UserMottoSavedTrigger;
import com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user.UserTrigger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jospi on 4-1-2017.
 */
public class PusherServiceTest {
    public static final String CONFIG_PUSHER_ID = "";
    public static final String CONFIG_PUSHER_KEY = "";
    public static final String CONFIG_PUSHER_SECRET = "";
    public static final String CONFIG_PUSHER_CLUSTER = "eu";
    public static final boolean CONFIG_PUSHER_ENCRYPTED = true;

    public static final int TEST_AMOUNT_CHANNELS = 15;

    private PusherService service;

    @Before
    public void setUp() throws Exception {
        if (CONFIG_PUSHER_ID.equals("")
                || CONFIG_PUSHER_KEY.equals("")
                || CONFIG_PUSHER_SECRET.equals("")
                || CONFIG_PUSHER_CLUSTER.equals("")) {
            throw new Exception("Test not configured.");
        }

        this.service = new PusherService(CONFIG_PUSHER_ID, CONFIG_PUSHER_KEY, CONFIG_PUSHER_SECRET, CONFIG_PUSHER_CLUSTER, CONFIG_PUSHER_ENCRYPTED);
    }

    @Test
    public void trigger() throws Exception {
        this.service.trigger(new ArrayList<String>() {{
            add("public-test");
        }}, "test-trigger-event", "Some test trigger data here!");
    }

    @Test
    public void trigger1() throws Exception {
        List<String> channels = new ArrayList<String>();
        for (int i = 0; i < TEST_AMOUNT_CHANNELS; i++) {
            channels.add("test-" + i);
        }

        ITrigger trigger = new UserMottoSavedTrigger(channels, 0, "username", "look", "My old shitty motto", "My sexy ass new motto!");
        this.service.trigger(trigger);
    }

}