# Exercise 2: Top Rated Events

**Goal**: Identify events with the highest average rating, considering only those that have received at least 10 feedback submissions.

I grouped the data by the event using `GROUP BY` and calculated the average rating using the `AVG()` aggregate function. To filter out events that don't have enough reviews, I used the `HAVING` clause, since you can't use `WHERE` on aggregated counts like `COUNT(feedback_id)`.
