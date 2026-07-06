# Exercise 9: Geolocation for Event Mapping

I added a feature to find the resident's physical coordinates so we can show them nearby events.

When you click "Find Nearby Events", the browser will prompt you for permission to access your location. I used `navigator.geolocation.getCurrentPosition()` passing in a success callback (`showPosition`), an error callback (`showError`), and a config object asking for high accuracy and a 10-second timeout.

If you click "Allow", it prints your Latitude and Longitude on the screen. If you click "Block", the error handler intercepts the `PERMISSION_DENIED` code and displays a friendly red error message instead of crashing silently.
