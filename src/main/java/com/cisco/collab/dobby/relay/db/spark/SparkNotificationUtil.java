package com.cisco.collab.dobby.relay.db.spark;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;

public class SparkNotificationUtil {

    @Entity
    public static class SparkNotificationPk {
        @Id
        String appId;
    }

    @Entity
    public static class SparkNotification {
        @Parent
        Key<SparkNotificationPk> pk;

        @Id
        Long timestamp;

        String notification;
    }

    public static Key<SparkNotificationPk> toPkFrom(String appId) {
        SparkNotificationPk pk = new SparkNotificationPk();
        pk.appId = appId;
        return Key.create(pk);
    }

    public static SparkNotification toEntityFrom(String appId,
            String notification) {
        SparkNotification entity = new SparkNotification();
        entity.notification = notification;
        entity.timestamp = new Date().getTime();
        entity.pk = toPkFrom(appId);
        return entity;
    }

    public static String fromEntity(SparkNotification entity) {
        return entity.notification;
    }

    public static List<String> fromEntities(List<SparkNotification> entities) {
        List<String> list = new ArrayList<String>();
        if (entities == null) return list;
        for (SparkNotification entity : entities) {
            String spark = fromEntity(entity);
            if (spark != null) {
                list.add(spark);
            }
        }
        return list;
    }
}
