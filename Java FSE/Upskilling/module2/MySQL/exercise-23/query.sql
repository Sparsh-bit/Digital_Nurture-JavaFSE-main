SELECT 
    DATE_FORMAT(registration_date, '%Y-%m') AS registration_month,
    COUNT(user_id) AS total_users
FROM Users
WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH)
GROUP BY registration_month
ORDER BY registration_month ASC;