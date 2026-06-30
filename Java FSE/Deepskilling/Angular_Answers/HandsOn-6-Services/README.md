# Hands-On 6: Services & Dependency Injection

**Goal:** Understand Singleton services vs Component-level providers and service-to-service injection.

## What I did:
1. Created `CourseService` and provided it in `'root'` so `CourseListComponent` and `HomeComponent` share the exact same instance (they both read the same array).
2. Created an `EnrollmentService` that injects `CourseService`. This proves services can depend on other services!
3. Created a `NotificationComponent` that explicitly defines `providers: [NotificationService]` in its `@Component` decorator. As explained in the comments, this forces Angular's Dependency Injection system to spawn a completely isolated instance of the service just for that component tree, overriding the root singleton.
