# Exercise 12: Event with Maximum Sessions

**Goal**: List the event(s) with the highest number of sessions.

I could have used `ORDER BY ... LIMIT 1`, but that's technically flawed because if there's a tie for first place, it'll only show one of them! 

Instead, I used a Common Table Expression (`WITH`) to pre-calculate the counts, and then filtered where the total equals the absolute `MAX()`. This guarantees all top events are shown if there's a tie.
