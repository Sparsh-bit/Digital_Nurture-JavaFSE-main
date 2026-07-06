# Exercise 6: Link and List Styling

I customized the default links and lists because the standard blue underlines are a bit ugly.

For the navigation menu, I removed the bullets completely using `list-style-type: none` and stripped out the default padding. I styled the `<a>` tags with `:link`, `:visited`, `:hover`, and `:active` pseudo-classes so they act like large clickable buttons that change color when you hover or click on them.

For a secondary "rules" list, I kept the bullets but changed them to squares (`list-style-type: square`) and moved them inside the content flow using `list-style-position: inside`, while adding some margin and padding to space them out nicely.
