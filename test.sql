SELECT penalty_team, count(*) as penalty_count, sum(penalty_yards) as total
FROM play
WHERE penalty_team IS NOT NULL
GROUP BY penalty_team
ORDER BY total DESC;
