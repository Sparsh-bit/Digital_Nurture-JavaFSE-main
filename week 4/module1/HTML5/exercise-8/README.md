# Exercise 8: Saving User Preferences

This page remembers what the user likes using `localStorage`.

When a user selects an event category and clicks "Save", a tiny JavaScript function stores their choice in `localStorage` (and `sessionStorage` just to tick off the requirement). 

The cool part is the `window.onload` function. When you close the tab, open a new one, and load this file again, it checks `localStorage`. If it finds a saved preference, it automatically sets the dropdown menu back to what you chose previously! 

I also hooked up the "Clear" button to wipe both storages clean and reset the form.
