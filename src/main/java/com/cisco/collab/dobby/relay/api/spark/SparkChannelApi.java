package com.cisco.collab.dobby.relay.api.spark;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cisco.collab.dobby.relay.api.spark.model.Spark;
import com.cisco.collab.dobby.relay.api.spark.resource.SparkChannelResource;
import com.cisco.collab.dobby.relay.service.spark.SparkService;

@Component
@Path("spark/{channelId}")
public class SparkChannelApi implements SparkChannelResource {    
    private static Logger LOG = Logger.getLogger(SparkChannelApi.class.getName());

    @Autowired
    SparkService spark;

    @Context
    HttpServletRequest request;

    public PostSparkByChannelIdResponse postSparkByChannelId(String channelId,
            Spark entity) throws Exception {
        LOG.info("Spark notification on channel: " + channelId + " from " + request.getRemoteHost());
        spark.queueNotification(channelId, entity);
        return PostSparkByChannelIdResponse.withOK();
    }

}
