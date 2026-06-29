# Exercise 11: Cards and Media Objects

## Objective
Exercise 11.1: Create a profile card using `card`, `card-body`, `card-title`, and `card-img-top`.
Exercise 11.2: Design a media object layout using flexbox (media objects were dropped in BS5) and align an image to the left of the content.

## Output & Explanation
- **Output**: A standard card containing an image, title, text, and button. Below it is a media object layout showing an image floated to the left of a text block.
- **Explanation**:
  - `card` provides a flexible and extensible content container.
  - Note: Bootstrap 5 dropped the explicit `.media` component classes that existed in v4. We recreate the exact media object layout using flex utilities: `d-flex` (flex container), `align-items-start` (top alignment), and `me-3` (margin-right on the image).
