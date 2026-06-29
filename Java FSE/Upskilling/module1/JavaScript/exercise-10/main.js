// Default parameters
function greetUser(name = "Guest") {
    console.log(`Hello, ${name}!`);
}
greetUser(); // Uses default
greetUser("Alice"); // Overrides default

const eventObj = {
    title: "Hackathon",
    location: "City Library",
    capacity: 200
};

// Destructuring
const { title, location } = eventObj;
console.log(`The ${title} is at the ${location}.`);

// Spread operator to clone array
const originalList = ["Event A", "Event B", "Event C"];
const clonedList = [...originalList];

console.log("Original:", originalList);
console.log("Cloned (using spread):", clonedList);

// Changing clone doesn't affect original
clonedList.push("Event D");
console.log("After pushing to clone:");
console.log("Original:", originalList);
console.log("Cloned:", clonedList);