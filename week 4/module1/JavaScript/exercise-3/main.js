const events = [
    { name: "Music Fest", seats: 100 },
    { name: "Tech Meetup", seats: 0 },
    { name: "Cooking Class", seats: -5 } // Intentional bad data
];

const listEl = document.getElementById("eventList");

events.forEach(event => {
    try {
        // Error handling for bad data
        if (event.seats < 0) {
            throw new Error(`Invalid seat count for ${event.name}`);
        }

        // Conditional rendering
        if (event.seats > 0) {
            console.log(`Showing ${event.name} (Seats: ${event.seats})`);
            const li = document.createElement('li');
            li.textContent = `${event.name} - ${event.seats} seats available`;
            listEl.appendChild(li);
        } else {
            console.log(`Hiding ${event.name} because it is full.`);
        }
    } catch (error) {
        console.error("Error processing event:", error.message);
    }
});