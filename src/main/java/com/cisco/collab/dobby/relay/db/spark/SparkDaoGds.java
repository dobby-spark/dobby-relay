package com.cisco.collab.dobby.relay.db.spark;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;

@Service
public class SparkDaoGds implements SparkDao {
    private static Logger LOG = Logger.getLogger(SparkDaoGds.class.getName());
    
    public SparkDaoGds() {
        LOG.info("Registering Spark DAO Entity classes ...");
        ObjectifyService.register(SparkNotificationUtil.SparkNotificationPk.class);
        ObjectifyService.register(SparkNotificationUtil.SparkNotification.class);
        LOG.info("... registration complete");
    }

    public void push(String appId, String notification) {
        LOG.info("saving notification in DB");
        ofy().save().entity(SparkNotificationUtil.toEntityFrom(appId, notification)).now();
    }

    public String pop(String appId) {
        LOG.info("pop notification not implemented");
        return null;
    }

    public List<String> popAll(String appId) {
        LOG.info("reading all notifications from DB");
        List<Object> entities = ofy().load().ancestor(SparkNotificationUtil.toPkFrom(appId)).list();
        LOG.info("deleting notifications from DB");
        ofy().delete().entities(SparkNotificationUtil.toEntitiesFrom(entities)).now();
        LOG.info("returning back popped list of notifications");
        return SparkNotificationUtil.fromEntities(entities);
    }

}
