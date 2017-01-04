package com.joopie.arcturus.plugin.friendfeed.service.pusher;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.joopie.arcturus.plugin.friendfeed.service.IService;
import com.joopie.arcturus.plugin.friendfeed.service.ITrigger;
import com.pusher.rest.Pusher;

import java.util.List;

/**
 * Created by jospi on 4-1-2017.
 */
public class PusherService implements IService {

    private Pusher pusher;

    public PusherService(String appId, String appKey, String appSecret, String appCluster, boolean appEncrypted) {
        this.pusher = new Pusher(appId, appKey, appSecret);
        this.pusher.setCluster(appCluster);
        this.pusher.setEncrypted(appEncrypted);

        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES);
        this.pusher.setGsonSerialiser(builder.create());
    }

    public void trigger(ITrigger trigger) {
        trigger.trigger(this);
    }

    public void trigger(List<String> channels, String trigger, Object data) {
        this.pusher.trigger(channels, trigger, data);
    }
}
