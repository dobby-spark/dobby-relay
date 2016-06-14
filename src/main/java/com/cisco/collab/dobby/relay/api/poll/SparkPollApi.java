package com.cisco.collab.dobby.relay.api.poll;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cisco.collab.dobby.relay.api.poll.model.PollSpark;
import com.cisco.collab.dobby.relay.api.poll.resource.SparkPollResource;
import com.cisco.collab.dobby.relay.api.spark.SparkApi;
import com.cisco.collab.dobby.relay.service.poll.PollService;

@Component
@Path("poll/spark")
public class SparkPollApi implements SparkPollResource {
    
    @Autowired
    PollService pollService;

    public GetPollSparkResponse getPollSpark() throws Exception {
        List<PollSpark> msgs = pollService.pollSparkNotifications(SparkApi.FakeAppId);
        if (msgs == null || msgs.isEmpty()) {
            return GetPollSparkResponse.withNotFound();            
        } else {
            return GetPollSparkResponse.withJsonOK(msgs);
        }
    }

}
