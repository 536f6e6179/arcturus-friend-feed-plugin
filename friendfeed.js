/**
 * Created by jospi on 4-1-2017.
 */
if (!Pusher) throw 'Did you forgot to include the Pusher library?';

var FriendFeedMessages = (function() {

    var DEFAULT_PROPERTIES = {
        limit: {
            value: 10
        },
        messages: {
            value: []
        }
    }

    function Class(limit) {
        this.limit = limit;
    }

    Object.defineProperties(Class, DEFAULT_PROPERTIES);

    Class.prototype.add = function(message) {
        this.messages.unshift(message);
        if (this.messages.length > this.limit) {
            this.messages.pop();
        }
    }

    Class.prototype.getMessages = function() {
        return this.messages.slice(0);
    };

    return Class;
})();

var FriendFeedException = (function() {

    var DEFAULT_PROPERTIES = {
        message: {
            value: ""
        }
    }

    function Class(message) {
        this.message = message;
    }

    Object.defineProperties(Class, DEFAULT_PROPERTIES);

    Class.prototype.toString = function() {
        return "FriendFeedException: " + this.message;
    };

    return Class;
})();

var FriendFeed = (function(Pusher, FriendFeedException, FriendFeedMessages) {

    var TRIGGER_USER_ACHIEVEMENT_LEVELED = "user-achievement-leveled";
    var TRIGGER_USER_FRIENDSHIP_ACCEPTED = "user-friendship-accepted";
    var TRIGGER_USER_LOGGED_IN = "user-logged-in";
    var TRIGGER_USER_MOTTO_SAVED = "user-motto-saved";
    var TRIGGER_USER_ROOM_ENTERED = "user-room-entered";

    function onUserAchievementLeveled(data) {
        this.messages.add({
            img: {
                src: this.templateAchievementUrl + data['achievement'] + "_" + data['new-level'] + ".png",
                alt: data['achievement']
            },
            username: data['username'],
            text: "Has earned the '" + data['achievement'] + "' achievement!",
            date: Date.now()
        });

        this.update();
    }

    function onUserFriendshipAccepted(data) {
        this.messages.add({
            img: {
                src: this.templateLookUrl + "?figure=" + data['user-look'] + "&direction=3&headonly=1",
                alt: data['username']
            },
            username: data['username'],
            text: "Is now friends with " + data['friendname'] + "!",
            date: Date.now()
        });

        this.update();
    }

    function onUserLoggedIn(data) {
        this.messages.add({
            img: {
                src: this.templateLookUrl + "?figure=" + data['user-look'] + "&direction=3&headonly=1",
                alt: data['username']
            },
            username: data['username'],
            text: "Just entered the hotel!",
            date: Date.now()
        });

        this.update();
    }

    function onUserMottoSaved(data) {
        this.messages.add({
            img: {
                src: this.templateLookUrl + "?figure=" + data['user-look'] + "&direction=3&headonly=1",
                alt: data['username']
            },
            username: data['username'],
            text: "Changed motto to '" + data['new-motto'] + "'!",
            date: Date.now()
        });

        this.update();
    }

    function onUserRoomEntered(data) {
        this.messages.add({
            img: {
                src: this.templateLookUrl + "?figure=" + data['user-look'] + "&direction=3&headonly=1",
                alt: data['username']
            },
            username: data['username'],
            text: "Just entered the room '" + data['room-name'] + "'!",
            date: Date.now()
        });

        this.update();
    }

    var BINDINGS = [
        {
            trigger: TRIGGER_USER_ACHIEVEMENT_LEVELED,
            callback: onUserAchievementLeveled,
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

    var DEFAULT_PROPERTIES = {
        userId: {
            value: null
        },
        limit: {
            value: 10
        },

        container: {
            value: null
        },

        pusherKey: {
            value: null
        },
        pusherOptions: {
            value: {}
        },

        templateLookUrl: {
            value: "http://habbo.com/habbo-imaging/avatarimage"
        },
        templateAchievementUrl: {
            value: ""
        },

        messages: {
            value: null
        },

        pusher: {
            value: null
        },

        channel: {
            value: null
        }
    };

    function validateOptions(options) {
        if (!options.userId
            || !options.container
            || !options.pusherKey) {
            throw new FriendFeedException("Invalid properties");
        }
    }

    function Class(options) {
        var options = options | {};
        validateOptions(options);
        Object.assign(this, options);

        this.messages = new FriendFeedMessages(this.limit);

        this.pusher = new Pusher(this.pusherKey, this.pusherOptions);
        this.channel = this.pusher.subscribe("private-user-" + this.userId);

        this.container.classList.add("friendfeed-container");

        var scope = this;
        bindings.forEach(function(binding) {
            scope.channel.bind(binding.trigger, binding.callback, scope);
        });
    }

    Class.prototype.update = function() {
        this.container.innerHTML = "";

        var scope = this;
        this.messages.getMessages().forEach(function(message) {
            scope.container.innerHTML += "<div class='friendfeed-message'>" +
                "   <img class='friendfeed-message-img' src='" + message.img.src + "' alt='" + message.img.alt + "'>" +
                "   <div class='friendfeed-content'>" +
                "       <p class='friendfeed-content-username'>" + message.username + "</p>" +
                "       <p class='friendfeed-content-text'>" + message.text + "</p>" +
                "       <p class='friendfeed-content-date'>" + message.date + "</p>" +
                "   </div>" +
                "</div>";
        });
    };

    return Class;
})(Pusher, FriendFeedException, FriendFeedMessages)