# Exercise 7: Low Feedback Alerts

**Goal**: List all users who gave feedback with a rating less than 3, along with their comments and associated event names.

This just required joining three tables (`Feedback`, `Users`, and `Events`) so we could pull the human-readable names instead of just IDs, and adding a simple `WHERE rating < 3` filter.
