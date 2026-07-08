# Exercise 4: Peak Session Hours

**Goal**: Count how many sessions are scheduled between 10 AM to 12 PM for each event.

I extracted just the time portion from the datetime column using the `TIME()` function. Then I just used standard `GROUP BY` to count the sessions for each event that fell into that window.
