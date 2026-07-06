const container = document.querySelector("#container");
const addBtn = document.querySelector("#addBtn");
let eventCount = 1;

// Function to create an event card
function createCard(id) {
    const card = document.createElement("div");
    card.className = "card";
    
    const title = document.createElement("h4");
    title.innerText = "Event #" + id;
    
    const cancelBtn = document.createElement("button");
    cancelBtn.innerText = "Cancel Registration";
    cancelBtn.className = "cancel-btn";
    
    // Update UI when canceled
    cancelBtn.onclick = function() {
        container.removeChild(card);
    };
    
    card.appendChild(title);
    card.appendChild(cancelBtn);
    return card;
}

// Listen for clicks to add new cards
addBtn.onclick = function() {
    const newCard = createCard(eventCount++);
    container.appendChild(newCard);
};