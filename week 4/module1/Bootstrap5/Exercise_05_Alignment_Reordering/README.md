# Exercise 5: Alignment and Reordering in Grid

## Objective
Exercise 5.1: Use `justify-content-center` and `align-items-center` to center content inside a row.
Exercise 5.2: Reorder columns on different screen sizes using `order-md-2`, `order-md-1`.

## Output & Explanation
- **Output**: 
  - First section: Content is perfectly centered both horizontally and vertically within a tall row.
  - Second section: On mobile (small screens), "Box 1" appears above "Box 2". On medium screens and up, "Box 2" appears before "Box 1".
- **Explanation**:
  - `justify-content-center` centers flex items on the main axis (horizontal), while `align-items-center` centers them on the cross axis (vertical).
  - `.order-*` classes use flexbox order to visually reorder DOM elements without changing the HTML structure.
