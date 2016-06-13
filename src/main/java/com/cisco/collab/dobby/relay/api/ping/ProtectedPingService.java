package com.cisco.collab.dobby.relay.api.ping;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import com.cisco.collab.dobby.relay.api.ping.model.Pong;
import com.cisco.collab.dobby.relay.api.ping.resource.ProtectedPingResource;

@Component
@Path("ping")
public class ProtectedPingService implements ProtectedPingResource {

    public GetPingResponse getPing(String authorization) throws Exception {
        Pong pong = new Pong();
        pong.setMessage("Hello World");
        return GetPingResponse.withJsonOK(pong);
    }

}
