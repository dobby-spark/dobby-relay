package com.cisco.collab.dobby.relay.api.spark;

import java.util.logging.Logger;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cisco.collab.dobby.relay.api.spark.model.Spark;
import com.cisco.collab.dobby.relay.api.spark.resource.SparkCallbackResource;
import com.cisco.collab.dobby.relay.service.spark.SparkService;

@Component
@Path("spark")
public class SparkApi implements SparkCallbackResource {

    @Autowired
    SparkService sparkNotification;
    
    public static final String FakeAppId = "1";

    private static Logger LOG = Logger.getLogger(SparkApi.class.getName());

    public PostSparkResponse postSpark(Spark entity) throws Exception {
        LOG.info("got message from " + entity.getData().getPersonEmail());
        sparkNotification.queueNotification(FakeAppId, entity);
        return PostSparkResponse.withOK();
    }

}
