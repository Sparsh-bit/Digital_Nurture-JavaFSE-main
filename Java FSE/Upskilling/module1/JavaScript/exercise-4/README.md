# Exercise 4: Functions, Scope, Closures, Higher-Order Functions

This exercise got a bit more advanced with closures and callbacks.

I created an `addEvent` function to push new items to a global `eventsList` array. 

For the closure part, I made a `createRegistrationTracker` function. It takes a category and sets a local `totalRegs` variable to 0. It returns an inner `registerUser` function. When I call `registerMusic()`, it remembers the `totalRegs` variable from its parent scope and increments it! This is a really cool way to keep variables private.

Finally, `filterEventsByCategory` takes in an array and a callback function. I passed in a custom anonymous function to filter out only the "Music" events.
