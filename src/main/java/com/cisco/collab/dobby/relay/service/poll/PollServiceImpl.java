package com.cisco.collab.dobby.relay.service.poll;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.collab.dobby.relay.api.poll.model.PollSpark;
import com.cisco.collab.dobby.relay.service.spark.SparkService;

@Service
public class PollServiceImpl implements PollService {
    private static Logger LOG = Logger.getLogger(PollServiceImpl.class.getName());

    @Autowired
    SparkService spark;
    
    public List<PollSpark> pollSparkNotifications(String appId) {
        LOG.info("polling spark service for any notifications");
        return spark.pollSparkNotifications(appId);
    }

}
