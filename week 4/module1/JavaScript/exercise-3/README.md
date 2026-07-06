# Exercise 3: Conditionals, Loops, and Error Handling

The goal here was to filter a list of events so we only show ones that actually have seats available.

I set up an array of mock events and used `.forEach()` to loop through them. Inside the loop, I used an `if/else` statement to check if `event.seats > 0`. If so, I dynamically created an `<li>` element and added it to the page. If it was 0, it just logged that the event was hidden.

I also threw in a `try...catch` block. I intentionally added a "Cooking Class" event with `-5` seats. The script catches that, throws an Error, and logs it safely in the catch block without crashing the rest of the loop!
