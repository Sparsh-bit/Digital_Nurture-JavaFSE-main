# Exercise 14: jQuery and JS Frameworks

For the final exercise, I brought in jQuery via CDN to show how much simpler DOM manipulation used to be.

Instead of writing `document.getElementById('toggleBtn').addEventListener(...)`, I just wrote `$('#toggleBtn').click(...)`. It's so much shorter!

Inside the click handler, I used jQuery's built-in `.fadeOut()` and `.fadeIn()` animations. To do this in vanilla JS, you'd have to write custom CSS transitions or `requestAnimationFrame` loops, but jQuery does it in one line.

**Note on Frameworks:** While jQuery is great for quick DOM tweaks, building complex apps gets messy with spaghetti code. Moving to modern frameworks like **React** or **Vue** is beneficial because they use "declarative" rendering. You just update your state variables, and the framework automatically figures out what parts of the DOM need to change, keeping your code incredibly organized!
