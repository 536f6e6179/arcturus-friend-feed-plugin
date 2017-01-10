package com.joopie.arcturus.plugin.friendfeed.service;

import com.eu.habbo.Emulator;
import com.joopie.arcturus.plugin.friendfeed.service.pusher.PusherService;

/**
 * Creates a new trigger service.
 */
public class ServiceFactory {

    public static final String CONFIG_PUSHER_ID_KEY = "plugin.friendfeed.pusher.id";
    public static final String CONFIG_PUSHER_KEY_KEY = "plugin.friendfeed.pusher.key";
    public static final String CONFIG_PUSHER_SECRET_KEY = "plugin.friendfeed.pusher.secret";
    public static final String CONFIG_PUSHER_CLUSTER_KEY = "plugin.friendfeed.pusher.cluster";
    public static final String CONFIG_PUSHER_ENCRYPTED_KEY = "plugin.friendfeed.pusher.encrypted";

    /**
     * Returns now, by default, a Pusher service.
     * @return
     */
    public static IService createService() {
        String pusherId = Emulator.getConfig().getValue(CONFIG_PUSHER_ID_KEY);
        String pusherKey = Emulator.getConfig().getValue(CONFIG_PUSHER_KEY_KEY);
        String pusherSecret = Emulator.getConfig().getValue(CONFIG_PUSHER_SECRET_KEY);
        String pusherCluster = Emulator.getConfig().getValue(CONFIG_PUSHER_CLUSTER_KEY);
        boolean pusherEncrypted = Emulator.getConfig().getBoolean(CONFIG_PUSHER_ENCRYPTED_KEY);

        return new PusherService(pusherId, pusherKey, pusherSecret, pusherCluster, pusherEncrypted);
    }
}
