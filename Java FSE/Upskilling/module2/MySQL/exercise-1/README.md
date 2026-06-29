# Exercise 1: User Upcoming Events

**Goal**: Show a list of all upcoming events a user is registered for in their city, sorted by date.

I used `JOIN` to connect `Users`, `Registrations`, and `Events`. Then I added a `WHERE` clause to filter out past events (`status = 'upcoming'`) and made sure the user's city matches the event's city (`u.city = e.city`). Finally, I used `ORDER BY e.start_date ASC` to sort it chronologically.
