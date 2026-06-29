// Constructor function
function CommunityEvent(name, date, seats) {
    this.name = name;
    this.date = date;
    this.seats = seats;
}

// Add method to prototype so it is shared across all instances
CommunityEvent.prototype.checkAvailability = function() {
    if (this.seats > 0) {
        return `Yes! ${this.name} has ${this.seats} seats left.`;
    }
    return `Sorry, ${this.name} is fully booked.`;
}

// Create objects
const event1 = new CommunityEvent("Art Walk", "2024-08-01", 10);
const event2 = new CommunityEvent("Book Club", "2024-08-05", 0);

console.log(event1.checkAvailability());
console.log(event2.checkAvailability());

// List keys and values using Object.entries()
console.log("\nEvent 1 details:");
Object.entries(event1).forEach(([key, value]) => {
    console.log(`${key}: ${value}`);
});