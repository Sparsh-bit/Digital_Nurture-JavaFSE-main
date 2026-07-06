# Hands-On 8: HTTP Client & Interceptors

**Goal:** Use HttpClient, RxJS Operators, and Interceptors.

## What I did:
1. Refactored `CourseService` to use `HttpClient.get()` instead of a hardcoded array. It now returns `Observable<Course[]>`.
2. Leveraged RxJS! I used `tap` for safe side-effects (logging), `map` to filter out 0-credit courses before the UI sees them, and `catchError` to gracefully handle JSON server downtime.
3. Created an `AuthInterceptor` that intercepts every single outgoing HTTP request and injects a Bearer token into the headers.
4. Created a `LoadingInterceptor` that automatically toggles a loading spinner using the `finalize` operator so we never forget to turn it off on error!
