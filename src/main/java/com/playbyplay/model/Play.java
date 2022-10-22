package com.playbyplay.model;




public class Play {
    private double play_id;
    private String game_id;
    private String old_game_id;
    private String home_team;
    private String away_team;
    private String season_type;
    private int week;
    private String posTeam;
    private String posTeam_type;
    private String defTeam;
    private String side_of_field;
    private double yardline_100;
    private String game_date;
    private double quarter_seconds_remaining;
    private double half_seconds_remaining;
    private double game_seconds_remaining;
    private String game_half;
    private double quarter_end;
    private double drive;
    private double sp;
    private double qtr;
    private double down;
    private double goal_to_go;
    private String time;
    private String yrdln;
    private double ydstogo;
    private double ydsnet;
    private String desc;
    private String play_type;
    private double yards_gained;
    private double shotgun;
    private double no_huddle;
    private double qb_dropback;
    private double qb_kneel;
    private double qb_spike;
    private double qb_scramble;
    private String pass_legnth;
    private String pass_location;
    private double air_yards;
    private double yards_after_catch;
    private String run_location;
    private String run_gap;
    private String field_goal_result;
    private double kick_distance;
    private String extra_point_result;
    private String two_point_conv_result;
    private double home_timeouts_remaining;
    private double away_timeouts_remaining;
    private double timeout;
    private String timeout_team;
    private String td_team;
    private String td_player_name;
    private String td_player_id;
    private double posteam_timeouts_remaining;
    private double defteam_timeouts_remaining;
    private double total_home_score;
    private double total_away_score;
    private double posteam_score;
    private double defteam_score;
    private double score_differential;
    private double posteam_score_post;
    private double defteam_score_post;
    private double score_differential_post;
    private double no_score_prob;
    private double opp_fg_prob;
    private double opp_safety_prob;
    private double opp_td_prob;
    private double fg_prob;
    private double safety_prob;
    private double td_prob;
    private double extra_point_prob;
    private double two_point_conversion_prob;
    private double ep;
    private double epa;
    private double total_home_epa;
    private double total_away_epa;
    private double total_home_rush_epa;
    private double total_away_rush_epa;
    private double total_home_pass_epa;
    private double total_away_pass_epa;
    private double air_epa;
    private double yac_epa;
    private double comp_air_epa;
    private double comp_yac_epa;
    private double total_home_comp_air_epa;
    private double total_away_comp_air_epa;
    private double total_home_comp_yac_epa;
    private double total_away_comp_yac_epa;
    private double total_home_raw_air_epa;
    private double total_away_raw_air_epa;
    private double total_home_raw_yac_epa;
    private double total_away_raw_yac_epa;
    private double wp;
    private double def_wp;
    private double home_wp;
    private double away_wp;
    private double wpa;
    private double vegas_wpa;
    private double vegas_home_wpa;
    private double home_wp_post;
    private double away_wp_post;
    private double vegas_wp;
    private double vegas_home_wp;
    private double total_home_rush_wpa;
    private double total_away_rush_wpa;
    private double total_home_pass_wpa;
    private double total_away_pass_wpa;
    private double air_wpa;
    private double yac_wpa;
    private double comp_air_wpa;
    private double comp_yac_wpa;
    private double total_home_comp_air_wpa;
    private double total_away_comp_air_wpa;
    private double total_home_comp_yac_wpa;
    private double total_away_comp_yac_wpa;
    private double total_home_raw_air_wpa;
    private double total_away_raw_air_wpa;
    private double total_home_raw_yac_wpa;
    private double total_away_raw_yac_wpa;
    private double punt_blocked;
    private double first_down_rush;
    private double first_down_pass;
    private double first_down_penalty;
    private double third_down_converted;
    private double third_down_failed;
    private double fourth_down_converted;
    private double fourth_down_failed;
    private double incomplete_pass;
    private double touchback;
    private double interception;
    private double punt_inside_twenty;
    private double punt_in_endzone;
    private double punt_out_of_bounds;
    private double punt_downed;
    private double punt_fair_catch;
    private double kickoff_inside_twenty;
    private double kickoff_in_endzone;
    private double kickoff_out_of_bounds;
    private double kickoff_downed;
    private double kickoff_fair_catch;
    private double fumble_forced;
    private double fumble_not_forced;
    private double fumble_out_of_bounds;
    private double solo_tackle;
    private double safety;
    private double penalty;
    private double tackled_for_loss;
    private double fumble_lost;
    private double own_kickoff_recovery;
    private double own_kickoff_recover_td;
    private double qb_hit;
    private double rush_attempt;
    private double pass_attempt;
    private double sack;
    private double touchdown;
    private double pass_touchdown;
    private double rush_touchdown;
    private double return_touchdown;
    private double extra_point_attempt;
    private double two_point_attempt;
    private double field_goal_attempt;
    private double kickoff_attempt;
    private double punt_attempt;
    private double fumble;
    private double complete_pass;
    private double assist_tackle;
    private double lateral_reception;
    private double lateral_rush;
    private double lateral_return;
    private double lateral_recovery;
    private String passer_player_id;
    private String passer_player_name;
    private double passing_yards;
    private String receiver_player_id;
    private String receiver_player_name;
    private double receiving_yards;
    private String rusher_player_id;
    private String rusher_player_name;
    private double rushing_yards;
    private String lateral_receiver_player_id;
    private String lateral_receiver_player_name;
    private double lateral_receiving_yards;
    private String lateral_rusher_player_id;
    private String lateral_rusher_player_name;
    private double lateral_rushing_yards;
    private String lateral_sack_player_id;
    private String lateral_sack_player_name;
    private String interception_player_id;
    private String interception_player_name;
    private String lateral_interception_player_id;
    private String lateral_interception_player_name;
    private String punt_returner_player_id;
    private String punt_returner_player_name;
    private String lateral_punt_returner_player_id;
    private String lateral_punt_returner_player_name;
    private String kickoff_returner_player_id;
    private String kickoff_returner_player_name;
    private String lateral_kickoff_returner_player_id;
    private String lateral_kickoff_returner_player_name;

    public double getPlay_id() {
        return play_id;
    }

    public void setPlay_id(double play_id) {
        this.play_id = play_id;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public String getOld_game_id() {
        return old_game_id;
    }

    public void setOld_game_id(String old_game_id) {
        this.old_game_id = old_game_id;
    }

    public String getHome_team() {
        return home_team;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }

    public String getAway_team() {
        return away_team;
    }

    public void setAway_team(String away_team) {
        this.away_team = away_team;
    }

    public String getSeason_type() {
        return season_type;
    }

    public void setSeason_type(String season_type) {
        this.season_type = season_type;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getPosTeam() {
        return posTeam;
    }

    public void setPosTeam(String posTeam) {
        this.posTeam = posTeam;
    }

    public String getPosTeam_type() {
        return posTeam_type;
    }

    public void setPosTeam_type(String posTeam_type) {
        this.posTeam_type = posTeam_type;
    }

    public String getDefTeam() {
        return defTeam;
    }

    public void setDefTeam(String defTeam) {
        this.defTeam = defTeam;
    }

    public String getSide_of_field() {
        return side_of_field;
    }

    public void setSide_of_field(String side_of_field) {
        this.side_of_field = side_of_field;
    }

    public double getYardline_100() {
        return yardline_100;
    }

    public void setYardline_100(double yardline_100) {
        this.yardline_100 = yardline_100;
    }

    public String getGame_date() {
        return game_date;
    }

    public void setGame_date(String game_date) {
        this.game_date = game_date;
    }

    public double getQuarter_seconds_remaining() {
        return quarter_seconds_remaining;
    }

    public void setQuarter_seconds_remaining(double quarter_seconds_remaining) {
        this.quarter_seconds_remaining = quarter_seconds_remaining;
    }

    public double getHalf_seconds_remaining() {
        return half_seconds_remaining;
    }

    public void setHalf_seconds_remaining(double half_seconds_remaining) {
        this.half_seconds_remaining = half_seconds_remaining;
    }

    public double getGame_seconds_remaining() {
        return game_seconds_remaining;
    }

    public void setGame_seconds_remaining(double game_seconds_remaining) {
        this.game_seconds_remaining = game_seconds_remaining;
    }

    public String getGame_half() {
        return game_half;
    }

    public void setGame_half(String game_half) {
        this.game_half = game_half;
    }

    public double getQuarter_end() {
        return quarter_end;
    }

    public void setQuarter_end(double quarter_end) {
        this.quarter_end = quarter_end;
    }

    public double getDrive() {
        return drive;
    }

    public void setDrive(double drive) {
        this.drive = drive;
    }

    public double getSp() {
        return sp;
    }

    public void setSp(double sp) {
        this.sp = sp;
    }

    public double getQtr() {
        return qtr;
    }

    public void setQtr(double qtr) {
        this.qtr = qtr;
    }

    public double getDown() {
        return down;
    }

    public void setDown(double down) {
        this.down = down;
    }

    public double getGoal_to_go() {
        return goal_to_go;
    }

    public void setGoal_to_go(double goal_to_go) {
        this.goal_to_go = goal_to_go;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getYrdln() {
        return yrdln;
    }

    public void setYrdln(String yrdln) {
        this.yrdln = yrdln;
    }

    public double getYdstogo() {
        return ydstogo;
    }

    public void setYdstogo(double ydstogo) {
        this.ydstogo = ydstogo;
    }

    public double getYdsnet() {
        return ydsnet;
    }

    public void setYdsnet(double ydsnet) {
        this.ydsnet = ydsnet;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPlay_type() {
        return play_type;
    }

    public void setPlay_type(String play_type) {
        this.play_type = play_type;
    }

    public double getYards_gained() {
        return yards_gained;
    }

    public void setYards_gained(double yards_gained) {
        this.yards_gained = yards_gained;
    }

    public double getShotgun() {
        return shotgun;
    }

    public void setShotgun(double shotgun) {
        this.shotgun = shotgun;
    }

    public double getNo_huddle() {
        return no_huddle;
    }

    public void setNo_huddle(double no_huddle) {
        this.no_huddle = no_huddle;
    }

    public double getQb_dropback() {
        return qb_dropback;
    }

    public void setQb_dropback(double qb_dropback) {
        this.qb_dropback = qb_dropback;
    }

    public double getQb_kneel() {
        return qb_kneel;
    }

    public void setQb_kneel(double qb_kneel) {
        this.qb_kneel = qb_kneel;
    }

    public double getQb_spike() {
        return qb_spike;
    }

    public void setQb_spike(double qb_spike) {
        this.qb_spike = qb_spike;
    }

    public double getQb_scramble() {
        return qb_scramble;
    }

    public void setQb_scramble(double qb_scramble) {
        this.qb_scramble = qb_scramble;
    }

    public String getPass_legnth() {
        return pass_legnth;
    }

    public void setPass_legnth(String pass_legnth) {
        this.pass_legnth = pass_legnth;
    }

    public String getPass_location() {
        return pass_location;
    }

    public void setPass_location(String pass_location) {
        this.pass_location = pass_location;
    }

    public double getAir_yards() {
        return air_yards;
    }

    public void setAir_yards(double air_yards) {
        this.air_yards = air_yards;
    }

    public double getYards_after_catch() {
        return yards_after_catch;
    }

    public void setYards_after_catch(double yards_after_catch) {
        this.yards_after_catch = yards_after_catch;
    }

    public String getRun_location() {
        return run_location;
    }

    public void setRun_location(String run_location) {
        this.run_location = run_location;
    }

    public String getRun_gap() {
        return run_gap;
    }

    public void setRun_gap(String run_gap) {
        this.run_gap = run_gap;
    }

    public String getField_goal_result() {
        return field_goal_result;
    }

    public void setField_goal_result(String field_goal_result) {
        this.field_goal_result = field_goal_result;
    }

    public double getKick_distance() {
        return kick_distance;
    }

    public void setKick_distance(double kick_distance) {
        this.kick_distance = kick_distance;
    }

    public String getExtra_point_result() {
        return extra_point_result;
    }

    public void setExtra_point_result(String extra_point_result) {
        this.extra_point_result = extra_point_result;
    }

    public String getTwo_point_conv_result() {
        return two_point_conv_result;
    }

    public void setTwo_point_conv_result(String two_point_conv_result) {
        this.two_point_conv_result = two_point_conv_result;
    }

    public double getHome_timeouts_remaining() {
        return home_timeouts_remaining;
    }

    public void setHome_timeouts_remaining(double home_timeouts_remaining) {
        this.home_timeouts_remaining = home_timeouts_remaining;
    }

    public double getAway_timeouts_remaining() {
        return away_timeouts_remaining;
    }

    public void setAway_timeouts_remaining(double away_timeouts_remaining) {
        this.away_timeouts_remaining = away_timeouts_remaining;
    }

    public double getTimeout() {
        return timeout;
    }

    public void setTimeout(double timeout) {
        this.timeout = timeout;
    }

    public String getTimeout_team() {
        return timeout_team;
    }

    public void setTimeout_team(String timeout_team) {
        this.timeout_team = timeout_team;
    }

    public String getTd_team() {
        return td_team;
    }

    public void setTd_team(String td_team) {
        this.td_team = td_team;
    }

    public String getTd_player_name() {
        return td_player_name;
    }

    public void setTd_player_name(String td_player_name) {
        this.td_player_name = td_player_name;
    }

    public String getTd_player_id() {
        return td_player_id;
    }

    public void setTd_player_id(String td_player_id) {
        this.td_player_id = td_player_id;
    }

    public double getPosteam_timeouts_remaining() {
        return posteam_timeouts_remaining;
    }

    public void setPosteam_timeouts_remaining(double posteam_timeouts_remaining) {
        this.posteam_timeouts_remaining = posteam_timeouts_remaining;
    }

    public double getDefteam_timeouts_remaining() {
        return defteam_timeouts_remaining;
    }

    public void setDefteam_timeouts_remaining(double defteam_timeouts_remaining) {
        this.defteam_timeouts_remaining = defteam_timeouts_remaining;
    }

    public double getTotal_home_score() {
        return total_home_score;
    }

    public void setTotal_home_score(double total_home_score) {
        this.total_home_score = total_home_score;
    }

    public double getTotal_away_score() {
        return total_away_score;
    }

    public void setTotal_away_score(double total_away_score) {
        this.total_away_score = total_away_score;
    }

    public double getPosteam_score() {
        return posteam_score;
    }

    public void setPosteam_score(double posteam_score) {
        this.posteam_score = posteam_score;
    }

    public double getDefteam_score() {
        return defteam_score;
    }

    public void setDefteam_score(double defteam_score) {
        this.defteam_score = defteam_score;
    }

    public double getScore_differential() {
        return score_differential;
    }

    public void setScore_differential(double score_differential) {
        this.score_differential = score_differential;
    }

    public double getPosteam_score_post() {
        return posteam_score_post;
    }

    public void setPosteam_score_post(double posteam_score_post) {
        this.posteam_score_post = posteam_score_post;
    }

    public double getDefteam_score_post() {
        return defteam_score_post;
    }

    public void setDefteam_score_post(double defteam_score_post) {
        this.defteam_score_post = defteam_score_post;
    }

    public double getScore_differential_post() {
        return score_differential_post;
    }

    public void setScore_differential_post(double score_differential_post) {
        this.score_differential_post = score_differential_post;
    }

    public double getNo_score_prob() {
        return no_score_prob;
    }

    public void setNo_score_prob(double no_score_prob) {
        this.no_score_prob = no_score_prob;
    }

    public double getOpp_fg_prob() {
        return opp_fg_prob;
    }

    public void setOpp_fg_prob(double opp_fg_prob) {
        this.opp_fg_prob = opp_fg_prob;
    }

    public double getOpp_safety_prob() {
        return opp_safety_prob;
    }

    public void setOpp_safety_prob(double opp_safety_prob) {
        this.opp_safety_prob = opp_safety_prob;
    }

    public double getOpp_td_prob() {
        return opp_td_prob;
    }

    public void setOpp_td_prob(double opp_td_prob) {
        this.opp_td_prob = opp_td_prob;
    }

    public double getFg_prob() {
        return fg_prob;
    }

    public void setFg_prob(double fg_prob) {
        this.fg_prob = fg_prob;
    }

    public double getSafety_prob() {
        return safety_prob;
    }

    public void setSafety_prob(double safety_prob) {
        this.safety_prob = safety_prob;
    }

    public double getTd_prob() {
        return td_prob;
    }

    public void setTd_prob(double td_prob) {
        this.td_prob = td_prob;
    }

    public double getExtra_point_prob() {
        return extra_point_prob;
    }

    public void setExtra_point_prob(double extra_point_prob) {
        this.extra_point_prob = extra_point_prob;
    }

    public double getTwo_point_conversion_prob() {
        return two_point_conversion_prob;
    }

    public void setTwo_point_conversion_prob(double two_point_conversion_prob) {
        this.two_point_conversion_prob = two_point_conversion_prob;
    }

    public double getEp() {
        return ep;
    }

    public void setEp(double ep) {
        this.ep = ep;
    }

    public double getEpa() {
        return epa;
    }

    public void setEpa(double epa) {
        this.epa = epa;
    }

    public double getTotal_home_epa() {
        return total_home_epa;
    }

    public void setTotal_home_epa(double total_home_epa) {
        this.total_home_epa = total_home_epa;
    }

    public double getTotal_away_epa() {
        return total_away_epa;
    }

    public void setTotal_away_epa(double total_away_epa) {
        this.total_away_epa = total_away_epa;
    }

    public double getTotal_home_rush_epa() {
        return total_home_rush_epa;
    }

    public void setTotal_home_rush_epa(double total_home_rush_epa) {
        this.total_home_rush_epa = total_home_rush_epa;
    }

    public double getTotal_away_rush_epa() {
        return total_away_rush_epa;
    }

    public void setTotal_away_rush_epa(double total_away_rush_epa) {
        this.total_away_rush_epa = total_away_rush_epa;
    }

    public double getTotal_home_pass_epa() {
        return total_home_pass_epa;
    }

    public void setTotal_home_pass_epa(double total_home_pass_epa) {
        this.total_home_pass_epa = total_home_pass_epa;
    }

    public double getTotal_away_pass_epa() {
        return total_away_pass_epa;
    }

    public void setTotal_away_pass_epa(double total_away_pass_epa) {
        this.total_away_pass_epa = total_away_pass_epa;
    }

    public double getAir_epa() {
        return air_epa;
    }

    public void setAir_epa(double air_epa) {
        this.air_epa = air_epa;
    }

    public double getYac_epa() {
        return yac_epa;
    }

    public void setYac_epa(double yac_epa) {
        this.yac_epa = yac_epa;
    }

    public double getComp_air_epa() {
        return comp_air_epa;
    }

    public void setComp_air_epa(double comp_air_epa) {
        this.comp_air_epa = comp_air_epa;
    }

    public double getComp_yac_epa() {
        return comp_yac_epa;
    }

    public void setComp_yac_epa(double comp_yac_epa) {
        this.comp_yac_epa = comp_yac_epa;
    }

    public double getTotal_home_comp_air_epa() {
        return total_home_comp_air_epa;
    }

    public void setTotal_home_comp_air_epa(double total_home_comp_air_epa) {
        this.total_home_comp_air_epa = total_home_comp_air_epa;
    }

    public double getTotal_away_comp_air_epa() {
        return total_away_comp_air_epa;
    }

    public void setTotal_away_comp_air_epa(double total_away_comp_air_epa) {
        this.total_away_comp_air_epa = total_away_comp_air_epa;
    }

    public double getTotal_home_comp_yac_epa() {
        return total_home_comp_yac_epa;
    }

    public void setTotal_home_comp_yac_epa(double total_home_comp_yac_epa) {
        this.total_home_comp_yac_epa = total_home_comp_yac_epa;
    }

    public double getTotal_away_comp_yac_epa() {
        return total_away_comp_yac_epa;
    }

    public void setTotal_away_comp_yac_epa(double total_away_comp_yac_epa) {
        this.total_away_comp_yac_epa = total_away_comp_yac_epa;
    }

    public double getTotal_home_raw_air_epa() {
        return total_home_raw_air_epa;
    }

    public void setTotal_home_raw_air_epa(double total_home_raw_air_epa) {
        this.total_home_raw_air_epa = total_home_raw_air_epa;
    }

    public double getTotal_away_raw_air_epa() {
        return total_away_raw_air_epa;
    }

    public void setTotal_away_raw_air_epa(double total_away_raw_air_epa) {
        this.total_away_raw_air_epa = total_away_raw_air_epa;
    }

    public double getTotal_home_raw_yac_epa() {
        return total_home_raw_yac_epa;
    }

    public void setTotal_home_raw_yac_epa(double total_home_raw_yac_epa) {
        this.total_home_raw_yac_epa = total_home_raw_yac_epa;
    }

    public double getTotal_away_raw_yac_epa() {
        return total_away_raw_yac_epa;
    }

    public void setTotal_away_raw_yac_epa(double total_away_raw_yac_epa) {
        this.total_away_raw_yac_epa = total_away_raw_yac_epa;
    }

    public double getWp() {
        return wp;
    }

    public void setWp(double wp) {
        this.wp = wp;
    }

    public double getDef_wp() {
        return def_wp;
    }

    public void setDef_wp(double def_wp) {
        this.def_wp = def_wp;
    }

    public double getHome_wp() {
        return home_wp;
    }

    public void setHome_wp(double home_wp) {
        this.home_wp = home_wp;
    }

    public double getAway_wp() {
        return away_wp;
    }

    public void setAway_wp(double away_wp) {
        this.away_wp = away_wp;
    }

    public double getWpa() {
        return wpa;
    }

    public void setWpa(double wpa) {
        this.wpa = wpa;
    }

    public double getVegas_wpa() {
        return vegas_wpa;
    }

    public void setVegas_wpa(double vegas_wpa) {
        this.vegas_wpa = vegas_wpa;
    }

    public double getVegas_home_wpa() {
        return vegas_home_wpa;
    }

    public void setVegas_home_wpa(double vegas_home_wpa) {
        this.vegas_home_wpa = vegas_home_wpa;
    }

    public double getHome_wp_post() {
        return home_wp_post;
    }

    public void setHome_wp_post(double home_wp_post) {
        this.home_wp_post = home_wp_post;
    }

    public double getAway_wp_post() {
        return away_wp_post;
    }

    public void setAway_wp_post(double away_wp_post) {
        this.away_wp_post = away_wp_post;
    }

    public double getVegas_wp() {
        return vegas_wp;
    }

    public void setVegas_wp(double vegas_wp) {
        this.vegas_wp = vegas_wp;
    }

    public double getVegas_home_wp() {
        return vegas_home_wp;
    }

    public void setVegas_home_wp(double vegas_home_wp) {
        this.vegas_home_wp = vegas_home_wp;
    }

    public double getTotal_home_rush_wpa() {
        return total_home_rush_wpa;
    }

    public void setTotal_home_rush_wpa(double total_home_rush_wpa) {
        this.total_home_rush_wpa = total_home_rush_wpa;
    }

    public double getTotal_away_rush_wpa() {
        return total_away_rush_wpa;
    }

    public void setTotal_away_rush_wpa(double total_away_rush_wpa) {
        this.total_away_rush_wpa = total_away_rush_wpa;
    }

    public double getTotal_home_pass_wpa() {
        return total_home_pass_wpa;
    }

    public void setTotal_home_pass_wpa(double total_home_pass_wpa) {
        this.total_home_pass_wpa = total_home_pass_wpa;
    }

    public double getTotal_away_pass_wpa() {
        return total_away_pass_wpa;
    }

    public void setTotal_away_pass_wpa(double total_away_pass_wpa) {
        this.total_away_pass_wpa = total_away_pass_wpa;
    }

    public double getAir_wpa() {
        return air_wpa;
    }

    public void setAir_wpa(double air_wpa) {
        this.air_wpa = air_wpa;
    }

    public double getYac_wpa() {
        return yac_wpa;
    }

    public void setYac_wpa(double yac_wpa) {
        this.yac_wpa = yac_wpa;
    }

    public double getComp_air_wpa() {
        return comp_air_wpa;
    }

    public void setComp_air_wpa(double comp_air_wpa) {
        this.comp_air_wpa = comp_air_wpa;
    }

    public double getComp_yac_wpa() {
        return comp_yac_wpa;
    }

    public void setComp_yac_wpa(double comp_yac_wpa) {
        this.comp_yac_wpa = comp_yac_wpa;
    }

    public double getTotal_home_comp_air_wpa() {
        return total_home_comp_air_wpa;
    }

    public void setTotal_home_comp_air_wpa(double total_home_comp_air_wpa) {
        this.total_home_comp_air_wpa = total_home_comp_air_wpa;
    }

    public double getTotal_away_comp_air_wpa() {
        return total_away_comp_air_wpa;
    }

    public void setTotal_away_comp_air_wpa(double total_away_comp_air_wpa) {
        this.total_away_comp_air_wpa = total_away_comp_air_wpa;
    }

    public double getTotal_home_comp_yac_wpa() {
        return total_home_comp_yac_wpa;
    }

    public void setTotal_home_comp_yac_wpa(double total_home_comp_yac_wpa) {
        this.total_home_comp_yac_wpa = total_home_comp_yac_wpa;
    }

    public double getTotal_away_comp_yac_wpa() {
        return total_away_comp_yac_wpa;
    }

    public void setTotal_away_comp_yac_wpa(double total_away_comp_yac_wpa) {
        this.total_away_comp_yac_wpa = total_away_comp_yac_wpa;
    }

    public double getTotal_home_raw_air_wpa() {
        return total_home_raw_air_wpa;
    }

    public void setTotal_home_raw_air_wpa(double total_home_raw_air_wpa) {
        this.total_home_raw_air_wpa = total_home_raw_air_wpa;
    }

    public double getTotal_away_raw_air_wpa() {
        return total_away_raw_air_wpa;
    }

    public void setTotal_away_raw_air_wpa(double total_away_raw_air_wpa) {
        this.total_away_raw_air_wpa = total_away_raw_air_wpa;
    }

    public double getTotal_home_raw_yac_wpa() {
        return total_home_raw_yac_wpa;
    }

    public void setTotal_home_raw_yac_wpa(double total_home_raw_yac_wpa) {
        this.total_home_raw_yac_wpa = total_home_raw_yac_wpa;
    }

    public double getTotal_away_raw_yac_wpa() {
        return total_away_raw_yac_wpa;
    }

    public void setTotal_away_raw_yac_wpa(double total_away_raw_yac_wpa) {
        this.total_away_raw_yac_wpa = total_away_raw_yac_wpa;
    }

    public double getPunt_blocked() {
        return punt_blocked;
    }

    public void setPunt_blocked(double punt_blocked) {
        this.punt_blocked = punt_blocked;
    }

    public double getFirst_down_rush() {
        return first_down_rush;
    }

    public void setFirst_down_rush(double first_down_rush) {
        this.first_down_rush = first_down_rush;
    }

    public double getFirst_down_pass() {
        return first_down_pass;
    }

    public void setFirst_down_pass(double first_down_pass) {
        this.first_down_pass = first_down_pass;
    }

    public double getFirst_down_penalty() {
        return first_down_penalty;
    }

    public void setFirst_down_penalty(double first_down_penalty) {
        this.first_down_penalty = first_down_penalty;
    }

    public double getThird_down_converted() {
        return third_down_converted;
    }

    public void setThird_down_converted(double third_down_converted) {
        this.third_down_converted = third_down_converted;
    }

    public double getThird_down_failed() {
        return third_down_failed;
    }

    public void setThird_down_failed(double third_down_failed) {
        this.third_down_failed = third_down_failed;
    }

    public double getFourth_down_converted() {
        return fourth_down_converted;
    }

    public void setFourth_down_converted(double fourth_down_converted) {
        this.fourth_down_converted = fourth_down_converted;
    }

    public double getFourth_down_failed() {
        return fourth_down_failed;
    }

    public void setFourth_down_failed(double fourth_down_failed) {
        this.fourth_down_failed = fourth_down_failed;
    }

    public double getIncomplete_pass() {
        return incomplete_pass;
    }

    public void setIncomplete_pass(double incomplete_pass) {
        this.incomplete_pass = incomplete_pass;
    }

    public double getTouchback() {
        return touchback;
    }

    public void setTouchback(double touchback) {
        this.touchback = touchback;
    }

    public double getInterception() {
        return interception;
    }

    public void setInterception(double interception) {
        this.interception = interception;
    }

    public double getPunt_inside_twenty() {
        return punt_inside_twenty;
    }

    public void setPunt_inside_twenty(double punt_inside_twenty) {
        this.punt_inside_twenty = punt_inside_twenty;
    }

    public double getPunt_in_endzone() {
        return punt_in_endzone;
    }

    public void setPunt_in_endzone(double punt_in_endzone) {
        this.punt_in_endzone = punt_in_endzone;
    }

    public double getPunt_out_of_bounds() {
        return punt_out_of_bounds;
    }

    public void setPunt_out_of_bounds(double punt_out_of_bounds) {
        this.punt_out_of_bounds = punt_out_of_bounds;
    }

    public double getPunt_downed() {
        return punt_downed;
    }

    public void setPunt_downed(double punt_downed) {
        this.punt_downed = punt_downed;
    }

    public double getPunt_fair_catch() {
        return punt_fair_catch;
    }

    public void setPunt_fair_catch(double punt_fair_catch) {
        this.punt_fair_catch = punt_fair_catch;
    }

    public double getKickoff_inside_twenty() {
        return kickoff_inside_twenty;
    }

    public void setKickoff_inside_twenty(double kickoff_inside_twenty) {
        this.kickoff_inside_twenty = kickoff_inside_twenty;
    }

    public double getKickoff_in_endzone() {
        return kickoff_in_endzone;
    }

    public void setKickoff_in_endzone(double kickoff_in_endzone) {
        this.kickoff_in_endzone = kickoff_in_endzone;
    }

    public double getKickoff_out_of_bounds() {
        return kickoff_out_of_bounds;
    }

    public void setKickoff_out_of_bounds(double kickoff_out_of_bounds) {
        this.kickoff_out_of_bounds = kickoff_out_of_bounds;
    }

    public double getKickoff_downed() {
        return kickoff_downed;
    }

    public void setKickoff_downed(double kickoff_downed) {
        this.kickoff_downed = kickoff_downed;
    }

    public double getKickoff_fair_catch() {
        return kickoff_fair_catch;
    }

    public void setKickoff_fair_catch(double kickoff_fair_catch) {
        this.kickoff_fair_catch = kickoff_fair_catch;
    }

    public double getFumble_forced() {
        return fumble_forced;
    }

    public void setFumble_forced(double fumble_forced) {
        this.fumble_forced = fumble_forced;
    }

    public double getFumble_not_forced() {
        return fumble_not_forced;
    }

    public void setFumble_not_forced(double fumble_not_forced) {
        this.fumble_not_forced = fumble_not_forced;
    }

    public double getFumble_out_of_bounds() {
        return fumble_out_of_bounds;
    }

    public void setFumble_out_of_bounds(double fumble_out_of_bounds) {
        this.fumble_out_of_bounds = fumble_out_of_bounds;
    }

    public double getSolo_tackle() {
        return solo_tackle;
    }

    public void setSolo_tackle(double solo_tackle) {
        this.solo_tackle = solo_tackle;
    }

    public double getSafety() {
        return safety;
    }

    public void setSafety(double safety) {
        this.safety = safety;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public double getTackled_for_loss() {
        return tackled_for_loss;
    }

    public void setTackled_for_loss(double tackled_for_loss) {
        this.tackled_for_loss = tackled_for_loss;
    }

    public double getFumble_lost() {
        return fumble_lost;
    }

    public void setFumble_lost(double fumble_lost) {
        this.fumble_lost = fumble_lost;
    }

    public double getOwn_kickoff_recovery() {
        return own_kickoff_recovery;
    }

    public void setOwn_kickoff_recovery(double own_kickoff_recovery) {
        this.own_kickoff_recovery = own_kickoff_recovery;
    }

    public double getOwn_kickoff_recover_td() {
        return own_kickoff_recover_td;
    }

    public void setOwn_kickoff_recover_td(double own_kickoff_recover_td) {
        this.own_kickoff_recover_td = own_kickoff_recover_td;
    }

    public double getQb_hit() {
        return qb_hit;
    }

    public void setQb_hit(double qb_hit) {
        this.qb_hit = qb_hit;
    }

    public double getRush_attempt() {
        return rush_attempt;
    }

    public void setRush_attempt(double rush_attempt) {
        this.rush_attempt = rush_attempt;
    }

    public double getPass_attempt() {
        return pass_attempt;
    }

    public void setPass_attempt(double pass_attempt) {
        this.pass_attempt = pass_attempt;
    }

    public double getSack() {
        return sack;
    }

    public void setSack(double sack) {
        this.sack = sack;
    }

    public double getTouchdown() {
        return touchdown;
    }

    public void setTouchdown(double touchdown) {
        this.touchdown = touchdown;
    }

    public double getPass_touchdown() {
        return pass_touchdown;
    }

    public void setPass_touchdown(double pass_touchdown) {
        this.pass_touchdown = pass_touchdown;
    }

    public double getRush_touchdown() {
        return rush_touchdown;
    }

    public void setRush_touchdown(double rush_touchdown) {
        this.rush_touchdown = rush_touchdown;
    }

    public double getReturn_touchdown() {
        return return_touchdown;
    }

    public void setReturn_touchdown(double return_touchdown) {
        this.return_touchdown = return_touchdown;
    }

    public double getExtra_point_attempt() {
        return extra_point_attempt;
    }

    public void setExtra_point_attempt(double extra_point_attempt) {
        this.extra_point_attempt = extra_point_attempt;
    }

    public double getTwo_point_attempt() {
        return two_point_attempt;
    }

    public void setTwo_point_attempt(double two_point_attempt) {
        this.two_point_attempt = two_point_attempt;
    }

    public double getField_goal_attempt() {
        return field_goal_attempt;
    }

    public void setField_goal_attempt(double field_goal_attempt) {
        this.field_goal_attempt = field_goal_attempt;
    }

    public double getKickoff_attempt() {
        return kickoff_attempt;
    }

    public void setKickoff_attempt(double kickoff_attempt) {
        this.kickoff_attempt = kickoff_attempt;
    }

    public double getPunt_attempt() {
        return punt_attempt;
    }

    public void setPunt_attempt(double punt_attempt) {
        this.punt_attempt = punt_attempt;
    }

    public double getFumble() {
        return fumble;
    }

    public void setFumble(double fumble) {
        this.fumble = fumble;
    }

    public double getComplete_pass() {
        return complete_pass;
    }

    public void setComplete_pass(double complete_pass) {
        this.complete_pass = complete_pass;
    }

    public double getAssist_tackle() {
        return assist_tackle;
    }

    public void setAssist_tackle(double assist_tackle) {
        this.assist_tackle = assist_tackle;
    }

    public double getLateral_reception() {
        return lateral_reception;
    }

    public void setLateral_reception(double lateral_reception) {
        this.lateral_reception = lateral_reception;
    }

    public double getLateral_rush() {
        return lateral_rush;
    }

    public void setLateral_rush(double lateral_rush) {
        this.lateral_rush = lateral_rush;
    }

    public double getLateral_return() {
        return lateral_return;
    }

    public void setLateral_return(double lateral_return) {
        this.lateral_return = lateral_return;
    }

    public double getLateral_recovery() {
        return lateral_recovery;
    }

    public void setLateral_recovery(double lateral_recovery) {
        this.lateral_recovery = lateral_recovery;
    }

    public String getPasser_player_id() {
        return passer_player_id;
    }

    public void setPasser_player_id(String passer_player_id) {
        this.passer_player_id = passer_player_id;
    }

    public String getPasser_player_name() {
        return passer_player_name;
    }

    public void setPasser_player_name(String passer_player_name) {
        this.passer_player_name = passer_player_name;
    }

    public double getPassing_yards() {
        return passing_yards;
    }

    public void setPassing_yards(double passing_yards) {
        this.passing_yards = passing_yards;
    }

    public String getReceiver_player_id() {
        return receiver_player_id;
    }

    public void setReceiver_player_id(String receiver_player_id) {
        this.receiver_player_id = receiver_player_id;
    }

    public String getReceiver_player_name() {
        return receiver_player_name;
    }

    public void setReceiver_player_name(String receiver_player_name) {
        this.receiver_player_name = receiver_player_name;
    }

    public double getReceiving_yards() {
        return receiving_yards;
    }

    public void setReceiving_yards(double receiving_yards) {
        this.receiving_yards = receiving_yards;
    }

    public String getRusher_player_id() {
        return rusher_player_id;
    }

    public void setRusher_player_id(String rusher_player_id) {
        this.rusher_player_id = rusher_player_id;
    }

    public String getRusher_player_name() {
        return rusher_player_name;
    }

    public void setRusher_player_name(String rusher_player_name) {
        this.rusher_player_name = rusher_player_name;
    }

    public double getRushing_yards() {
        return rushing_yards;
    }

    public void setRushing_yards(double rushing_yards) {
        this.rushing_yards = rushing_yards;
    }

    public String getLateral_receiver_player_id() {
        return lateral_receiver_player_id;
    }

    public void setLateral_receiver_player_id(String lateral_receiver_player_id) {
        this.lateral_receiver_player_id = lateral_receiver_player_id;
    }

    public String getLateral_receiver_player_name() {
        return lateral_receiver_player_name;
    }

    public void setLateral_receiver_player_name(String lateral_receiver_player_name) {
        this.lateral_receiver_player_name = lateral_receiver_player_name;
    }

    public double getLateral_receiving_yards() {
        return lateral_receiving_yards;
    }

    public void setLateral_receiving_yards(double lateral_receiving_yards) {
        this.lateral_receiving_yards = lateral_receiving_yards;
    }

    public String getLateral_rusher_player_id() {
        return lateral_rusher_player_id;
    }

    public void setLateral_rusher_player_id(String lateral_rusher_player_id) {
        this.lateral_rusher_player_id = lateral_rusher_player_id;
    }

    public String getLateral_rusher_player_name() {
        return lateral_rusher_player_name;
    }

    public void setLateral_rusher_player_name(String lateral_rusher_player_name) {
        this.lateral_rusher_player_name = lateral_rusher_player_name;
    }

    public double getLateral_rushing_yards() {
        return lateral_rushing_yards;
    }

    public void setLateral_rushing_yards(double lateral_rushing_yards) {
        this.lateral_rushing_yards = lateral_rushing_yards;
    }

    public String getLateral_sack_player_id() {
        return lateral_sack_player_id;
    }

    public void setLateral_sack_player_id(String lateral_sack_player_id) {
        this.lateral_sack_player_id = lateral_sack_player_id;
    }

    public String getLateral_sack_player_name() {
        return lateral_sack_player_name;
    }

    public void setLateral_sack_player_name(String lateral_sack_player_name) {
        this.lateral_sack_player_name = lateral_sack_player_name;
    }

    public String getInterception_player_id() {
        return interception_player_id;
    }

    public void setInterception_player_id(String interception_player_id) {
        this.interception_player_id = interception_player_id;
    }

    public String getInterception_player_name() {
        return interception_player_name;
    }

    public void setInterception_player_name(String interception_player_name) {
        this.interception_player_name = interception_player_name;
    }

    public String getLateral_interception_player_id() {
        return lateral_interception_player_id;
    }

    public void setLateral_interception_player_id(String lateral_interception_player_id) {
        this.lateral_interception_player_id = lateral_interception_player_id;
    }

    public String getLateral_interception_player_name() {
        return lateral_interception_player_name;
    }

    public void setLateral_interception_player_name(String lateral_interception_player_name) {
        this.lateral_interception_player_name = lateral_interception_player_name;
    }

    public String getPunt_returner_player_id() {
        return punt_returner_player_id;
    }

    public void setPunt_returner_player_id(String punt_returner_player_id) {
        this.punt_returner_player_id = punt_returner_player_id;
    }

    public String getPunt_returner_player_name() {
        return punt_returner_player_name;
    }

    public void setPunt_returner_player_name(String punt_returner_player_name) {
        this.punt_returner_player_name = punt_returner_player_name;
    }

    public String getLateral_punt_returner_player_id() {
        return lateral_punt_returner_player_id;
    }

    public void setLateral_punt_returner_player_id(String lateral_punt_returner_player_id) {
        this.lateral_punt_returner_player_id = lateral_punt_returner_player_id;
    }

    public String getLateral_punt_returner_player_name() {
        return lateral_punt_returner_player_name;
    }

    public void setLateral_punt_returner_player_name(String lateral_punt_returner_player_name) {
        this.lateral_punt_returner_player_name = lateral_punt_returner_player_name;
    }

    public String getKickoff_returner_player_id() {
        return kickoff_returner_player_id;
    }

    public void setKickoff_returner_player_id(String kickoff_returner_player_id) {
        this.kickoff_returner_player_id = kickoff_returner_player_id;
    }

    public String getKickoff_returner_player_name() {
        return kickoff_returner_player_name;
    }

    public void setKickoff_returner_player_name(String kickoff_returner_player_name) {
        this.kickoff_returner_player_name = kickoff_returner_player_name;
    }

    public String getLateral_kickoff_returner_player_id() {
        return lateral_kickoff_returner_player_id;
    }

    public void setLateral_kickoff_returner_player_id(String lateral_kickoff_returner_player_id) {
        this.lateral_kickoff_returner_player_id = lateral_kickoff_returner_player_id;
    }

    public String getLateral_kickoff_returner_player_name() {
        return lateral_kickoff_returner_player_name;
    }

    public void setLateral_kickoff_returner_player_name(String lateral_kickoff_returner_player_name) {
        this.lateral_kickoff_returner_player_name = lateral_kickoff_returner_player_name;
    }
}
