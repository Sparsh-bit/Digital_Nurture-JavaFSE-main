# Exercise 16: Positioning Utilities

## Objective
Exercise 16.1: Create a fixed footer using `position-fixed bottom-0`.
Exercise 16.2: Use `position-relative` and `position-absolute` to overlay a badge over an image.

## Output & Explanation
- **Output**: An image with a notification badge sitting perfectly on its top-right corner. At the bottom of the viewport, there is a dark footer that stays in place even if you scroll.
- **Explanation**:
  - `position-relative` is applied to the image wrapper, setting the positioning context.
  - `position-absolute top-0 start-100 translate-middle` is applied to the badge, anchoring it to the top-right corner of the wrapper and pulling it back by 50% so it perfectly straddles the border.
  - `position-fixed bottom-0 w-100` anchors the footer to the bottom of the window, spanning 100% width.
