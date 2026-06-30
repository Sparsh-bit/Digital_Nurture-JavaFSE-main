# Hands-On 9: NgRx State Management

**Goal:** Implement Redux-pattern state management for Angular.

## What I did:
1. Created actions inside `course.actions.ts`. Notice the `[Course]` prefix? This convention makes it super easy to filter actions in the Redux DevTools timeline!
2. Built a pure `course.reducer.ts` that handles transitions between Loading, Success, and Failure states immutably.
3. Created memoized selectors in `course.selectors.ts` so the components only re-render when the specific slice of state changes.
4. Extracted the side-effects (HTTP calls) out of the components and into `course.effects.ts`. Effects listen for actions, hit the API, and dispatch new success/failure actions back to the reducer!
