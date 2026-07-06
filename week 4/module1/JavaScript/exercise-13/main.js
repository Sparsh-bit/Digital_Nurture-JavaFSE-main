document.getElementById("failBtn").addEventListener("click", () => {
    const payload = { userId: 42, action: "register" };
    
    console.log("Submitting payload to server...");
    
    // Intentional typo in URL to trigger 404
    fetch("https://jsonplaceholder.typicode.com/postzzzz", {
        method: "POST",
        body: JSON.stringify(payload)
    })
    .then(res => {
        if (!res.ok) {
            // Need a breakpoint here to see what res.status is
            console.error("Bad response:", res.status);
        }
        return res.json();
    })
    .catch(err => {
        // Failing silently intentionally
    });
});