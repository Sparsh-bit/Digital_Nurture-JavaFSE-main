# Exercise 3: Inactive Users

**Goal**: Retrieve users who have not registered for any events in the last 90 days.

I approached this by doing a `LEFT JOIN` between `Users` and `Registrations`, but specifically restricting the join to registrations that happened in the last 90 days using `DATE_SUB(CURDATE(), INTERVAL 90 DAY)`. 
Then, by adding `WHERE r.registration_id IS NULL`, it perfectly filters down to the users who *didn't* match that criteria (meaning they are inactive).
