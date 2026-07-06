const sendBtn = document.getElementById("sendBtn");
const output = document.getElementById("output");

sendBtn.addEventListener("click", () => {
    output.innerText = "Sending data...";
    
    const userData = {
        name: "Test User",
        event: "Community Cleanup"
    };

    // Simulate fetch request to mock API (jsonplaceholder)
    fetch("https://jsonplaceholder.typicode.com/posts", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(userData)
    })
    .then(response => response.json())
    .then(data => {
        // Use setTimeout to artificially delay the success message just to show it loading
        setTimeout(() => {
            console.log("Server responded with:", data);
            output.innerText = `Success! Server generated ID: ${data.id}`;
            output.style.color = "green";
        }, 1000);
    })
    .catch(error => {
        output.innerText = "Failed to send data.";
        output.style.color = "red";
        console.error(error);
    });
});