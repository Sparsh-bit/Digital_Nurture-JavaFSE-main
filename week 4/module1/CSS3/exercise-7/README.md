# Exercise 7: Table Styling

The admin table looked like it was straight out of 1995, so I spruced it up.

I applied `border-collapse: collapse` so the borders merge into single lines instead of looking double-layered. I also added some padding and centered the text inside the `th` and `td` cells. 

To make the rows easier to read across long screens, I added zebra striping by applying a light gray background to every even row using `.admin-table tbody tr:nth-child(even)`. I threw in a hover effect on the rows as well just as a nice bonus!
