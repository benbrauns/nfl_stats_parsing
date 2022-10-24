SELECT season, COUNT(*) AS attempts, sum(rushing_yards) AS yards
FROM play
JOIN game ON play.game_id = game.game_id
WHERE rusher_player_id = (
	SELECT gsis_id
	FROM player
	WHERE display_name = 'Aaron Rodgers'
	AND status = 'ACT'
)
AND season_type = 'REG'
GROUP BY season
ORDER BY season;

SELECT COUNT(*)
FROM play;

SELECT player.display_name, SUM(receiving_yards) / COUNT(*)
FROM play
JOIN player ON play.receiver_player_id = player.gsis_id
WHERE posteam = 'GB'
AND pass_attempt = true
GROUP BY player.display_name
ORDER BY SUM(receiving_yards) / COUNT(*) DESC;


SELECT player.display_name, SUM(passing_yards) / COUNT(*)
FROM player
JOIN play ON player.gsis_id = play.passer_player_id
JOIN game ON play.game_id = game.game_id
WHERE pass_attempt = true
AND EXTRACT(MONTH FROM game.game_date) = 10
AND EXTRACT(ISODOW FROM game.game_date) = 1
GROUP BY player.display_name
ORDER BY SUM(passing_yards) / COUNT(*) DESC;

SELECT *
FROM player
WHERE display_name = 'Drew Bennett';

