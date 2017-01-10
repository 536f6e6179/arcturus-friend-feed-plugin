package com.joopie.arcturus.plugin.friendfeed.service;

import java.util.List;

/**
 * Interface for service.
 */
public interface IService {
    /**
     * Trigger an ITrigger interface to send itself.
     * @param trigger
     */
    void trigger(ITrigger trigger);

    /**
     * Sends a request on it's own.
     * @param channels
     * @param trigger
     * @param data
     */
    void trigger(List<String> channels, String trigger, Object data);

    //void addTriggerToBatch(ITrigger trigger);
    //void triggerBatch();
}
