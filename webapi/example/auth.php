<?php
    define('PUSHER_ID', '');
    define('PUSHER_KEY', '');
    define('PUSHER_SECRET', '');

    require_once './lib/Pusher.php';

    if (!isset($_POST['socket_id'], $_POST['channel_name'])) {
        header('HTTP/1.0 401 Unauthorized');
        echo 'Forbidden';
        exit;
    }

    $socketId = $_POST['socket_id'];
    $channelName = $_POST['channel_name'];

    /* Check here if the user is logged in!
    Example:

    if (!is_user_logged_in()) {
        header('HTTP/1.0 401 Unauthorized');
        echo 'Forbidden';
        exit;
    }

    $userId = get_user_id();
    */

    // Example ID!
    $userId = 1;

    if ('private-user-' . $userId != $channelName) {
        header('HTTP/1.0 401 Unauthorized');
        echo 'Forbidden';
        exit;
    }

    $pusher = new Pusher(PUSHER_KEY, PUSHER_SECRET, PUSHER_ID, [
        'cluster' => 'eu',
        'encrypted' => true
    ]);

    echo $pusher->socket_auth($channelName, $socketId);