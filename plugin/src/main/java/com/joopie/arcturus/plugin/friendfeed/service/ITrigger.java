package com.joopie.arcturus.plugin.friendfeed.service;

/**
 * Interface for trigger.
 */
public interface ITrigger {
    /**
     * Sends out the trigger to the service.
     * @param service
     */
    void trigger(IService service);
}
