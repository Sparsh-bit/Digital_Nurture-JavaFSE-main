# Exercise 15: Event Session Time Conflict

**Goal**: Identify overlapping sessions within the same event.

This is a classic overlapping time problem! I did a Self-Join on the `Sessions` table (`s1` and `s2`). 
The logic `s1.start_time < s2.end_time AND s1.end_time > s2.start_time` is the standard algorithm to detect if two time windows overlap. I also added `s1.session_id < s2.session_id` to prevent the query from comparing a session to itself, or returning duplicate flipped pairs.
