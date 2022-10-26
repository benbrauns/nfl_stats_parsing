package com.playbyplay.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Game {
    private String game_id;
    private String home_team;
    private String away_team;
    private Integer season;
    private String season_type;
    private Integer week;
    private LocalDate game_date;
    private BigDecimal spread_line;
    private BigDecimal total_line;
    private String roof;
    private String home_coach;
    private String away_coach;
    private Integer temp;
    private Integer wind;

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
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

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getSeason_type() {
        return season_type;
    }

    public void setSeason_type(String season_type) {
        this.season_type = season_type;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public LocalDate getGame_date() {
        return game_date;
    }

    public void setGame_date(LocalDate game_date) {
        this.game_date = game_date;
    }
}
