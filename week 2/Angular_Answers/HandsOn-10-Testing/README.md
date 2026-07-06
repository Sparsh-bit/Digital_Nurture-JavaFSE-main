# Hands-On 10: Unit Testing Angular Applications

**Goal:** Test Components and Services using Jasmine and TestBed.

## What I did:
1. Created `course-card.component.spec.ts` to test DOM rendering and @Output events. Notice how `fixture.detectChanges()` must be called to sync the class logic with the HTML template before querying!
2. I used `By.css()` to find elements instead of raw DOM selectors to keep the tests scoped nicely to the component tree.
3. Tested `CourseService` using the `HttpClientTestingModule`. This prevents real HTTP requests from firing and allows us to use `httpMock.expectOne()` to assert the correct URL was called, then mock the response using `.flush()`.
4. The `httpMock.verify()` in the `afterEach` block acts as a safety net to catch rogue, unintended API calls!
