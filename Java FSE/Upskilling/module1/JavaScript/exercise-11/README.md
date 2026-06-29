# Exercise 11: Working with Forms

This is how I handle custom form validation in JavaScript.

First, I hooked onto the form's `submit` event and immediately called `e.preventDefault()`. This stops the browser from doing a hard page reload when you click Submit.

Then I accessed the inputs securely using `form.elements['name']`. I ran some basic validation (checking if name is empty, checking if email contains an `@` symbol). If any of them fail, I display the inline red error messages. If everything looks good, I show a success message and clear the form using `form.reset()`.
