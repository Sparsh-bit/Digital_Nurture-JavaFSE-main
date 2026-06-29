import os
import shutil

base_dir = "/Volumes/Volume D/Digital-Nurture-JavaFSE-main/Java FSE/Upskilling/module1/Bootstrap5"

# Clean old structure
if os.path.exists(base_dir):
    for filename in os.listdir(base_dir):
        file_path = os.path.join(base_dir, filename)
        try:
            if os.path.isfile(file_path) or os.path.islink(file_path):
                os.unlink(file_path)
            elif os.path.isdir(file_path):
                shutil.rmtree(file_path)
        except Exception as e:
            print('Failed to delete %s. Reason: %s' % (file_path, e))

os.makedirs(base_dir, exist_ok=True)

exercises = [
    {
        "dir": "exercise-1",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My First Bootstrap Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Getting started with Bootstrap 5</h1>
        <p>This is just a simple page to test out if the CDN links are working properly. Everything looks good so far!</p>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>""",
        "readme": """# Exercise 1 Solution

Hey! This is my solution for the first exercise. 
I created a simple HTML file and linked the Bootstrap 5 CSS and JS files using the jsdelivr CDN. 
I also added a basic container with a heading and a paragraph just to make sure the fonts and margins get applied correctly.

For the second part of the exercise (npm setup), I would normally run `npm install bootstrap` and link it from `node_modules`, but I used the CDN here so the HTML file can just be opened in the browser without any setup.
"""
    },
    {
        "dir": "exercise-2",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bootstrap Structure Test</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h2>Testing out JS Plugins</h2>
        <p>I wanted to see if the JS bundle is loaded, so I added a tooltip below.</p>
        
        <button type="button" class="btn btn-secondary" data-bs-toggle="tooltip" data-bs-placement="right" title="Yay! The JS is working.">
            Hover over this button
        </button>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // Found this snippet in the docs to enable tooltips
        var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
        var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
          return new bootstrap.Tooltip(tooltipTriggerEl)
        })
    </script>
</body>
</html>""",
        "readme": """# Exercise 2 Solution

In this folder, I explored how Bootstrap's files are structured.
- The CSS folder has `bootstrap.min.css` which handles all the layouts, grids, and colors.
- The JS folder has `bootstrap.bundle.min.js`. The "bundle" part means it includes Popper.js, which we need for dropdowns and tooltips.

I modified the HTML file to include the JS bundle at the bottom. To prove it works, I added a small script that enables a tooltip on a button. If you open `index.html` and hover over the button, you'll see it!
"""
    },
    {
        "dir": "exercise-3",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Responsive Grid Test</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .my-box {
            background-color: #eee;
            padding: 20px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2>Testing the Grid System</h2>
        <p>Resize the window to see how the columns shift around.</p>
        
        <div class="row">
            <div class="col-12 col-md-6 col-lg-4">
                <div class="my-box">First column</div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="my-box">Second column</div>
            </div>
            <div class="col-12 col-md-6 col-lg-4">
                <div class="my-box">Third column</div>
            </div>
        </div>
    </div>
</body>
</html>""",
        "readme": """# Exercise 3: Responsive Grid

Here is the code for the responsive grid layout. 

I used the `.container` to center everything. Inside the `.row`, I added three divs with the classes `col-12 col-md-6 col-lg-4`.
This makes them take up the full width on phones, half the width on tablets (2 per row), and a third of the width on laptops (3 per row).

I added a little bit of custom CSS just to make the boxes visible so you can actually see the grid working when you resize the browser.
"""
    },
    {
        "dir": "exercise-4",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Column Layouts</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h4>Two Column Layout (Sidebar + Main)</h4>
        <div class="row mb-5">
            <div class="col-md-3 bg-light p-3 border">
                <strong>Sidebar</strong>
                <ul class="list-unstyled mt-2">
                    <li><a href="#">Link 1</a></li>
                    <li><a href="#">Link 2</a></li>
                </ul>
            </div>
            <div class="col-md-9 p-3 border-bottom border-top border-end">
                <strong>Main Content</strong>
                <p>This area takes up 9 columns on medium and larger screens.</p>
            </div>
        </div>

        <h4>Four Column Equal Width</h4>
        <div class="row text-center">
            <div class="col-sm-3 p-3 bg-primary text-white border">Col A</div>
            <div class="col-sm-3 p-3 bg-secondary text-white border">Col B</div>
            <div class="col-sm-3 p-3 bg-primary text-white border">Col C</div>
            <div class="col-sm-3 p-3 bg-secondary text-white border">Col D</div>
        </div>
    </div>
</body>
</html>""",
        "readme": """# Exercise 4: Layouts

This exercise was about creating specific layouts using the grid classes.

For the first part, I made a sidebar layout. Since the grid is 12 columns total, I gave the sidebar `col-md-3` and the main content `col-md-9`. I used the `md` breakpoint so they stack nicely on top of each other on smaller screens.

For the second part, I made a four-column layout using `col-sm-3` (since 3 * 4 = 12). I used `sm` this time so they stay in a row on slightly smaller screens like large phones.
"""
    },
    {
        "dir": "exercise-5",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Alignment & Reordering</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h4>Alignment</h4>
        <div class="row justify-content-center align-items-center bg-light" style="height: 250px; border: 1px solid #ddd;">
            <div class="col-4 bg-info p-3 text-center rounded">
                I am perfectly centered in this box!
            </div>
        </div>

        <h4 class="mt-5">Reordering</h4>
        <div class="row">
            <div class="col-12 col-md-6 order-md-2 p-4 bg-warning">
                I am the first div in HTML, but I show up second on laptops.
            </div>
            <div class="col-12 col-md-6 order-md-1 p-4 bg-success text-white">
                I am the second div in HTML, but I show up first on laptops.
            </div>
        </div>
    </div>
</body>
</html>""",
        "readme": """# Exercise 5: Flexbox Alignment and Ordering

In this one, I used Bootstrap's built-in flexbox utilities for the grid.

To center the content in a tall row, I just applied `justify-content-center` (for horizontal centering) and `align-items-center` (for vertical centering) directly to the `.row` div.

For the reordering part, I added `order-md-2` to the first box and `order-md-1` to the second box. On phones, they appear in the normal HTML order. But once the screen reaches medium size, the green box jumps to the front!
"""
    },
    {
        "dir": "exercise-6",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Flexbox Utilities</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h4>Responsive Navbar with Flex</h4>
        <div class="d-flex flex-column flex-md-row bg-dark p-2 rounded mb-5">
            <a href="#" class="text-white p-2 text-decoration-none">Home</a>
            <a href="#" class="text-white p-2 text-decoration-none">About</a>
            <a href="#" class="text-white p-2 text-decoration-none">Contact</a>
        </div>

        <h4>Card with Flex Alignment</h4>
        <div class="card shadow-sm">
            <div class="card-body d-flex justify-content-between align-items-center">
                <div>
                    <h5 class="mb-0">Awesome Product</h5>
                    <small class="text-muted">In stock</small>
                </div>
                <button class="btn btn-primary">Add to cart</button>
            </div>
        </div>
    </div>
</body>
</html>""",
        "readme": """# Exercise 6: More Flexbox Utilities

(I noticed the prompt called these 7.1 and 7.2, but I put them under exercise-6 so it stays organized.)

I made a simple navbar without using the actual `.navbar` component, just using raw flexbox utilities. By combining `d-flex`, `flex-column`, and `flex-md-row`, the links stack on mobile and sit in a row on desktop.

I also made a card where the text is pushed to the left and the button is pushed to the right using `justify-content-between`. Adding `align-items-center` keeps the button perfectly aligned with the text block vertically.
"""
    },
    {
        "dir": "exercise-7",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Typography Tests</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="display-1">Huge Title</h1>
        <p class="lead">This is a lead paragraph. It looks a bit nicer for introductory text.</p>
        <p>This is a normal paragraph, but it has some <span class="fw-bold">bold words</span> and some <span class="text-muted">greyed out words</span>.</p>
        
        <hr class="my-4">
        
        <p class="text-uppercase">this was typed in lowercase but shows up uppercase.</p>
        <p class="text-lowercase">THIS WAS TYPED IN UPPERCASE.</p>
        <p class="text-capitalize">this makes the first letter of every word capital.</p>
    </div>
</body>
</html>""",
        "readme": """# Exercise 7: Typography

This is just a quick page showing off Bootstrap's typography classes.

The `.display-1` class makes the heading huge, much bigger than a normal h1.
The `.lead` class is great for the first paragraph of an article.
I also tested out the text transform utilities (`text-uppercase`, `text-lowercase`, `text-capitalize`) which are super handy because you don't have to write custom CSS for them.
"""
    },
    {
        "dir": "exercise-8",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Forms</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6 mb-4">
                <h4>Sign Up</h4>
                <form>
                    <div class="mb-3">
                        <label class="form-label">Username</label>
                        <div class="input-group">
                            <span class="input-group-text">@</span>
                            <input type="text" class="form-control" placeholder="johndoe">
                        </div>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Email</label>
                        <input type="email" class="form-control" placeholder="john@example.com">
                    </div>
                    <div class="mb-3 form-check">
                        <input type="checkbox" class="form-check-input" id="check1">
                        <label class="form-check-label" for="check1">I agree to the terms</label>
                    </div>
                    <button type="submit" class="btn btn-primary">Sign up</button>
                </form>
            </div>
            
            <div class="col-md-5 offset-md-1">
                <h4>Login (Floating Labels)</h4>
                <form class="p-4 border rounded bg-light">
                    <div class="form-floating mb-3">
                        <input type="email" class="form-control" id="fEmail" placeholder="name@example.com">
                        <label for="fEmail">Email address</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input type="password" class="form-control" id="fPass" placeholder="Password">
                        <label for="fPass">Password</label>
                    </div>
                    <button type="submit" class="btn btn-success w-100">Log in</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>""",
        "readme": """# Exercise 8: Forms

Here I built two different forms to try out the form components.

On the left is a standard registration form. I used `.input-group` to add an `@` symbol to the username field, and `.form-check` for the checkbox.
On the right is a login form using the newer floating labels (`.form-floating`). It looks really clean because the label shrinks and moves to the top when you click inside the input. Note that for floating labels to work properly, the `<input>` must come *before* the `<label>` in the HTML.
"""
    },
    {
        "dir": "exercise-9",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buttons</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h4>All the buttons</h4>
        <div class="mb-4">
            <button class="btn btn-primary">Primary</button>
            <button class="btn btn-secondary">Secondary</button>
            <button class="btn btn-success">Success</button>
            <button class="btn btn-danger">Danger</button>
            <button class="btn btn-warning">Warning</button>
            <button class="btn btn-info">Info</button>
            <button class="btn btn-dark">Dark</button>
        </div>
        
        <div class="mb-4">
            <button class="btn btn-outline-primary">Primary Outline</button>
            <button class="btn btn-outline-success">Success Outline</button>
            <button class="btn btn-outline-danger">Danger Outline</button>
        </div>

        <h4>Button Groups</h4>
        <div class="btn-group mb-3">
            <button class="btn btn-primary">Left</button>
            <button class="btn btn-primary">Middle</button>
            <button class="btn btn-primary">Right</button>
        </div>
        
        <br>
        
        <div class="btn-group" role="group">
            <input type="checkbox" class="btn-check" id="checkA">
            <label class="btn btn-outline-primary" for="checkA">Option A</label>
            
            <input type="checkbox" class="btn-check" id="checkB">
            <label class="btn btn-outline-primary" for="checkB">Option B</label>
        </div>
    </div>
</body>
</html>""",
        "readme": """# Exercise 9: Buttons

Just a page showcasing all the different button variants. 
I added regular buttons and the outline versions (`btn-outline-*`) which look really nice on white backgrounds.

I also created a standard button group to attach buttons together, and a toggleable button group. The toggleable one is pretty cool because it's actually just checkboxes styled with `btn-check` and standard button classes on the labels. It acts exactly like a checkbox but looks like a button group.
"""
    },
    {
        "dir": "exercise-10",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Navbars and Tabs</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-dark navbar-dark mb-5">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">MySite</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#myNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="myNav">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item"><a class="nav-link active" href="#">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Profile</a></li>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search...">
                    <button class="btn btn-outline-info" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>

    <div class="container">
        <h4 class="mb-3">Tabs</h4>
        <ul class="nav nav-tabs mb-4">
            <li class="nav-item"><a class="nav-link active" href="#">Overview</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Settings</a></li>
        </ul>

        <h4 class="mb-3">Pills</h4>
        <ul class="nav nav-pills">
            <li class="nav-item"><a class="nav-link active" href="#">Dashboard</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Messages</a></li>
        </ul>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>""",
        "readme": """# Exercise 10: Navigation

I created a fully responsive navbar at the top of the page. It has a dark theme (`navbar-dark bg-dark`) and collapses on smaller screens thanks to `navbar-expand-lg`. I included a search form aligned to the right.

Below the navbar, I added examples of `.nav-tabs` and `.nav-pills`. They're built exactly the same way using `<ul>` and `<li>`, you just change the class name to get a completely different look.
"""
    },
    {
        "dir": "exercise-11",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cards & Media</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h4>Profile Card</h4>
        <div class="card mb-5" style="width: 300px;">
            <img src="https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?w=300" class="card-img-top" alt="Avatar">
            <div class="card-body">
                <h5 class="card-title">Alex Smith</h5>
                <p class="card-text">Full-stack web developer and UI enthusiast.</p>
                <button class="btn btn-primary btn-sm">Follow</button>
            </div>
        </div>

        <h4>Media Layout</h4>
        <div class="d-flex p-3 bg-white border rounded">
            <img src="https://via.placeholder.com/80" class="me-3 rounded-circle" alt="Placeholder">
            <div>
                <h5 class="mb-1">Comment by User</h5>
                <p class="mb-0 text-muted">This is an example of a media layout built with flexbox since Bootstrap 5 got rid of the old media object classes. It works perfectly!</p>
            </div>
        </div>
    </div>
</body>
</html>""",
        "readme": """# Exercise 11: Cards

I built a simple profile card with an image on top (`card-img-top`), a title, description, and a button.

For the second part, since Bootstrap 5 removed the `.media` classes, I recreated the media object layout using flexbox. By putting `d-flex` on the wrapper and `me-3` (margin-right) on the image, we get the exact same layout where the image sits nicely to the left of the text content.
"""
    },
    {
        "dir": "exercise-12",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spacing Utilities</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="bg-light border m-3 p-2">
            This box has <code>m-3</code> (margin all around) and <code>p-2</code> (padding all around).
        </div>
        <div class="bg-light border mt-4 py-5">
            This box has <code>mt-4</code> (margin top) and <code>py-5</code> (padding top and bottom, making it tall).
        </div>

        <h4 class="mt-5 mb-4 text-center">Pricing Plans</h4>
        <div class="row justify-content-center">
            <div class="col-md-4 mb-4">
                <div class="card text-center p-4">
                    <h5>Basic</h5>
                    <h2 class="my-3">$9/mo</h2>
                    <button class="btn btn-outline-primary">Choose Plan</button>
                </div>
            </div>
            <div class="col-md-4 mb-4">
                <div class="card text-center p-4 border-primary">
                    <h5 class="text-primary">Premium</h5>
                    <h2 class="my-3">$29/mo</h2>
                    <button class="btn btn-primary">Choose Plan</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>""",
        "readme": """# Exercise 12: Spacing

Spacing classes in Bootstrap are huge time savers. 

I created a few boxes to demonstrate margin and padding (`m-3`, `py-5`, etc.).
Then I built a pricing section layout. Notice how I used `p-4` to give the cards lots of breathing room inside, and `my-3` (margin on the y-axis) to space out the pricing numbers. It looks super clean without writing any CSS.
"""
    },
    {
        "dir": "exercise-13",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Colors and Backgrounds</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h4>Dashboard Metrics</h4>
        <div class="row text-center mb-5">
            <div class="col-md-3">
                <div class="p-3 bg-primary text-white rounded mb-3">Users: 1.2k</div>
            </div>
            <div class="col-md-3">
                <div class="p-3 bg-success text-white rounded mb-3">Revenue: $5k</div>
            </div>
            <div class="col-md-3">
                <div class="p-3 bg-warning text-dark rounded mb-3">Alerts: 4</div>
            </div>
            <div class="col-md-3">
                <div class="p-3 bg-danger text-white rounded mb-3">Errors: 2</div>
            </div>
        </div>

        <h4>Gradient Background</h4>
        <div class="p-5 bg-dark bg-gradient text-white rounded-3 shadow">
            <h2>Welcome to the platform</h2>
            <p>This hero section looks slightly better than a flat color because of the bg-gradient class.</p>
        </div>
    </div>
</body>
</html>""",
        "readme": """# Exercise 13: Colors & Backgrounds

Here I used Bootstrap's contextual colors to make a little mock dashboard. 
I matched the background colors to the meaning of the metric (success for revenue, danger for errors). Also, I had to use `text-dark` on the warning box because white text is hard to read on a yellow background.

I also added a hero section at the bottom using `bg-dark` combined with `bg-gradient`. It adds a nice subtle fade effect that makes it look a bit more polished.
"""
    },
    {
        "dir": "exercise-14",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Display Utilities</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container-fluid">
        <div class="row" style="min-height: 100vh;">
            <!-- Sidebar -->
            <div class="col-md-3 bg-light border-end d-none d-md-block p-4">
                <h5>App Sidebar</h5>
                <p class="text-muted">You can only see me on tablets and desktops.</p>
            </div>
            
            <!-- Main content -->
            <div class="col-md-9 p-4">
                <h3>Main Dashboard</h3>
                
                <div class="alert alert-warning d-block d-md-none">
                    <strong>Hey!</strong> The sidebar is hidden because you're on a small screen.
                </div>

                <div class="bg-info text-white p-3 rounded d-none d-lg-flex justify-content-between align-items-center">
                    <span>This blue banner is strictly for large desktop screens.</span>
                    <button class="btn btn-light btn-sm">Click me</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>""",
        "readme": """# Exercise 14: Hiding and Showing Things

This exercise is all about responsive visibility.

I created a layout with a sidebar. I added `d-none` to hide it everywhere, and then `d-md-block` to show it again, but only on medium screens and larger. So on mobile, the sidebar completely disappears.

To counteract that, I added a warning alert in the main content area that says "Hey! The sidebar is hidden". I set it to `d-block d-md-none`, meaning it shows on mobile, but hides on tablets and up. Open it and resize your browser to see them swap!
"""
    },
    {
        "dir": "exercise-15",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Borders & Shadows</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5 text-center">
        <img src="https://images.unsplash.com/photo-1544717305-2782549b5136?w=150" 
             class="border border-success border-3 rounded-circle mb-5" alt="Avatar">
             
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card shadow-lg border-0 rounded-4 p-3">
                    <div class="card-body">
                        <h5>Shadow Card</h5>
                        <p class="text-muted">Looks like it's popping off the page.</p>
                        <button class="btn btn-primary rounded-pill w-100">Pill Button</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>""",
        "readme": """# Exercise 15: Borders, Shadows, and Rounded Corners

These small utilities can really change how an app looks.

I took a square image and applied `rounded-circle` to make it a perfect circle avatar. I also gave it a thick green border (`border border-success border-3`).

Below that, I made a card look a bit more modern by taking away the default border (`border-0`), adding a large drop shadow (`shadow-lg`), and increasing the corner radius (`rounded-4`). Inside, there's a button styled with `rounded-pill`.
"""
    },
    {
        "dir": "exercise-16",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Positioning</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="height: 1500px;"> <!-- tall body to test scrolling -->
    
    <div class="container mt-5">
        <h4>Position Relative/Absolute</h4>
        
        <div class="position-relative d-inline-block mt-3">
            <button class="btn btn-secondary px-4 py-2">Notifications</button>
            <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger border border-light">
                5
            </span>
        </div>
        
        <p class="mt-5 text-muted">Scroll all the way down. The footer will follow you.</p>
    </div>

    <div class="position-fixed bottom-0 w-100 bg-dark text-white text-center py-2 shadow">
        I am stuck to the bottom!
    </div>
    
</body>
</html>""",
        "readme": """# Exercise 16: Positioning Utilities

I used `position-relative` on a button wrapper, and then put a badge inside it with `position-absolute top-0 start-100 translate-middle`. This creates that classic red notification dot sitting perfectly on the top-right corner of the button.

I also made the body super tall just to test scrolling, and pinned a dark bar to the bottom of the screen using `position-fixed bottom-0 w-100`. It stays there no matter where you scroll.
"""
    },
    {
        "dir": "exercise-17",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bootstrap Icons</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>
<body>
    <div class="container mt-5">
        <h4 class="mb-4">Icon Buttons</h4>
        <button class="btn btn-outline-primary"><i class="bi bi-pencil"></i></button>
        <button class="btn btn-outline-danger"><i class="bi bi-trash"></i></button>
        <button class="btn btn-outline-secondary"><i class="bi bi-gear"></i></button>
    </div>
    
    <footer class="bg-light py-4 mt-5 border-top text-center">
        <p class="text-muted mb-2">Find me online</p>
        <a href="#" class="text-dark fs-4 mx-2"><i class="bi bi-github"></i></a>
        <a href="#" class="text-primary fs-4 mx-2"><i class="bi bi-twitter"></i></a>
        <a href="#" class="text-danger fs-4 mx-2"><i class="bi bi-youtube"></i></a>
    </footer>
</body>
</html>""",
        "readme": """# Exercise 17: Bootstrap Icons

I brought in the Bootstrap Icons stylesheet from the CDN.

I replaced some standard text buttons with icon-only buttons (like edit, delete, and settings icons).
Then in the footer, I added some social media icons. Because they act just like text fonts, I was able to use standard text utilities like `text-primary` and `fs-4` to change their color and size. Pretty easy!
"""
    },
    {
        "dir": "exercise-18",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JS Plugins</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h4>Modal Test</h4>
        <button type="button" class="btn btn-primary mb-5" data-bs-toggle="modal" data-bs-target="#myModal">
            Open Modal
        </button>

        <div class="modal fade" id="myModal" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Hello!</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body">
                        The JS bundle handles opening and closing this without us writing any code.
                    </div>
                </div>
            </div>
        </div>

        <h4>Accordion</h4>
        <div class="accordion" id="faqAccordion">
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#ans1">
                        Question 1
                    </button>
                </h2>
                <div id="ans1" class="accordion-collapse collapse show" data-bs-parent="#faqAccordion">
                    <div class="accordion-body">This is the answer to question 1.</div>
                </div>
            </div>
            <div class="accordion-item">
                <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#ans2">
                        Question 2
                    </button>
                </h2>
                <div id="ans2" class="accordion-collapse collapse" data-bs-parent="#faqAccordion">
                    <div class="accordion-body">This is the answer to question 2.</div>
                </div>
            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>""",
        "readme": """# Exercise 18: JS Plugins

Here I tested out two components that require JavaScript.

First is the modal popup. I just added `data-bs-toggle="modal"` and `data-bs-target="#myModal"` to the button, and Bootstrap's JS script handles everything else when you click it.

Second is an accordion. Similar logic here—I used data attributes to link the headers to the collapse panels. Giving the collapse panels the `data-bs-parent` attribute ensures that when you open one, the other one automatically closes.
"""
    },
    {
        "dir": "exercise-19",
        "html": """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sass Customization</title>
    <!-- Note: Normally this would point to our compiled custom.css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5 text-center">
        <h2>Sass Config Setup</h2>
        <p>I mocked the files for how I would set this up with npm and Sass.</p>
        <p>Check the files in this folder!</p>
    </div>
</body>
</html>""",
        "readme": """# Exercise 19: Sass Customization

I couldn't really run a full node/Sass compile process just in plain HTML files via CDN, so I mocked out what the setup would look like in a real project.

If you look in this directory, I created a `package.json` with the sass build script, and a `custom.scss` file.
In `custom.scss`, I override `$primary` to be a different color, and `$border-radius` to be slightly larger, then import bootstrap.

If I were to run `npm run build-css`, it would spit out a brand new `custom.css` file with all the Bootstrap classes using my new custom theme settings!
"""
    }
]

for ex in exercises:
    ex_path = os.path.join(base_dir, ex['dir'])
    os.makedirs(ex_path, exist_ok=True)
    
    with open(os.path.join(ex_path, 'index.html'), 'w') as f:
        f.write(ex['html'])
        
    with open(os.path.join(ex_path, 'README.md'), 'w') as f:
        f.write(ex['readme'])
        
    if ex['dir'] == "exercise-19":
        with open(os.path.join(ex_path, 'package.json'), 'w') as f:
            f.write('{\n  "name": "bootstrap-sass",\n  "version": "1.0.0",\n  "scripts": {\n    "build-css": "sass custom.scss custom.css"\n  },\n  "dependencies": {\n    "bootstrap": "^5.3.0"\n  },\n  "devDependencies": {\n    "sass": "^1.62.1"\n  }\n}')
            
        with open(os.path.join(ex_path, 'custom.scss'), 'w') as f:
            f.write('// 1. My custom overrides\n$primary: #6f42c1; // purple\n$border-radius: 1rem;\n\n// 2. Import bootstrap\n@import "../node_modules/bootstrap/scss/bootstrap";')

print("Refactored to organic structure!")
