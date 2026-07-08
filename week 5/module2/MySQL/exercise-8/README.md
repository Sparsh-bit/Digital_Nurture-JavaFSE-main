# Exercise 8: Sessions per Upcoming Event

**Goal**: Display all upcoming events with the count of sessions scheduled for them.

I used a `LEFT JOIN` here just in case there's an upcoming event that hasn't had any sessions scheduled yet (it will show a count of 0 instead of completely disappearing from the results like an `INNER JOIN` would do).
