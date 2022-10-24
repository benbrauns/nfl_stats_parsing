package com.playbyplay.model;


import java.math.BigDecimal;

public class Play {
    private Integer play_id;
    private String game_id;
    private String posteam;
    private String defteam;
    private Integer yardline_100;
    private Integer game_seconds_remaining;
    private Integer drive;
    private Integer qtr;
    private Integer down;
    private Integer ydstogo;
    private Integer ydsnet;
    //desc
    private String play_desc;
    private String play_type;
    private Integer yards_gained;
    private String pass_location;
    private String run_location;
    private String run_gap;

    private String timeout_team;
    private Integer posteam_timeouts_remaining;
    private Integer defteam_timeouts_remaining;
    private Integer posteam_score;
    private Integer defteam_score;

    //players and yardage
    private String td_player_id;
    private String passer_player_id;
    private Integer air_yards;
    private Integer yards_after_catch;
    private Integer passing_yards;
    private String receiver_player_id;
    private Integer receiving_yards;
        //rushing
    private String rusher_player_id;
    private Integer rushing_yards;
        //defense
    private String interception_player_id;
        //special teams
    private String punt_returner_player_id;
    private String kickoff_returner_player_id;
    private String punter_player_id;
    private String kicker_player_id;
    private Integer kick_distance;

    //probabilities
    private BigDecimal opp_fg_prob;
    private BigDecimal opp_safety_prob;
    private BigDecimal opp_td_prob;
    private BigDecimal fg_prob;
    private BigDecimal safety_prob;
    private BigDecimal td_prob;
    private BigDecimal extra_point_prob;
    private BigDecimal two_point_conversion_prob;
    private BigDecimal ep;
    private BigDecimal epa;
    private BigDecimal air_epa;
    private BigDecimal yac_epa;
    private BigDecimal wp;
    private BigDecimal def_wp;
    private BigDecimal wpa;
    private BigDecimal vegas_wpa;
    private BigDecimal vegas_wp;
    private BigDecimal air_wpa;
    private BigDecimal yac_wpa;

    //flags
    private Boolean timeout;
    private Boolean shotgun;
    private Boolean no_huddle;
    private Boolean qb_dropback;
    private Boolean qb_kneel;
    private Boolean qb_spike;
    private Boolean qb_scramble;
    private Boolean punt_blocked;
    private Boolean touchback;
    private Boolean interception;
    private Boolean fumble;
    private Boolean fumble_forced;
    private Boolean fumble_out_of_bounds;
    private Boolean fumble_lost;
    private Boolean solo_tackle;
    private Boolean safety;
    private Boolean penalty;
    private Boolean qb_hit;
    private Boolean rush_attmept;
    private Boolean pass_attempt;
    private Boolean sack;
    private Boolean touchdown;

    public Integer getPlay_id() {
        return play_id;
    }

    public void setPlay_id(Integer play_id) {
        this.play_id = play_id;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public String getPosteam() {
        return posteam;
    }

    public void setPosteam(String posteam) {
        this.posteam = posteam;
    }

    public String getDefteam() {
        return defteam;
    }

    public void setDefteam(String defteam) {
        this.defteam = defteam;
    }

    public Integer getYardline_100() {
        return yardline_100;
    }

    public void setYardline_100(Integer yardline_100) {
        this.yardline_100 = yardline_100;
    }

    public Integer getGame_seconds_remaining() {
        return game_seconds_remaining;
    }

    public void setGame_seconds_remaining(Integer game_seconds_remaining) {
        this.game_seconds_remaining = game_seconds_remaining;
    }

    public Integer getDrive() {
        return drive;
    }

    public void setDrive(Integer drive) {
        this.drive = drive;
    }

    public Integer getQtr() {
        return qtr;
    }

    public void setQtr(Integer qtr) {
        this.qtr = qtr;
    }

    public Integer getDown() {
        return down;
    }

    public void setDown(Integer down) {
        this.down = down;
    }

    public Integer getYdstogo() {
        return ydstogo;
    }

    public void setYdstogo(Integer ydstogo) {
        this.ydstogo = ydstogo;
    }

    public Integer getYdsnet() {
        return ydsnet;
    }

    public void setYdsnet(Integer ydsnet) {
        this.ydsnet = ydsnet;
    }

    public String getPlay_desc() {
        return play_desc;
    }

    public void setPlay_desc(String play_desc) {
        this.play_desc = play_desc;
    }

    public String getPlay_type() {
        return play_type;
    }

    public void setPlay_type(String play_type) {
        this.play_type = play_type;
    }

    public Integer getYards_gained() {
        return yards_gained;
    }

    public void setYards_gained(Integer yards_gained) {
        this.yards_gained = yards_gained;
    }

    public String getPass_location() {
        return pass_location;
    }

    public void setPass_location(String pass_location) {
        this.pass_location = pass_location;
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

    public String getTimeout_team() {
        return timeout_team;
    }

    public void setTimeout_team(String timeout_team) {
        this.timeout_team = timeout_team;
    }

    public Integer getPosteam_timeouts_remaining() {
        return posteam_timeouts_remaining;
    }

    public void setPosteam_timeouts_remaining(Integer posteam_timeouts_remaining) {
        this.posteam_timeouts_remaining = posteam_timeouts_remaining;
    }

    public Integer getDefteam_timeouts_remaining() {
        return defteam_timeouts_remaining;
    }

    public void setDefteam_timeouts_remaining(Integer defteam_timeouts_remaining) {
        this.defteam_timeouts_remaining = defteam_timeouts_remaining;
    }

    public Integer getPosteam_score() {
        return posteam_score;
    }

    public void setPosteam_score(Integer posteam_score) {
        this.posteam_score = posteam_score;
    }

    public Integer getDefteam_score() {
        return defteam_score;
    }

    public void setDefteam_score(Integer defteam_score) {
        this.defteam_score = defteam_score;
    }

    public String getTd_player_id() {
        return td_player_id;
    }

    public void setTd_player_id(String td_player_id) {
        this.td_player_id = td_player_id;
    }

    public String getPasser_player_id() {
        return passer_player_id;
    }

    public void setPasser_player_id(String passer_player_id) {
        this.passer_player_id = passer_player_id;
    }

    public Integer getAir_yards() {
        return air_yards;
    }

    public void setAir_yards(Integer air_yards) {
        this.air_yards = air_yards;
    }

    public Integer getYards_after_catch() {
        return yards_after_catch;
    }

    public void setYards_after_catch(Integer yards_after_catch) {
        this.yards_after_catch = yards_after_catch;
    }

    public Integer getPassing_yards() {
        return passing_yards;
    }

    public void setPassing_yards(Integer passing_yards) {
        this.passing_yards = passing_yards;
    }

    public String getReceiver_player_id() {
        return receiver_player_id;
    }

    public void setReceiver_player_id(String receiver_player_id) {
        this.receiver_player_id = receiver_player_id;
    }

    public Integer getReceiving_yards() {
        return receiving_yards;
    }

    public void setReceiving_yards(Integer receiving_yards) {
        this.receiving_yards = receiving_yards;
    }

    public String getRusher_player_id() {
        return rusher_player_id;
    }

    public void setRusher_player_id(String rusher_player_id) {
        this.rusher_player_id = rusher_player_id;
    }

    public Integer getRushing_yards() {
        return rushing_yards;
    }

    public void setRushing_yards(Integer rushing_yards) {
        this.rushing_yards = rushing_yards;
    }

    public String getInterception_player_id() {
        return interception_player_id;
    }

    public void setInterception_player_id(String interception_player_id) {
        this.interception_player_id = interception_player_id;
    }

    public String getPunt_returner_player_id() {
        return punt_returner_player_id;
    }

    public void setPunt_returner_player_id(String punt_returner_player_id) {
        this.punt_returner_player_id = punt_returner_player_id;
    }

    public String getKickoff_returner_player_id() {
        return kickoff_returner_player_id;
    }

    public void setKickoff_returner_player_id(String kickoff_returner_player_id) {
        this.kickoff_returner_player_id = kickoff_returner_player_id;
    }

    public String getPunter_player_id() {
        return punter_player_id;
    }

    public void setPunter_player_id(String punter_player_id) {
        this.punter_player_id = punter_player_id;
    }

    public String getKicker_player_id() {
        return kicker_player_id;
    }

    public void setKicker_player_id(String kicker_player_id) {
        this.kicker_player_id = kicker_player_id;
    }

    public Integer getKick_distance() {
        return kick_distance;
    }

    public void setKick_distance(Integer kick_distance) {
        this.kick_distance = kick_distance;
    }

    public BigDecimal getOpp_fg_prob() {
        return opp_fg_prob;
    }

    public void setOpp_fg_prob(BigDecimal opp_fg_prob) {
        this.opp_fg_prob = opp_fg_prob;
    }

    public BigDecimal getOpp_safety_prob() {
        return opp_safety_prob;
    }

    public void setOpp_safety_prob(BigDecimal opp_safety_prob) {
        this.opp_safety_prob = opp_safety_prob;
    }

    public BigDecimal getOpp_td_prob() {
        return opp_td_prob;
    }

    public void setOpp_td_prob(BigDecimal opp_td_prob) {
        this.opp_td_prob = opp_td_prob;
    }

    public BigDecimal getFg_prob() {
        return fg_prob;
    }

    public void setFg_prob(BigDecimal fg_prob) {
        this.fg_prob = fg_prob;
    }

    public BigDecimal getSafety_prob() {
        return safety_prob;
    }

    public void setSafety_prob(BigDecimal safety_prob) {
        this.safety_prob = safety_prob;
    }

    public BigDecimal getTd_prob() {
        return td_prob;
    }

    public void setTd_prob(BigDecimal td_prob) {
        this.td_prob = td_prob;
    }

    public BigDecimal getExtra_point_prob() {
        return extra_point_prob;
    }

    public void setExtra_point_prob(BigDecimal extra_point_prob) {
        this.extra_point_prob = extra_point_prob;
    }

    public BigDecimal getTwo_point_conversion_prob() {
        return two_point_conversion_prob;
    }

    public void setTwo_point_conversion_prob(BigDecimal two_point_conversion_prob) {
        this.two_point_conversion_prob = two_point_conversion_prob;
    }

    public BigDecimal getEp() {
        return ep;
    }

    public void setEp(BigDecimal ep) {
        this.ep = ep;
    }

    public BigDecimal getEpa() {
        return epa;
    }

    public void setEpa(BigDecimal epa) {
        this.epa = epa;
    }

    public BigDecimal getAir_epa() {
        return air_epa;
    }

    public void setAir_epa(BigDecimal air_epa) {
        this.air_epa = air_epa;
    }

    public BigDecimal getYac_epa() {
        return yac_epa;
    }

    public void setYac_epa(BigDecimal yac_epa) {
        this.yac_epa = yac_epa;
    }

    public BigDecimal getWp() {
        return wp;
    }

    public void setWp(BigDecimal wp) {
        this.wp = wp;
    }

    public BigDecimal getDef_wp() {
        return def_wp;
    }

    public void setDef_wp(BigDecimal def_wp) {
        this.def_wp = def_wp;
    }

    public BigDecimal getWpa() {
        return wpa;
    }

    public void setWpa(BigDecimal wpa) {
        this.wpa = wpa;
    }

    public BigDecimal getVegas_wpa() {
        return vegas_wpa;
    }

    public void setVegas_wpa(BigDecimal vegas_wpa) {
        this.vegas_wpa = vegas_wpa;
    }

    public BigDecimal getVegas_wp() {
        return vegas_wp;
    }

    public void setVegas_wp(BigDecimal vegas_wp) {
        this.vegas_wp = vegas_wp;
    }

    public BigDecimal getAir_wpa() {
        return air_wpa;
    }

    public void setAir_wpa(BigDecimal air_wpa) {
        this.air_wpa = air_wpa;
    }

    public BigDecimal getYac_wpa() {
        return yac_wpa;
    }

    public void setYac_wpa(BigDecimal yac_wpa) {
        this.yac_wpa = yac_wpa;
    }

    public Boolean getTimeout() {
        return timeout;
    }

    public void setTimeout(Boolean timeout) {
        this.timeout = timeout;
    }

    public Boolean getShotgun() {
        return shotgun;
    }

    public void setShotgun(Boolean shotgun) {
        this.shotgun = shotgun;
    }

    public Boolean getNo_huddle() {
        return no_huddle;
    }

    public void setNo_huddle(Boolean no_huddle) {
        this.no_huddle = no_huddle;
    }

    public Boolean getQb_dropback() {
        return qb_dropback;
    }

    public void setQb_dropback(Boolean qb_dropback) {
        this.qb_dropback = qb_dropback;
    }

    public Boolean getQb_kneel() {
        return qb_kneel;
    }

    public void setQb_kneel(Boolean qb_kneel) {
        this.qb_kneel = qb_kneel;
    }

    public Boolean getQb_spike() {
        return qb_spike;
    }

    public void setQb_spike(Boolean qb_spike) {
        this.qb_spike = qb_spike;
    }

    public Boolean getQb_scramble() {
        return qb_scramble;
    }

    public void setQb_scramble(Boolean qb_scramble) {
        this.qb_scramble = qb_scramble;
    }

    public Boolean getPunt_blocked() {
        return punt_blocked;
    }

    public void setPunt_blocked(Boolean punt_blocked) {
        this.punt_blocked = punt_blocked;
    }

    public Boolean getTouchback() {
        return touchback;
    }

    public void setTouchback(Boolean touchback) {
        this.touchback = touchback;
    }

    public Boolean getInterception() {
        return interception;
    }

    public void setInterception(Boolean interception) {
        this.interception = interception;
    }

    public Boolean getFumble() {
        return fumble;
    }

    public void setFumble(Boolean fumble) {
        this.fumble = fumble;
    }

    public Boolean getFumble_forced() {
        return fumble_forced;
    }

    public void setFumble_forced(Boolean fumble_forced) {
        this.fumble_forced = fumble_forced;
    }

    public Boolean getFumble_out_of_bounds() {
        return fumble_out_of_bounds;
    }

    public void setFumble_out_of_bounds(Boolean fumble_out_of_bounds) {
        this.fumble_out_of_bounds = fumble_out_of_bounds;
    }

    public Boolean getFumble_lost() {
        return fumble_lost;
    }

    public void setFumble_lost(Boolean fumble_lost) {
        this.fumble_lost = fumble_lost;
    }

    public Boolean getSolo_tackle() {
        return solo_tackle;
    }

    public void setSolo_tackle(Boolean solo_tackle) {
        this.solo_tackle = solo_tackle;
    }

    public Boolean getSafety() {
        return safety;
    }

    public void setSafety(Boolean safety) {
        this.safety = safety;
    }

    public Boolean getPenalty() {
        return penalty;
    }

    public void setPenalty(Boolean penalty) {
        this.penalty = penalty;
    }

    public Boolean getQb_hit() {
        return qb_hit;
    }

    public void setQb_hit(Boolean qb_hit) {
        this.qb_hit = qb_hit;
    }

    public Boolean getRush_attmept() {
        return rush_attmept;
    }

    public void setRush_attmept(Boolean rush_attmept) {
        this.rush_attmept = rush_attmept;
    }

    public Boolean getPass_attempt() {
        return pass_attempt;
    }

    public void setPass_attempt(Boolean pass_attempt) {
        this.pass_attempt = pass_attempt;
    }

    public Boolean getSack() {
        return sack;
    }

    public void setSack(Boolean sack) {
        this.sack = sack;
    }

    public Boolean getTouchdown() {
        return touchdown;
    }

    public void setTouchdown(Boolean touchdown) {
        this.touchdown = touchdown;
    }
}
