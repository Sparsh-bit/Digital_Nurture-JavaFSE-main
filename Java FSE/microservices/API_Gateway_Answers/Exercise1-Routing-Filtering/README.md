# Exercise 1: Edge Services for Routing and Filtering

This project implements a Spring Cloud Gateway to handle routing and global filtering in a microservices architecture.

### Key Implementations:
1. **`pom.xml`**: Includes the `spring-cloud-starter-gateway` dependency along with the Spring Cloud Dependency Management BOM.
2. **`application.properties`**: Defines a simple route that captures any request starting with `/example/**` and forwards it to `http://example.org`.
3. **`LoggingFilter.java`**: Implements `GlobalFilter` to intercept all requests hitting the gateway. It logs the incoming request URI and also demonstrates how to log the outgoing response status using reactive `Mono.fromRunnable`.

### To Run:
Run `mvn spring-boot:run` and then navigate to `http://localhost:8080/example/foo` in your browser to see the gateway proxy the request and log it in your console!
