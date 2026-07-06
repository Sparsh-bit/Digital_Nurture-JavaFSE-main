# Exercise 2: Syntax, Data Types, and Operators

In this one, I practiced setting up some variables for a specific event.

I used `const` for the `eventName` and `eventDate` because those shouldn't change. I used `let` for `availableSeats` because that number will definitely go down as people register.

I used ES6 template literals (the backticks) to inject the variables directly into the strings, which is so much cleaner than using the `+` operator. Speaking of operators, I simulated someone registering by using the `--` decrement operator to instantly drop the `availableSeats` count by 1.
