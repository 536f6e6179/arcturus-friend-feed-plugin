package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import com.google.gson.annotations.Expose;
import com.joopie.arcturus.plugin.friendfeed.service.ITrigger;

import java.util.List;

/**
 * Created by jospi on 3-1-2017.
 */
public class UserRoomEnteredTrigger extends UserTrigger implements ITrigger {
    public static final String TRIGGER = "user-room-entered";

    @Expose
    private int roomId;
    @Expose
    private String roomName;

    public UserRoomEnteredTrigger(List<String> channels, int userId, String username, int roomId, String roomName) {
        super(channels, TRIGGER, userId, username);

        this.roomId = roomId;
        this.roomName = roomName;
    }

    public int getRoomId() {
        return this.roomId;
    }

    public String getRoomName() {
        return this.roomName;
    }
}