-- Useful queries for the calculator_db

-- All history, most recent first
SELECT * FROM calculation_history ORDER BY created_at DESC;

-- History filtered by calculator type
SELECT * FROM calculation_history WHERE calculator_type = 'BMI' ORDER BY created_at DESC;

-- Count of calculations per type
SELECT calculator_type, COUNT(*) AS total
FROM calculation_history
GROUP BY calculator_type
ORDER BY total DESC;

-- Calculations made today
SELECT * FROM calculation_history
WHERE DATE(created_at) = CURDATE();

-- Delete a single history entry
DELETE FROM calculation_history WHERE id = ?;

-- Clear all history
TRUNCATE TABLE calculation_history;
