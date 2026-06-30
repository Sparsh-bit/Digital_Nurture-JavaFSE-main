# Exercise 2: Load Balancing in API Gateway

This project integrates Spring Cloud LoadBalancer directly into the Spring Cloud Gateway to demonstrate client-side load balancing.

### Key Implementations:
1. **Dependencies**: Requires both `spring-cloud-starter-gateway` and `spring-cloud-starter-loadbalancer`.
2. **`application.properties`**: Uses the `lb://example-service` URI format. The `lb://` prefix tells the gateway to intercept the request and resolve `example-service` to a real IP address and port from the service registry (like Eureka) before routing.
3. **`LoadBalancerConfiguration.java`**: Replaces the default Round-Robin load balancing strategy with a `RandomLoadBalancer`.
