package com.hrbrd.springbootmetricsdemo;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final MeterRegistry meterRegistry;

    public HomeController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/hello")
    public String hello() {
        meterRegistry.counter("hello").increment();
        return "Hello World!";
    }

}