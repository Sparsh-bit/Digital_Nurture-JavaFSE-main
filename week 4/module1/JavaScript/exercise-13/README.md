# Exercise 13: Debugging and Testing

This exercise is set up for DevTools practice. The script contains a silent failure.

If you click the button, nothing seems to happen. But if you open Chrome DevTools:
1. **Console**: You'll see the "Submitting payload" log, followed by a red error about a 404 Not Found.
2. **Network Tab**: If you click the Network tab, you'll see the failed `fetch` request in red. Clicking on it shows that I intentionally misspelled the endpoint URL as `/postzzzz`.
3. **Breakpoints**: You can go to Sources, put a breakpoint on `console.error("Bad response")`, and see exactly what the response object looks like when the server rejects it.
