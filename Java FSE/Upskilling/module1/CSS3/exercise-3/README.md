# Exercise 3: Selectors Playground

In this exercise, I played around with different types of CSS selectors to style the community events list.

- I used the `*` universal selector to wipe out the default browser margins and padding.
- I targeted all `<h2>` tags directly using an element selector.
- The banner uses an ID selector (`#mainHeader`), which is perfect since there's only one main header.
- For the individual events, I used a class selector (`.eventCard`) so I can apply the same box styling to multiple events.
- Finally, I grouped `h3` and `p` together (`h3, p { ... }`) to give them a consistent text color and line height without duplicating CSS.
