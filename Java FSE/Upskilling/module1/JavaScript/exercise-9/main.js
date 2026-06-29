const loadBtn = document.getElementById("loadBtn");
const spinner = document.getElementById("spinner");
const eventList = document.getElementById("eventList");

// Mock fetch function returning a Promise with delay
function mockFetchEvents() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve([
                { id: 1, name: "City Marathon" },
                { id: 2, name: "Street Food Fest" }
            ]);
            // to test error, comment above and uncomment below
            // reject(new Error("API is down!"));
        }, 1500);
    });
}

// Using Async/Await
loadBtn.addEventListener("click", async () => {
    eventList.innerHTML = "";
    spinner.style.display = "block"; // Show loading spinner
    
    try {
        const data = await mockFetchEvents();
        
        data.forEach(evt => {
            const li = document.createElement("li");
            li.innerText = evt.name;
            eventList.appendChild(li);
        });
    } catch (error) {
        console.error("Fetch failed:", error);
        eventList.innerHTML = `<li style="color:red;">Error: ${error.message}</li>`;
    } finally {
        spinner.style.display = "none"; // Hide spinner regardless of success/fail
    }
});