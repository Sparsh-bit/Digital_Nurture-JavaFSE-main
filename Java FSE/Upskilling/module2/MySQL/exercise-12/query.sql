WITH SessionCounts AS (
    SELECT event_id, COUNT(session_id) AS total_sessions
    FROM Sessions
    GROUP BY event_id
)
SELECT e.title, sc.total_sessions
FROM Events e
JOIN SessionCounts sc ON e.event_id = sc.event_id
WHERE sc.total_sessions = (SELECT MAX(total_sessions) FROM SessionCounts);