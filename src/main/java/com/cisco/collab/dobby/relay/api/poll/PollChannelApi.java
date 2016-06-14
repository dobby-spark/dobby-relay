package com.cisco.collab.dobby.relay.api.poll;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cisco.collab.dobby.relay.api.poll.model.PollSpark;
import com.cisco.collab.dobby.relay.api.poll.resource.PollChannelResource;
import com.cisco.collab.dobby.relay.service.poll.PollService;

@Component
@Path("poll/{channelId}")
public class PollChannelApi implements PollChannelResource {
    private static Logger LOG = Logger.getLogger(PollChannelApi.class.getName());

    @Context
    HttpServletRequest request;
    
    @Autowired
    PollService pollService;
    public GetPollByChannelIdResponse getPollByChannelId(String channelId)
            throws Exception {
        LOG.info("Polling request on channel: " + channelId + " from " + request.getRemoteHost());
        List<PollSpark> msgs = pollService.pollSparkNotifications(channelId);
        if (msgs == null || msgs.isEmpty()) {
            return GetPollByChannelIdResponse.withNotFound();            
        } else {
            return GetPollByChannelIdResponse.withJsonOK(msgs);
        }
    }

}
