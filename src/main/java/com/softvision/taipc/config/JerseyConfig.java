package com.softvision.taipc.config;

import com.softvision.taipc.controller.CandidateController;
import com.softvision.taipc.controller.EventController;
import com.softvision.taipc.controller.PanelController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CandidateController.class);
        register(EventController.class);
        register(PanelController.class);
    }
}
