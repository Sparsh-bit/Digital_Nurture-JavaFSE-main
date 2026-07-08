# Exercise 10: Feedback Gap

**Goal**: Identify events that had registrations but received no feedback at all.

I used an `INNER JOIN` on Registrations to guarantee we only look at events that actually had people sign up. Then I used a `LEFT JOIN` to Feedback and filtered for `WHERE f.feedback_id IS NULL` to isolate the events that have absolutely zero reviews.
