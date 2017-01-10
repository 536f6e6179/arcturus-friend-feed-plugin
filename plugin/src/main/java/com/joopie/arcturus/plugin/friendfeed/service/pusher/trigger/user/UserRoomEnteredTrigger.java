package com.joopie.arcturus.plugin.friendfeed.service.pusher.trigger.user;

import com.google.gson.annotations.Expose;
import com.joopie.arcturus.plugin.friendfeed.service.ITrigger;

import java.util.List;

/**
 * A trigger class containing data.
 */
public class UserRoomEnteredTrigger extends UserTrigger implements ITrigger {
    public static final String TRIGGER = "user-room-entered";

    @Expose
    public final int roomId;
    @Expose
    public final String roomName;

    /**
     *
     * @param channels
     * @param userId
     * @param username
     * @param userLook
     * @param roomId
     * @param roomName
     */
    public UserRoomEnteredTrigger(List<String> channels, int userId, String username, String userLook, int roomId, String roomName) {
        super(channels, TRIGGER, userId, username, userLook);

        this.roomId = roomId;
        this.roomName = roomName;
    }
}