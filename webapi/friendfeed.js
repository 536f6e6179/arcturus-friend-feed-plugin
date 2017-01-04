/**
 * Created by jospi on 4-1-2017.
 */
if (!Pusher) throw 'Did you forgot to include the Pusher library?';

var FriendFeedMessages = (function() {

    var DEFAULT_PROPERTIES = {
        limit: {
            value: 10,
            writable: true
        },
        messages: {
            value: [],
            writable: true,
        }
    }

    function Class(limit) {
        Object.defineProperties(this, DEFAULT_PROPERTIES);

        this.limit = limit;
    }

    Class.prototype.add = function(message) {
        this.messages.unshift(message);
        if (this.messages.length > this.limit) {
            this.messages.pop();
        }
    };

    Class.prototype.getMessages = function() {
        return this.messages.slice(0);
    };

    return Class;
})();

var FriendFeedException = (function() {

    var DEFAULT_PROPERTIES = {
        message: {
            value: "",
            writable: true
        }
    }

    function Class(message) {
        Object.defineProperties(this, DEFAULT_PROPERTIES);

        this.message = message;
    }

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
                src: this.templateAchievementUrl + data['achievement'] + data['new-level'] + ".gif", //ACH_RegistrationDuration20.gif
                alt: data['achievement']
            },
            username: data['username'],
            text: "Has earned the '" + data['achievement'] + "' achievement!",
            date: new Date().toLocaleString('en-GB')
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
            date: new Date().toLocaleString('en-GB')
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
            date: new Date().toLocaleString('en-GB')
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
            date: new Date().toLocaleString('en-GB')
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
            date: new Date().toLocaleString('en-GB')
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
            value: null,
            writable: true
        },
        limit: {
            value: 10,
            writable: true
        },

        container: {
            value: null,
            writable: true
        },

        pusherKey: {
            value: null,
            writable: true
        },
        pusherOptions: {
            value: {},
            writable: true
        },

        templateLookUrl: {
            value: "http://habbo.com/habbo-imaging/avatarimage",
            writable: true
        },
        templateAchievementUrl: {
            value: "https://habboo-a.akamaihd.net/c_images/album1584/",
            writable: true
        },

        messages: {
            value: null,
            writable: true
        },

        pusher: {
            value: null,
            writable: true
        },

        channel: {
            value: null,
            writable: true
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
        Object.defineProperties(this, DEFAULT_PROPERTIES);

        var options = options || {};
        validateOptions(options);
        Object.assign(this, options);

        this.messages = new FriendFeedMessages(this.limit);

        this.pusher = new Pusher(this.pusherKey, this.pusherOptions);
        this.channel = this.pusher.subscribe("private-user-" + this.userId);

        this.container.classList.add("friendfeed-container");

        var scope = this;
        BINDINGS.forEach(function(binding) {
            scope.channel.bind(binding.trigger, binding.callback, scope);
        });

        this.update();
    }

    Class.prototype.update = function() {
        this.container.innerHTML = "";

        var scope = this;
        this.messages.getMessages().forEach(function(message) {
            scope.container.innerHTML += "<div class='friendfeed-message'>" +
                "   <div class='friendfeed-img'>" +
                "      <img src='" + message.img.src + "' alt='" + message.img.alt + "'>" +
                "   </div>" +
                "   <div class='friendfeed-content'>" +
                "       <p class='friendfeed-content-username'>" + message.username + "</p>" +
                "       <p class='friendfeed-content-text'>" + message.text + "</p>" +
                "       <p class='friendfeed-content-date'>" + message.date + "</p>" +
                "   </div>" +
                "   <div class='clear-both'></div>" +
                "</div>";
        });

        if (this.messages.getMessages().length < 1) {
            this.container.innerHTML = "<div class='friendfeed-message friendfeed-no-messages'>" +
                "   <div class='friendfeed-content'>" +
                "       <p class='friendfeed-content-text'>No feeds yet! Keep this page open and see the messages popping up.</p>" +
                "   </div>" +
                "</div>";
        }
    };

    return Class;
})(Pusher, FriendFeedException, FriendFeedMessages)