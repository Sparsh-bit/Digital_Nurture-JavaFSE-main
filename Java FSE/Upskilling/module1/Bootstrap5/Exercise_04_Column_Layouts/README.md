# Exercise 4: Column Layouts and Grid Classes

## Objective
Exercise 4.1: Design a two-column layout with a sidebar (col-md-3) and content area (col-md-9).
Exercise 4.2: Create a four-column layout (col-sm-3) with equal width.

## Output & Explanation
- **Output**: 
  - The first section shows a sidebar taking 1/4 of the width and main content taking 3/4 of the width on medium screens. On small screens, they stack.
  - The second section shows four equal-width columns on small screens and above.
- **Explanation**:
  - The grid is based on 12 columns.
  - `col-md-3` + `col-md-9` = 12, creating the perfect sidebar/content split.
  - `col-sm-3` * 4 = 12, creating a 4-column layout that triggers on small (sm) screens and up.
