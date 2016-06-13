package com.cisco.collab.dobby.relay.service.poll;

import java.util.List;

import com.cisco.collab.dobby.relay.api.poll.model.PollSpark;

public interface PollService {
    List<PollSpark> pollSparkNotifications();
}
