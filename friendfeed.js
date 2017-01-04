/**
 * Created by jospi on 4-1-2017.
 */
if (!Pusher) throw 'Did you forgot to include the Pusher library?';

var FriendFeedMessages = (function() {

    function Object(limit) {
        this.limit = limit;
        this.messages = [];
    }

    Object.prototype.add = function(message) {
        this.messages.unshift(message);
        if (this.messages.length > this.limit) {
            this.messages.pop();
        }
    }

    Object.prototype.getMessages = function() {
        return this.messages.slice(0);
    }

    return Object;
})();

var FriendFeedException = (function() {

    function Object(message) {
        this.message = message;
    }

    Object.prototype.toString = function() {
        return "FriendFeedException: " + this.message;
    }

    return Object;
})();

var FriendFeed = (function(Pusher, FriendFeedException, FriendFeedMessages) {

    var TRIGGER_USER_ACHIEVEMENT_LEVELED = "user-achievement-leveled";
    var TRIGGER_USER_FRIENDSHIP_ACCEPTED = "user-friendship-accepted";
    var TRIGGER_USER_LOGGED_IN = "user-logged-in";
    var TRIGGER_USER_MOTTO_SAVED = "user-motto-saved";
    var TRIGGER_USER_ROOM_ENTERED = "user-room-entered";

    function onUserAchievementLeveled(data) {
        this.messages.add(data);
    }

    function onUserFriendshipAccepted(data) {
        this.messages.add(data);
    }

    function onUserLoggedIn(data) {
        this.messages.add(data);
    }

    function onUserMottoSaved(data) {
        this.messages.add(data);
    }

    function onUserRoomEntered(data) {
        this.messages.add(data);
    }

    var bindings = [
        {
            trigger: TRIGGER_USER_ACHIEVEMENT_LEVELED,
            callback: onUserAchievementLeveled
        },
        {
            trigger: TRIGGER_USER_FRIENDSHIP_ACCEPTED,
            callback: onUserFriendshipAccepted
        },
        {
            trigger: TRIGGER_USER_LOGGED_IN,
            callback: onUserLoggedIn
        },
        {
            trigger: TRIGGER_USER_MOTTO_SAVED,
            callback: onUserMottoSaved
        },
        {
            trigger: TRIGGER_USER_ROOM_ENTERED,
            callback: onUserRoomEntered
        }
    ];

    function validateOptions(options) {
        if (!options.userId
            || !options.container
            || !options.pusher
            || !options.pusher && (!options.pusher.key)) {
            throw new FriendFeedException("Invalid properties");
        }

        if (!options.limit) {
            options.limit = 10;
        }

        if (!options.pusher.options) {
            options.pusher.options = {};
        }
    }

    function Object(options) {
        validateOptions(options);

        this.messages = new FriendFeedMessages(options.limit);

        this.pusher = new Pusher(options.pusher.key, options.pusher.options);
        this.channel = this.pusher.subscribe("private-user-" + options.userId);

        this.container = options.container;

        var scope = this;
        bindings.forEach(function(binding) {
            scope.channel.bind(binding.trigger, binding.callback, scope);
        });
    }

    return Object;
})(Pusher, FriendFeedException, FriendFeedMessages)