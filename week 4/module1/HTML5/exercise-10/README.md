# Exercise 10: Debugging with Chrome DevTools

This exercise is entirely hands-on inside the browser, so I created a dummy page with some intentional bugs to practice with.

Here's how I tested it in Chrome:
1. **Inspect Element**: The main content box is completely invisible on load. I right-clicked the page, chose "Inspect", found `<div id="secret-content">` in the Elements tab, and unticked `display: none` in the Styles pane to make it appear.
2. **Console Logging**: When you click the "Calculate Event Total" button, it alerts that the total is "$205" instead of "$25". If you open the Console tab, you can see the logs I put in `console.log("Tax:", tax, type(tax));` which prove that `tax` is being evaluated as a string.
3. **Breakpoints**: I went to the **Sources** tab, opened `index.html`, and clicked on line 28 (`let total = basePrice + tax;`) to place a blue breakpoint. When I clicked the button again, the page froze, and I was able to hover over the variables to inspect their values live! 

A great way to end the HTML5 module!
