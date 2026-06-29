# Exercise 7: DOM Manipulation

Time to actually interact with the page!

I used `document.querySelector()` to grab the `#container` div and the "Register" button. 

When you click the register button, it calls my `createCard()` function. Inside that function, I used `document.createElement()` to build a `<div>`, an `<h4>`, and a `<button>` completely from scratch using JavaScript. I then appended them all together.

I also added an `onclick` listener to the generated "Cancel" button, which uses `container.removeChild(card)` to delete itself from the DOM when clicked.
