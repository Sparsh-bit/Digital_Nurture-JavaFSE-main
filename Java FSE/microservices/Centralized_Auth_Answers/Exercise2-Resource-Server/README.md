# Exercise 2: Resource Server

This project sets up a Spring Boot application acting as an OAuth2 Resource Server.

### Key Implementations:
1. **Dependencies**: Requires `spring-boot-starter-oauth2-resource-server`.
2. **`application.yml`**: Defines the `issuer-uri`. This tells the resource server where to fetch the public keys required to validate the incoming JWT signatures.
3. **`ResourceServerConfig.java`**: Uses `HttpSecurity` to configure `oauth2ResourceServer().jwt()`, rejecting any requests missing a valid Bearer token.
4. **`SecureController.java`**: A protected endpoint `/secure`.

Requests made to `/secure` must include an `Authorization: Bearer <token>` header, where the token was issued by the defined `issuer-uri`.
