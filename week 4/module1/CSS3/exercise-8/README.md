# Exercise 8: Box Model & Layout Control

Here I played with the CSS box model (margins, padding, borders, outlines).

I applied a border, 20px of padding (space inside the border), and 15px of margin (space outside the border) to the `.eventCard` elements to give them breathing room.
I also used `outline` on an input field. Outlines are cool because unlike borders, they don't take up actual physical layout space, so they don't push other elements around.

Finally, I demonstrated the difference between hiding elements. The "Secret Event" card uses `visibility: hidden`—it's invisible but leaves a giant blank gap where it's supposed to be. The "Cancelled Event" uses `display: none` and it gets completely wiped from the layout flow as if it never existed!
