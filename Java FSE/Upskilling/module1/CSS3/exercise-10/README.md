# Exercise 10: Responsive Web Design

Here I used media queries to make sure the portal looks good on phones too!

By default, the layout uses flexbox to put the navbar links side-by-side with the logo, and the hero image side-by-side with the text. I used `vw` (viewport width) on the image so it scales dynamically.

I added an `@media screen and (max-width: 768px)` query. If you shrink your browser window below 768px, the media query kicks in and completely restyles the layout:
- The navigation links stack vertically instead of horizontally.
- The hero image and text stack on top of each other.
- The font size and image widths are adjusted to fit the smaller screen perfectly.
