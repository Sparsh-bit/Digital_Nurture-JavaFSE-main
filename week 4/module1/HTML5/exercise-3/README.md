# Exercise 3: Welcome Message with Styling and ID/Class

In this exercise, I set up a personalized welcome banner for logged-in residents.

I used a unique ID (`#welcomeBanner`) for the main container because there should only ever be one welcome banner on the page. I styled it with a blue background using an internal `<style>` block in the head.

Inside the banner, I used an inline style on a `<span>` tag (`style="color: red; font-weight: bold;"`) to make the special offer pop out. I know inline styles aren't great for maintainability, but it was perfect for this specific requirement!

Finally, I created a `.highlight` class and applied it to a different paragraph to show the difference between reusable classes and unique IDs.
