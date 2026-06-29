# Exercise 11: Debug and Test with Dev Tools

This exercise doesn't require a finished CSS file, it's about learning how to debug in the browser. 
I created a dummy HTML file here that has a few intentional bugs so I could practice using Chrome DevTools.

Here's what I did to test it:
1. I opened `index.html` in Chrome and opened DevTools (F12).
2. I toggled the **Device Toolbar** (the little phone/tablet icon) to simulate an iPhone and saw how badly the `.buggy-box` broke the screen layout because of `width: 120%`.
3. In the **Elements** tab, I live-edited the CSS of `.buggy-box`, changing width to `100%` and saw the horizontal scroll disappear instantly.
4. Finally, I checked the **Network** tab, hit refresh, and saw `broken-styles.css` failing to load with a 404 error (red text), proving my external stylesheet link was broken.

DevTools is honestly a lifesaver.
