package com.example.demo.util;

import com.example.demo.controller.EmployeeController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig()
    {
    }
    @PostConstruct
    public void setUp() {

        register(CorsFilter.class);
        register(EmployeeController.class);
    }
}
