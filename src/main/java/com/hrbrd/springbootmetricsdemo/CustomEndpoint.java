package com.hrbrd.springbootmetricsdemo;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Endpoint(id = "custom-endpoint")
@Component
public class CustomEndpoint {
    private final Map<String, String> metrics;


    public CustomEndpoint() {
        metrics = new ConcurrentHashMap<>();
        metrics.put("id", "custom-endpoint");
        metrics.put("status", "initialized");
    }

    @ReadOperation
    public Map<String, String> getMetrics() {
        return metrics;
    }

    @ReadOperation
    public String getMetric(@Selector String name) {
        return metrics.get(name);
    }

    @WriteOperation
    public void setMetric(@Selector String name, String value) {
        metrics.put(name, value);
    }

}