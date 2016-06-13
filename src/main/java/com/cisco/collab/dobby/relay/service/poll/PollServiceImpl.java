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
    SparkService sparkNotification;
    
    public List<PollSpark> pollSparkNotifications() {
        LOG.info("polling not implemented yet, returning null list");
        return null;
    }

}
