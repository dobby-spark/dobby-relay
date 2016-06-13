package com.cisco.collab.dobby.relay.api.ping;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import com.cisco.collab.dobby.relay.api.ping.model.Pong;
import com.cisco.collab.dobby.relay.api.ping.resource.PublicPingResource;

@Component
@Path("public/ping")
public class PublicPingService implements PublicPingResource {

    private static final Pong pong;

    static {
        pong = new Pong();
        pong.setMessage("Hello World!");
    }

    public GetPublicPingResponse getPublicPing() throws Exception {
        return GetPublicPingResponse.withJsonOK(pong);
    }
}
