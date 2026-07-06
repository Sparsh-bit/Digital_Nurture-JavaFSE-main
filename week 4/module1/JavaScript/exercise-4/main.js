let eventsList = [];

function addEvent(name, category) {
    eventsList.push({ name, category });
    console.log(`Added event: ${name}`);
}

// Closure to track registrations per category
function createRegistrationTracker(category) {
    let totalRegs = 0;
    
    return function registerUser() {
        totalRegs++;
        console.log(`Registered! Total for ${category} is now ${totalRegs}.`);
    }
}

// Higher order function passing a callback
function filterEventsByCategory(events, callback) {
    return events.filter(callback);
}

// Setup
addEvent("Rock Concert", "Music");
addEvent("Jazz Night", "Music");
addEvent("Farmers Market", "Community");

// Testing closure
const registerMusic = createRegistrationTracker("Music");
registerMusic();
registerMusic();

// Testing callback filter
const musicEvents = filterEventsByCategory(eventsList, function(evt) {
    return evt.category === "Music";
});

console.log("Filtered Music Events:", musicEvents);