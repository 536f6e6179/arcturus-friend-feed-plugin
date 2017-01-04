package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger;

import com.google.gson.annotations.Expose;
import com.joopie.arcturus.plugin.friendfeed.service.IService;
import com.joopie.arcturus.plugin.friendfeed.service.ITrigger;

import java.util.List;

/**
 * Created by jospi on 4-1-2017.
 */
public class Trigger implements ITrigger{
    public static final int MAX_CHANNELS = 10;

    @Expose(serialize = false, deserialize = false)
    private List<String> channels;
    @Expose(serialize = false, deserialize = false)
    private String trigger;

    public Trigger(List<String> channels, String trigger) {
        this.channels = channels;
        this.trigger = trigger;
    }

    public void trigger(IService service) {
        int channelFromIndex = 0;
        int channelToIndex = 0;

        while (channelToIndex < this.channels.size()) {
            channelFromIndex = channelToIndex;
            channelToIndex = Math.min(channelFromIndex + MAX_CHANNELS, this.channels.size());

            List<String> subChannels = this.channels.subList(channelFromIndex, channelToIndex);

            service.trigger(subChannels, this.trigger, this);
        }
    }

    public List<String> getChannels() {
        return this.channels;
    }

    public String getTrigger() {
        return this.trigger;
    }
}
