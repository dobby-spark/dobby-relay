package com.cisco.collab.dobby.relay.service.spark;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.cisco.collab.dobby.relay.api.spark.model.Spark;

@Service
public class SparkServiceImpl implements SparkService {
    private static Logger LOG = Logger.getLogger(SparkServiceImpl.class.getName());

    public void queueNotification(Spark notification) {
        LOG.info("notification queue not implemented yet");
    }

}
