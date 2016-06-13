package com.cisco.collab.dobby.relay.service.poll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.collab.dobby.relay.api.poll.model.PollSpark;
import com.cisco.collab.dobby.relay.service.spark.SparkService;

@Service
public class PollServiceImpl implements PollService {

    @Autowired
    SparkService sparkNotification;
    
    public List<PollSpark> pollSparkNotifications() {
        // TODO Auto-generated method stub
        return null;
    }

}
