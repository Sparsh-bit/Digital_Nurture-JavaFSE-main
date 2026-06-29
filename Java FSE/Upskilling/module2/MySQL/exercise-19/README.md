# Exercise 19: Completed Events with Feedback Summary

**Goal**: For completed events, show total registrations and average feedback rating.

I had to use `COUNT(DISTINCT ...)` here because joining both Registrations and Feedback to Events simultaneously creates a Cartesian product (multiplies the rows). Distinct ensures we count the true number of registrations.
