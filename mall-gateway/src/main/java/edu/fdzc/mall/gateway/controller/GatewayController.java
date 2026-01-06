package edu.fdzc.mall.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GatewayController {

    @GetMapping("/")
    public Mono<String> home() {
        return Mono.just("Mall Gateway is running!");
    }

    @GetMapping("/health")
    public Mono<String> health() {
        return Mono.just("{\"status\":\"UP\"}");
    }
}