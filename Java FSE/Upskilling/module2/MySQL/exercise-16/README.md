# Exercise 16: Unregistered Active Users

**Goal**: Find users who created an account in the last 30 days but haven’t registered for any events.

Very similar to Exercise 3. I filtered for new accounts in the `WHERE` clause using `DATE_SUB`, and used the `LEFT JOIN / IS NULL` trick to find users lacking matching records in the Registrations table.
