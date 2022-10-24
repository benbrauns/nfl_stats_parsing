DROP TABLE IF EXISTS player, play, game, team CASCADE;

CREATE TABLE player(
	player_id serial,
	status VARCHAR(3),
	display_name VARCHAR(50),
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	esb_id VARCHAR(9),
	gsis_id VARCHAR(10) UNIQUE,
	suffix VARCHAR(8),
	birth_date date,
	college_name VARCHAR(40),
	position_group VARCHAR(5),
	position VARCHAR(5),
	jersey_number int,
	height VARCHAR(7),
	weight int,
	team_abbr VARCHAR(5),
	team_seq VARCHAR(20),
	current_team_id VARCHAR(5),
	football_name VARCHAR(15),
	entry_year int,
	rookie_year int,
	draft_club VARCHAR(5),
	college_conference VARCHAR(100),
	status_description_abbr VARCHAR(5),
	status_short_description VARCHAR(20),
	gsis_it_id int,
	short_name VARCHAR(20),
	smart_id VARCHAR(40),
	headshot VARCHAR(100),
	draft_number int,
	uniform_number VARCHAR(5),
	draft_round int,
	season int,
	CONSTRAINT PK_player PRIMARY KEY (player_id)
);

CREATE TABLE team (
	team_id serial,
	name VARCHAR(100),
	abbr VARCHAR(4) UNIQUE,
	conference VARCHAR(3),
	division VARCHAR(5),
	CONSTRAINT PK_team PRIMARY KEY (team_id)
);

CREATE TABLE game(
	game_id VARCHAR(50) UNIQUE,
	home_team VARCHAR(5),
	away_team VARCHAR(5),
	season int,
	season_type VARCHAR(4),
	week int,
	game_date date,
	CONSTRAINT PK_game PRIMARY KEY (game_id),
	CONSTRAINT FK_game_home_team FOREIGN KEY (home_team) REFERENCES team(abbr),
	CONSTRAINT FK_game_away_team FOREIGN KEY (away_team) REFERENCES team(abbr)
);

--REFERENCE: https://nflreadr.nflverse.com/articles/dictionary_pbp.html
CREATE TABLE play(
	play_id int,
	game_id VARCHAR(50),
	posteam VARCHAR(5),
	defteam VARCHAR(5),
	yardline_100 int,
	game_seconds_remaining int,
	drive int,
	--currently only leaving this so that I can detect overtime as 5
	qtr int,
	down int,
	--yards to either the first down or touchdown. a way to track first down positions
	ydstogo int,
	ydsnet int, --yards gained on the drive
	play_desc text,
	play_type VARCHAR(15),
	yards_gained int, --Numeric yards gained (or lost) by the possessing team, excluding yards gained via fumble recoveries and laterals.
	pass_location VARCHAR(10), --left, middle, right
	run_location VARCHAR(10), --left, middle, right
	run_gap VARCHAR(10), --String indicator for line gap of run: end, guard, or tackle
	
	timeout_team VARCHAR(5),
	posteam_timeouts_remaining int,
	defteam_timeouts_remaining int,
	posteam_score int,
	defteam_score int,
	
	--players and yardage
	td_player_id VARCHAR(10),
		--passing
	passer_player_id VARCHAR(10),
	air_yards int,
	yards_after_catch int,
	passing_yards int,
	receiver_player_id VARCHAR(10),
	receiving_yards int,
		--rushing
	rusher_player_id VARCHAR(10),
	rushing_yards int,
		--defense
	interception_player_id VARCHAR(10),
		--special teams
	punt_returner_player_id VARCHAR(10),
	kickoff_returner_player_id VARCHAR(10),
	punter_player_id VARCHAR(10),
	kicker_player_id VARCHAR(10),
	kick_distance int, --This applies for punts, kickoffs, field goals
	
	
	--probabilities
	opp_fg_prob numeric,
	opp_safety_prob numeric,
	opp_td_prob numeric,
	fg_prob numeric,
	safety_prob numeric,
	td_prob numeric,
	extra_point_prob numeric,
	two_point_conversion_prob numeric,
	ep numeric,
	epa numeric,
	air_epa numeric,
	yac_epa numeric,
	wp numeric,
	def_wp numeric,
	wpa numeric,
	vegas_wpa numeric,
	vegas_wp numeric,
	air_wpa numeric,
	yac_wpa numeric,
	
	--flags
	timeout boolean,
	shotgun boolean,
	no_huddle boolean,
	qb_dropback boolean,
	qb_kneel boolean,
	qb_spike boolean,
	qb_scramble boolean,
	punt_blocked boolean,
	touchback boolean,
	interception boolean,
	fumble boolean,
	fumble_forced boolean,
	fumble_not_forced boolean,
	fumble_out_of_bounds boolean,
	fumble_lost boolean,
	solo_tackle boolean,
	safety boolean,
	penalty boolean,
	qb_hit boolean,
	rush_attmept boolean,
	pass_attempt boolean,
	sack boolean,
	touchdown boolean,
	
	--stopped at kicker_player_id
	
	
	CONSTRAINT PK_play PRIMARY KEY (play_id, game_id),
	CONSTRAINT FK_play_game_id FOREIGN KEY (game_id) REFERENCES game(game_id),
	CONSTRAINT FK_play_posteam FOREIGN KEY (posteam) REFERENCES team(abbr),
	CONSTRAINT FK_play_defteam FOREIGN KEY (defteam) REFERENCES team(abbr),
	CONSTRAINT FK_play_timeout_team FOREIGN KEY (timeout_team) REFERENCES team(abbr),
	CONSTRAINT FK_play_td_player_id FOREIGN KEY (td_player_id) REFERENCES player(gsis_id),
	CONSTRAINT FK_play_passer_player_id FOREIGN KEY (passer_player_id) REFERENCES player(gsis_id),
	CONSTRAINT FK_play_receiver_player_id FOREIGN KEY (receiver_player_id) REFERENCES player(gsis_id),
	CONSTRAINT FK_play_rusher_player_id FOREIGN KEY (rusher_player_id) REFERENCES player(gsis_id),
	CONSTRAINT FK_play_interception_player_id FOREIGN KEY (interception_player_id) REFERENCES player(gsis_id),
	CONSTRAINT FK_play_punt_returner_player_id FOREIGN KEY (punt_returner_player_id) REFERENCES player(gsis_id),
	CONSTRAINT FK_play_kickoff_returner_player_id FOREIGN KEY (kickoff_returner_player_id) REFERENCES player(gsis_id),
	CONSTRAINT FK_play_punter_player_id FOREIGN KEY (punter_player_id) REFERENCES player(gsis_id),
	CONSTRAINT FK_play_kicker_player_id FOREIGN KEY (kicker_player_id) REFERENCES player(gsis_id)
);



