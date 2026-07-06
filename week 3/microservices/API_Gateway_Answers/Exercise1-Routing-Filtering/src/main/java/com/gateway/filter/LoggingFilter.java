package com.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("Global Logging Filter - Incoming Request: " + exchange.getRequest().getURI());
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            System.out.println("Global Logging Filter - Outgoing Response Status: " + exchange.getResponse().getStatusCode());
        }));
    }
}
