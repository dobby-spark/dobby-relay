package com.cisco.collab.dobby.relay.db.spark;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class SparkDaoGds implements SparkDao {
    private static Logger LOG = Logger.getLogger(SparkDaoGds.class.getName());

    public void push(String notification) {
        LOG.info("push notification not implemented");
    }

    public String pop() {
        LOG.info("pop notification not implemented");
        return null;
    }

    public List<String> popAll() {
        LOG.info("pop all notifications not implemented");
        return SparkNotificationUtil.fromEntities(null);
    }

}
