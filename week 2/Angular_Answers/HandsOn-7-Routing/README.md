# Hands-On 7: Angular Routing

**Goal:** Setup nested routes, lazy loading, and route guards.

## What I did:
1. Configured the main router in `app.routes.ts`.
2. Demonstrated Lazy Loading by using `loadChildren` for the `/enroll` route. This ensures the heavy enrollment logic is only downloaded from the server when the user actually navigates to that route!
3. Created an `AuthGuard` using `CanActivate` to protect the profile page.
4. Created an `UnsavedChangesGuard` using `CanDeactivate`. This intercepts the user's attempt to navigate away from a dirty form and pops up a `window.confirm()` dialog.
