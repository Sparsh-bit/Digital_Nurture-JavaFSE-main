# Exercise 5: Most Active Cities

**Goal**: List the top 5 cities with the highest number of distinct user registrations.

Pretty straightforward aggregation here. I joined users and registrations, grouped by the city, and used `COUNT(DISTINCT user_id)` to make sure we don't double count someone who registered for multiple events. `ORDER BY ... DESC` and `LIMIT 5` gets us the top 5!
