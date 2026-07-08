# Exercise 23: Registration Trends

**Goal**: Show a month-wise registration count trend over the past 12 months.

I used `DATE_FORMAT(registration_date, '%Y-%m')` to strip the specific day out of the date and group everyone by Year and Month. 
