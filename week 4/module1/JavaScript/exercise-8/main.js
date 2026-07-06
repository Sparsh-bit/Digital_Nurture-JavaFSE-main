const searchInput = document.getElementById('searchInput');
const categoryFilter = document.getElementById('categoryFilter');
const regBtn = document.getElementById('regBtn');
const output = document.getElementById('output');

// keydown event
searchInput.addEventListener('keydown', (e) => {
    // using setTimeout so it logs after the character is actually added to input
    setTimeout(() => {
        output.innerText = `Searching for: ${searchInput.value}`;
    }, 10);
});

// change event
categoryFilter.addEventListener('change', (e) => {
    output.innerText = `Filtered category to: ${e.target.value}`;
});

// click event
regBtn.addEventListener('click', () => {
    output.innerText = "You clicked register!";
});