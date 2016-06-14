package com.cisco.collab.dobby.relay.db.spark;

import java.util.List;

public interface SparkDao {
    void push(String appId, String notification);
    String pop(String appId);
    List<String> popAll(String appId);
}
