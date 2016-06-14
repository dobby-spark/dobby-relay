package com.cisco.collab.dobby.relay.service.spark;

import java.util.List;

import com.cisco.collab.dobby.relay.api.poll.model.PollSpark;
import com.cisco.collab.dobby.relay.api.spark.model.Spark;

public interface SparkService {
    void queueNotification(Spark notification);
    List<PollSpark> pollSparkNotifications();
}
