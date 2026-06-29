# Exercise 11: Daily New User Count

**Goal**: Find the number of users who registered each day in the last 7 days.

I filtered the `Users` table using `DATE_SUB()` to grab only the last 7 days of registrations, grouped them by the exact date, and counted them up. Super standard metric query.
