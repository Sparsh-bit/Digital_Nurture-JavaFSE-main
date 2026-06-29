// Setup event details
const eventName = "Summer BBQ";
const eventDate = "July 15, 2024";
let availableSeats = 50;

// Log info using template literals
console.log(`Event: ${eventName} is happening on ${eventDate}.`);
console.log(`Currently there are ${availableSeats} seats left.`);

// Simulate a registration
console.log("Someone just registered!");
availableSeats--; // decrease seats using decrement operator

console.log(`Now there are ${availableSeats} seats left.`);