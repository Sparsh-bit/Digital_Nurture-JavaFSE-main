# Exercise 5: Objects and Prototypes

Here I modeled the events using a constructor function called `CommunityEvent`.

Instead of putting the `checkAvailability()` method directly inside the constructor (which would create a new copy of the function for every single event), I attached it to `CommunityEvent.prototype`. This way, every event object shares the exact same function in memory, which is much more efficient.

After creating two mock events, I used `Object.entries()` to loop over `event1`. This gave me an array of `[key, value]` pairs, which I destructured in a `.forEach()` loop to print out the properties dynamically!
