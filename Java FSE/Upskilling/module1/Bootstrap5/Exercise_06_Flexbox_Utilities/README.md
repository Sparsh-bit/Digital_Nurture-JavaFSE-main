# Exercise 6: Responsive Flexbox Utilities
*(Note: The prompt numbered these as 7.1 and 7.2 under section 6, we are maintaining order)*

## Objective
Exercise 7.1 (6.1): Create a navbar using `d-flex`, `flex-column`, and `flex-md-row` for responsive behavior.
Exercise 7.2 (6.2): Use `justify-content-between` and `align-items-center` in a card layout.

## Output & Explanation
- **Output**: 
  - A navigation bar that stacks links vertically on mobile and displays them in a row on medium screens and up.
  - A card where the title/description and the action button are pushed to opposite ends and vertically centered.
- **Explanation**:
  - `d-flex` applies `display: flex`. `flex-column` sets the flex-direction to column for mobile. `flex-md-row` changes it to row on medium screens.
  - Inside the card body, `justify-content-between` distributes the extra space between the text block and the button. `align-items-center` ensures they align perfectly in the middle vertically.
