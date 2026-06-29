# Exercise 14: Display and Visibility

## Objective
Exercise 14.1: Use `d-none`, `d-md-block`, `d-lg-flex` to hide/show sections based on screen size.
Exercise 14.2: Create a responsive sidebar that only shows on tablets and above.

## Output & Explanation
- **Output**: 
  - A layout featuring a sidebar that disappears on mobile devices.
  - A notification that only shows on mobile, telling the user the sidebar is hidden.
  - A green flexbox banner that only appears on desktop (large) screens.
- **Explanation**:
  - `d-none` hides the element on all screen sizes.
  - Adding `d-md-block` overrides `d-none` starting from the `md` breakpoint, showing it as a block element.
  - `d-lg-flex` is similar, but shows it as a flex container only on large screens and up.
