# Exercise 1: OAuth2/OIDC Centralized Authentication

This project demonstrates how to set up an OAuth2 Client using Spring Boot 3. 

### Key Implementations:
1. **`pom.xml`**: Includes `spring-boot-starter-oauth2-client` and `spring-boot-starter-security`.
2. **`application.yml`**: Configures the OAuth2 provider details (like Google) including client ID, secret, and scopes.
3. **`SecurityConfig.java`**: Configured using the modern Spring Boot 3 `SecurityFilterChain` approach instead of the deprecated `WebSecurityConfigurerAdapter`.
4. **`UserController.java`**: A simple REST controller that exposes the authenticated `Principal` (user details) once login succeeds.

### To Run:
Make sure to replace `YOUR_CLIENT_ID` and `YOUR_CLIENT_SECRET` in the `application.yml` with real credentials from Google Cloud Console (or any other provider) before running `mvn spring-boot:run`.
