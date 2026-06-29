const form = document.getElementById("signupForm");

form.addEventListener("submit", (e) => {
    // Prevent the page from reloading
    e.preventDefault();
    
    // Access inputs using form.elements
    const nameInput = form.elements['userName'].value.trim();
    const emailInput = form.elements['userEmail'].value.trim();
    
    const nameErr = document.getElementById("nameErr");
    const emailErr = document.getElementById("emailErr");
    
    let isValid = true;
    
    if (!nameInput) {
        nameErr.style.display = "block";
        isValid = false;
    } else {
        nameErr.style.display = "none";
    }
    
    if (!emailInput.includes("@")) {
        emailErr.style.display = "block";
        isValid = false;
    } else {
        emailErr.style.display = "none";
    }
    
    if (isValid) {
        document.getElementById("successMsg").innerText = "Form submitted successfully!";
        form.reset();
    } else {
        document.getElementById("successMsg").innerText = "";
    }
});