# Exercise 5: Event Registration Form

I created the event registration form for the residents.

I used all the correct HTML5 input types (`text`, `email`, `date`) which helps mobile browsers pull up the right keyboards and date pickers. I added `placeholder` text to help guide the user, made the critical fields `required` for basic validation, and slapped `autofocus` on the Name field so the cursor drops right in when the page loads.

To handle the submission, I used a tiny bit of inline JS on the `<form>` to prevent the page from reloading. Instead, it grabs the resident's name and spits out a friendly confirmation message into the `<output>` tag at the bottom. The whole thing is styled with some clean CSS to look like a modern card.
