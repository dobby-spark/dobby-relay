package com.cisco.collab.dobby.relay.service.spark;

public interface SparkService {
    // need to update below method to add argument from Notification API
    // it should pass the recieved notification object as argument
    void queueNotification(/* add argument here */);
}
