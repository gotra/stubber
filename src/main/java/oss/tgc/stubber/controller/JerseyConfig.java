package oss.tgc.stubber.controller;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Created by rajeevguru on 02/07/15.
 */
@Component
@ApplicationPath(value = "/donotuse")
public class JerseyConfig extends ResourceConfig {


    public JerseyConfig() {
        register(MainController.class);

    }

}
