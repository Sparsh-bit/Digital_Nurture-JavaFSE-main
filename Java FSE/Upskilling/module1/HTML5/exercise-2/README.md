# Exercise 2: Navigation and Linking

I built out the navigation structure for the portal. 

I used a `<nav>` tag containing standard anchor `<a>` links. To make the page jump to the correct sections, I linked the `href` directly to the section IDs (like `href="#events"` targeting `<section id="events">`). I also added some dummy CSS height to the sections so you can actually see the page scroll when you click the links.

For the external help document, I created a dummy `help.html` file and linked to it using `target="_blank"`. This ensures that when a resident clicks "Help", they don't lose their place on the main portal page—it just opens in a new browser tab.
