# Exercise 3: Resilience Patterns in API Gateway

This project demonstrates how to protect downstream microservices using Resilience4j Circuit Breakers inside Spring Cloud Gateway.

### Key Implementations:
1. **Dependencies**: Uses `spring-cloud-starter-circuitbreaker-reactor-resilience4j` which integrates seamlessly with the reactive nature of the Gateway.
2. **`application.properties`**: Associates the `CircuitBreaker` filter with our route and defines the Resilience4J properties (a failure rate threshold of 50% over a sliding window of 10 requests).
3. **`ResilienceConfiguration.java`**: Provides a `Customizer` bean that configures the default behavior of the circuit breakers, including a 3-second timeout (`TimeLimiterConfig`). This prevents the gateway from hanging indefinitely if a downstream service goes unresponsive!
