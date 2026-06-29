# Exercise 18: Bootstrap 5 JavaScript Plugins

## Objective
Exercise 18.1: Add a modal popup triggered by a button.
Exercise 18.2: Create a collapsible accordion using `accordion` and Bootstrap JavaScript behavior.

## Output & Explanation
- **Output**: A button that opens a modal window when clicked. Below it, an accordion with two panels that can be expanded or collapsed.
- **Explanation**:
  - The modal uses `data-bs-toggle="modal"` and `data-bs-target="#exampleModal"` on the button to tie the trigger to the modal HTML structure without writing any custom JS.
  - The accordion uses `data-bs-toggle="collapse"` and links the buttons to the collapsable bodies via ID. The `data-bs-parent` attribute ensures that only one panel can stay open at a time.
