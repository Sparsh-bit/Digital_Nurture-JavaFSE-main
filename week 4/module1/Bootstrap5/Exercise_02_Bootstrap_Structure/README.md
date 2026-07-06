# Exercise 2: Bootstrap Structure and Files

## Objective
Exercise 2.1: Explore the structure of the downloaded Bootstrap directory. Identify and explain the purpose of the CSS, JS, and icons folders.
Exercise 2.2: Modify your HTML to include Bootstrap's JavaScript plugins via bootstrap.bundle.min.js.

## Output & Explanation
- **Output**: A webpage with a button that shows a tooltip on hover, demonstrating the working JS plugins.
- **Explanation (2.1)**:
  - **CSS Folder**: Contains the compiled CSS files (`bootstrap.min.css`) which provide the styling, grid system, and utility classes.
  - **JS Folder**: Contains compiled JavaScript files (`bootstrap.bundle.min.js`) needed for interactive components like tooltips, modals, dropdowns, etc. The bundle includes Popper.js, which is required for dropdowns and tooltips.
  - **Icons Folder** (If downloaded separately or via npm): Contains SVG icons and icon fonts used to add vector graphics to your project easily.
- **Explanation (2.2)**: We included `bootstrap.bundle.min.js` at the end of the `<body>` in `index.html` and added a script to initialize the tooltip, proving the JS is loaded correctly.
