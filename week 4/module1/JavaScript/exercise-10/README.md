# Exercise 10: Modern JavaScript Features

Just a quick script to refactor some older JS patterns into modern ES6+.

- I added a **default parameter** (`name = "Guest"`) to a function, which prevents it from printing "undefined" if no argument is passed.
- I used **object destructuring** (`const { title, location } = eventObj`) to quickly extract variables out of an object without having to write `eventObj.title` over and over.
- I used the **spread operator** (`...originalList`) to perfectly clone an array. I proved it worked by pushing a new item to the clone and confirming the original array stayed untouched.
