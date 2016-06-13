package com.cisco.collab.dobby.relay.service.spark;

import com.cisco.collab.dobby.relay.api.spark.model.Spark;

public interface SparkService {
    void queueNotification(Spark notification);
}
