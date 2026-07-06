let events = [
    { title: "Baking Basics", category: "Food" },
    { title: "Guitar Lessons", category: "Music" }
];

// Add a new event
events.push({ title: "Piano Recital", category: "Music" });
console.log("After push:", events);

// Filter to only show music events
const musicEvents = events.filter(e => e.category === "Music");
console.log("Filtered to Music:", musicEvents);

// Map to format strings
const formattedCards = events.map(e => `Event Card: [${e.category}] ${e.title}`);
console.log("Formatted cards:", formattedCards);