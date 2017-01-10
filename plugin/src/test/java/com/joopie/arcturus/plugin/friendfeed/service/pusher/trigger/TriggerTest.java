package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger;

import com.joopie.arcturus.plugin.friendfeed.service.IService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TriggerTest {
    public static final String TEST_TRIGGER = "test-trigger";
    public static final int TEST_AMOUNT_CHANNELS = 125;
    public static final int TEST_AMOUNT_TRIGGERS = (int)Math.ceil((double)TEST_AMOUNT_CHANNELS / Trigger.MAX_CHANNELS);

    @Mock
    private IService service;

    private List<String> channels;
    private Trigger trigger;

    @Before
    public void setUp() throws Exception {
        this.channels = new ArrayList<String>();
        for (int i = 0; i < TEST_AMOUNT_CHANNELS; i++) {
            this.channels.add("test-" + i);
        }

        this.trigger = new Trigger(this.channels, TEST_TRIGGER);
    }

    @Test
    public void trigger() throws Exception {
        this.trigger.trigger(this.service);
        verify(this.service, times(TEST_AMOUNT_TRIGGERS)).trigger(anyListOf(String.class), eq(TEST_TRIGGER), eq(this.trigger));
    }
}