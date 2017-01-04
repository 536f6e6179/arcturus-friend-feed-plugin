package com.joopie.arcturus.plugin.friendfeed.service;

import java.util.List;

/**
 * Created by jospi on 3-1-2017.
 */
public interface IService {
    void trigger(ITrigger trigger);
    void trigger(List<String> channels, String trigger, Object data);

    //void addTriggerToBatch(ITrigger trigger);
    //void triggerBatch();
}
