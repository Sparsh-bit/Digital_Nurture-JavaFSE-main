# Exercise 19: Customization with Sass

## Objective
Exercise 19.1: Set up a Bootstrap 5 project with Sass using npm.
Exercise 19.2: Customize primary colors and border radius via `_variables.scss` and recompile Bootstrap.

## Explanation & Setup Instructions
In a real environment, you do not just link to a CDN when customizing via Sass. You follow these steps:

1. **Initialize Project:**
   ```bash
   npm init -y
   ```

2. **Install Bootstrap & Sass:**
   ```bash
   npm install bootstrap
   npm install --save-dev sass
   ```

3. **Create SCSS files:**
   You create an entry point (e.g., `custom.scss`):
   ```scss
   // custom.scss
   
   // 1. Override default variables
   $primary: #ff5722; // Change primary color to deep orange
   $border-radius: 0.75rem; // Increase default border radius

   // 2. Import Bootstrap source files
   @import "../node_modules/bootstrap/scss/bootstrap";
   ```

4. **Compile SCSS to CSS:**
   Add a script to your `package.json`:
   ```json
   "scripts": {
     "build-css": "sass custom.scss custom.css"
   }
   ```
   Run `npm run build-css` to generate your customized Bootstrap CSS file.

*(This directory contains mock files representing this configuration setup.)*
