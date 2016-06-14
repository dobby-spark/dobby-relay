package com.cisco.collab.dobby.relay.service.spark;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.collab.dobby.relay.api.poll.model.PollSpark;
import com.cisco.collab.dobby.relay.api.spark.model.Spark;
import com.cisco.collab.dobby.relay.db.spark.SparkDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SparkServiceImpl implements SparkService {
    
    private static Logger LOG = Logger.getLogger(SparkServiceImpl.class.getName());

    @Autowired
    SparkDao dao;

    static ObjectMapper mapper = new ObjectMapper();

    public void queueNotification(Spark notification) {
        LOG.info("pushing notification with Spark DAO");
        try {
            String spark = mapper.writeValueAsString(notification);
            dao.push(spark);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            LOG.warning("Failed to push a spark notification");
        }
    }

    public List<PollSpark> pollSparkNotifications() {
        LOG.info("popping all notifications from Spark DAO");
        List<PollSpark> list = new ArrayList<PollSpark>();
        for (String spark : dao.popAll()) {
            try {
                PollSpark poll = mapper.readValue(spark, PollSpark.class);
                list.add(poll);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                LOG.warning("Failed to poll a spark notification");
            }
        }
        return list;
    }
}
