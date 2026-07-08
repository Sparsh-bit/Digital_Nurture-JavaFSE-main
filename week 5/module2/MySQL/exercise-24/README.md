# Exercise 24: Average Session Duration per Event

**Goal**: Compute the average duration (in minutes) of sessions in each event.

The `TIMESTAMPDIFF(MINUTE, start, end)` function is perfect here. It calculates the raw minutes for each session, and then I just pass that result straight into the `AVG()` aggregate function.
