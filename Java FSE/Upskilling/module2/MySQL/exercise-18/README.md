# Exercise 18: Resource Availability Check

**Goal**: List all events that do not have any resources uploaded.

The classic "anti-join". `LEFT JOIN` the Resources table, and pull only the rows where the joined `resource_id` came back as `NULL`.
