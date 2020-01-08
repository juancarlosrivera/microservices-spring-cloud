package com.jc.microservices.limitsservice.controller;

import com.jc.microservices.limitsservice.bean.LimitConfiguration;
import com.jc.microservices.limitsservice.configuration.Configuration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsConfiguration() {

        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }

    @GetMapping("/fault-tolerance-example")
    @HystrixCommand(defaultFallback = "fallbackRetrieveConfiguration")
    public LimitConfiguration retrieveLimitsConfigurationFaultToleranceExample() {

        throw new RuntimeException("ERROR, fault tolerance hystrix, method fallbackRetrieveConfiguration should be executed");
    }

    public LimitConfiguration fallbackRetrieveConfiguration() {

        return new LimitConfiguration(9999, 999);
    }
}
