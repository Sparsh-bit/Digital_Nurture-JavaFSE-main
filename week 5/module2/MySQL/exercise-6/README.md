# Exercise 6: Event Resource Summary

**Goal**: Generate a report showing the number of resources uploaded for each event.

I could have just done a simple `COUNT()`, but I decided to make it a bit cooler by using `SUM(CASE WHEN ...)` to pivot the data. This way, the report shows the total count, but also breaks it down by `pdf_count`, `image_count`, and `link_count` in separate columns.
