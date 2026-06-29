# Exercise 12: AJAX & Fetch API

Here I simulated sending form data to a backend server.

I used the native `fetch()` API and set the method to `POST`. I converted my dummy `userData` object into a string using `JSON.stringify()` and sent it to `jsonplaceholder.typicode.com`, which is a great free service for testing mock APIs.

I handled the response with `.then()`. Inside the success block, I added a `setTimeout` for 1 second just to artificially slow it down, making the "Sending data..." message stay on screen long enough to be read. When it's done, it prints out the ID that the mock server generated for us.
