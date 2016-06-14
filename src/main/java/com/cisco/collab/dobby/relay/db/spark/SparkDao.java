package com.cisco.collab.dobby.relay.db.spark;

import java.util.List;

public interface SparkDao {
    void push(String notification);
    String pop();
    List<String> popAll();
}
