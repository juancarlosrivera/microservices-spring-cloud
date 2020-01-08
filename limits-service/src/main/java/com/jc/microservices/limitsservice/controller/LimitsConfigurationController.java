package com.jc.microservices.limitsservice.controller;

import com.jc.microservices.limitsservice.bean.LimitConfiguration;
import com.jc.microservices.limitsservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsConfiguration() {

        return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
    }
}
