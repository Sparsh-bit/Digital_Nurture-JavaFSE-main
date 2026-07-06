# Exercise 3: Fundamentals of Responsive Grid Layout

## Objective
Exercise 3.1: Create a container with three columns that stack vertically on mobile, two-per-row on tablets, and three-per-row on desktops.
Exercise 3.2: Use `.container`, `.row`, and `.col-*` classes appropriately for responsive design.

## Output & Explanation
- **Output**: A responsive grid that changes layout based on the screen size. Resize your browser window to see the columns shift from 3-per-row (desktop) to 2-per-row (tablet) to stacked 1-per-row (mobile).
- **Explanation**:
  - We wrap the grid in a `.container` to provide a max-width and centering.
  - The `.row` class acts as a flex container for the columns.
  - For each column, we use `.col-12` for mobile (100% width, stacking), `.col-md-6` for tablets (50% width, 2 per row), and `.col-lg-4` for desktops (33.3% width, 3 per row).
