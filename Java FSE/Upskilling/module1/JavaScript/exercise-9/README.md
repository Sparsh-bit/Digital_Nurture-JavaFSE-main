# Exercise 9: Async JS, Promises, Async/Await

Handling asynchronous data!

I built a `mockFetchEvents` function that returns a JavaScript `Promise`. I put a `setTimeout` inside it to simulate 1.5 seconds of network lag before it resolves with some mock JSON data.

I wired up a button click to an `async` function. When clicked, it reveals a loading spinner text, and then `await mockFetchEvents()` pauses the function execution until the promise resolves. Once the data arrives, it builds the list items and hides the spinner. I also wrapped the whole thing in a `try...catch` block to handle potential network failures gracefully.
