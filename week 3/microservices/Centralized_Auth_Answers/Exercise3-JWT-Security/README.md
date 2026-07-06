# Exercise 3: Custom JWT Security Implementation

This project demonstrates how to manually handle JSON Web Tokens for authentication without relying entirely on the built-in OAuth2 resource server starter.

### Key Implementations:
1. **JJWT Dependency**: We use the modern `jjwt-api`, `jjwt-impl`, and `jjwt-jackson` libraries (v0.11.5) to parse and generate keys.
2. **`JwtTokenProvider`**: Handles creating tokens using HMAC-SHA256 and validating incoming token signatures.
3. **`JwtTokenFilter`**: Intercepts every HTTP request, checks for the `Authorization: Bearer` header, extracts the token, validates it, and injects the `Authentication` context into the `SecurityContextHolder`.
4. **`SecurityConfig`**: Places our custom `JwtTokenFilter` in front of the standard `UsernamePasswordAuthenticationFilter`.
5. **Controllers**: We have a public `/api/auth/login` endpoint that issues a token, and a secured `/api/profile` endpoint that requires one.
