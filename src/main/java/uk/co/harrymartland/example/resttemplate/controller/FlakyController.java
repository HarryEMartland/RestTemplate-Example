package uk.co.harrymartland.example.resttemplate.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlakyController {

    @GetMapping("/flaky/{percent}")
    @CircuitBreaker(name = "flaky")
    public Boolean attemptToGet(@PathVariable Double percent) {

        if (Math.random() > percent) {
            throw new RuntimeException("Flaky Exception");
        }

        return true;
    }

}
