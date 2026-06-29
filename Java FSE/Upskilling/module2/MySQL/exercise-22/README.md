# Exercise 22: Duplicate Registrations Check

**Goal**: Detect if a user has been registered more than once for the same event.

By grouping by BOTH `user_id` and `event_id`, I'm looking for unique combinations. If any combination has a count greater than 1, it means that specific user registered for that specific event twice!
